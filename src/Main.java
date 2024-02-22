public class Main {
    public static void main(String[] args) {
        // TODO code application logic here
        LinkedList myList = new LinkedList();

        //LList myList = new LList();
        try {
            myList.Insert(1, 0);
            myList.Insert(2, 0);
            myList.Insert(3, 0);
            myList.Insert(3, 0);
            myList.Insert(3, 0);
            myList.Insert(3, 0);
            myList.Insert(2, 0);
            myList.Insert(2, 0);
            myList.Insert(2, 0);
            myList.Insert(2, 0);
            myList.Insert(9, 5);
            myList.Insert(9, 6);
            myList.Insert(1, 0);
            myList.Insert(2, 0);
            myList.Insert(2, 0);
            myList.Insert(3, 0);
            myList.Insert(2, 0);
            myList.Insert(5, 54);

            //System.out.println("The element " + myList.Delete(6) + " is deleted");

        } catch (Exception ex) {
            System.out.println(ex);
        }

        myList.Output();
        myList.LinkReverse();
        myList.Output();
        myList.SacuraL();
        myList.Output();
        myList.OpacuraL();
        myList.Output();
        myList.ReverseOutput();
        System.out.println(myList);
    }
}