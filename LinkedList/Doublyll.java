public class Doublyll{
    class Node{
        int data;
        Node next;
        Node prev;
        Node(int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    public Node head=null;
    public Node tail=null;
    public int size=0;

    //addFirst
    public void addFirst(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=tail=newNode;
            size++;
            return;
        }
        
        newNode.next=head;
        head.prev=newNode;
        head=newNode;
        size++;
        
    }

    //print Doubly linkedlist
    public void printll(){
        if(head==null){
            System.out.println("Doubly linked list is empty");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    //remove first node
    public void removeFirst(){
        if(head==null){
            return;
        }
        if(size==1){
            head=tail=null;
        }
        head=head.next;
        head.prev=null;
        size--;

    }

    //add Last

    public void addLast(int data){
        Node newNode = new Node(data);
        if(head==null){
            head=tail=newNode;
            size++;
            return;
        }
        tail.next=newNode;
        newNode.prev=tail;
        tail=newNode;
        size++;
    }

    //remove last
    public void removeLast(){
        tail=tail.prev;
        tail.next=null;
        size--;
    }

    //reverse a doubly linkedlist
    
    public void reverseDLl(){
        Node curr=head;
        Node prev=null;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            
            prev=curr;
            curr=next;
            
        }
        head=prev;
    }


    public static void main(String args[]){
        Doublyll dll = new Doublyll();
        dll.addFirst(5);
        dll.addFirst(4);
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.printll();
        dll.reverseDLl();
        dll.printll();
        
    }
}