package com.jin.testoldperson.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.jin.testoldperson.app.Constants;
import com.jin.testoldperson.app.WxUtils;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;


public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

    private IWXAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WxUtils.getInstance().register(this, Constants.APP_ID);
        api = WxUtils.getInstance().iwxapi;
        try {
            api.handleIntent(getIntent(), this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        setIntent(intent);
        api.handleIntent(intent, this);
    }

    @Override
    public void onReq(BaseReq req) {
        Log.e("===", req.getType() + "--------------------------------");
        switch (req.getType()) {
            case ConstantsAPI.COMMAND_GETMESSAGE_FROM_WX:

                break;
            case ConstantsAPI.COMMAND_SHOWMESSAGE_FROM_WX:

                break;
            default:
                break;
        }
    }

    @Override
    public void onResp(BaseResp resp) {
        int result = 0;
        Log.e("===", resp.errStr + " ================   " + resp.errCode);
        switch (resp.errCode) {
            case BaseResp.ErrCode.ERR_OK:
                // 成功
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:
// 取消
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED:
// 决绝
                break;
            case BaseResp.ErrCode.ERR_UNSUPPORT:
//中断
                break;
            default:

                break;
        }

        Toast.makeText(this, result, Toast.LENGTH_LONG).show();
    }


}