package com.jenkins.test;

import android.content.Intent;
import android.content.UriMatcher;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.jenkins.test.builder.NetritionFacts;

import java.util.Iterator;
import java.util.Set;

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

  private static final UriMatcher sURIMatcher = new UriMatcher(UriMatcher.NO_MATCH);

  static {
    sURIMatcher.addURI("app", "addresses", 1);
    sURIMatcher.addURI("app", "channels", 2);
    sURIMatcher.addURI("app", "chat_list", 3);
    sURIMatcher.addURI("app", "chat_official", 4);
    sURIMatcher.addURI("app", "chat_shop", 5);
    sURIMatcher.addURI("app", "collect", 6);
    sURIMatcher.addURI("app", "goods", 7);
    sURIMatcher.addURI("app", "main", 8);
    sURIMatcher.addURI("app", "malls", 9);
    sURIMatcher.addURI("app", "my_order", 10);
    sURIMatcher.addURI("app", "person", 11);
    sURIMatcher.addURI("app", "person_history", 12);
    sURIMatcher.addURI("app", "person_info", 13);
    sURIMatcher.addURI("app", "setting", 14);
    sURIMatcher.addURI("app", "subject_group", 15);
    sURIMatcher.addURI("app", "tiered", 16);
    sURIMatcher.addURI("app", "subject_group", 17);

    sURIMatcher.addURI("app", "/addresses", 1);
    sURIMatcher.addURI("app", "/channels", 2);
    sURIMatcher.addURI("app", "/chat_list", 3);
    sURIMatcher.addURI("app", "/chat_official", 4);
    sURIMatcher.addURI("app", "/chat_shop", 5);
    sURIMatcher.addURI("app", "/collect", 6);
    sURIMatcher.addURI("app", "/goods", 7);
    sURIMatcher.addURI("app", "/main", 8);
    sURIMatcher.addURI("app", "/malls", 9);
    sURIMatcher.addURI("app", "/my_order", 10);
    sURIMatcher.addURI("app", "/person", 11);
    sURIMatcher.addURI("app", "/person_history", 12);
    sURIMatcher.addURI("app", "/person_info", 13);
    sURIMatcher.addURI("app", "/setting", 14);
    sURIMatcher.addURI("app", "/subject_group", 15);
    sURIMatcher.addURI("app", "/tiered", 16);
    sURIMatcher.addURI("app", "/subject_group", 17);
  }

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
               Toast.makeText(MainActivity.this, msg.obj.toString(), Toast.LENGTH_LONG).show();
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
    // Uri url = Uri.parse("/tiered?id=xxx&serie_id=yyy");
    Uri url = Uri.parse(
        "/go?path=page&id=%2Factivity%2Fcashgift.html&chl=tg.hz.1029358.1348755");
    // Uri url = Uri.parse("/go?path=tiered&id=xxx&serie_id=yyy&page=1232132");
    // Uri url = Uri.parse("mengtuiapp://goods?id=1000");
    Uri.Builder bd = url.buildUpon();
    if (TextUtils.isEmpty(url.getScheme())) {
      bd.scheme("mt");
    }
    if (TextUtils.isEmpty(url.getAuthority())) {
      bd.authority("app");
    }
    if (url.getPath().contains("go")) {
      bd = new Uri.Builder();
      bd.scheme("mt");
      bd.authority("app");
      String path = url.getQueryParameter("path");
      if (path.contains("page")) {
        bd.scheme("http");
        bd.authority("www.mt.com");
        bd.path(url.getQueryParameter("id"));
        Set<String> stringSet = url.getQueryParameterNames();
        Iterator<String> iterable = stringSet.iterator();
        while (iterable.hasNext()) {
          String key = iterable.next();
          if (TextUtils.equals(key, "path") || TextUtils.equals(key, "id")) {
            continue;
          }
          bd.appendQueryParameter(key, url.getQueryParameter(key));
          Log.d("MainActivity", "hasNext " + key + " value " + url.getQueryParameter(key));
        }
      }
    } else {
      bd.path(url.getQueryParameter("path"));
      Set<String> stringSet = url.getQueryParameterNames();
      Iterator<String> iterable = stringSet.iterator();
      while (iterable.hasNext()) {
        String key = iterable.next();
        if (TextUtils.equals(key, "path")) {
          continue;
        }
        bd.appendQueryParameter(key, url.getQueryParameter(key));
        Log.d("MainActivity", "hasNext " + key + " value " + url.getQueryParameter(key));
      }
    }
    bd.appendQueryParameter("refPageName", "mainActivity");
    bd.appendQueryParameter("refPageId", "123123120213123213isalfkadaa");
    url = bd.build();

    Log.d("MainActivity", "bd.build():" + bd.build().toString());
    Log.d("MainActivity", "toString:" + url.toString());
    Log.d("MainActivity", "getAuthority:" + url.getAuthority());
    Log.d("MainActivity", "getEncodedPath:" + url.getEncodedPath());
    Log.d("MainActivity", "getPath:" + url.getPath());
    Log.d("MainActivity", "getScheme:" + url.getScheme());

    int match = sURIMatcher.match(url);
    Log.d("MainActivity", "sURIMatcher:" + match);
    thread.start();

  }
}
