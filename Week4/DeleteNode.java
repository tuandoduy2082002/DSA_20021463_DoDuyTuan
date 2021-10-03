public class DeleteNode {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    public SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {
        SinglyLinkedListNode cur = llist;
        if (position == 0) {
            return llist.next;
        } else {
            for (int i = 0; i < (position - 1); i++) {
                cur = cur.next;
            }
            cur.next = cur.next.next;
        }
        return llist;
    }
}
