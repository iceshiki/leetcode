package tool;


import model.LinkListNode;

/**
 * @author chenjianchao
 * @description TODO
 * @createDate 2022/11/17 11:42
 */
public class LinkListTools {
    public static void print(LinkListNode node) {
        while (null != node) {
            System.out.print(node.val);
            node = node.next;
        }
    }
}
