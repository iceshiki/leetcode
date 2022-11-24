package subject;

import model.TreeNode;
import model.TreeNodeTools;

import java.util.*;

/**
 * @author ice_shiki
 * @description TODO
 * @createDate 2022/11/24 13:18
 */
public class Subject102 {

    private final List<List<Integer>> levelOrderList = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (null == root) {
            return new ArrayList<>();
        }
        levelNumList(root, 0);
        return levelOrderList;
    }

    public void levelNumList(TreeNode node, int level) {
        List<Integer> numList;
        if (levelOrderList.size() <= level) {
            numList = new LinkedList<>();
            levelOrderList.add(numList);
        } else {
            numList = levelOrderList.get(level);
        }
        numList.add(node.val);

        if (node.left != null) {
            levelNumList(node.left, level + 1);
        }
        if (node.right != null) {
            levelNumList(node.right, level + 1);
        }
    }

    public static void main(String[] args) {
//        Integer[] integers = {3, 9, 20, null, null, 15, 7};
        Integer[] integers = {};

        TreeNode root = TreeNodeTools.buildTree(integers);

        new Subject102().levelOrder(root);
    }
}

