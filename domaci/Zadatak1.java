/*
Написати функцију која прима матрицу (2Д низ) и враћа највећи ред (по збиру)
Hint: Сетите се како смо радили највећи елемент низа
int[][] matrix = { { 3, 2, 1, 7 },
           { 9, 11, 5, 4 },
           { 6, 0, 13, 17 },
           { 7, 21, 14, 15 } };

largestRow(matrix); // Враћа - [7, 21, 14, 15]
 */

import java.util.Arrays;
import java.util.Stack;

public class Zadatak1 {
    public static void main(String[] args) {
        int[][] matrix = { { 3, 2, 1, 7 },
                { 9, 11, 5, 4 },
                { 6, 0, 13, 17 },
                { 7, 21, 14, 15 } };
        System.out.println(Arrays.toString(largestRow(matrix)));


    }
    public static int[] largestRow(int[][] lista){
        Stack<int[]> temp = new Stack<>();
        int sum = 0;
        for (int[] ints : lista) {
            int tempSum = 0;
            for (var j = 0; j < lista.length; j++) {
                tempSum += ints[j];
            }
            if (sum <= tempSum) {
                temp.push(ints);
                sum = tempSum;
            }

        }

     return temp.pop();
    }


}
