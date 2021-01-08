package com.algorithm.sort;

public class HeapSort {
    public static void main(String[] args) {

        int[] a={100,10,30,20,50,40,4,8,9,77};
        int len=a.length;

        for(int i=0;i<len;i++){
            System.out.print(a[i]+",");
            MinHeapFixup(a,i);
        }System.out.println();

        for(int j=0;j<len;j++){
            System.out.print(a[j]+",");
        }System.out.println();

        for(int k=len-1;k>=1;k--){
            swap(a,k,0);
            MinHeapFixdown(a,0,k);
        }

        for(int j=0;j<len;j++){
            System.out.print(a[j]+",");
        }System.out.println();
    }


    public static void swap(int[] a,int l,int r){
        int t=a[l];
        a[l]=a[r];
        a[r]=t;
    }
    //堆插入
    public static void MinHeapFixup(int a[], int i){
        int j, temp;
        temp = a[i];
        j = (i - 1) / 2;      //父结点
        while (j >= 0 && i != 0)
        {
            if (a[j] <= temp)
                break;
            a[i] = a[j];     //把较大的子结点往下移动,替换它的子结点
            i = j;
            j = (i - 1) / 2;
        }
        a[i] = temp;
    }

    //堆删除
    /**
     * @param a
     * @param i
     * @param n
     */
    public static void MinHeapFixdown(int[] a,int i,int n){
        int j, temp;

        temp = a[i];
        j = 2 * i + 1;
        while (j < n)
        {
            if (j + 1 < n && a[j + 1] < a[j]) //在左右孩子中找最小的
                j++;

            if (a[j] >= temp)
                break;

            a[i] = a[j];     //把较小的子结点往上移动,替换它的父结点
            i = j;
            j = 2 * i + 1;
        }
        a[i] = temp;
    }
}
