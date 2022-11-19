package model;

/**
 * @Author: chen.jc
 * @createDate: 2022/11/20
 */
public class BiLinkListNode {
    public int key;
    public int val;
    public BiLinkListNode next;
    public BiLinkListNode prev;

    public BiLinkListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
