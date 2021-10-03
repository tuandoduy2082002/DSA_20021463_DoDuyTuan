public class MergeSortLinkedList {
    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode currA, SinglyLinkedListNode currB) {
        if (currA == null) {
            return currB;
        } else if (currB == null) {
            return currA;
        }

        SinglyLinkedListNode head = null;
        if (currA.data < currB.data) {
            head = currA;
            currA = currA.next;
        } else {
            head = currB;
            currB = currB.next;
        }
        
        SinglyLinkedListNode n = head;
        while (currA != null && currB != null) {
            if (currA.data < currB.data) {
                n.next = currA;
                currA = currA.next;
            } else {
                n.next = currB;
                currB = currB.next;
            }
            n = n.next;
        }
        if (currA == null) {
            n.next = currB;
        } else {
            n.next = currA;
        }
        return head;
    }
}
