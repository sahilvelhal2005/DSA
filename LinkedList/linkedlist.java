import java.util.*;

public class linkedlist {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;
    public int size;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            size++;
            return;
        }
        newNode.next = null;
        tail.next = newNode;
        tail = newNode;
        size++;
    }

    public void printLL() {
        if (head == null) {
            System.out.println("Linked List is empty");
            return;
        }
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    // add a node at a given index
    public void addNode(int data, int idx) {
        if (idx == 0) {
            addFirst(data);
            size++;
            return;

        }
        int i = 0;
        Node temp = head;
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }

    // linear search
    public void linearSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                System.out.print("Key found at index: " + i);
                return;
            }
            temp = temp.next;
            i++;
        }
        System.out.print("Key not found");
        return;
    }

    public static  int recSearch(Node head,int key,int index){
        if(head == null){
            return -1;
        }
        else if(head.data==key){
            return index;
        }
        

        return recSearch(head.next,key,index+1);

    }

    // reverse a linkedlist
    public void reverLL() {
        Node prev = null;
        Node curr = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // remove nth node from last
    public void removeNthfromLast(int n) {
        int sz = size - n + 1;
        if (sz == 1) {
            head = head.next;
            size--;
            return;
        }
        Node temp = head;
        int i = 1;
        while (i < sz - 1) {
            temp = temp.next;
            i++;
        }
        temp.next = temp.next.next;
        size--;
    }

    // checking if palindrome
    public boolean isPalindrome() {
        if (head == null) {
            System.out.println("LL is empty!!");
            return false;
        } else if (head == tail) {
            return true;
        }
        // find mid
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // reverse 2nd halfed linnked list
        Node prev = null;
        Node curr = slow;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node RightHead = prev;
        // compare both halves
        Node leftHead = head;
        while (RightHead != null) {
            if (leftHead.data != RightHead.data) {
                return false;
            }
            leftHead = leftHead.next;
            RightHead = RightHead.next;
        }
        return true;
    }

    // check if cycle exit
    // floyds cycle algorithm
    public boolean isCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    // remove cycle
    public void removeCycle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (slow != fast) {
            return; // no cycle
        }
        slow = head;
        Node prev = null;
        while (fast != slow) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }
        prev.next = null; // removing cycle
    }

    //merge sort in linkedlist

    private Node getMid(Node head){
        Node slow=head;
        Node fast = head.next;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    private Node merge(Node head1, Node head2){
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                temp.next=head1;
                temp=temp.next;
                head1=head1.next;
            }else{
                temp.next=head2;
                temp=temp.next;
                head2=head2.next;
            }
        }
        if(head1!=null){
            temp.next=head1;
        }
        if(head2!=null){
            temp.next=head2;
        }
        return mergedLL.next;
    }

    public Node mergeSort(Node head){

        //base case
        if(head==null || head.next==null){
            return head;
        }
        //break ll in two parts 
        Node mid = getMid(head);
        

        //left head and right head
        Node leftHead = head;
        Node rightHead = mid.next;
        mid.next=null;

        Node newLeft = mergeSort(leftHead);
        Node newRight = mergeSort(rightHead);
        

        return merge(newLeft,newRight);
    }

    // zig zag linkedlist
    public void zigzag() {
        // find mid
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // reverse 2nd half
        Node prev = null;
        Node curr = slow.next;
        slow.next = null;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        // alternate zig-zag
        Node LH = head;
        Node RH = prev;
        Node nextL, nextR;
        while (LH != null && RH != null) {
            nextL = LH.next;
            LH.next = RH;
            nextR = RH.next;
            RH.next = nextL;
            RH = nextR;
            LH = nextL;
        }

    }

    public static void main(String args[]) {
        linkedlist ll = new linkedlist();
        ll.addLast(5);
        ll.addLast(4);
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(1);
        ll.addLast(0);
        ll.printLL();
        ll.head=ll.mergeSort(ll.head);
        ll.printLL();
    }
}