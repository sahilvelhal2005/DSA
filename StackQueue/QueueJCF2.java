import java.util.Stack;

public class QueueJCF2 {
    static class Queue {
        public Stack<Integer> s1 = new Stack<>();
        public Stack<Integer> s2 = new Stack<>();

        // isEmpty
        public boolean isEmpty() {
            return s1.isEmpty();
        }

        // add
        public void add(int data) {
            s1.push(data);
        }

        // remove
        public int remove() {
            if (isEmpty()) {
                return -1;
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            int res = s2.pop();
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return res;
        }

        // peek
        public int peek() {
            if (isEmpty()) {
                return -1;
            }
            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }
            int res = s2.peek();
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
            return res;
        }
    }

    public static void main(String args[]) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);

        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
    }
}   
