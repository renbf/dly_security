package com.project.util;
import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.style.Style0;

public class PushtoSingle {
    //采用"Java SDK 快速入门"， "第二步 获取访问凭证 "中获得的应用配置，用户可以自行替换
    private static String appId = "MEHOktmxWV91Wm5qJrgW13";
    private static String appKey = "lWxpjzhEXZAMItZkSiGNJ";
    private static String masterSecret = "pfaoESE4DUAIubqrMMI9T1";

    static String CID = "73a176cd803fb363d4b1da5b6b7c49ca";
    //别名推送方式
    // static String Alias = "";
    static String host = "http://sdk.open.api.igexin.com/apiex.htm";

    public static void main(String[] args) throws Exception {
        IGtPush push = new IGtPush(host, appKey, masterSecret);
        LinkTemplate template = linkTemplateDemo();
        SingleMessage message = new SingleMessage();
        message.setOffline(true);
        // 离线有效时间，单位为毫秒，可选
        message.setOfflineExpireTime(24 * 3600 * 1000);
        message.setData(template);
        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
        message.setPushNetWorkType(0);
        Target target = new Target();
        target.setAppId(appId);
        target.setClientId(CID);
        //target.setAlias(Alias);
        IPushResult ret = null;
        try {
            ret = push.pushMessageToSingle(message, target);
        } catch (RequestException e) {
            e.printStackTrace();
            ret = push.pushMessageToSingle(message, target, e.getRequestId());
        }
        if (ret != null) {
            System.out.println(ret.getResponse().toString());
        } else {
            System.out.println("服务器响应异常");
        }
    }
    public static LinkTemplate linkTemplateDemo() {
        LinkTemplate template = new LinkTemplate();
        // 设置APPID与APPKEY
        template.setAppId(appId);
        template.setAppkey(appKey);

        Style0 style = new Style0();
        // 设置通知栏标题与内容
        style.setTitle("请输入通知栏标题");
        style.setText("请输入通知栏内容");
        // 配置通知栏图标
        style.setLogo("icon.png");
        // 配置通知栏网络图标
        style.setLogoUrl("");
        // 设置通知是否响铃，震动，或者可清除
        style.setRing(true);
        style.setVibrate(true);
        style.setClearable(true);
        template.setStyle(style);

        // 设置打开的网址地址
        template.setUrl("http://www.baidu.com");
        return template;
    }
}