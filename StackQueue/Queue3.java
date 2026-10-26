import java.util.Queue;
import java.util.LinkedList;

public class Queue3 {

    //interleave
    public static Queue<Integer> interleave(Queue<Integer> q){
        int size =  q.size();
        Queue<Integer> newQ = new LinkedList<>();
        for(int i=0;i<size/2;i++){
            newQ.add(q.remove());
        }
        while(!newQ.isEmpty()){
            int m=newQ.remove();
            q.add(m);
            int k=q.remove();
            q.add(k);
            
        }

        return q;
    }
    public static void main(String args[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        Queue<Integer> k = new LinkedList<>();
        k=interleave(q);
        while(!k.isEmpty()){
            System.out.print(k.remove()+" ");
        }
        System.out.println();

    }
}
