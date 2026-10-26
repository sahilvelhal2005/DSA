import java.util.Stack;

public class QueueJCF {
    static class Queue{
        
        //Queue using two Stacks
        
        public Stack<Integer> s1 = new Stack<>();
        public Stack<Integer> s2 = new Stack<>();

        public boolean isEmpty(){
            return s1.isEmpty();
        }

        //add
        public void add(int data){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
            s1.push(data);

            while(!s2.isEmpty()){
                s1.push(s2.pop());
            }
        }

        //remove
        public int remove(){
            if(s1.isEmpty()){
                return -1;
            }
            return s1.pop();
        }

        //peek
        public int peek(){
            if(s1.isEmpty()){
                return -1;
            }
            return s1.peek();
        }
    }

    public static void main(String args[]){
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while(!q.isEmpty()){
            System.out.print(q.remove()+" ");
        }
        System.out.println(q.isEmpty());
    }
}
