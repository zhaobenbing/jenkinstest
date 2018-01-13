package com.jenkins.test;

import android.support.annotation.NonNull;

/**
 * Created by zhaobenbing@wanda.cn on 18/1/8.
 */

public class TestSum implements Cloneable, Comparable<String> {
  private Object o;

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    Long sum = 0l;
    for (int i = 0; i < Integer.MAX_VALUE; i++) {
      sum += i;
    }
    System.out.println(sum);
    System.out.println(System.currentTimeMillis() - start);
  }

  @Override
  public int compareTo(@NonNull String o) {
    return 0;
  }
}
