import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {

	private Node<Item> first;
	private Node<Item> last;
	private int size;

	// Linked List
	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
	}

	// construct an empty deque
	public Deque() {
		first = null;
		last = null;
		size = 0;
	}

	// is the deque empty?
	public boolean isEmpty() {
		return size == 0;
	}

	// return the number of items on the deque
	public int size() {
		return size;
	}

	// add the item to the front
	public void addFirst(Item item) {
		Node<Item> old = first;
		first = new Node<Item>();
		first.item = item;
		if (this.isEmpty()) {
			last = first;
		} else {
			first.next = old;
		}
		size++;
	}

	// add the item to the back
	public void addLast(Item item) {
		Node<Item> old = last;
		last = new Node<Item>();
		last.item = item;
		last.next = null;
		if (this.isEmpty()) {
			first = last;
		} else {
			old.next = last;
		}
		size++;
	}

	// remove and return the item from the front
	public Item removeFirst() {
		if (this.isEmpty()) {
			throw new NoSuchElementException("Dequeue have size equal zero");
		}
		Item item = first.item;
		first = first.next;
		size--;
		return item;
	}

	// remove and return the item from the back
	public Item removeLast() {
		if (isEmpty()) {
			throw new NoSuchElementException("Dequeue have size equal zero");
		}
		Item item = first.item;
		first = first.next;
		size--;
		if (this.isEmpty()) {
			last = null;
		}
		return item;
	}

	// return an iterator over items in order from front to back
	@Override
	public Iterator<Item> iterator() {
		/** from front to end */
		return new ListIterator<Item>(first);
	}

	private class ListIterator<Item> implements Iterator<Item> {
		private Node<Item> current;

		public ListIterator(Node<Item> first) {
			current = first;
		}

		public boolean hasNext() {
			return current != null;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Item item = current.item;
			current = current.next;
			return item;
		}
	}

	// unit testing (required)
	public static void main(String[] args) {
		Deque<String> test = new Deque<>();
		test.addFirst("a");
		test.addFirst("bb");
		test.addFirst("ccc");
		test.addFirst("dddd");
		test.addLast("bb");
		test.addLast("ccc");
		test.addLast("dddd");
		test.removeLast();
		test.removeLast();
		test.removeLast();

        for (String t : test) {
            System.out.println(t);
        }
	}
}