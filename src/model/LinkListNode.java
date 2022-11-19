package model;

/**
 * @author chenjianchao
 * @description TODO
 * @createDate 2022/11/17 11:21
 */
public class LinkListNode {
    public int val;
    public LinkListNode next;

    public LinkListNode() {
    }

    public LinkListNode(int val) {
        this.val = val;
    }

    public LinkListNode(int val, LinkListNode next) {
        this.val = val;
        this.next = next;
    }
}
