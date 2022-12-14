public class Main {
    public static void main(String args[]){
        LinkedList list = new LinkedList();

        for(int i=1;i<12;i++){
            list.add(i);
        }
        list.printReverse();

        list.makeReverse(list.head);

        list.printReverse();

        //list.makeCycle(list.head.next.next.next);

        System.out.println(list.hasCycle());
    }
}
