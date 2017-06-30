package com.jin.testoldperson.app;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.jin.testoldperson.R;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class WxapiActivity extends Activity {

    private IWXAPI api;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wxapi);
        api = WXAPIFactory.createWXAPI(this, Constants.APP_ID);
    }
    public void share(View view){
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
}
