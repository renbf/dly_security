package com.project.framework.getui.pushmessage;

import java.util.ArrayList;
import java.util.List;

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
import com.project.system.domain.SysUser;
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
	public static void pushList(List<SysUser> users,TMessage tmessage) {
		
		IIGtPush push = new IGtPush(GetuiConfig.appKey, GetuiConfig.masterSecret,true);
		LinkTemplate template = toLinkTemplate(tmessage);
		ListMessage message = new ListMessage();
        message.setData(template);
        // 设置消息离线，并设置离线时间
        message.setOffline(true);
        // 离线有效时间，单位为毫秒，可选
        message.setOfflineExpireTime(24 * 1000 * 3600);
        // 配置推送目标
        List<Target> targets = new ArrayList<Target>();
        for(SysUser sysUser:users) {
        	Target target = new Target();
        	target.setAppId(GetuiConfig.appId);
            target.setClientId(sysUser.getUserName());
            targets.add(target);
        }
        // taskId用于在推送时去查找对应的message
        String taskId = push.getContentId(message);
        IPushResult ret = push.pushMessageToList(taskId, targets);
        log.info(ret.getResponse().toString());
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
}

