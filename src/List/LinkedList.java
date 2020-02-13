package List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T>{

    protected ChainNode<T> Head;
    protected int Size;

    public LinkedList(){
        this.Head = null;
        this.Size = 0;
    }

    @Override
    public boolean IsEmpty() {
        return this.Size == 0;
    }

    @Override
    public int Size() {
        return this.Size;
    }

    @Override
    public T Get(int index) {
        this.CheckIndex(index);
        ChainNode<T> currentNode = this.Head;
        for(int i = 0; i< index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.element;
    }

    @Override
    public int IndexOf(T Element) {
        ChainNode<T> currentNode = this.Head;
        int index = 0;
        while(currentNode != null && !currentNode.element.equals(Element)) {
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
        while(currentNode != null) {
            if(currentNode.element.equals(Element))
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
        if(index == 0) {
            removedElement = this.Head.element;
            this.Head = this.Head.next;
        }else{
            ChainNode<T> q = this.Head;
            for(int i = 0; i < index -1; i++) {
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
        int index = this.IndexOf(Element);
        if(index == -1) {
            return false;
        }else {
            this.Remove(index);
            return true;
        }
    }

    @SafeVarargs
    @Override
    public final boolean RemoveAll(T... Elements) {
        boolean flag = true;
        for(T e : Elements){
            int index = this.IndexOf(e);
            if(index == -1) {
                flag = false;
            }else {
                this.Remove(index);
            }
        }
        return flag;
    }

    @Override
    public void Clear() {
        this.Head = null;
    }

    @Override
    public void Add(int index, T Element) {
        if(index < 0 || index > this.Size) {
            throw new IndexOutOfBoundsException("index = " + index + "; Size = "+ Size);
        }
        if(index == 0) {
            this.Head = new ChainNode<>(Element, this.Head);
        }else {
            ChainNode<T> p = this.Head;
            for(int i = 0; i< index - 1; i++) {
                p = p.next;
            }
            p.next = new ChainNode<>(Element, p.next);
        }
        this.Size++;
    }

    @Override
    public void Add(T Element) {
        this.Add(this.Size, Element);
    }

    @SafeVarargs
    @Override
    public final void AddAll(T... Elements) {
        for(T e : Elements){
            this.Add(e);
        }
    }

    @SafeVarargs
    @Override
    public final void AddAll(int index, T... Elements) {
        int i = index;
        for(T e : Elements){
            this.Add(i++, e);
        }
    }

    @Override
    public boolean Contains(T Element) {
        return this.IndexOf(Element) != -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator(this);
    }

    @Override
    public T Set(int index, T Element) {
        this.CheckIndex(index);
        ChainNode<T> currentNode = this.Head;
        for(int i = 0; i<index; i++){
            currentNode = currentNode.next;
        }
        T temp = currentNode.element;
        currentNode.element = Element;
        return temp;
    }

    @Override
    public String ToString() {
        StringBuilder s = new StringBuilder("[");
        for(T x : this) {
            s.append(x).append(", ");
        }
        if(this.Size > 0) {
            s.setLength(s.length()-2);
        }
        s.append("]");
        return new String(s);
    }

    private void CheckIndex(int index) {
        if(index < 0 || index >= this.Size) {
            throw new IndexOutOfBoundsException("index = " + index + "; Size = " + this.Size);
        }
    }

    private static class ChainNode<E>{
        private E element;
        private ChainNode<E> next;

        public ChainNode(E element, ChainNode<E> next) {
            this.element = element;
            this.next = next;
        }

    }

    private class LinkedListIterator implements Iterator<T>{
        private ChainNode<T> nextNode;

        public LinkedListIterator(LinkedList<T> linkedList) {
            this.nextNode = linkedList.Head;
        }

        @Override
        public boolean hasNext() {
            return this.nextNode != null;
        }

        @Override
        public T next() {
            if(nextNode != null) {
                T elementToReturn = this.nextNode.element;
                nextNode = nextNode.next;
                return elementToReturn;
            }else{
                throw new NoSuchElementException("No next element.");
            }
        }
    }

}
