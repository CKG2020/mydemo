package com.example.demo123;

public class Ques {

    public static int Q1(int[] a, int top){
        top=top-1;
        for(int i=0;i<a.length;i++){
            for (int j=i;j<a.length;j++){
                int temp;
                if (a[i]<a[j]){
                    temp=a[i];
                    a[i]=a[j];
                    a[j]=temp;
                }
            }
        }
        return a[top];
    }

    public static int InsertSort(int[] a, int top){//插入排序
        for(int i=1;i<a.length;i++){
            int temp = a[i];
            int j;
            for(j=i-1;j>=0&&a[j]>temp;j--){
                a[j+1] = a[j];
            }
            a[j+1] = temp;
        }
        top=a.length-top;
        return a[top];
    }

    public static void main(String[] args) {
        int[] a = new int[]{10, 13, 9, 4, 5, 2};
        System.out.println(Q1(a,1));
        int[] b = new int[]{10, 13, 9, 4, 5, 2};
        System.out.println(InsertSort(b,1));
    }
}
