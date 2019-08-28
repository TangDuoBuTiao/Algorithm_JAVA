package 玩转算法面试.链表;

public class num237_删除链表中的节点 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        //先把待删除节点的值等于它的下一个节点的值
        node.val = node.next.val;
        //定义一个新节点，指向待删除节点的下一个节点
        ListNode delNode = node.next;
        node.next = delNode.next;
    }
}
