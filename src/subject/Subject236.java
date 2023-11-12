package subject;

import model.TreeNode;
import model.TreeNodeTools;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * <p>
 * 示例 1：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
 * 输出：3
 * 解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
 * <p>
 * 示例 2：
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
 * 输出：5
 * 解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
 * <p>
 * 示例 3：
 * 输入：root = [1,2], p = 1, q = 2
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * 树中节点数目在范围 [2, 105] 内。
 * -109 <= Node.val <= 109
 * 所有 Node.val 互不相同 。
 * p != q
 * p 和 q 均存在于给定的二叉树中。
 *
 * @level medium
 */
public class Subject236 {
    private TreeNode ans;

    /**
     * 方法一
     * 方法二 可是使用hash存储p访问过的节点，q再次访问如果匹配到就是最近公共祖先
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        this.preOrder(root, p, q);
        return ans;
    }

    public boolean preOrder(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = preOrder(root.left, p, q);
        boolean rson = preOrder(root.right, p, q);

        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public static void main(String[] args) {
        Subject236 subject236 = new Subject236();
        System.out.println(subject236.lowestCommonAncestor(TreeNodeTools.buildTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}), new TreeNode(5), new TreeNode(1)).val);
        System.out.println(subject236.lowestCommonAncestor(TreeNodeTools.buildTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4}), new TreeNode(5), new TreeNode(4)).val);
        System.out.println(subject236.lowestCommonAncestor(TreeNodeTools.buildTree(new Integer[]{2, 1}), new TreeNode(2), new TreeNode(1)).val);
    }
}
