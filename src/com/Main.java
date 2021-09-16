package com;

public class Main {
    public static void main(String[] args) {
            MyArray<Integer> myArray = new MyArray();
            myArray.addLast(333);
            myArray.addLast(200);
            myArray.addLast(200);
            myArray.addLast(200);
            myArray.addFirst(50);
            myArray.add(1,2);
            //myArray.remove(0);
            myArray.removeEle(2);
        System.out.println(myArray);
        System.out.println(myArray.contains(200));
        System.out.println("master test");
        System.out.println("hot fix test");
    }
}
