import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {

	private Item[] queue;
	int elementsSpace;
	private int size;

	public RandomizedQueue() /** construct an empty randomized queue */
	{
		size = 0;
		elementsSpace = 1;
		queue = (Item[]) new Object[elementsSpace];
	}

	public boolean isEmpty() /** is the queue empty? */
	{
		return size == 0;
	}

	public int size() /** return the number of items on the queue */
	{
		return size;
	}

	public void enqueue(Item item) /** add the item */
	{
		if (elementsSpace == size)
			resize(2 * elementsSpace); /** double size of array if necessary */
		queue[size] = item;
		size++;
	}

	public Item dequeue() /** delete and return a random item */
	{
		if (isEmpty())
			throw new NoSuchElementException();
		int randomIndex = StdRandom.uniform(size);
		Item temp = queue[randomIndex];
		queue[randomIndex] = queue[size - 1];
		size--;

		if (elementsSpace == (1.0 / 4.0) * size)
			resize(elementsSpace / 2); /** shrink size of array if necessary */

		return temp;
	}

	public Item sample() /** return (but do not delete) a random item */
	{
		if (isEmpty())
			throw new NoSuchElementException();
		int randomIndex = StdRandom.uniform(size);
		return queue[randomIndex];
	}

	public static void main(String[] args) /** unit testing */
	{

		RandomizedQueue<Integer> rq = new RandomizedQueue<>();
		rq.enqueue(15);
		rq.enqueue(20);
		rq.enqueue(6);
		rq.enqueue(1);
		rq.enqueue(2);
		rq.enqueue(3);
		rq.enqueue(4);

		for (int i = 0; i < 10; i++) {
			System.out.print(rq.sample() + " ");
		}
		System.out.println();
		System.out.println(rq.dequeue() + " removed");

		for (Integer e : rq) {
			System.out.println(e + " outer");

		}

	}

	/** resize the underlying array */
	private void resize(int capacity) {
		Item[] temp = (Item[]) new Object[capacity];
		for (int i = 0; i < size; i++) {
			temp[i] = queue[i];
		}
		elementsSpace = capacity;
		queue = temp;
	}

	@Override
	public Iterator<Item> iterator() {
		resize(size);
		StdRandom.shuffle(queue);
		return new ArrayIterator();
	}

	/** an iterator, doesn't implement remove() since it's optional */
	private class ArrayIterator implements Iterator<Item> {

		private int i = 0;

		public boolean hasNext() {
			return i < size;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		public Item next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Item item = queue[(i) % size];
			i++;
			return item;
		}
	}
}