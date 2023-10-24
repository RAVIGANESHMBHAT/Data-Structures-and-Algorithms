import java.util.Scanner;

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class TreeCreationUsingLinkedList {
    TreeNode root;

    TreeNode create() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value:");
        int data = sc.nextInt();
        if (data == -1) {
            sc.close();
            return null;
        }
        root = create();
        System.out.println("Enter left child of " + data);
        root.left = create();
        System.out.println("Enter right child of " + data);
        root.right = create();

        sc.close();

        return root;
    }

    public static void main() {
        TreeCreationUsingLinkedList t = new TreeCreationUsingLinkedList();
        TreeNode root = t.create();
        System.out.println(root);
    }
}