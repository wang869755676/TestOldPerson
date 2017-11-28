package com.jin.testoldperson.webView;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;

import com.jin.testoldperson.R;

public class MainActivity extends Activity {

    private EditText mAddressView = null;
    private WebView mWebView = null;
    private AlertDialog alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        mAddressView = (EditText) findViewById(R.id.addressView);
        mWebView = (WebView) findViewById(R.id.webView);

        WebSettings settings = mWebView.getSettings();
        settings.setJavaScriptEnabled(true);

        mWebView.setWebViewClient(new InterceptingWebViewClient(this, mWebView));
        mWebView.setWebChromeClient(new WebChromeClient());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
       AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("全局的dialog")
                .setMessage("全局的Dialog里面的内容")
                .setNegativeButton("ok",null);
        alertDialog=builder.create();
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
alertDialog.show();
        loadOnEnter();
    }

    private void loadOnEnter() {
        mAddressView.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN)
                        && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    load();
                }

                return true;
            }
        });
    }

    public void buttonClicked(View v) {
        load();
        mWebView.requestFocus();
    }

    private void load() {
        mWebView.loadUrl(mAddressView.getText().toString());
    }
}
