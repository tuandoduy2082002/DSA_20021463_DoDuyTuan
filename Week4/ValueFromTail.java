public class ValueFromTail {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    public static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        SinglyLinkedListNode curr = head;
        SinglyLinkedListNode runner = head;

        for (int i = 0; i < positionFromTail; i++) {
            runner = runner.next;
        }

        while (runner.next != null) {
            curr = curr.next;
            runner = runner.next;
        }
        return curr.data;
    }
}
