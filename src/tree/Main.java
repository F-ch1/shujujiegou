package tree;

public class Main {
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        bst.addEle(7);
        bst.addEle(3);
        bst.addEle(10);
        bst.addEle(5);
        bst.addEle(1);
        bst.addEle(9);
        bst.addEle(12);
        int size = bst.size();
        BST<Integer>.Node search = bst.search(3);
        System.out.println(search);
        BST<Integer>.Node searchparent = bst.searchparent(11);
        System.out.println(searchparent);
        bst.preOrder();
        System.out.println();
        bst.midOrder();
        System.out.println();
        bst.lastOrder();
        System.out.println();
        bst.preOrderNR();
        System.out.println();
        bst.levelOrder();
        BST<Integer>.Node node = bst.removeNode(bst.root, 3);
        System.out.println(node);
    }
}
