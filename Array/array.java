import java.util.*;


public class array {

    //changing array
    public static void change(String fruits[]){
        fruits[0]="apple";
        fruits[1]="mango";
        fruits[2]="banana";
    }

    //linear search of string array
    public static int linear_search(String menue[],String key){
        for(int i=0;i<menue.length;i++){
            if(menue[i].equals(key)){
                return i;
            }
            
        }
        return -1;
    }

    //greatest of all numbers
    public static int greatest_of_all(int numbers[]){
            int highest_num=Integer.MIN_VALUE;
            for(int i=0;i<numbers.length;i++){
                if(numbers[i]>highest_num){
                    highest_num=numbers[i];
                }
            }
            return highest_num;
    }

    //binary search
    public static int binary_search(int numbers[],int key){
        int start=0;
        int end=numbers.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(numbers[mid]==key){
                System.out.println("key found at index: "+mid);
                return mid;
            }
            else if(numbers[mid]>key){
                end=mid-1;
            }
            else{start=mid+1;}

        }
        return -1;
    }

    //pairs in array
    
    public static void reverse(int numbers[]){
        int max_sum=Integer.MIN_VALUE;
        int curr_sum=0;
        for(int i=0;i<numbers.length;i++){
            int curr=numbers[i];
            for(int j=i+1;j<numbers.length;j++){
                System.out.print("("+curr+","+numbers[j]+")");
                curr_sum=curr+numbers[j];
                if(curr_sum>max_sum){
                    max_sum=curr_sum;
                }
            }
            
            System.out.println();
            System.out.println("the maximum sum is: "+max_sum);
            
        }
    }
        

        //double number checking

    public static boolean double_check(int numbers[]){
            
            for(int i=0;i<numbers.length;i++){
                for(int j=i+1;j<numbers.length;j++){
                    if(numbers[i]==numbers[j]){
                        return true;
                    }
                    
                }
            }
            return false;
        }

        //rain trapping
        public static int rain_traping(int heights[]){
            //water trapped=(water level-column level)*width of colum
            //water_level=min(left,right)-height
            //making left and right maximum arrays (auxillary array)
            int left_max[]=new int[heights.length];
            int right_max[]=new int[heights.length];
            int n=heights.length;
            if(n==0){
                return 0;
            }
            int water_trapped=0;
            right_max[n-1]=heights[n-1];
            left_max[0]=heights[0];
            for(int i=1;i<n;i++){
                left_max[i]=Math.max(heights[i], left_max[i-1]);
            }
            for(int i=n-2;i>=0;i--){
                
                right_max[i]=Math.max(heights[i], right_max[i+1]);
            }
            for(int i=0;i<n;i++){
                water_trapped+=(Math.min(left_max[i], right_max[i]))-heights[i];
            }
            return water_trapped;
        }

        //bubble sorting
        public static void bubble_sort(int numbers[]){
            for(int i=0;i<numbers.length-1;i++){
                for(int j=0;j<numbers.length-1-i;j++){
                    if(numbers[j]>numbers[j+1]){
                        //swap
                        int temp=numbers[j];
                        numbers[j]=numbers[j+1];
                        numbers[j+1]=temp;
                    }
                }
            }
        }


        //print bubble sorted array
        public static void print_sorted_array(int numbers[]){
            for(int i=0; i<=numbers.length-1;i++){
                System.out.print(numbers[i]+" ");
            }
        }


        //selection sorting
        public static void selection_sorting(int arr[]){
            for(int i=0;i<arr.length-1;i++){
                int minval=i;
                for(int j=i+1;j<arr.length;j++){
                    if(arr[j]<arr[minval]){
                        minval=j;
                    }
                }
                //swap
                int temp=arr[i];
                arr[i]=arr[minval];
                arr[minval]=temp;
            }
        }
    
    //MAIN function
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int heights[]={1,2,3,4,5,6,7,8,9,10};
        int numbers[] = {2, 4, 6, 8};
        reverse(numbers);
        // bubble_sort(numbers);
        // print_sorted_array(numbers);
    }
}
    



