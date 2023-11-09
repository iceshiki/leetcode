package model;

/**
 * @author ice_shiki
 * @createDate 2022/11/17 11:21
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public void print() {
        ListNode node = this;
        while (null != node) {
            System.out.print(node.val);
            node = node.next;
        }
        System.out.println();
    }

    /**
     * 从数组创建list，返回头指针
     * @param numArr
     * @return head
     */
    public static ListNode makeList(int[] numArr){
        ListNode head = new ListNode(numArr[0]);
        ListNode node = head;
        for (int i = 1; i < numArr.length; i++) {
            node.next = new ListNode(numArr[i]);
            node = node.next;
        }
        return head;
    }
}
