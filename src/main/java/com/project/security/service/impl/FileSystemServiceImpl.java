package com.project.security.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import com.jcraft.jsch.SftpException;
import com.project.common.utils.Md5Utils;
import com.project.framework.config.SftpConfig;
import com.project.security.service.IFileSystemService;
/**
 * 
 * @author rbf
 *
 */
@Service
public class FileSystemServiceImpl implements IFileSystemService {
	
	private static final Logger log = LoggerFactory.getLogger(FileSystemServiceImpl.class);
	@Autowired
    private SftpConfig config;
	
	// 设置第一次登陆的时候提示，可选值：(ask | yes | no)
    private static final String SESSION_CONFIG_STRICT_HOST_KEY_CHECKING = "StrictHostKeyChecking";
    /**
     * 创建SFTP连接
     * @return
     * @throws Exception
     */
    private ChannelSftp createSftp(){
        try {
			JSch jsch = new JSch();
			log.info("Try to connect sftp[" + config.getUsername() + "@" + config.getHost() + "], use password["
					+ config.getPassword() + "]");
			Session session = createSession(jsch, config.getHost(), config.getUsername(), config.getPort());
			session.setPassword(config.getPassword());
			session.connect(config.getSessionConnectTimeout());
			log.info("Session connected to {}.", config.getHost());
			Channel channel = session.openChannel(config.getProtocol());
			channel.connect(config.getChannelConnectedTimeout());
			log.info("Channel created to {}.", config.getHost());
			return (ChannelSftp) channel;
		} catch (Exception e) {
			log.error("获取sftpchannel失败",e);
			throw new RuntimeException();
		}
    }
 
    /**
     * 加密秘钥方式登陆
     * @return
     */
    private ChannelSftp connectByKey() throws Exception {
        JSch jsch = new JSch();
 
        // 设置密钥和密码 ,支持密钥的方式登陆
        if (StringUtils.isNotBlank(config.getPrivateKey())) {
            if (StringUtils.isNotBlank(config.getPassphrase())) {
                // 设置带口令的密钥
                jsch.addIdentity(config.getPrivateKey(), config.getPassphrase());
            } else {
                // 设置不带口令的密钥
                jsch.addIdentity(config.getPrivateKey());
            }
        }
        log.info("Try to connect sftp[" + config.getUsername() + "@" + config.getHost() + "], use private key[" + config.getPrivateKey()
                + "] with passphrase[" + config.getPassphrase() + "]");
 
        Session session = createSession(jsch, config.getHost(), config.getUsername(), config.getPort());
        // 设置登陆超时时间
        session.connect(config.getSessionConnectTimeout());
        log.info("Session connected to " + config.getHost() + ".");
 
        // 创建sftp通信通道
        Channel channel = session.openChannel(config.getProtocol());
        channel.connect(config.getChannelConnectedTimeout());
        log.info("Channel created to " + config.getHost() + ".");
        return (ChannelSftp) channel;
    }
 
    /**
     * 创建session
     * @param jsch
     * @param host
     * @param username
     * @param port
     * @return
     * @throws Exception
     */
    private Session createSession(JSch jsch, String host, String username, Integer port) throws Exception {
        Session session = null;
 
        if (port <= 0) {
            session = jsch.getSession(username, host);
        } else {
            session = jsch.getSession(username, host, port);
        }
 
        if (session == null) {
            throw new Exception(host + " session is null");
        }
 
        session.setConfig(SESSION_CONFIG_STRICT_HOST_KEY_CHECKING, config.getSessionStrictHostKeyChecking());
        return session;
    }
 
    /**
     * 关闭连接
     * @param sftp
     */
    private void disconnect(ChannelSftp sftp) {
        try {
            if (sftp != null) {
                if (sftp.isConnected()) {
                    sftp.disconnect();
                } else if (sftp.isClosed()) {
                    log.info("sftp is closed already");
                }
                if (null != sftp.getSession()) {
                    sftp.getSession().disconnect();
                }
            }
        } catch (JSchException e) {
            e.printStackTrace();
        }
    }
    
    private boolean createDirs(String dirPath, ChannelSftp sftp) {
        if (dirPath != null && !dirPath.isEmpty()
                    && sftp != null) {
            String[] dirs = Arrays.stream(dirPath.split("/"))
                   .filter(StringUtils::isNotBlank)
                   .toArray(String[]::new);
     
            for (String dir : dirs) {
                try {
                    sftp.cd(dir);
                    log.info("Change directory {}", dir);
                } catch (Exception e) {
                    try {
                        sftp.mkdir(dir);
                        log.info("Create directory {}", dir);
                    } catch (SftpException e1) {
                         log.error("Create directory failure, directory:{}", dir, e1);
                         e1.printStackTrace();
                    }
                    try {
                        sftp.cd(dir);
                        log.info("Change directory {}", dir);
                    } catch (SftpException e1) {
                        log.error("Change directory failure, directory:{}", dir, e1);
                        e1.printStackTrace();
                    }
                }
            }
            return true;
        }
        return false;
    }
    
	@Override
	public String uploadFile(String targetPath, MultipartFile file) throws Exception{
		ChannelSftp sftp = this.createSftp();
	    try {
	        sftp.cd(config.getRoot());
	        log.info("Change path to {}", config.getRoot());
	 
	        int index = targetPath.lastIndexOf("/");
	        String fileDir = targetPath.substring(0, index);
	        String fileName = targetPath.substring(index + 1);
	        boolean dirs = this.createDirs(fileDir, sftp);
	        if (!dirs) {
	            log.error("Remote path error. path:{}", targetPath);
	            throw new Exception("Upload File failure");
	        }
	        fileName = fileName.replace("_", " ");
	        fileName = Md5Utils.hash(fileName + System.nanoTime());
	        sftp.put(file.getInputStream(), fileName);
	        
	        return "http://60.205.187.254:8088/image/sercurity/"+fileName;
	    } catch (Exception e) {
	        log.error("Upload file failure. TargetPath: {}", targetPath, e);
	        throw new RuntimeException("Upload File failure");
	    } finally {
	        this.disconnect(sftp);
	    }
	}

	@Override
	public File downloadFile(String targetPath) throws Exception{
		ChannelSftp sftp = this.createSftp();
	    OutputStream outputStream = null;
	    try {
	        sftp.cd(config.getRoot());
	        log.info("Change path to {}", config.getRoot());
	 
	        File file = new File(targetPath.substring(targetPath.lastIndexOf("/") + 1));
	 
	        outputStream = new FileOutputStream(file);
	        sftp.get(targetPath, outputStream);
	        log.info("Download file success. TargetPath: {}", targetPath);
	        return file;
	    } catch (Exception e) {
	        log.error("Download file failure. TargetPath: {}", targetPath, e);
	         throw new RuntimeException("Download File failure");
	    } finally {
	        if (outputStream != null) {
	            outputStream.close();
	        }
	        this.disconnect(sftp);
	    }
	}

	@Override
	public boolean deleteFile(String targetPath) throws Exception{
		ChannelSftp sftp = null;
	    try {
	        sftp = this.createSftp();
	        sftp.cd(config.getRoot());
	        sftp.rm(targetPath);
	        return true;
	    } catch (Exception e) {
	        log.error("Delete file failure. TargetPath: {}", targetPath, e);
	        throw new Exception("Delete File failure");
	    } finally {
	        this.disconnect(sftp);
	    }
	}

}
