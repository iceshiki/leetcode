package subject;

import model.LinkListNode;
import tool.LinkListTools;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 示例 1：
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：[2,1]
 * 示例 3：
 * 输入：head = []
 * 输出：[]
 * 提示：
 * 链表中节点的数目范围是 [0, 5000]
 * -5000 <= Node.val <= 5000
 * 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/reverse-linked-list">...</a>
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author chenjianchao
 * @description TODO
 * @createDate 2022/11/17 11:20
 */
public class Subject206 {
    public static LinkListNode reverseList(LinkListNode head) {
        LinkListNode prev = null;
        LinkListNode next;
        while (null != head) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }


    public static void main(String[] args) {
        LinkListNode head = null;
        for (int i = 5; i > 0; i--) {
            LinkListNode node = new LinkListNode(i);
            if (null != head) {
                node.next = head;
            }
            head = node;
        }

        LinkListTools.print(head);
        head = reverseList(head);
        System.out.println();
        LinkListTools.print(head);
    }

}
