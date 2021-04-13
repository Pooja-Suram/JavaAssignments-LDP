
class SListIterator<T> {

    public SList<T> currentNode;

    public SListIterator(SList<T> slist)
    {
        currentNode = slist;
    }

    public boolean hasNext()
    {
        return (currentNode != null);
    }

    public SList<T> next()
    {
        SList<T> node = currentNode;
        currentNode = currentNode.next;

        return node;
    }
}


