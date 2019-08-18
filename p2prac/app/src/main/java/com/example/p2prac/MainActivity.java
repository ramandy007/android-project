package com.example.p2prac;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.View;

import android.content.BroadcastReceiver;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

interface SmsListener{
    void messageReceived(String messageText);
}

public class MainActivity extends AppCompatActivity implements SmsListener {
    TextView tv;
    BroadcastReceiver br =new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            final String TAG ="MyBroadcastReceiver";
            StringBuilder sb = new StringBuilder();
            sb.append("Action: "+intent.getAction()+'\n');
            sb.append("URI: "+intent.toUri(Intent.URI_INTENT_SCHEME).toString() +"\n");
            String log = sb.toString();
            Log.d("subactivity","newmybroadcastreceiver");
            Log.d(TAG,log);
            Toast.makeText(context,log,Toast.LENGTH_LONG).show();
        }
    };

    MyOTPReceiver broadcastReceiver;
    public static final String OTP_REGEX = "[0-9]{1,6}";

    Intent intent1 = new Intent();


    @Override
    protected void onDestroy() {
        super.onDestroy();
       this.unregisterReceiver(br);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       MyOTPReceiver.bindListener(new SmsListener() {
           @Override
           public void messageReceived(String messageText) {
               tv = findViewById(R.id.tv);

               tv.setText(messageText);

           }
       });
        broadcastReceiver = new MyOTPReceiver();
        Log.i("mainactivity","hello world");
        intent1.setAction("hello yo all");

        IntentFilter filter = new IntentFilter();
        filter.addAction(intent1.getAction());
        this.registerReceiver(br,filter);
//
    }

public void broadcastIntent(View v){
       Log.d("view", String.valueOf(v.getId()));
        sendBroadcast(intent1);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter=new IntentFilter
                ("android.provider.Telephony.SMS_RECEIVED");
        registerReceiver(broadcastReceiver,intentFilter);

    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);

    }

    @Override
    public void messageReceived(String messageText) {
        Log.e("Message",messageText);
        Toast.makeText(MainActivity.this,"Message: "+
                messageText,Toast.LENGTH_LONG).show();
        Pattern pattern = Pattern.compile(OTP_REGEX);
        Matcher matcher = pattern.matcher(messageText);
        String otp = "XXXXX";
        while (matcher.find())
        {
            otp = matcher.group();
        }

        Toast.makeText(MainActivity.this,"OTP: "+ otp ,Toast.LENGTH_LONG).show();
        TextView t = findViewById(R.id.tv);
        t.setText(otp);



    }
}

class MyOTPReceiver extends BroadcastReceiver{
    private static SmsListener mListener;
    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();
        SmsMessage smsMessage;
        if(Build.VERSION.SDK_INT>=19){
            SmsMessage[] msgs = Telephony.Sms.Intents.getMessagesFromIntent(intent);
            smsMessage=msgs[0];

        }else{
            Object pdus[]=(Object[])bundle.get("pdus");
            smsMessage=SmsMessage.createFromPdu((byte[])pdus[0]);

        }

        String messageBody = smsMessage.getMessageBody();
        mListener.messageReceived(messageBody);

    }
    public static void bindListener(SmsListener listener){
        mListener = listener;
    }



}
