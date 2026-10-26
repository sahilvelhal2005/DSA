import java.util.Stack;

public class StackS {
    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    static class Stack{
        Node head = null;

        //check if stack is empty
        public boolean isEmpty(){
            if(head==null){
                return true;
            }else{
                return false;
            }
        }

        //print stack
        public void printStack(){
            if(isEmpty()){
                System.out.println("Stack is Empty");
                return;
            }
            Node temp = head;
            while(temp!=null){
                System.out.print(temp.data+" -> ");
                temp=temp.next;
            }
            System.out.print("null");

        }

        //peek
        public int peek(){
            if(head==null){
                return -1;
            }
            return head.data;
        }

        //push
        public Node push(int data){
            Node newNode = new Node(data);
            if(isEmpty()){
                head=newNode;
                return head;
            }else{
                newNode.next=head;
                head=newNode;
                return head;
            }
        }

        //pop
        public int pop(){
            if(isEmpty()){
                return -1;
            }
            int data = head.data;
            head=head.next;
            return data;
        }

        //Push At bottom
        public void pushAtBottom(int data){
            Node newNode = new Node(data);
            if(head==null){
                head=newNode;
                return;
            }
            Node temp = head;
            Node prev=null;
            while(temp!=null){
                prev=temp;
                temp=temp.next;
            }
            prev.next=newNode;
        }

        //reverse a stack
        public void reverse(Stack s){
            if(s.isEmpty()){
                return;
            }
            int data=s.pop();
            reverse(s);
            s.pushAtBottom(data);

        }

        //stock span problem
        public static int[] stockSpan(int[] stocks,Stack s){
            
            int[] span = new int[stocks.length];
            span[0]=1;
            s.push(0);
            for(int i=1;i<stocks.length;i++){
                while(!s.isEmpty() && stocks[i]>stocks[s.peek()]){
                    s.pop();
                }
                if(s.isEmpty()){
                    span[i]=i+1;
                }else{
                    int prevHigh=s.peek();
                    span[i]=i-prevHigh;
                }
                s.push(i);
            }
            return span;
            
        }

    }


    //main
    public static void main(String args[]){
        Stack s = new Stack();
        // Stack s1 = new Stack();
        // s.push(2);
        // s.push(3);
        // s.push(4);
        // s.printStack();
        // System.out.println();
        // s.reverse(s);
        // s.printStack();

        int[] stocks = {100, 80, 60, 70, 60, 85, 100};
        int[] spans =s.stockSpan(stocks,s);
        System.out.println("Stock spans:");
        for (int span : spans) {
            System.out.print(span + " ");
        }

    }
}
