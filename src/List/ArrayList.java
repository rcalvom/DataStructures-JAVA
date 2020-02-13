package List;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<T> implements List<T> {

    protected T[] Elements;
    protected int Size;

    @SuppressWarnings("unchecked")
    public ArrayList(int InitialCapacity) {
        if(InitialCapacity < 1) {
            throw new IllegalArgumentException("The Initial Capacity must be greater than zero.");
        }
        this.Elements = (T[]) new Object[InitialCapacity];
        this.Size = 0;
    }

    public ArrayList() {
        this(8);
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
        return this.Elements[index];
    }

    @Override
    public int IndexOf(T Element) {
        for(int i = 0; i < this.Size; i++) {
            if(this.Elements[i].equals(Element)) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public int LastIndexOf(T Element) {
        for(int i = this.Size-1; i >= 0; i--) {
            if(this.Elements[i].equals(Element)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public T Remove(int index) {
        this.CheckIndex(index);
        T removedElement = this.Elements[index];
        if (this.Size - index + 1 >= 0) {
            System.arraycopy(this.Elements, index + 1, this.Elements, index + 1 - 1, this.Size - index + 1);
        }
        this.Elements[--this.Size] = null;
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
    public final boolean RemoveAll(T ... Elements) {
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
        this.Elements = null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void Add(int index, T Element) {
        if(index < 0 || index > Size) {
            throw new IndexOutOfBoundsException("Index = "+ index + "; Size = "+ this.Size);
        }
        if(this.Size == this.Elements.length) {
            T[] old = this.Elements;
            this.Elements = (T[]) new Object[2 * this.Size];
            System.arraycopy(old, 0, this.Elements, 0, this.Size);
        }
        if (this.Size - index >= 0) {
            System.arraycopy(this.Elements, index, this.Elements, index + 1, this.Size - index);
        }
        this.Elements[index] = Element;
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
        return new ArrayListIterator<T>(this);
    }

    @Override
    public T Set(int index, T Element) {
        this.CheckIndex(index);
        T e = this.Elements[index];
        this.Elements[index] = Element;
        return e;
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

    public void Sort() {
        Arrays.sort(this.Elements, 0, this.Size);
    }

    protected void CheckIndex(int index) {
        if(index < 0 || index >= this.Size) {
            throw new IndexOutOfBoundsException("Index = "+ index + "; Size = "+ this.Size);
        }
    }

    private class ArrayListIterator<E> implements Iterator<E>{

        private ArrayList<E> list;
        private int nextIndex;

        public ArrayListIterator(ArrayList<E> theList) {
            this.list = theList;
            this.nextIndex = 0;
        }

        @Override
        public boolean hasNext() {
            return this.nextIndex < this.list.Size;
        }

        @Override
        public E next() {
            if(this.nextIndex < this.list.Size) {
                return this.list.Elements[this.nextIndex++];
            }else{
                throw new NoSuchElementException("No next element");
            }
        }

    }

}
