package assn04;

public class Main {
  public static void main(String[] args) {
    /*
    This is a basic example of how to create a BST and add values
    to it (which have been commented out).
    You should add more examples and use this class to debug your code
    */
    BST<Integer> bst = new NonEmptyBST<Integer>(3);
    bst.printPreOrderTraversal();
    System.out.println(bst.findMin());
    System.out.println("");

    bst.remove(3);
    bst.printPreOrderTraversal();
    System.out.println("");
    bst.printPostOrderTraversal();


  }

}
