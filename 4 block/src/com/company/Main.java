package com.company;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int inputInt (){
        Scanner in = new Scanner(System.in);
        int vvod = in.nextInt();
        return vvod;
    }
    public static double inputDouble (){
        Scanner in = new Scanner(System.in);
        double vvod = in.nextDouble();
        return vvod;
    }
    public static String inputStr (){
        Scanner in = new Scanner(System.in);
        String vvod = in.nextLine();
        return vvod;
    }
    public static char inputchar () throws IOException {
        Scanner in = new Scanner(System.in);
        char vvod=(char)System.in.read();
        return vvod;
    }

    public static void task1(int N, int K, String str){
        String [] arr= str.split(" ");
        for(int i=0;i<arr.length;i++){
            if(arr[i].length()>K){
                System.out.println("Превышено количество символов в одной строке");
                return;
            }
            if(arr.length>N){
                System.out.println("Превышено количество слов в сочинении");
                return;
            }
        }
        System.out.println(Arrays.toString(arr));
        String out="";
        int length=0;

        for(int i=0;i<arr.length;i++){
            length+=arr[i].length();
            if(length<=K){
                out+=arr[i]+" ";
                if(i==arr.length-1){
                    System.out.println((out));
                }
            }
            else{
                System.out.println(out);
                out="";
                i=i-1;
                length=0;
            }
        }
    }

    public static String task2(String str) {
        int raz = 0, ind = 0, num = 0;
        String [] str1 = new String[str.length()];
        for (int i = 0; i < str.length(); i++){
            if(str.charAt(i)=='('){
                raz++;
            }
            if(str.charAt(i)==')'){
                raz--;
            }
            if(raz < 0){
                return "Error";
            }
            if(raz == 0){
                str1[ind]="";
                for (int j=num;j<=i;j++) {
                    str1[ind] += str.charAt(j);
                }
                num=i+1;
                ind++;
            }
        }

        String [] str2 = new String[ind];
        for (int i = 0; i < str2.length; i++) {
            str2[i]=str1[i];
        }
        return Arrays.toString(str2);
    }

    public static String task3Camel(String str){
        String out="";
        int length=str.length();
        for (int i = 0; i < length - 1; i++) {
            if (str.charAt(i) == '_') {
                out += Character.toUpperCase(str.charAt(i + 1));
                i++;
            } else {
                out += str.charAt(i);
            }
        }
        if (str.charAt(length - 1) != '_') {
            out += str.charAt(length - 1);
        }
        return out;
    }
    public static String task3Snake(String str){
        String out="";
        int length=str.length();
        for (int i = 0; i<str.length();i++){
            if((int)str.charAt(i) > 64 && (int)str.charAt(i) < 91){
                out += "_";
                out += Character.toLowerCase(str.charAt(i));
            }
            else {
                out += str.charAt(i);
            }
        }
        return out;
    }

    public static void main(String[] args) {
        int key=0;
        int key1=0;
        do{
            System.out.println("Введите номер задания или 11 для выхода:");
            key=inputInt();
            switch (key){
                case (1):
                    int N=inputInt(), K=inputInt();
                    String str=inputStr();
                    task1(N,K,str);
                    System.out.println();
                    break;
                case(2):
                    String str1=inputStr();
                    System.out.println(task2(str1));
                    break;
                case(3):
                    do{
                    System.out.println("Введите номер подзадания или 3 для выбора основного задания:");
                    key1=inputInt();
                    switch (key1) {
                        case (1):
                            String str2 = inputStr();
                            System.out.println(task3Camel(str2));
                            break;
                        case (2):
                            String str3 = inputStr();
                            System.out.println(task3Snake(str3));
                            break;
                        case(3):
                            break;
                    }
                    }while(key1!=3);
                    break;
                case(4):

                    break;
                case (5):

                    break;
                case(6):

                    break;
                case(7):

                    break;
                case(8):

                    break;
                case(9):

                    break;
                case(10):

                    break;
                case(11):

                    break;
            }
        } while (key!=11);
    }
}
