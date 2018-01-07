package com.jenkins.test;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by zhaobenbing@wanda.cn on 18/1/2.
 */

public class TestData {
  public static void main(String[] args) {
    int[] data = new int[30];
    int size = data.length;
    Random random = new Random();
    for (int i = 0; i < size; i++) {
      data[i] = random.nextInt(30);
    }
    for (int i = 0; i < size; i++) {
      System.out.print("" + data[i] + ", ");
    }
    System.out.println("================");
    disData(data);
  }

  private static void disData(int[] data) {
    if (data == null || data.length == 0)
      return;
    int[] result = new int[data.length];
    int size = result.length;
    // for (int i = 0; i < size; i++) {
    // for (int j = i+1; j < i; j++) {
    // if (data[i] == data[j]) {
    // //continue;
    // result[i] = data[j];
    // } else {
    // //
    // }
    // }
    // }
    HashMap<Integer, Integer> hashMap = new HashMap<>();;

    for (int i = 0; i < size; i++) {
      hashMap.put(data[i], data[i]);
    }
    for (int i = 0; i < size; i++) {
      if (hashMap.get(i) == null) continue;
      System.out.print("" + hashMap.get(i) + ", ");
    }
    System.out.println("===================");
  }
}
