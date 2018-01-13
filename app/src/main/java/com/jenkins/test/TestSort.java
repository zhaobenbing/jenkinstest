package com.jenkins.test;

/**
 * Created by zhaobenbing@wanda.cn on 18/1/12.
 */

public class TestSort {
  private static int count = 0;

  public static void main(String[] args) {
    int[] numbers = {49, 38, 65, 97, 76, 13, 27, 49};
    long start = System.currentTimeMillis();
     int[] sort = bubbleSort(numbers);
//    int[] sort = selectSort(numbers);
    print(sort);
    System.out.println("time:" + (System.currentTimeMillis() - start) + "");
  }

  private static int[] bubbleSort(int[] numbers) {
    int temp = 0;
    int size = numbers.length;
    for (int i = 0; i < 1; i++) {
      for (int j = 0; j < size - i - 1; j++) {
        if (numbers[j] > numbers[j + 1]) {
          temp = numbers[j];
          numbers[j] = numbers[j + 1];
          numbers[j + 1] = temp;
        }
      }
      print(numbers);
    }
    return numbers;
  }

  private static int[] selectSort(int[] numbers) {
    int temp = 0;
    int size = numbers.length;
    for (int i = 0; i < size; i++) {
      int k = i;
      for (int j = size - 1; j > i; j--) {
        if (numbers[k] > numbers[j]) {
          k = j;
        }
      }
      temp = numbers[i];
      numbers[i] = numbers[k];
      numbers[k] = temp;
    }
    return numbers;
  }

  private static void print(int[] ps) {
    for (int i = 0; i < ps.length; i++) {
      System.out.print(ps[i] + " ");
    }
    System.out.println();
    System.out.println("==================" + ++count);
  }
}
