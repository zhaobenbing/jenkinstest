package com.jenkins.test;

/**
 * Created by zhaobenbing@wanda.cn on 18/1/1.
 */

public class SafeDoubleCheckLocking {
  private volatile static SafeDoubleCheckLocking mSingleTon;

  private SafeDoubleCheckLocking() {}

  public static SafeDoubleCheckLocking getInstance() {
    if (mSingleTon == null) {
      synchronized (SafeDoubleCheckLocking.class) {
        if (mSingleTon == null) {
          mSingleTon = new SafeDoubleCheckLocking();
        }
      }
    }
    return mSingleTon;
  }
}
