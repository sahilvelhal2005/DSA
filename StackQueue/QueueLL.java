public class QueueLL {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    static class QueueLL{
        public Node head=null;
        public Node tail=null;

        //check if Q is Empty
        public boolean isEmpty(){
            if(head==tail==null){
                return true;
            }
            return false;
        }

        //add in queuq
        public Node add(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head=tail=newNode;
            }
            tail.next=newNode;
            tail=newNode;
            return head;
        }

        //remove
        public int remove(){
            if(isEmpty()){
                System.out.println("Q is empty.");
                return -1;
            }
            int res = head.data;
            head=head.next;
            return res;
        }


    }
}
