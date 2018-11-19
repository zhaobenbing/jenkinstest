package com.jenkins.test;

import android.net.Uri;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.net.URI;

/**
 * Created by zhaobenbing@innotechx.com on 18/1/23.
 */

public class TestURI {
  public static final int A = 1;
  public static final int B = 2;
  public static final int C = 3;
  public static final int D = 4;
  public static final int E = 5;

  private final String abc;

    public TestURI() {
        abc = "sdf";
    }

    private int str;

  @Inter
  public int getStr() {
    return str;
  }

  public void setStr(@Inter int str) {
    this.str = str;
  }

  @IntDef({A, B, C, D, E})
  @Retention(RetentionPolicy.SOURCE)
  public @interface Inter {}

  public static void main(String[] args) {
    URI uri = URI.create("http://www.baidu.com/shop/talk?userId=1231231");
    System.out.println(uri.getQuery());
    System.out.println(uri.getHost());
    System.out.println(uri.getPath());
    System.out.println(uri.getPort());
    System.out.println(uri.getScheme());

    // Uri uri1 = Uri.parse("s://shop/talk?userId=1231231");
    // System.out.println(uri1.getQuery());
    // System.out.println(uri1.getAuthority());
    // System.out.println(uri1.getHost());
    // System.out.println(uri1.getPath());
    // System.out.println(uri1.getQueryParameter("userId"));

    TestURI testURI = new TestURI();
    testURI.setStr(TestURI.A);

    System.out.println(testURI.getStr());

    @Inter
    int in = testURI.getStr();
      switch (in) {

          case A:
              break;
          case B:
              break;
          case C:
              break;
          case D:
              break;
          case E:
              break;
      }
  }

}
