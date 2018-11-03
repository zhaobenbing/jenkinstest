package com.jenkins.test;

import android.net.Uri;

import java.net.URI;

/**
 * Created by zhaobenbing@innotechx.com on 18/1/23.
 */

public class TestURI {
  public static void main(String[] args) {
      URI uri = URI.create("http://www.baidu.com/shop/talk?userId=1231231");
      System.out.println(uri.getQuery());
      System.out.println(uri.getHost());
      System.out.println(uri.getPath());
      System.out.println(uri.getPort());
      System.out.println(uri.getScheme());

      Uri uri1 = Uri.parse("s://shop/talk?userId=1231231");
      System.out.println(uri1.getQuery());
      System.out.println(uri1.getAuthority());
      System.out.println(uri1.getHost());
      System.out.println(uri1.getPath());
      System.out.println(uri1.getQueryParameter("userId"));

  }
}
