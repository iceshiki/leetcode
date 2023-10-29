package model;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author chenjianchao
 * @description TODO
 * @createDate 2022/11/24 13:44
 */
public class TreeNodeTools {
    public static TreeNode buildTree(Integer[] numArray) {

        if (numArray.length == 0) {
            return null;
        }
        final TreeNode root = new TreeNode(numArray[0]);
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        int index = 1;

        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (numArray.length <= index) {
                break;
            }
            poll.left = setSubNode(numArray[index], queue);
            index++;
            poll.right = setSubNode(numArray[index], queue);
            index++;
        }
        return root;
    }

    private static TreeNode setSubNode(Integer num, Queue<TreeNode> queue) {
        TreeNode node = null;
        if (null != num) {
            node = new TreeNode(num);
            queue.add(node);
        }
        return node;
    }

    public static void prePrint(TreeNode head){
        if (head == null) {
            return;
        }
        System.out.print(head.val+" ");
        prePrint(head.left);
        prePrint(head.right);
    }
}
