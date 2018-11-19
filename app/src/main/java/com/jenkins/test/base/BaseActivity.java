package com.jenkins.test.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.lang.annotation.Annotation;

/**
 * Created by zhaobenbing@innotechx.com on 2018/11/8.
 */
public class BaseActivity extends AppCompatActivity {
  UI annotation;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getClass().isAnnotationPresent(UI.class)) {
      annotation = getClass().getAnnotation(UI.class);
      int layoutId = annotation.value();
      setContentView(layoutId);
     // Toast.makeText(this, annotation.text(), Toast.LENGTH_LONG).show();
    }
    Annotation[] annotations = getClass().getAnnotations();
    if (true){
     // Toast.makeText(this,getClass().getAnnotation(MethodAn.class).name(),Toast.LENGTH_LONG).show();
    }
  }
}
