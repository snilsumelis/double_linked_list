public class LinkedList extends DoubleLinkNode implements HW2Interface {
    private DoubleLinkNode first;


    public LinkedList() {
        first = null;
    }

    @Override
    /* Function to insert a new node at given position in doubly linked list. */
    public void Insert(int newElement, int pos) throws Exception {

        if (pos < 0)
            throw LinkedListException();
        DoubleLinkNode Dummy;
        Dummy = first;
        if (pos == 0) // Add to the first location
        {
            //Create new node and store new data
            DoubleLinkNode NewNode = new DoubleLinkNode();
            NewNode.Element = newElement;
            //Make right of new node as first and left null
            NewNode.right = first;
            NewNode.left = null;
            //change left of head node to new node
            if (first != null)
                first.left = NewNode;
            //move the head to point to the new node
            first = NewNode;
        } else {
            //using a pointer to travel the linked list till position given.
            while (pos - 1 != 0 && Dummy != null) {
                Dummy = Dummy.right;
                pos--;
            }
            //creating and storing the new node with element in a pointer.
            DoubleLinkNode NewNode = new DoubleLinkNode();
            NewNode.Element = newElement;
            // Throw exception if dummy's position never listed
            if (Dummy == null) {
                throw LinkedListException();

            } else if (Dummy.right == null) {
                /*if the node right to node at given position is null, we make the next node
                  as new node and new node's previous link as this current node.*/
                NewNode.right = null;
                Dummy.right = NewNode;
                NewNode.left = Dummy;
            } else {
                //storing next node to current node in link part(next) of new node.
                NewNode.right = Dummy.right;
                //storing new node in link part(next) of current node.
                Dummy.right = NewNode;
                //storing the new node in previous link part(prev) of the node which
                //was next to current node initially.
                NewNode.right.left = NewNode;
                //store the current node in left link part(prev) of new node.
                NewNode.left = Dummy;


            }

        }

    }

    @Override
    public int Delete(int pos) throws Exception {
        int DeletedNodeElement = 0;
        DoubleLinkNode del = first;
        if (pos < 1)
            throw LinkedListException();
        pos--;
        while (pos-- > 0) {
            del = del.right;
        }

        if (first == null || del == null)
            throw LinkedListException();

        if (first == del) {
            DeletedNodeElement = first.Element;
            first = del.right;
            first.left = null;
        }
        if (del.right != null) {
            DeletedNodeElement = del.Element;
            del.right.left = del.left;
        }
        if (del.left != null) {
            del.left.right = del.right;
        }
        return DeletedNodeElement;
    }


    @Override
    public void LinkReverse() {
        if (first.right == null) return;
        left = null;
        DoubleLinkNode current;
        current = first;

        while (current != null) {
            left = current.left;
            current.left = current.right;
            current.right = left;
            current = current.left;
        }
        if (left != null) {
            first = left.left;
        }
    }

    @Override
    public void SacuraL() {

        DoubleLinkNode Dummy = first;
        DoubleLinkNode newFirst = null;

        int count = 1;
        //it was needed so that the complexity of the entire operation is n. Detailed explanation in report.
        boolean Listing = false;

        //A loop that covers adding the value and number of elements to the list for all elements
        while(Dummy != null) {

            if(Dummy.right != null) {
                //if the element of dummy is equals to dummys right element increment counter
                if(Dummy.right.Element == Dummy.Element) {
                    count++;
                }
                else {
                    // If the repeating elements are finished, start listing with the current count value
                    // If there are no repeating elements, start listing with the predefined count value of 1
                    Listing = true;
                }
            }
            else {
                //Last element of the list will list with default count value (1)
                Listing = true;
            }


            if(Listing == true) {

                // Create new node and set count value to new nodes element
                DoubleLinkNode countNode = new DoubleLinkNode();
                countNode.Element = count;

                // Create new node and set original element as new nodes element
                DoubleLinkNode originalElement = new DoubleLinkNode();
                originalElement.Element = Dummy.Element;

                // Connect links each other
                countNode.left = originalElement;
                originalElement.right = countNode;

                //if these nodes are the first ones, these will be the first couple of the list
                if(newFirst == null) {
                    newFirst = originalElement;
                }
                else {
                    //if there are already listed couples, traverse to end of list end do listing
                    DoubleLinkNode temp = newFirst;
                    while(temp.right != null) {
                        temp = temp.right;
                    }
                    // listing to end of list
                    temp.right = originalElement;
                    originalElement.left = temp;
                }
                //return to the default count number and turn off the listing
                count = 1;
                Listing = false;
            }
            //Move dummy to dummys right (after the repeated elements first element)
            Dummy = Dummy.right;

        }
        //at the end of the whole new listing operation take this new list instead of other one
        first = newFirst;

    }

    @Override
    public void OpacuraL() {
        //Create new lists first and tail
        DoubleLinkNode newFirst = null;
        DoubleLinkNode newTail = null;

        DoubleLinkNode Dummy = first;
        // Traverse the dummy in list to the end
        while(Dummy != null && Dummy.right != null) {

            //Take as an integer the dummys right element
            int Count = Dummy.right.Element;

            //List the dummy count times
            for(int i = 0; i < Count; i++) {
                DoubleLinkNode newNode = new DoubleLinkNode();
                newNode.Element = Dummy.Element;
                //First element of the list
                if(newFirst == null) {
                    newFirst = newNode;
                }
                //Listing to the end of the list
                else {
                    newNode.left = newTail;
                    newTail.right = newNode;
                }
                newTail = newNode;
            }
            //To skipping the count element double shift
            Dummy = Dummy.right.right;
        }
        //Take the new list as the default one
        first = newFirst;
    }

    @Override
    public void Output() {
        DoubleLinkNode Dummy;
        Dummy = first;
        System.out.print("The Elements in the list are : ");
        while (Dummy != null) {
            System.out.print(Dummy.Element + " ");
            Dummy = Dummy.right;
        }
        System.out.println();
    }

    @Override
    public void ReverseOutput() {
        DoubleLinkNode Dummy;
        Dummy = first;

        // take tail to end of linked list
        while (Dummy.right != null) {
            Dummy = Dummy.right;
        }
        // take tail back to start of list and print every step
        System.out.print("The Elements in the list are : ");
        while (Dummy != first) {
            System.out.print(Dummy.Element + " ");
            Dummy = Dummy.left;
        }
        // When list have only one element
        System.out.println(Dummy.Element);
    }

    @Override
    public String toString() {
        String List = "";
        DoubleLinkNode Dummy = first;
        while(Dummy != null) {
            List += Dummy.Element + " ";
            Dummy = Dummy.right;
        }
        return List;
    }

    @Override
    public Exception LinkedListException() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
