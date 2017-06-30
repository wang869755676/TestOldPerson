package com.jin.testoldperson.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jin.testoldperson.app.Constants;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.ShowMessageFromWX;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;



public class WXEntryActivity extends Activity implements IWXAPIEventHandler{
	
	private static final int TIMELINE_SUPPORTED_VERSION = 0x21020001;
	


    private IWXAPI api;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    	api = WXAPIFactory.createWXAPI(this, Constants.APP_ID, false);

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
		Log.e("===",resp.errStr+"    "+resp.errCode);
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