import java.util.Queue;

public class QueueQ {
    static class Queue{

        int arr[];
        int size;
        int rear;

        Queue(int n){
            this.arr=new int[n];
            rear=-1;
            size=n;
        }

        //check if Q is empty
        public boolean isEmpty(){
            return rear==-1;
        }

        //print Q
        public void printQ(){
            for(int i=0;i<=rear;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }

        //add element in Q
        public void add(int data){
            if(rear==size-1){
                System.out.println("Queue is full cant add elements");
                return;
            }
            rear++;
            arr[rear]=data;
            return;
        }

        //remove element from Q
        public int remove(){
            if(isEmpty()){
                System.out.println("Q is Empty");
                return -1;
            }
            int front = arr[0];
            for(int i=0;i<rear;i++){
                arr[i]=arr[i+1];
            }
            rear--;
            return front;
        }

    public static void main(String args[]){
        Queue q = new Queue(5);
        System.out.println(q.isEmpty());
        q.add(5);
        q.add(2);
        q.add(4);
        q.add(10);
        q.add(8);
        q.add(45);
        q.remove();
        q.printQ();
        q.add(11);
        System.out.println();
        q.printQ();
    }
}
