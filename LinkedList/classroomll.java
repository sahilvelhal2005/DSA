import java.util.LinkedList;
public class classroomll{
    public static void main(String args[]){
        LinkedList<Integer> ll=new LinkedList<>();
        ll.addFirst(2);
        ll.addLast(3);
        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll);
        ll.addFirst(10);
        ll.addFirst(34);
        ll.addLast(12);
        System.out.println(ll);
        System.out.println(ll.size());
    }
}