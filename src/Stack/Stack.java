package Stack;

public interface Stack<T> {
    boolean IsEmpty();
    T Peek();
    T Pop();
    void Clear();
    void Push(T Element);
    void Push(T ... Elements);
}
