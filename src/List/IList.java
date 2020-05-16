package List;

import java.util.Iterator;

/**
 * A list represents a linear data structure with access to all elements.
 *
 * @param <T> This describes the data type in the list.
 */
public interface IList<T> extends Iterable<T> {

    /**
     * Checks if the list is empty.
     *
     * @return True if the list is empty, False otherwise.
     */
    boolean IsEmpty();

    /**
     * Gets the number of elements in the list.
     *
     * @return Number of elements in the list.
     */
    int Size();

    /**
     * Returns the element at specified position in the list.
     *
     * @param index Position in the list.
     * @return Element at specified position in the list.
     */
    T Get(int index);

    /**
     * Returns the index of the first occurrence of the specified element in the list.
     *
     * @param Element the specified element.
     * @return The index of the first occurrence of the element, if it does not exists, return -1.
     */
    int IndexOf(T Element);

    /**
     * Returns the index of the last occurrence of the specified element in the list.
     *
     * @param Element the specified element.
     * @return The index of the last occurrence of the element.
     */
    int LastIndexOf(T Element);

    /**
     * Removes the element at the specified position in the list.
     *
     * @param index Position in the list.
     * @return the element removed.
     */
    T Remove(int index);

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     *
     * @param Element the specified element.
     * @return True if the element was removed. False otherwise.
     */
    boolean Remove(T Element);

    /**
     * Removes from this list all of its elements that are contained in the param.
     *
     * @param Elements Elements to be removed.
     * @return True if all elements were removed. False otherwise.
     */
    boolean RemoveAll(T... Elements);

    /**
     * Removes all of the elements from this list.
     */
    void Clear();

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index   Index at which the specified element is to be inserted.
     * @param Element Element to be inserted.
     */
    void Add(int index, T Element);

    /**
     * Appends the specified element to the end of the list.
     *
     * @param Element Element to be appended to the list.
     */
    void Add(T Element);

    /**
     * Appends the specified elements to the end of the list.
     *
     * @param Elements Elements to be appended to the list.
     */
    void AddAll(T... Elements);

    /**
     * Inserts the specified elements at the specified position in this list.
     *
     * @param index Index at which the specified elements is to be inserted.
     */
    void AddAll(int index, T... Elements);

    /**
     * Returns if this list contains the specified element.
     *
     * @param Element Element whose presence in the list is to be tested.
     * @return True if the Element exists in the list. False otherwise.
     */
    boolean Contains(T Element);

    /**
     * Returns an iterator over the elements in the list.
     *
     * @return Iterator over the elements in the list.
     */
    @Override
    Iterator<T> iterator();

    /**
     * Replaces the element at the specified position in the list with the specified element.
     *
     * @param index   Index of the element to replace.
     * @param Element element to be stored at the specified position.
     * @return the element previously at the specified position.
     */
    T Set(int index, T Element);

    /**
     * Returns a string representation of the list.
     *
     * @return string representation.
     */
    String ToString();

}
