package bie270.util;

public interface Collection {

	/**
	 * Returns the number of items in this collection.
	 * 
	 * @return the number of items in this collection.
	 */
	public abstract int size();

	/**
	 * Tests if some item is in this collection.
	 * 
	 * @param x
	 *            any object.
	 * @return true if this collection contains an item equal to x.
	 */
	public abstract boolean contains(Object x);

	/**
	 * Adds an item to this collection, at the end.
	 * 
	 * @param x
	 *            any object.
	 * @return true.
	 */
	public abstract boolean add(Object x);

	/**
	 * Removes an item from this collection.
	 * 
	 * @param x
	 *            any object.
	 * @return true if this item was removed from the collection.
	 */
	public abstract boolean remove(Object x);

	/**
	 * Change the size of this collection to zero.
	 */
	public abstract void clear();

	public abstract boolean isEmpty();

	/**
	 * Obtains a primitive array view of the collection.
	 * @return the primitive array view.
	 */
	public abstract Object[] toArray();

	/**
	 * Obtains an Iterator object used to traverse the collection.
	 * 
	 * @return an iterator positioned prior to the first element.
	 */
	public abstract Iterator iterator();

}