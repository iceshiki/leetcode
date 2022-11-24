package subject;

import model.ListNode;

/**
 * 合并两个有序链表
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 示例 1：
 * 输入：l1 = [1,2,4], l2 = [1,3,4]
 * 输出：[1,1,2,3,4,4]
 *
 * 示例 2：
 * 输入：l1 = [], l2 = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：l1 = [], l2 = [0]
 * 输出：[0]
 *
 * 提示：
 * 两个链表的节点数目范围是 [0, 50]
 * -100 <= Node.val <= 100
 * l1 和 l2 均按 非递减顺序 排列
 * @author ice_shiki
 * @createDate 2022/11/21
 */
public class Subject21 {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        while (true) {
            if (list1.val < list2.val) {
                node.next = list1;
                list1 = list1.next;
            } else {
                node.next = list2;
                list2 = list2.next;
            }
            if (list1 == null || list2 == null) {
                while (node.next != null) {
                    node = node.next;
                }
                node.next = list1 == null ? list2 : list1;
                break;
            }
            node = node.next;
        }

        return head.next;
    }

    public static void main(String[] args) {
        ListNode list1Head = new ListNode();
        ListNode list1Cur = list1Head;
        list1Head.next = list1Cur;
        ListNode list1 = new ListNode(1);
        list1Cur.next = list1;
        list1Cur = list1;
        list1 = new ListNode(2);
        list1Cur.next = list1;
        list1Cur = list1;
        list1 = new ListNode(4);
        list1Cur.next = list1;
        list1Cur = list1;

        ListNode list2Head = new ListNode();
        ListNode list2Cur = list2Head;
        list2Head.next = list2Cur;
        ListNode list2 = new ListNode(1);
        list2Cur.next = list2;
        list2Cur = list2;
        list2 = new ListNode(3);
        list2Cur.next = list2;
        list2Cur = list2;
        list2 = new ListNode(4);
        list2Cur.next = list2;
        list2Cur = list2;
        ListNode merge = mergeTwoLists(list1Head.next, list2Head.next);
//        ListNode merge = mergeTwoLists(null, list2Head.next);
//        ListNode merge = mergeTwoLists(null, null);
        if (merge != null) {
            merge.print();
        }
    }
}
