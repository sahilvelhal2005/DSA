import java.util.*;

public class recursion {

    public static void printDec(int n) {
        if (n == 1) {
            System.out.print(1);
            return;
        } else {
            System.out.print(n + " ");
            printDec(n - 1);
        }
    }

    // print increasing
    public static void printInc(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        printInc(n - 1);
        System.out.print(n + " ");
    }

    // print Factorial

    public static int Fact(int n) {
        if (n == 0) {
            return 1;
        }
        int fn = n * Fact(n - 1);
        return fn;
    }

    // sum of first n natural numbers
    public static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        int sum = 0;
        sum = n + sum(n - 1);
        return sum;
    }

    // fibonnaci series
    public static int Fib(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }
        return (Fib(n - 1) + Fib(n - 2));
    }

    // is sorted array?
    public static boolean isSorted(int arr[], int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] > arr[i + 1]) {
            return false;
        } else {
            return isSorted(arr, i + 1);
        }
    }

    // search for last occourence key
    public static int LastOcc(int arr[], int key, int i) {
        if (i == 0) {
            if (arr[i] == key) {
                return i;
            } else {
                return -1;
            }
        } else if (arr[i] == key) {
            return i;
        } else {
            return LastOcc(arr, key, i - 1);
        }
    }

    //finding X^n

    public static int Pow(int x,int n){
        if(n==1){
            return x;
        }
        return (x*(Pow(x,n-1)));
    }


    //rain water trapping
    public static int RainTrap(int heights[]){
        int WaterTrapped=0;
        int LeftMax[]=new int[heights.length];
        int RightMax[]=new int[heights.length];
        if(heights.length==1){
            return 0;
        }
        LeftMax[0]=heights[0];
        RightMax[heights.length-1]=heights[heights.length-1];
        for(int i=1;i<heights.length;i++){
                LeftMax[i]=Math.max(LeftMax[i-1], heights[i]);
        }
        for(int i=heights.length-2;i>=0;i--){
            RightMax[i]=Math.max(heights[i],RightMax[i+1]);
        }
        for(int i=0;i<heights.length;i++){
            int res=Math.min(LeftMax[i], RightMax[i])-heights[i];
            if(res>=0){
                WaterTrapped+=res;
            }
        }
        return WaterTrapped;

    }

    public static void main(String args[]) {
        int height[] = {3,0,2};
        System.out.print(RainTrap(height));
    }
}