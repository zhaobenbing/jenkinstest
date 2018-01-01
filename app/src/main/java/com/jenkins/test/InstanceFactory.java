package com.jenkins.test;

import java.util.concurrent.ForkJoinPool;

/**
 * Created by zhaobenbing@wanda.cn on 18/1/1.
 */

public class InstanceFactory {
  private InstanceFactory() {}

  public static void main(String[] args) {
  }
  public static class InstanceHolder {
    public static InstanceFactory instance = new InstanceFactory();
  }

  public static InstanceFactory getInstance() {
    return InstanceHolder.instance;
  }
}
