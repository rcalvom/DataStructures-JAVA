package Queue;

public interface Queue<T> {
    boolean IsEmpty();
    T Peek();
    T Dequeue();
    void Clear();
    void Enqueue(T Element);
    void Enqueue(T ... Elements);
}
