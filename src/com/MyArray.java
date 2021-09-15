package com;

import java.util.Arrays;

public class MyArray<E> {
    private E[] data;//数据
    private int size;//数组大小

    public MyArray(int capacity){
        data = (E[]) new Object[capacity];//数组容量
        size=0;
    }
    public MyArray(){
        this(10);
    }
    //得到数组容量
    public int getcapacity(){
        return data.length;
    }
    //得到数组大小
    public int getSize(){
        return size;
    }
    //判断是否为空
    public boolean isEmpty(){
        return size==0;
    }
    //数组末尾添加数据
    public void addLast(E ele){
       /* if (size==data.length){
            throw new RuntimeException("数组已满...");
        }
        data[size]=ele;
        size++;*/
        add(size,ele);
    }
    //数组添加数据
    public void add(int index,E ele){
        if (size==data.length){
            throw new RuntimeException("数组已满...");
        }
        if (index>=data.length||index<0){
            throw  new RuntimeException("index<0||index>=size");
        }
        //将索引为index的位置空出来 下标后的数据向后挪一位；
        //i=size-1位数组中最后一个数
        for (int i=size-1;i>=index;i--){
            data[i+1]=data[i];
        }
        data[index]=ele;
        size++;
    }
    //数组第一位添加数据
    public void addFirst(E ele){
        add(0,ele);
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }
//查找索引位置的元素
    public E get(int index){
        if (index<0||index>=size){
            throw  new RuntimeException("index<0||index>=size");
        }
     return data[index];
    }
    //修改索引位置的元素内容
    public void set(int index,E ele){
        if (index<0||index>=size){
            throw  new RuntimeException("index<0||index>=size");
        }
        data[index]=ele;
    }
    public boolean contains(E ele){
        for (int i=0;i<size-1;i++){
            if (data[i].equals(ele)){
                return true;
            }
        }
        return false;
    }
    public  int find(E ele){
        for (int i=0;i<size-1;i++){
            if (data[i].equals(ele)){
                return i;
            }
        }
        return -1;
    }
    public E remove(int index){
        if (index<0||index>=size){
            throw  new RuntimeException("index<0||index>=size");
        }
        // index后的所有数据向前移动一位
        //index+1 为索引后的第一位
        //i<=size-1 数组大小
        for (int i=index+1;i<=size-1;i++){
            data[i-1]=data[i];
        }
        //前移后最后一位上的值置0
        data[size-1]=null;
        size--;
        return data[index];
    }
    public E removeFirst(){
        return remove(0);
    }
    public E removeLast(){
        return remove(size-1);
    }
    public void removeEle(E ele){
        int index = find(ele);
        if(index!=-1){
            remove(index);}
    }
}
