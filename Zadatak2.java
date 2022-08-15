/*
Написати програм који највећу (по збиру) колону, ставља на прво место
int[][] matrix = { { 3, 2, 1, 7 },
           { 9, 11, 5, 4 },
           { 6, 0, 13, 17 },
           { 7, 21, 14, 15 } };

// ... Овде иде ваша магија

int[][] result = { { 7, 3, 2, 1 },
           { 4, 9, 11, 5 },
           { 17, 6, 0, 13 },
           { 15, 7, 21, 14 } };
 */



import java.util.Arrays;


// comentar
public class Zadatak2 {
    public static void main(String[] args) {
        int[][] matrix = { { 3, 2, 1, 7 },
                { 9, 11, 5, 4 },
                { 6, 0, 13, 17 },
                { 7, 21, 14, 15 } };
        for (var el:
             matrix) {
            System.out.println(Arrays.toString(el));
        }
        System.out.println(indexOfMax(matrix));

        for (var el:
             result(matrix,indexOfMax(matrix))) {
            System.out.println(Arrays.toString(el));
        }

    }


    public static int[][] result(int[][] lista, int maxIndex){
        for (var el:
             lista) {
            var temp = el[maxIndex];
            el[maxIndex] = el[0];
            el[0] = temp;
        }
       int index = 1;
        while (index != maxIndex) {
            if (index == maxIndex) break;

            for (var el :
                    lista) {
                var temporary = el[maxIndex];
                el[maxIndex] = el[index];
                el[index] = temporary;
            }
            index++;

        }
        return lista;
    }

    // funkcija koja vraca index kolone sa najvecim zbirom elemenata
    public static int indexOfMax(int[][] lis){
        int[] sums = new int[lis.length];
        int index = 0;
        int max = 0;
        for (var el:
             lis) {
            sums[index] = sumOfVertikal(lis, index);
            if (max < sums[index]) max = sums[index];

            index++;
        }

        int i = 0;
        for (var el:
             sums) {
            if (el == max) break;
            i++;
        }
        return i;
    }
    // step je index j za kolonu
    public static int sumOfVertikal(int[][] list, int step){
        int sum = 0;
        for (var el:
                list) {
            sum += el[step];
        }
        return sum;
    }
}
