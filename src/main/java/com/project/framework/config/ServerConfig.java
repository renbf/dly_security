package com.project.framework.config;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 获取项目ip:port
 * @author rbf
 *
 */
@Component
public class ServerConfig  implements ApplicationListener<WebServerInitializedEvent> {
	private static final Logger log = LoggerFactory.getLogger(ServerConfig.class);
    private int serverPort;
 
    public String getUrl() {
        InetAddress address = null;
        try {
            address = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
        	log.error("",e);
        }
//        return "http://"+address.getHostAddress() +":"+this.serverPort;
        return "http://aaa.vipgz1.idcfengye.com";
    }
 
    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        this.serverPort = event.getWebServer().getPort();
    }

}
