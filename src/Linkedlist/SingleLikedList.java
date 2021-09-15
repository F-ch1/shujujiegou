package Linkedlist;

public class SingleLikedList<E> {
    private class Node{
        public E e;//Node节点的元素
        private Node next; //下一个节点的指针 仍然是Node类型
        public Node(E e){//构造方法
            this.e=e;
        }
        public Node(E e,Node next ){
            this.e=e;
            this.next=next;
        }
        public  Node(){

        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
    //头结点指针 Node类型
    //private Node head;
    private Node dummyhead; //虚拟头节点
    //链表长度
    private int size;
    public int getSize() {
        return size;
    }
    //构造方法
    public SingleLikedList() {
        this.dummyhead = new Node(null,null);
        this.size = 0;
    }
    //判断为空
    public boolean isEmpty(){
        return size == 0;
    }
    //向链表头部加入元素
    public void addFirst(E e){
        add(0,e);
        /*Node node = new Node();
        node.next=head;//加入节点的下一个指针指向头结点
        head=node;//加入的节点成为头结点
        node.e=e;//将加入的元素赋值给e
        size++;//链表长度+1*/
    }
    //向链表加入元素
    public void add(int index,E e){
        if (index<0||index>size){
            throw  new RuntimeException("index<0||index>=size");
        }

            Node prev = dummyhead; //待添加节点开始为虚拟头结点
            for (int i=0;i<index;i++){//找到给定节点位置
                                    // index-1为给定节点的前一个节点（从0开始但有一个虚拟节点）
                prev=prev.next;
            }
          /*  Node node = new Node();//新建一个节点
            node.next=prev.next;//将待插入节点的前节点的下一个节点的指针赋值给待插入节点的下一个节点
            prev.next=node;//将插入节点赋值的给前节点的下一个节点的指针
            node.e=e;*/
            prev.next= new Node(e, prev.next);
            /*
            * new Node(e, prev.next); 新建一个节点 待插入节点的下一个节点的指针为待插入节点的前节点的下一个节点的指针
            * prev.next=   将插入的节点复制给前节点的下一个节点的指针
            * */
            size++;
        }
    //向链表尾部加入元素
    public void addLast(E e){
        add(size,e);
    }
    //获得指定位置的元素（是下标为index  下标从0开始）
    public E get(int index){
        if (index<0||index>size){
            throw new RuntimeException("index<0||index>size");
        }
        Node node = dummyhead.next;//将代查节点设为虚拟头结点的下一个节点就是头结点（从0开始）
        for (int i=0;i<index;i++){//遍历找到待查位置的节点 index-1为指定节点位置（从0开始）

            node=node.next;//节点的下一个节点指针赋值给待查节点
        }
        return node.e; //获得指定位置的节点并返回元素的值
    }
    //获得头结点（
    public E getFirst(int index){
        E e = get(0);
        return e;
    }
    //获得指尾结点
    public E getLast(int index){
        return get(size-1);
    }
    //修改指定下标的元素节点
    public void set(int index,E e){
        if (index<0||index>size){
            throw new RuntimeException("index<0||index>size");
        }
      Node node = dummyhead.next;
        for (int i=0;i<index;i++){//node.next为指定index的节点
            node=node.next;//node.next赋值给node
        }
        node.e=e;
    }
    public boolean contains(E e){
        Node node = dummyhead.next;//辅助指针
        for (int i=0;i<size-1;i++){
            if (node.e.equals(e)){
                return true;
            }
           node=node.next;
        }
        return false;
    }
    //删除指定节点
    public E remove(int index){
        if (index<0||index>size){
            throw new RuntimeException("index<0||index>size");
        }
        Node prev = dummyhead;//从虚拟节点开始
        for (int i=0;i<index;i++){//找到待删除节点的前一个节点 从虚拟节点开始
            prev=prev.next;
        }
       Node node = prev.next;//的到待删除节点node（前一个节点的下一个节点）
        prev.next=node.next;//将删除节点的下一节点指向前一个节点的下一个节点
        node.next=null;//删除节点的下一个节点设置为空 垃圾回收
        size--;//大小减1
        return node.e;
    }
    public E removeFirst(){
       return remove(0);
    }
    public E removeLast(){
       return remove(size-1);
    }
    //按节点值删除
    public void removeElement(E e){
        Node prev = dummyhead;
        while (prev.next!=null){
            if(prev.next.e.equals(e)){//prev.next为待删除节点
                break;
            }
            prev=prev.next;
        }
        if (prev.next!=null){
            Node delNode =prev.next;
            prev.next=delNode.next;
            delNode.next=null;
            size--;
        }
    }
    //实现链表翻转
    public void reverset(){
        Node cur = dummyhead.next;
        Node node =cur.next;
        Node reverHead =new Node();
        while (cur!=null){
            node=cur.next;
            cur.next=reverHead.next;
            reverHead.next=cur;
            cur=node;
        }
       dummyhead=reverHead;
    }
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node node = dummyhead.next;
        while (node!=null){
            stringBuilder.append(node+"->");
            node=node.next;
        }
        stringBuilder.append("NULL");
        return stringBuilder.toString();
    }

}
