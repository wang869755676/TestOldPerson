package com.jin.testoldperson.scoket;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.jin.testoldperson.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;


public class ScoketActivity extends AppCompatActivity {

    private String ip;
    private EditText iped;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:

                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoket);
        iped = (EditText) findViewById(R.id.editText3);
        getIPAddress();
        Log.e("===", getIPAddress() + "------------------");
        iped.setText(getIPAddress() + " ip 地址");

    }

    public void client(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                ip = iped.getText().toString();
                //客户端
//1、创建客户端Socket，指定服务器地址和端口
                Socket socket = null;
                try {
                    socket = new Socket(ip, 10086);
                    //2、获取输出流，向服务器端发送信息
                    OutputStream os = socket.getOutputStream();//字节输出流
                    PrintWriter pw = new PrintWriter(os);//将输出流包装成打印流
                    pw.write("用户名：admin；密码：123");
                    pw.flush();
                    socket.shutdownOutput();
//3、获取输入流，并读取服务器端的响应信息
                    InputStream is = socket.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String info = null;
                    while ((info = br.readLine()) != null) {
                        Log.e("===","我是客户端，服务器说：" + info);
                    }

//4、关闭资源
                    br.close();
                    is.close();
                    pw.close();
                    os.close();
                    socket.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    public void server(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                /**
                 * 基于TCP协议的Socket通信，实现用户登录，服务端
                 */
//1、创建一个服务器端Socket，即ServerSocket，指定绑定的端口，并监听此端口
                ServerSocket serverSocket = null;//1024-65535的某个端口
                try {
                    serverSocket = new ServerSocket(10086);
                    //2、调用accept()方法开始监听，等待客户端的连接
                    Socket socket = serverSocket.accept();
//3、获取输入流，并读取客户端信息
                    InputStream is = socket.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);
                    BufferedReader br = new BufferedReader(isr);
                    String info = null;
                    while ((info = br.readLine()) != null) {
                        Log.e("===","我是服务器，客户端说：" + info);
                    }
                    socket.shutdownInput();//关闭输入流
//4、获取输出流，响应客户端的请求
                    OutputStream os = socket.getOutputStream();
                    PrintWriter pw = new PrintWriter(os);
                    pw.write("欢迎您！");
                    pw.flush();


//5、关闭资源
                    pw.close();
                    os.close();
                    br.close();
                    isr.close();
                    is.close();
                    socket.close();
                    serverSocket.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    public String getIPAddress() {
        NetworkInfo info = ((ConnectivityManager) this
                .getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (info != null && info.isConnected()) {
            if (info.getType() == ConnectivityManager.TYPE_MOBILE) {//当前使用2G/3G/4G网络
                try {
                    //Enumeration<NetworkInterface> en=NetworkInterface.getNetworkInterfaces();
                    for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces();
                         en.hasMoreElements(); ) {
                        NetworkInterface intf = en.nextElement();
                        for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements(); ) {
                            InetAddress inetAddress = enumIpAddr.nextElement();
                            if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
                                return inetAddress.getHostAddress();
                            }
                        }
                    }
                } catch (SocketException e) {
                    e.printStackTrace();
                }

            } else if (info.getType() == ConnectivityManager.TYPE_WIFI) {//当前使用无线网络
                WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                //调用方法将int转换为地址字符串
                String ipAddress = intIP2StringIP(wifiInfo.getIpAddress());//得到IPV4地址
                return ipAddress;
            }
        } else {
            //当前无网络连接,请在设置中打开网络
        }
        return null;
    }

    /**
     * 将得到的int类型的IP转换为String类型
     *
     * @param ip
     * @return
     */
    public static String intIP2StringIP(int ip) {
        return (ip & 0xFF) + "." +
                ((ip >> 8) & 0xFF) + "." +
                ((ip >> 16) & 0xFF) + "." +
                (ip >> 24 & 0xFF);
    }
}

