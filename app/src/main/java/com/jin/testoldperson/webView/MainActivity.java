package com.jin.testoldperson.webView;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.SingleLineTransformationMethod;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnectionWrapper;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;

import com.jin.testoldperson.R;
import com.jin.testoldperson.textview.SlantedTextView;

public class MainActivity extends Activity {

    private EditText mAddressView = null;
    private WebView mWebView = null;
    private AlertDialog alertDialog;
    private SlantedTextView slantedTextView;
    private EditText editText;


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
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("全局的dialog")
                .setMessage("全局的Dialog里面的内容")
                .setNegativeButton("ok", null);
        alertDialog = builder.create();
        alertDialog.getWindow().setType(WindowManager.LayoutParams.TYPE_TOAST);
        alertDialog.show();
        loadOnEnter();
        slantedTextView = (SlantedTextView) findViewById(R.id.test);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.shake_x);
        slantedTextView.setAnimation(animation);
        animation.start();
        mAddressView.setTransformationMethod(new SingleLineTransformationMethod());
        editText = (EditText) findViewById(R.id.phone);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if (s == null || s.length() == 0)
                    return;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < s.length(); i++) {
                    if (i != 3 && i != 8 && s.charAt(i) == ' ') {
                        continue;
                    } else {
                        sb.append(s.charAt(i));
                        if ((sb.length() == 4 || sb.length() == 9)
                                && sb.charAt(sb.length() - 1) != ' ') {
                            sb.insert(sb.length() - 1, ' ');
                        }
                    }
                }
                if (!sb.toString().equals(s.toString())) {
                    int index = start + 1;
                    if (sb.charAt(start) == ' ') {
                        if (before == 0) {
                            index++;
                        } else {  // 删除字符
                            index--;
                        }
                    } else {
                        if (before == 1) {
                            index--;
                        }
                    }


                    editText.setText(sb.toString());
                    editText.setSelection(index);

               /*     int length = s.toString().length();
                //删除数字
                if (count == 0) {
                    if (length == 4) {
                        editText.setText(s.subSequence(0, 3));
                    }
                    if (length == 9) {
                        editText.setText(s.subSequence(0, 8));
                    }
                }
                //添加数字
                if (count == 1) {
                    if (length == 4) {
                        String part1 = s.subSequence(0, 3).toString();
                        String part2 = s.subSequence(3, length).toString();
                        editText.setText(part1 + " " + part2);
                    }
                    if (length == 9) {
                        String part1 = s.subSequence(0, 8).toString();
                        String part2 = s.subSequence(8, length).toString();
                        editText.setText(part1 + " " + part2);
                    }
                    if(length==11){
                        String part1 = s.subSequence(0, 3).toString();
                        String part2 = s.subSequence(3, 7).toString();
                        String part3 = s.subSequence(7, length).toString();
                        editText.setText(part1 + " " + part2+" "+part3);
                    }
                */}
                if(count==0 && sb.charAt(start-1)==' '){
                    editText.setText(editText.getText().toString().substring(0,editText.getText().toString().length()-1));

                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                //将光标移动到末尾
                editText.setSelection(editText.getText().toString().length());
                //处理s
            }
        });

        //InputConnectionWrapper  wrapper=new InputConnectionWrapper(editText.getinpu)
        //editText.onCreateInputConnection(new EditorInfo())

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
