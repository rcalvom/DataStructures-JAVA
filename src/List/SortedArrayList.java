package List;

public class SortedArrayList<T extends Comparable<? super T>> extends ArrayList<T> {
    public SortedArrayList(int InitialCapacity) {
        super(InitialCapacity);
    }

    public SortedArrayList() {
        super();
    }

    @Override
    public int IndexOf(T Element) {
        /*int center, low = 0, up = Size - 1;
        while (low <= up) {
            center = (up + low) / 2;
            int compareResult = Element.compareTo(this.Elements[center]);
            if (compareResult == 0) {
                while (this.Elements[center - 1].equals(Element)) {
                    center--;
                }
                return center;
            } else if (compareResult < 0) {
                up = center - 1;
            } else {
                low = center + 1;
            }
        }*/
        return -1;
    }

    @Override
    public int LastIndexOf(T Element) {
        int center, low = 0, up = Size - 1;
        while (low <= up) {
            center = (up + low) / 2;
            int compareResult = Element.compareTo(this.Elements[center]);
            if (compareResult == 0) {
                while (this.Elements[center + 1].equals(Element)) {
                    center++;
                }
                return center;
            } else if (compareResult < 0) {
                up = center - 1;
            } else {
                low = center + 1;
            }
        }
        return -1;
    }

    @Override
    public void Add(T Element) {
        if(this.Size == 0){
            super.Add(0, Element);
            return;
        }else if(Element.compareTo(this.Elements[0]) < 0){
            super.Add(0, Element);
            return;
        }else if(Element.compareTo(this.Elements[this.Size-1]) > 0){
            super.Add(this.Size, Element);
            return;
        }

        int center = 0, low = 0, up = Size - 1;
        while (up - low > 1) {
            center = (up + low) / 2;
            int compareResult = Element.compareTo(this.Elements[center]);
            if (compareResult == 0) {
                while (this.Elements[center + 1].equals(Element)) {
                    center++;
                }
                break;
            } else if (compareResult < 0) {
                up = center;
            } else {
                low = center;
            }
        }
        super.Add(low + 1, Element);
    }

    @Override
    public void Add(int index, T Element) {
        throw new UnsupportedOperationException("the sorted list does not support index insertion.");
    }

    @Override
    public T Set(int index, T Element) {
        throw new UnsupportedOperationException("the sorted list does not support modifications.");
    }

    @Override
    public void Sort() {
        throw new UnsupportedOperationException("the sorted list always is sorted.");

    }
}
