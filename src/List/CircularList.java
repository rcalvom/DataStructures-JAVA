package List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularList<T> extends LinkedList<T> {

    public CircularList() {
        this.Head = new ChainNode<>();
        this.Head.next = Head;
        this.Size = 0;
    }

    @Override
    public int IndexOf(T Element) {
        this.Head.element = Element;
        ChainNode<T> currentNode = this.Head.next;
        int index = 0;
        while (!currentNode.element.equals(Element)) {
            currentNode = currentNode.next;
            index++;
        }
        return currentNode == this.Head ? -1 : index;
    }

    @Override
    public int LastIndexOf(T Element) {
        this.Head.element = Element;
        ChainNode<T> currentNode = this.Head.next;
        int index = 0;
        int i = -1;
        while (index != this.Size) {
            if (currentNode.element.equals(Element)) {
                i = index;
            }
            currentNode = currentNode.next;
        }
        return i;
    }

    @Override
    public T Remove(int index) {
        this.CheckIndex(index);
        T removedElement;
        ChainNode<T> q = this.Head;
        for (int i = 0; i < index; i++) {
            q = q.next;
        }
        removedElement = q.next.element;
        q.next = q.next.next;
        this.Size--;
        return removedElement;
    }

    @Override
    public void Add(int index, T Element) {
        if (index < 0 || index > this.Size) {
            throw new IndexOutOfBoundsException("index = " + index + "; Size = " + this.Size);
        }
        ChainNode<T> p = this.Head;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        p.next = new ChainNode<>(Element, p.next);
        this.Size++;
    }

    @Override
    public String ToString() {
        StringBuilder s = new StringBuilder("[");
        ChainNode<T> currentNode = this.Head.next;
        while (currentNode != this.Head) {
            s.append(currentNode.element).append(", ");
            currentNode = currentNode.next;
        }
        if (this.Size > 0) {
            s.setLength(s.length() - 2);
        }
        s.append("]");
        return new String(s);
    }

    @Override
    public Iterator<T> iterator() {
        return new CircularListIterator(this);
    }

    protected class CircularListIterator implements Iterator<T> {
        protected ChainNode<T> nextNode;
        protected ChainNode<T> Head;

        public CircularListIterator(CircularList<T> circularList) {
            this.nextNode = circularList.Head.next;
            this.Head = circularList.Head;
        }

        @Override
        public boolean hasNext() {
            return !this.nextNode.next.equals(this.Head);
        }

        @Override
        public T next() {
            if (!this.nextNode.next.equals(this.Head)) {
                T elementToReturn = this.nextNode.element;
                nextNode = nextNode.next;
                return elementToReturn;
            } else {
                throw new NoSuchElementException("No next element.");
            }
        }
    }

}
