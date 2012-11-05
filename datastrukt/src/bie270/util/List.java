package bie270.util;

public interface List extends Collection{

	/**
	 * Returns the item at position idx.
	 * 
	 * @param idx
	 *            the index to search in.
	 * @throws ArrayIndexOutOfBoundsException
	 *             if index is out of range.
	 */

	public abstract Object get(int idx);

	/**
	 * Changes the item at position idx.
	 * 
	 * @param idx
	 *            the index to change.
	 * @param newVal
	 *            the new value.
	 * @return the old value.
	 * @throws ArrayIndexOutOfBoundsException
	 *             if index is out of range.
	 */
	public abstract Object set(int idx, Object newVal);

	/**
	 * Obtains a ListIterator object used to traverse the collection
	 * bidirectionally.
	 * 
	 * @return an iterator positioned prior to the requested element.
	 * @param idx
	 *            the index to start the iterator. Use size() to do complete
	 *            reverse traversal. Use 0 to do complete forward traversal.
	 * @throws IndexOutOfBoundsException
	 *             if idx is not between 0 and size(), inclusive.
	 */
	public abstract ListIterator listIterator(int idx);

}