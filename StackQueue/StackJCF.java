import java.util.Stack;

public class StackJCF {
    //valid parenthesis
    public static boolean duplicateParenthesis(String str){
        Stack<Character> s = new Stack<>();
        for(int i=0;i<str.length();i++){
            char curr=str.charAt(i);
            if(curr!=')'){
                s.push(curr);

            }else{
                int count = 0;
                while(!s.isEmpty()){
                    char k =s.pop();
                    if(k=='('){
                        break;
                    }
                    count++;
                }
                if(count!=0){
                    continue;
                }else{
                    return true;
                }
            }
        }
        return false;
    }


    //next greater element
    public static int[] nextGreaterElement(int[] elements){
        Stack<Integer> s = new Stack<>();
        int[] result= new int[elements.length];
        for(int i=elements.length-1;i>=0;i--){
            while(!s.isEmpty() && s.peek()<=elements[i]){
                s.pop();
            }
            if(s.isEmpty()){
                result[i]=-1;
            }else{
                result[i]=s.peek();
            }
            s.push(elements[i]);
        }
        return result;
    }

    public static void main(String args[]){
        // String s = "((a+b)";
        // System.out.println(duplicateParenthesis(s));
        int[] elements = {6,8,0,1,3};
        int[]  result=nextGreaterElement(elements);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
}
