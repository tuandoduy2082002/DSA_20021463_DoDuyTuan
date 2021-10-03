public class ReverseLinkedList {
    public static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    public static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        if (head == null || head.next == null)
            return head;

        /*
         * reverse the rest list and put the first element at the end.
         */
        SinglyLinkedListNode rest = reverse(head.next);
        head.next.next = head;

        /* tricky step -- see the diagram */
        head.next = null;

        /* fix the head pointer */
        return rest;
    }

}
