package List;

/**
 * Linear data structure: List.
 * @param <T> This describes the data type in the list.
 */
public abstract class List<T> implements IList<T> {
    /**
     * Number of elements in the list.
     */
    protected int Size;

    @Override
    public boolean IsEmpty() {
        return Size == 0;
    }

    @Override
    public int Size() {
        return this.Size;
    }

    @Override
    public void Add(T Element) {
        this.Add(this.Size, Element);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void AddAll(T... Elements) {
        for (T e : Elements) {
            this.Add(e);
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void AddAll(int index, T... Elements) {
        int i = index;
        for (T e : Elements) {
            this.Add(i++, e);
        }
    }

    @Override
    public boolean Contains(T Element) {
        return this.IndexOf(Element) != -1;
    }

    @Override
    public boolean Remove(T Element) {
        int index = this.IndexOf(Element);
        if (index == -1) {
            return false;
        } else {
            this.Remove(index);
            return true;
        }
    }

    @SafeVarargs
    @Override
    public final boolean RemoveAll(T... Elements) {
        boolean flag = true;
        for (T e : Elements) {
            int index = this.IndexOf(e);
            if (index == -1) {
                flag = false;
            } else {
                this.Remove(index);
            }
        }
        return flag;
    }

    @Override
    public String ToString() {
        StringBuilder s = new StringBuilder("[");
        for (T x : this) {
            s.append(x).append(", ");
        }
        if (this.Size > 0) {
            s.setLength(s.length() - 2);
        }
        s.append("]");
        return new String(s);
    }

    protected void CheckIndex(int index) {
        if (index < 0 || index >= this.Size) {
            throw new IndexOutOfBoundsException("index = " + index + "; Size = " + this.Size);
        }
    }
}
