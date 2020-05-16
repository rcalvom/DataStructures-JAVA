package List;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implementation of List using linked nodes.
 *
 * @param <T> This describes the data type in the list.
 */
public class LinkedList<T> extends List<T> {

    /**
     * The first node in the list.
     */
    protected ChainNode<T> Head;

    public LinkedList() {
        this.Head = null;
        this.Size = 0;
    }

    @Override
    public T Get(int index) {
        this.CheckIndex(index);
        ChainNode<T> currentNode = this.Head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.element;
    }

    @Override
    public int IndexOf(T Element) {
        ChainNode<T> currentNode = this.Head;
        int index = 0;
        while (currentNode != null && !currentNode.element.equals(Element)) {
            currentNode = currentNode.next;
            index++;
        }
        return currentNode == null ? -1 : index;
    }

    @Override
    public int LastIndexOf(T Element) {
        ChainNode<T> currentNode = this.Head;
        int index = 0;
        int i = -1;
        while (currentNode != null) {
            if (currentNode.element.equals(Element))
                i = index;
            currentNode = currentNode.next;
            index++;
        }
        return i;
    }

    @Override
    public T Remove(int index) {
        this.CheckIndex(index);
        T removedElement;
        if (index == 0) {
            removedElement = this.Head.element;
            this.Head = this.Head.next;
        } else {
            ChainNode<T> q = this.Head;
            for (int i = 0; i < index - 1; i++) {
                q = q.next;
            }
            removedElement = q.next.element;
            q.next = q.next.next;
        }
        this.Size--;
        return removedElement;
    }

    @Override
    public boolean Remove(T Element) {
        //TODO: implements.
        return false;
    }

    @Override
    public void Clear() {
        this.Head = null;
    }

    @Override
    public void Add(int index, T Element) {
        if (index < 0 || index > this.Size) {
            throw new IndexOutOfBoundsException("index = " + index + "; Size = " + Size);
        }
        if (index == 0) {
            this.Head = new ChainNode<>(Element, this.Head);
        } else {
            ChainNode<T> p = this.Head;
            for (int i = 0; i < index - 1; i++) {
                p = p.next;
            }
            p.next = new ChainNode<>(Element, p.next);
        }
        this.Size++;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator(this);
    }

    @Override
    public T Set(int index, T Element) {
        this.CheckIndex(index);
        ChainNode<T> currentNode = this.Head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        T temp = currentNode.element;
        currentNode.element = Element;
        return temp;
    }

    protected static class ChainNode<E> {
        protected E element;
        protected ChainNode<E> next;

        public ChainNode(E element, ChainNode<E> next) {
            this.element = element;
            this.next = next;
        }

        public ChainNode() {
        }

    }

    protected class LinkedListIterator implements Iterator<T> {
        protected ChainNode<T> nextNode;

        public LinkedListIterator(LinkedList<T> linkedList) {
            this.nextNode = linkedList.Head;
        }

        @Override
        public boolean hasNext() {
            return this.nextNode != null;
        }

        @Override
        public T next() {
            if (this.nextNode != null) {
                T elementToReturn = this.nextNode.element;
                nextNode = nextNode.next;
                return elementToReturn;
            } else {
                throw new NoSuchElementException("No next element.");
            }
        }
    }

}
