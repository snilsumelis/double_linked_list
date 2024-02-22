public interface HW2Interface {
    void Insert(int newElement, int pos) throws Exception;
    int Delete(int pos) throws Exception;
    void LinkReverse();
    void SacuraL();
    void OpacuraL();
    void Output();
    void ReverseOutput();
    @Override
    String toString();
    Exception LinkedListException();
}
