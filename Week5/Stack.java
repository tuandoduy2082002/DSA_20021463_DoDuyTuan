package Week5;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

class Stack<Item> implements Iterable<Item> {
    private static final int INIT_CAPACITY = 8;

    private Item[] a;
    private int n;

    public Stack() {
        a = (Item[]) new Object[INIT_CAPACITY];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    private void resize(int capacity) {
        assert capacity >= n;

        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = a[i];
        }
        a = copy;
    }

    public void push(Item item) {
        if (n == a.length) resize(2*a.length);
        a[n++] = item;
    }

    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = a[n-1];
        a[n-1] = null;
        n--;

        if (n > 0 && n == a.length/4) resize(a.length/2);
        return item;
    }

    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return a[n-1];
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;

        public ReverseArrayIterator() {
            i = n-1;
        }

        public boolean hasNext() {
            return i >= 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[i--];
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) stack.push(item);
            else if (!stack.isEmpty()) StdOut.print(stack.pop() + " ");
        }
        StdOut.println("(" + stack.size() + " left on stack)");
    }
}
