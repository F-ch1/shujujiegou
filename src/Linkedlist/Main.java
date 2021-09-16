package Linkedlist;

public class Main {
    public static void main(String[] args) {
        SingleLikedList<Integer> linklist = new SingleLikedList<Integer>();

        for (int i=0;i<5;i++){
            linklist.addFirst(2);
        }
        linklist.add(0,1);
        linklist.add(1,1);
        linklist.addLast(5);
        linklist.set(0,100);
        linklist.set(3,3);
        linklist.removeElement(3);
        System.out.println(linklist);
        linklist.reverset();
        System.out.println(linklist);
        boolean contains = linklist.contains(20);
        System.out.println(contains);
         System.out.println("pull test");
    }
}
