public class SList <T> {
    private T value;
    public SList next;

    public SList()
    {
        this.value = null;
        next = null;
    }
    public SList(T value)
    {
        this.value = value;
        next = null;
    }

    public SListIterator iterator()
    {
        return new SListIterator(this);
    }

    public String toString()
    {
        String nodeString = "Node value: " + value.toString();

        return nodeString;
    }
}