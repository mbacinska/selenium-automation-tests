package com.selenium.automated.tests;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class SortedArray {

  public static Scanner scanner = new Scanner(System.in);
  public static void main(String[] args) {
    Integer[] myArr = getIntegers(4);
    printArray(myArr);
    sortArray(myArr);

  }

  public static Integer[] getIntegers(int num) {
    Integer[] array = new Integer[num];
    System.out.println("Enter "+num+ " numbers");
    for (int i = 0; i < array.length; i++) {
      array[i] = scanner.nextInt();

    }
    return array;
  }
  public static void printArray(Integer[] array){
    for(int i=0;i<array.length;i++){
      System.out.println("My array "+i+ " element is: "+array[i]);
    }

  }
  public static void sortArray(Integer[] array){
    Arrays.sort(array, Collections.reverseOrder());
    System.out.println(Arrays.toString(array));
  }
}
