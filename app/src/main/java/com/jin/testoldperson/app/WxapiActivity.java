package com.jin.testoldperson.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jin.testoldperson.R;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;

public class WxapiActivity extends Activity {

    private IWXAPI api;
    private boolean click;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wxapi);
        api = WxUtils.getInstance().iwxapi;
    }

    public void share(View view) {
        click=true;
       /* Intent wechatIntent = new Intent(Intent.ACTION_SEND);
        wechatIntent.setPackage("com.tencent.mm");
        wechatIntent.setType("text/plain");
        wechatIntent.putExtra(Intent.EXTRA_STREAM, "https://open.weixin.qq.com/cgi-bin/applist?t=manage/list&lang=zh_CN&token=f23831cee30390d00c63140e02579f747bfda21e");
        startActivity(Intent.createChooser(wechatIntent, "分享到"));*/
        WXTextObject textObj = new WXTextObject();
        textObj.text = "啦啦";

        WXMediaMessage msg = new WXMediaMessage();
        msg.mediaObject = textObj;

        msg.title = "Will be ignored";
        msg.description = "哼哼";


        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = buildTransaction("text"); // transaction�ֶ�����Ψһ��ʶһ������
        req.message = msg;
        req.scene = SendMessageToWX.Req.WXSceneSession;


        api.sendReq(req);
    }

    private String buildTransaction(final String type) {
        return (type == null) ? String.valueOf(System.currentTimeMillis()) : type + System.currentTimeMillis();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(click){
            startActivity(new Intent(this,WxapiActivity.class));
        }
    }
}
