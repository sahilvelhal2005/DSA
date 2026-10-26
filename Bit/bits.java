import java.util.*;
public class bits {

    //check even or odd
        public static void isEvenOdd(int n){
            int one=1;
            if((n&one)==0){
                System.out.println(n+" is even");
            }
            else{
                System.out.println(n+" is odd");
            }
        }

        //get ith bit
            public static void ithBit(int n,int i){
                int bitmask=1<<i;
                if((n&bitmask)==0){
                    System.out.println("at ith place there is 0");
                }
                else{
                    System.out.println("at ith place there is 1");
                }
            }

            //set ith bit
            public static void setithBit(int n,int i){
                int bitMask=1<<i;
                n=n|bitMask;
                System.out.println(n);
            }

            //clear ith bit
            public static void clearIthBit(int n,int i){
                int bitMask=~(1<<i);
                System.out.println((n & bitMask));

            }



    public static void main(String args[]){
        Scanner sc= new Scanner(System.in);
        clearIthBit(10, 1);

    }
    
}
