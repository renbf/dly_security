package com.project.framework.getui.pushmessage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gexin.rp.sdk.base.IIGtPush;
import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.ListMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import com.project.security.domain.TUserClient;
import com.project.web.domian.TMessage;
/**
 * 个推工具类
 * @author rbf
 *
 */
public class GetuiUtils {
	
	private static final Logger log = LoggerFactory.getLogger(GetuiUtils.class);
	
	/**
	 * 批量推送
	 * @param users
	 * @param tmessage
	 */
	public static boolean pushList(List<TUserClient> users,TMessage tmessage) {
		try {
			List<TUserClient> userIos = users.stream().filter(u -> "1".equals(u.getSource()))
					.collect(Collectors.toList());
			List<TUserClient> userAndroid = users.stream().filter(u -> "0".equals(u.getSource()))
					.collect(Collectors.toList());
			boolean flag = false;
			if(CollectionUtils.isNotEmpty(userIos)) {
				Map<String, Object> iosResult = pushIosList(userIos, tmessage);
				if("ok".equals(iosResult.get("result"))) {
					flag = true;
					if(CollectionUtils.isNotEmpty(userAndroid)) {
						flag = false;
						Map<String, Object> androidResult = pushAndroidList(userAndroid, tmessage);
						if("ok".equals(androidResult.get("result"))) {
							flag = true;
						}
					}
				}
			}else {
				if(CollectionUtils.isNotEmpty(userAndroid)) {
					Map<String, Object> androidResult = pushAndroidList(userAndroid, tmessage);
					if("ok".equals(androidResult.get("result"))) {
						flag = true;
					}
				}
			}
			return flag;
		} catch (Exception e) {
			log.error("发送推送消息异常",e);
			throw new RuntimeException("发送推送消息异常");
		}
	}
	/**
	 * 批量推送
	 * @param users
	 * @param tmessage
	 */
	public static Map<String,Object> pushIosList(List<TUserClient> users,TMessage tmessage) {
		try {
			IIGtPush push = new IGtPush(GetuiConfig.appKey, GetuiConfig.masterSecret, true);
			TransmissionTemplate template = toTransmissionTemplate(tmessage);
			ListMessage message = new ListMessage();
			message.setData(template);
			// 设置消息离线，并设置离线时间
			message.setOffline(true);
			// 离线有效时间，单位为毫秒，可选
			message.setOfflineExpireTime(24 * 1000 * 3600);
			// 配置推送目标
			List<Target> targets = new ArrayList<Target>();
			for (TUserClient sysUser : users) {
				Target target = new Target();
				target.setAppId(GetuiConfig.appId);
				target.setClientId(sysUser.getClientId());
				targets.add(target);
			}
			// taskId用于在推送时去查找对应的message
			String taskId = push.getContentId(message);
			IPushResult ret = push.pushMessageToList(taskId, targets);
			log.info(ret.getResponse().toString());
			return ret.getResponse();
		} catch (Exception e) {
			log.error("发送ios推送消息异常",e);
			throw new RuntimeException("发送ios推送消息异常");
		}
	}
	
	/**
	 * 批量推送
	 * @param users
	 * @param tmessage
	 */
	public static Map<String,Object> pushAndroidList(List<TUserClient> users,TMessage tmessage) {
		try {
			IIGtPush push = new IGtPush(GetuiConfig.appKey, GetuiConfig.masterSecret, true);
			LinkTemplate template = toLinkTemplate(tmessage);
			ListMessage message = new ListMessage();
			message.setData(template);
			// 设置消息离线，并设置离线时间
			message.setOffline(true);
			// 离线有效时间，单位为毫秒，可选
			message.setOfflineExpireTime(24 * 1000 * 3600);
			// 配置推送目标
			List<Target> targets = new ArrayList<Target>();
			for (TUserClient sysUser : users) {
				Target target = new Target();
				target.setAppId(GetuiConfig.appId);
				target.setClientId(sysUser.getClientId());
				targets.add(target);
			}
			// taskId用于在推送时去查找对应的message
			String taskId = push.getContentId(message);
			IPushResult ret = push.pushMessageToList(taskId, targets);
			log.info(ret.getResponse().toString());
			return ret.getResponse();
		} catch (Exception e) {
			log.error("发送安卓推送消息异常",e);
			throw new RuntimeException("发送安卓推送消息异常");
		}
	}
	/**
	 * 通知
	 * @param message
	 * @return
	 */
	public static NotificationTemplate toNotificationTemplateDemo(TMessage message) {
        NotificationTemplate template = new NotificationTemplate();
        // 设置APPID与APPKEY
        template.setAppId(GetuiConfig.appId);
        template.setAppkey(GetuiConfig.appKey);
        // 设置通知栏标题与内容
        template.setTitle(message.getTitle());
        template.setText(message.getContext());
        // 配置通知栏图标
        template.setLogo("icon.png");
        // 配置通知栏网络图标
        template.setLogoUrl("");
        // 设置通知是否响铃，震动，或者可清除
        template.setIsRing(true);
        template.setIsVibrate(true);
        template.setIsClearable(true);
        // 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
        template.setTransmissionType(2);
        template.setTransmissionContent(message.getContext());
        return template;
    }
	/**
	 * 通知透传模板
	 * @param message
	 * @return
	 */
	public static TransmissionTemplate toTransmissionTemplate(TMessage message) {
		TransmissionTemplate template = new TransmissionTemplate();
	    template.setAppId(GetuiConfig.appId);
	    template.setAppkey(GetuiConfig.appKey);
	    // 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
	    template.setTransmissionType(2);
	    template.setTransmissionContent(message.getContext());
	    // 设置定时展示时间
	    // template.setDuration("2015-01-16 11:40:00", "2015-01-16 12:24:00");
	    return template;
    }
	/**
	 * 链接模板
	 * @param message
	 * @return
	 */
	public static LinkTemplate toLinkTemplate(TMessage message) {
        LinkTemplate template = new LinkTemplate();
        // 设置APPID与APPKEY
        template.setAppId(GetuiConfig.appId);
        template.setAppkey(GetuiConfig.appKey);
        // 设置通知栏标题与内容
        template.setTitle(message.getTitle());
        template.setText(message.getContext());
        // 配置通知栏图标
//        template.setLogo("icon.png");
        // 配置通知栏网络图标，填写图标URL地址
        template.setLogoUrl(message.getLogoUrl());
        // 设置通知是否响铃，震动，或者可清除
        template.setIsRing(true);
        template.setIsVibrate(true);
        template.setIsClearable(true);
        template.setUrl(message.getLinkUrl());
        // 设置打开的网址地址
        return template;
    }
	
	public static void main(String[] args) {
		List<TUserClient> users = new ArrayList<TUserClient>();
		TUserClient tUserClient = new TUserClient();
		tUserClient.setClientId("2fbdc3edb9fda579f0389a033e779e72");
		tUserClient.setSource("1");
		users.add(tUserClient);
		
		TUserClient tUserClient2 = new TUserClient();
		tUserClient2.setClientId("fa051cde88e744c30f5cceee3dcf4bc7");
		tUserClient2.setSource("0");
		users.add(tUserClient2);
		TMessage tmessage = new TMessage();
		tmessage.setTitle("标题");
		tmessage.setContext("内容内容");
		tmessage.setLinkUrl("");
		tmessage.setLogoUrl("");
		pushList(users, tmessage);
	}
}

