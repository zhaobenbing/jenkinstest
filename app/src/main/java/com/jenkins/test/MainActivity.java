package com.jenkins.test;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jenkins.test.builder.NetritionFacts;

public class MainActivity extends AppCompatActivity {
  private static final int STATUS = 200;
  private TextView mTextMessage;
  private Button mBtn;
  private Handler mHandler = new Handler() {
    @Override
    public void handleMessage(Message msg) {
      if (msg != null && msg.arg1 == STATUS) {
        Toast.makeText(MainActivity.this, "mHandler:" + msg.obj.toString(), Toast.LENGTH_LONG)
            .show();
      }
    }
  };
  private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener =
      new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
          switch (item.getItemId()) {
            case R.id.navigation_home:
              mTextMessage.setText(R.string.title_home);
              return true;
            case R.id.navigation_dashboard:
              mTextMessage.setText(R.string.title_dashboard);
              return true;
            case R.id.navigation_notifications:
              mTextMessage.setText(R.string.title_notifications);
              return true;
          }
          return false;
        }
      };

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    getSharedPreferences("", MODE_PRIVATE);
    mTextMessage = findViewById(R.id.message);
    mBtn = findViewById(R.id.btn);
    BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
    navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    NetritionFacts builder =
        new NetritionFacts.Builder(100, 220).setColor(123).setFat(100).setPrice(43).build();
    mBtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, TestActivity.class);
        startActivity(intent);
      }
    });

    Thread thread = new Thread(new Runnable() {
      @Override
      public void run() {
        Looper.prepare();
        Handler handler = new Handler() {
          @Override
          public void handleMessage(Message msg) {
            // super.handleMessage(msg);
            if (msg != null && msg.arg1 == STATUS) {
              Message message = mHandler.obtainMessage();
              message.arg1 = msg.arg1;
              message.obj = msg.obj;
              mHandler.sendMessage(message);
              // Toast.makeText(MainActivity.this, msg.obj.toString(), Toast.LENGTH_LONG).show();
            }
          }
        };

        Message msg = new Message();
        msg.arg1 = STATUS;
        msg.obj = "this is a sub thread handler";
        handler.sendMessage(msg);
        Looper.loop();
      }
    });
    thread.start();
  }

}
