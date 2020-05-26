package com.company;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static int inputInt() {
        Scanner in = new Scanner(System.in);
        int vvod = in.nextInt();
        return vvod;
    }

    public static long inputLong() {
        Scanner in = new Scanner(System.in);
        long vvod = in.nextLong();
        return vvod;
    }

    public static double inputDouble() {
        Scanner in = new Scanner(System.in);
        double vvod = in.nextDouble();
        return vvod;
    }

    public static String inputStr() {
        Scanner in = new Scanner(System.in);
        String vvod = in.nextLine();
        return vvod;
    }

    public static char inputchar() throws IOException {
        Scanner in = new Scanner(System.in);
        char vvod = (char) System.in.read();
        return vvod;
    }

    public static void task1(int N, int K, String str) {
        String[] arr = str.split(" ");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length() > K) {
                System.out.println("Превышено количество символов в одной строке");
                return;
            }
            if (arr.length > N) {
                System.out.println("Превышено количество слов в сочинении");
                return;
            }
        }
        System.out.println(Arrays.toString(arr));
        String out = "";
        int length = 0;

        for (int i = 0; i < arr.length; i++) {
            length += arr[i].length();
            if (length <= K) {
                out += arr[i] + " ";
                if (i == arr.length - 1) {
                    System.out.println((out));
                }
            } else {
                System.out.println(out);
                out = "";
                i = i - 1;
                length = 0;
            }
        }
    }

    public static String task2(String str) {
        int raz = 0, ind = 0, num = 0;
        String[] str1 = new String[str.length()];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                raz++;
            }
            if (str.charAt(i) == ')') {
                raz--;
            }
            if (raz < 0) {
                return "Error";
            }
            if (raz == 0) {
                str1[ind] = "";
                for (int j = num; j <= i; j++) {
                    str1[ind] += str.charAt(j);
                }
                num = i + 1;
                ind++;
            }
        }

        String[] str2 = new String[ind];
        for (int i = 0; i < str2.length; i++) {
            str2[i] = str1[i];
        }
        return Arrays.toString(str2);
    }

    public static String task3Camel(String str) {
        String out = "";
        int length = str.length();
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

    public static String task3Snake(String str) {
        String out = "";
        int length = str.length();
        for (int i = 0; i < str.length(); i++) {
            if ((int) str.charAt(i) > 64 && (int) str.charAt(i) < 91) {
                out += "_";
                out += Character.toLowerCase(str.charAt(i));
            } else {
                out += str.charAt(i);
            }
        }
        return out;
    }

    public static String task4(double start, double end, double rate, double multiplier) {
        double salary = 0;
        if (end >= 17) {
            if (end - 17 >= 0) {
                salary += rate * (end - 17) * multiplier;
            }
            if (17 - start >= 0) {
                salary += rate * (17 - start);
            }
        } else {
            if (end - start >= 0) {
                salary += rate * (end - start) * multiplier;
            }
        }
        String formattedSalary = String.format("%.2f", salary);
        return formattedSalary;
    }

    public static String task5(double weight, String type_w, double height, String type_h) {
        if (type_w == "pounds" || type_w == "Pounds") {
            weight = weight * 0.454;
        }
        if (type_h == "inches" || type_h == "Inches") {
            height = height * 0.05;
        }
        double BMI = weight / (Math.pow(height, 2));
        String formattedBMI = String.format("%.1f", BMI);
        if (BMI >= 25) {
            return "BMI=" + formattedBMI + " overweight";
        }
        if (BMI >= 18.5 && BMI <= 24.9) {
            return "BMI=" + formattedBMI + " normal weight";
        } else {
            return "BMI=" + formattedBMI + " underweight";
        }
    }

    public static int task6(long n) {
        if(n < 10) {return 0;}
        long num = 1;
        while(n != 0) {
            num*=(n % 10);
            n/=10;
        }
        return 1 + task6(num);
    }

    public static String task7(String str) {
        String out = "";
        int count = 0;
        int ind = 0;
        for (int i = 0; i < str.length()-1;i++){
            if (str.charAt(i)==str.charAt(i+1)){
                ind = i;
                count++;
            }
            else{
                if (count != 0){
                    count++;
                    out += str.charAt(i) + "*" + count;
                }
                else{
                    out += str.charAt(i);
                }
                count = 0;
            }
        }
        if (count != 0){
            count++;
            out += str.charAt(ind) + "*" + count;
        }
        if (str.charAt(str.length()-1)!=str.charAt(str.length()-2)){
            out += str.charAt(str.length()-1);
        }
        return out;
    }

    public static boolean task8(String arr1, String arr2) {
        String [] str1 = arr1.split(" " );
        String [] str2 = arr2.split(" " );
        String str1_1 = "";
        str1_1 +=  str1[str1.length-1];
        str1_1 = str1_1.toUpperCase();
        String str2_2 = "";
        str2_2 +=  str2[str2.length-1];
        str2_2 = str2_2.toUpperCase();
        String out1 = "";
        for (int i = 0; i < str1_1.length();i++){
            if(str1_1.charAt(i) == 'A' || str1_1.charAt(i) == 'E' || str1_1.charAt(i) == 'I' || str1_1.charAt(i) == 'O' || str1_1.charAt(i) == 'U'){
                out1+=(char)str1_1.charAt(i);
            }
        }
        String out2 = "";
        for (int i = 0; i < str2_2.length();i++){
            if(str2_2.charAt(i) == 'A' || str2_2.charAt(i) == 'E' || str2_2.charAt(i) == 'I' || str2_2.charAt(i) == 'O' || str2_2.charAt(i) == 'U'){
                out2+=(char)str2_2.charAt(i);
            }

        }
        if (out1.length()==out2.length()){
            for (int i = 0; i<out1.length();i++){
                if (out1.charAt(i)!=out2.charAt(i)){
                    return false;
                }
            }
            return true;
        }
        else{
            return false;
        }
    }
    public static boolean task9(long num1, long num2)
    {
        for (int i = 1; i < 10; i++)
        {
            if (Long.toString(num1).contains(Integer.toString(i) + Integer.toString(i) + Integer.toString(i)))
            {
                if (Long.toString(num2).contains(Integer.toString(i) + Integer.toString(i)))
                    return true;
            }
        }
        return false;
    }

    public static String task10(String str, String sep){
        if (str.length() <= 2){
            return "Error";
        }
        String [] parts = str.split(sep);
        String part = "";
        for (int i = 0; i < parts.length; i++){
            if (i % 2 != 0){
                part += parts[i];
            }
        }
        char []chars=part.toCharArray();
        Arrays.sort(chars);
        part = "";
        boolean flag = true;
        if (chars.length==1){
            return "Количество уникальных символов(книг): " + chars.length + "Уникальные символы(книги): " + Arrays.toString(chars);
        }
        for (int i = 0; i < chars.length-1; i++){
            if (chars[i]!=chars[i+1]){
                part +=chars[i];
            }
            else{
                flag = false;
            }
        }
        if (flag==false){
            part+=chars[chars.length-1];
        }
        char [] charsNew = part.toCharArray();
        return "Количество уникальных символов(книг): " + charsNew.length + "Уникальные символы(книги): " + Arrays.toString(charsNew);
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
                    double a=inputDouble(), b=inputDouble(),c=inputDouble(), d=inputDouble();
                    System.out.println("Зарплата: $"+ task4(a,b,c,d));
                    break;
                case (5):
                    double w=inputDouble();
                    String type_w=inputStr();
                    double h=inputDouble();
                    String type_h=inputStr();
                    System.out.println("Результат: "+ task5(w,type_w,h,type_h));
                    break;
                case(6):
                    int n=inputInt();
                    System.out.println(task6(n));
                    break;
                case(7):
                    String str2=inputStr();
                    System.out.println(task7(str2));
                    break;
                case(8):
                    String str3=inputStr(), str4=inputStr();
                    System.out.println(task8(str3,str4));
                    break;
                case(9):
                    long e=inputLong(), f=inputLong();
                    System.out.println(task9(e,f));
                    break;
                case(10):
                    String str5=inputStr(), str6=inputStr();
                    System.out.println(task10(str5,str6));
                    break;
                case(11):
                    System.out.println("До свидания!");
                    break;
            }
        } while (key!=11);
    }
}
