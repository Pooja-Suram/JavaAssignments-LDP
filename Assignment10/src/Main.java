class Main {

    public static void main(String[] args) {
        int[] array = {1, 2, 13, 42, 54};
        SList<Integer> integerSList = new SList<>();

        SList currList = integerSList;

        //Creating a linked list
        for (int j : array) {
            currList.next = new SList(j);
            currList = currList.next;
        }

        integerSList = integerSList.next;

        SListIterator iterator = integerSList.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}