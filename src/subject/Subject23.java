package subject;

import model.ListNode;

public class Subject23 {
    // todo
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = lists[0];
        ListNode another = null;
        for (int i = 1; i < lists.length; i++) {
            another = lists[i];
//            while ()
        }
        return null;
    }

    public void run(int[][] nums) {
        ListNode[] lists = new ListNode[nums.length];
        for (int i = 0; i < nums.length; i++) {
            lists[i] = ListNode.makeList(nums[i]);
        }

        ListNode node = mergeKLists(lists);
        node.print();
    }

    public static void main(String[] args) {
        Subject23 subject23 = new Subject23();
        subject23.run(new int[][]{{1, 4, 5}, {1, 3, 4}, {2, 6}});
    }
}
