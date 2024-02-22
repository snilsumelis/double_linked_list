# Double-Linked List Uygulaması

Bu Java programı, Double-Linked List yapısını kullanarak çeşitli işlemleri gerçekleştirir. İlgili veri yapısı, `DoubleLinkNode` adlı bir düğüm sınıfı ile birlikte `LinkedList` adlı bir sınıf tarafından uygulanmıştır.

## Double-Linked List Nedir?

Double-Linked List, her bir düğümün hem bir sonraki düğümü hem de bir önceki düğümü işaret ettiği bir veri yapısıdır. Bu özelliği sayesinde listelerde ileri ve geri hareket edebilme imkanı sağlar.

## İşlevler ve Kullanım

Bu program, `HW2Interface` arayüzünde tanımlanan yöntemleri uygular ve aşağıdaki işlevleri gerçekleştirir:

- Insert : inserts an int element defined in newElement after the position of pos into the LinkedList. It checks whether pos is valid or not. If pos is not a valid position for the LinkedList, it throws an exception.
- Delete : deletes the element stored in position pos in the linked list and returns the value of the element. If there is no element in pos, it throws exception.
- LinkReverse : the link will be reversed after this method has been initiated. For example, if the link list is in the form [2 3 2 2 1 2 2 2 2 3 3 3 3 2 1] the reverse method changes it to [1 2 3 3 3 3 2 2 2 2 1 2 2 3 2]
- SacuraL :  SacuraL takes the linked list and traces the  contiguous blocks in the list. After initiating the method, it changes the linked list into the list such that there are tuples: the element and number of occurrences in the list. For example, if the list is [1 2 3 3 3 3 2 2 2 2 1 2 2 3 2], after initiating the method the link list converts to: [1 1 2 1 3 4 2 4 1 1 2 2 3 1 2 1]
- OpacuraL : OpacuraL is the reverse of the SacuraL function.  For example, if the list is [1 1 2 1 3 4 2 4 1 1 2 2 3 1 2 1], after the method, the link list will be: [1 2 3 3 3 3 2 2 2 2 1 2 2 3 2]
- Output : Put the elements of the link list to console starting from the beginning.
- ReverseOutput : Reverse Output. Put the elements of the link list to the console starting from the end to the beginning. The linked list structure will not be affected.
