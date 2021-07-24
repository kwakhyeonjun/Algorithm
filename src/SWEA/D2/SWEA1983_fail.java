package SWEA.D2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SWEA1983_fail {
    static double[][] students;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++){
            int N = sc.nextInt();
            int K = sc.nextInt();
            students = new double[N][2];
            for(int i = 0; i < N; i++){
                int midterm_exam = sc.nextInt();
                int final_exam = sc.nextInt();
                int assignment = sc.nextInt();
                double total = midterm_exam * 0.35 + final_exam * 0.45 + assignment * 0.2;
                students[i][0] = i + 1;
                students[i][1] = total;
            }
            sort(students);
            for(int i = 0 ; i < N; i++){
                if((int)students[i][0] == K){
                    System.out.printf("#%d %s\n", test_case, getGrade(i, N));
                }
            }
        }
    }

    private static String getGrade(int i, int N) {
        int check = N/10;
        int temp = 0;
        for(int j = 1; j <= 10; j++){
            if(check * j > i && check * (j - 1) <= i){
                temp = j - 1;
            }
        }
        switch (temp){
            case 0:
                return "D0";
            case 1:
                return "C-";
            case 2:
                return "C0";
            case 3:
                return "B0";
            case 4:
                return "B-";
            case 5:
                return "B+";
            case 6:
                return "C+";
            case 7:
                return "A-";
            case 8:
                return "A0";
            case 9:
                return "A+";
            default:
                return "F";
        }
    }

    public static void sort(double[][] arr){
        quickSort(arr, 0, arr.length -1);
    }

    public static void quickSort(double[][] arr, int lo, int hi){
        if(lo>=hi) return;

        int pivot = partition(arr, lo, hi);
        quickSort(arr, lo, pivot);
        quickSort(arr, pivot+1, hi);
    }

    public  static int partition(double[][] arr, int left, int right){
        int lo = left - 1;
        int hi = right + 1;
        double pivot = arr[(left + right) / 2][1];

        while(true){
            do{
                lo++;
            }while(arr[lo][1] < pivot);

            do{
                hi--;
            }while(arr[hi][1] > pivot && lo <= hi);
            if(lo >= hi) return hi;
            swap(arr, lo, hi);
        }
    }
    private static void swap(double[][] arr, int i, int j){
        double temp1 = arr[i][0];
        double temp2 = arr[i][1];
        arr[i][0] = arr[j][0];
        arr[i][1] = arr[j][1];
        arr[j][0] = temp1;
        arr[j][1] = temp2;
    }
}
