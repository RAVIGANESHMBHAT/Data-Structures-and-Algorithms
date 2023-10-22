import java.util.Scanner;

public class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class TreeCreationUsingLinkedList {
    TreeNode root;

    static TreeNode create() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value:")
        int data = sc.nextInt();
        if(data == -1) {
            return null;
        }
        root = create();
        System.out.println("Enter left child of "+ data);
        root.left = create();
        System.out.println("Enter right child of "+ data);
        root.right = create();
    }

    public static void main() {
        TreeNode root = create();
    }
}