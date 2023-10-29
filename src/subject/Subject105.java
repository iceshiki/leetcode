package subject;

import model.TreeNode;
import model.TreeNodeTools;

import java.util.Arrays;

public class Subject105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length > 1) {
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == root.val) {
                    if (i > 0) {
                        int[] leftSubPreorder = Arrays.copyOfRange(preorder, 1, i+1);
                        int[] leftSubInorder = Arrays.copyOfRange(inorder, 0, i);
                        root.left = buildTree(leftSubPreorder, leftSubInorder);
                    }
                    if (i < preorder.length - 1) {
                        int[] rightSubPreorder = Arrays.copyOfRange(preorder, i + 1, preorder.length);
                        int[] rightSubInorder = Arrays.copyOfRange(inorder, i + 1, inorder.length);
                        root.right = buildTree(rightSubPreorder, rightSubInorder);
                    }
                    break;
                }
            }
        }
        return root;
    }


    public static void main(String[] args) {
        Subject105 subject105 = new Subject105();

        TreeNode root = subject105.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        TreeNodeTools.prePrint(root);

    }
}
