package tree;

import Linkedlist.SingleLikedList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E> > {
    public class Node{
        E e;
        Node left;
        Node right;
        public Node(E e){
            this.e=e;
            this.left=null;
            this.right=null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
    public Node root;
    private int size;
    public int size(){
        return size;
    }
 /*
 public void addEle(E e){
        if (root==null){
           root=new Node(e);
            size++;
        }else {
            addEle(root,e);
        }
    }*/
    public void addEle(E e){
        root=addEle(root,e);
    }
    /*
    private void addEle(Node node, E e) {
        if (node.left==null&&e.compareTo(node.e)<0){
            node.left=new Node(e);
            size++;
            return;
        }else if (node.right==null&&e.compareTo(node.e)>0){

            size++; node.right=new Node(e);
            return;
        }
        if (e.compareTo(node.e)<0){
            addEle(node.left,e);
        }else if (e.compareTo(node.e)>0){
            addEle(node.right,e);
        }
    }*/
    //方法优化
    private Node addEle(Node node ,E e){
        if (node==null){//递归终止条件
            node=new Node(e);
            size++;
            return node;
        }
        if (e.compareTo(node.e)<0){//递归
            node.left=addEle(node.left,e);
        }else if (e.compareTo(node.e)>0){
            node.right=addEle(node.right,e);
        }
        return node;
    }
    public Node search(E e){
        return search(root,e);
    }
/*
* 在以node为根的树上查找元素e所在的节点
* 查找元素所在节点
* */
    private Node search(Node node, E e) {
        if (node==null){
            return null;
        }
        if (e.compareTo(node.e)==0){
            return node;
        }
        else if (e.compareTo(node.e)<0){
               return search(node.left,e);
        }else if(e.compareTo(node.e)>0){
            return search(node.right,e);
        }
        return node;
    }
    public Node searchparent(E e){
        return searchparent(root,e);
    }

    private Node searchparent(Node node, E e) {
       if (node==null){
           return null;
       }
       if (node.left!=null&&e.compareTo(node.left.e)==0||node.right!=null&&e.compareTo(node.right.e)==0){
           return node;
       }
        if (node.left!=null&&e.compareTo(node.e)<0){
            return searchparent(node.left,e);
        }else if (node.right!=null&&e.compareTo(node.e)>0){
            return searchparent(node.right,e);
        }else {
            return null;
        }

    }
    //先序遍历
    public void preOrder(){
        preOrder(root);
    }
//先序遍历实现
    private void preOrder(Node node) {
        if (node==null){//递归终止条件
            return;
        }
        System.out.print(node.e+",");//先输出根节点
        preOrder(node.left);//递归调用根节点的左节点
        preOrder(node.right);//递归调用根节点的右节点
    }
    //中序遍历
    public void midOrder(){
        midOrder(root);
    }

    private void midOrder(Node node) {
        if (node==null){
            return;
        }
        midOrder(node.left);
        System.out.print(node.e+",");
        midOrder(node.right);
    }
    //后序遍历
    public void lastOrder(){
        lastOrder(root);
    }

    private void lastOrder(Node node) {
        if (node==null){
            return;

        }
        lastOrder(node.left);
        lastOrder(node.right);
        System.out.print(node.e+",");
    }
    //非递归先序遍历
    public void preOrderNR(){
        preOrderNR(root);
    }
    //利用栈非递归先序遍历
    private void preOrderNR(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()){
            Node curNode = stack.pop();
            System.out.print(curNode.e+",");
            if (curNode.left!=null){
                stack.push(curNode.left);
            }if (curNode.right!=null){
                stack.push(curNode.right);
            }
        }
    }
    //广度遍历
    public  void levelOrder(){
        levelOrder(root);
    }
    //广度遍历的实现 利用队列 while循环
    private void levelOrder(Node node) {
        Queue<Node> queue = new LinkedList<Node>();
            queue.add(node);
            while (!queue.isEmpty()){
                Node curNode = queue.remove();
                System.out.print(curNode.e+",");
                if (curNode.left!=null){
                    queue.add(curNode.left);
                }
                if (curNode.right!=null){
                    queue.add(curNode.right);
                }
            }
    }
    //找到根节点右边节点的最小值
    public Node minNode(Node node){
        if (node.left==null){//递归终止条件 根节点的右边最小值的节点没有左节点（左节点最小）
            return node;
        }
        return minNode(node.left);
    }
    //删除节点
    public Node removeNode(Node node,E e){
        if (node==null){
            return null;
        }
        if (e.compareTo(node.e)<0){
            node.left=removeNode(node.left,e);
            return node;
        }else if (e.compareTo(node.e)>0){
            node.right=removeNode(node.right,e);
            return node;
        }else{
            if (node.left==null){//如果待删除子树的左子树为空，则将子树的右子树代替子树的根，
                Node rightNode=node.right;
                node.right=null;// 并将子树根节点对右子树的引用置为空
                size--;
                return rightNode;
            }
            if (node.right==null){
                Node leftNode = node.left;
                node.left=null;
                size--;
                return leftNode;
            }
            Node minNode = minNode(node.right);
            minNode.right = removeNode(node.right, minNode.e);
            minNode.left=node.left;
            node.left=node.right=null;
            return minNode;
        }
    }
}
