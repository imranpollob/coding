
public class Main {

    public static void main(String[] args) {
        SLL ll = new SLL();

        ll.addFirst(10);
        ll.print();

        ll.addFirst(5);
        ll.print();

        ll.addLast(15);
        ll.print();

        ll.insert(1, 8);
        ll.print();

        ll.removeFirst();
        ll.print();

        ll.removeLast();
        ll.print();

        ll.delete(8);
        ll.print();

        ll.delete(10);
        ll.print();

        ll.addLast(10);
        ll.addLast(20);
        ll.addLast(30);
        ll.addLast(40);
        ll.addLast(50);
        ll.print();

        ll.search(10);
        ll.search(30);
        ll.search(50);
        ll.search(60);

//        ll.changeVal();
        ll.printRec();

        ll.checkloop();
        ll.createloop(50, 20);
        ll.removeloop();

        ll.print();

        ll.reversePrint();
        
        ll.reverse();
        ll.print();
    }

}
