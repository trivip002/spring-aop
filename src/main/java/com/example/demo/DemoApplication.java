package com.example.demo;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    /*
        Draw line from n point
     */
    @Test
    public void solution1() {
        var n = 3;
        var a = new int[]{1, 3};
        var b = new int[]{2, 2};
        var c = new int[a.length][2];
        for (var i = 0; i < a.length; i++) {
            c[i] = new int[]{a[i], b[i]};
        }
        var result = checkGoThroughAllVertices(n, c);
        //var result = checkCircle(c);
        System.out.println(result);
    }

    public boolean checkGoThroughAllVertices(int point, int[][] arr) {
        var result = new int[0][];
        for (var i = 1; i <= point; i++) {
            for (var j = 0; j < arr.length; j++) {
                if ((arr[j][0] == i && arr[j][1] == i + 1) || (arr[j][1] == i && arr[j][0] == i + 1)) {
                    result = ArrayUtils.add(result, arr[j]);
                    arr = ArrayUtils.removeElement(arr, arr[j]);
                    j--;
                } else if (arr[j][0] == i || arr[j][1] == i) {
                    arr = ArrayUtils.removeElement(arr, arr[j]);
                    j--;
                }
            }
        }
        System.out.println(Arrays.deepToString(result));
        return result.length == point - 1;
    }

    public boolean checkCircle(int[][] arr) {
        var resultLine = new ArrayList<int[]>();
        var result = true;
        resultLine.add(arr[0]);
        arr = ArrayUtils.removeElement(arr, arr[0]);
        for (var i = 0; i < resultLine.size(); i++) {
            for (var j = 0; j < arr.length; j++) {
                if (resultLine.get(i)[1] == arr[j][0] && arr[j][1] != resultLine.get(i)[0]) {
                    var currentLine = arr[j];
                    arr = ArrayUtils.removeElement(arr, arr[j]);
                    resultLine.add(currentLine);
                    break;
                }
            }
        }
        if (arr.length == 0) {
            resultLine.forEach(item -> System.out.println("(" + item[0] + "," + item[1] + ")"));
            return true;
        }
        int[] lastLine = null;
        var numOfArr = arr.length - 1;
        while (numOfArr >= 0) {
            if (resultLine.get(resultLine.size() - 1)[1] == arr[numOfArr][0] && arr[numOfArr][1] == resultLine.get(0)[0]) {
                lastLine = arr[numOfArr];
                break;
            }
            numOfArr--;
        }
        if (lastLine != null && arr.length <= 1) {
            resultLine.add(lastLine);
        } else {
            result = false;
        }
        resultLine.forEach(item -> System.out.println("(" + item[0] + "," + item[1] + ")"));
        return result;
    }

    /*
           params: a string (only digits)
           return: an integer specifying how many numbers divisible by 3 can be obtained with at most one change of a digit
    */
    @Test
    public void solution2() {
        List<String> result = new ArrayList<>();
        String numberStr = "022";
        int number = Integer.parseInt(numberStr);
        if (number % 3 == 0) {
            result.add(numberStr);
        }
        for (int i = 0; i < numberStr.length(); i++) {
            for (int j = 0; j <= 9; j++) {
                StringBuilder numStr = new StringBuilder(numberStr);
                numStr.setCharAt(i, String.valueOf(j).charAt(0));
                int num = Integer.parseInt(numStr.toString());
                if (num % 3 == 0) {
                    result.add(numStr.toString());
                }
            }
        }
        result.stream().distinct().sorted().forEach(System.out::println);
        System.out.println("Output is " + (int) result.stream().distinct().count());
    }

    /*
          params: integer number
          return: the smallest integer greater than N, the sum of whose digits is twice as big as the sum of digits of N.
    */
    @Test
    public void solution3() {
        int input = 14;
        String inputStr = String.valueOf(input);
        StringBuilder result = new StringBuilder();
        int sumInput = 0;
        for (int i = 0; i < inputStr.length(); i++) {
            sumInput += Character.getNumericValue(inputStr.charAt(i));
        }
        sumInput *= 2;
        if (sumInput < input) {
            if (sumInput < 9) {
                result.append(1).append(sumInput - 1);
                System.out.println(result);
            } else {
                while (sumInput > 0) {
                    result.append(Math.min(sumInput, 9));
                    sumInput -= Math.min(sumInput, 9);
                }
                System.out.println(result.reverse());
            }
        } else {
            System.out.println(sumInput);
        }
    }

    /*
      params: 2 array string a[] and b[], string p
      return: the name which contain in p, must smallest in alphabetically.
    */
    @Test
    public void solutionFindContact() {
        final String[] A = new String[]{"sander", "amy", "ann", "michael"};
        final String[] B = new String[]{"123456789", "234567890", "789123456", "123123123"};
        final String P = "1";
        String result = "NO CONTACT";
        List<String> listResults = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            if (A[i].length() > 9 || B[i].length() > 9 || !B[i].matches("^[0-9]*$")) {
                System.out.println(result);
                return;
            }
            if (B[i].contains(P)) {
                listResults.add(A[i].toLowerCase());
            }
        }
        if (listResults.size() != 0) {
            result = listResults.stream().sorted().collect(Collectors.toList()).get(0);
        }
        System.out.println(result);
    }

    @Test
    public void solution() {
        int result = 0;
        Integer[] a = {3,3,3};
        List<Integer> list = Arrays.stream(a).sorted().distinct().collect(Collectors.toList());
        int middleValue = list.get(list.size() / 2);
        for (int i = 0; i < a.length; i++) {
            if (a[i] > middleValue) {
                a[i]--;
                i--;
                result++;
            } else if (a[i] < middleValue) {
                a[i]++;
                i--;
                result++;
            }
        }
        System.out.println(result);
    }

}










