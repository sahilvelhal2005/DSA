import java.util.*;

public class twodarray {

    //taking input in 2darrays and printing its output
    public static void input_output_2darray(int array[][]){
    Scanner sc=new Scanner(System.in);
       int n=array.length;
       int m=array[0].length;
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            array[i][j]=sc.nextInt();
        }
       }
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            System.out.print(array[i][j]+" ");
        }
        System.out.println();
       }
     }

     //2d array sprial printing
     public static void spiral(int array[][]){
        int startRow=0;
        int startCol=0;
        int endRow=array.length-1;
        int endCol=array[0].length-1;
        while(startRow<=endRow && startCol<=endCol){

        //top
        for(int j=startCol;j<=endCol;j++){
            System.out.print(array[startRow][j]+" ");
        }
        //right
        for(int i=startRow+1;i<=endRow;i++){
            System.out.print(array[i][endCol]+" ");
        }
        //bottom
        for (int j = endCol - 1; j >= startCol; j--) {
            if(startRow==endRow){
                break;
            }
                System.out.print(array[endRow][j] + " ");
            }
        
        //left
            for (int i = endRow - 1; i >= startRow+1; i--) {
                if(startCol==endCol){
                    break;
                }
                System.out.print(array[i][startCol] + " ");
            }
        
        startCol++;
        startRow++;
        endCol--;
        endRow--;
     }
    }

   public static void dia_sum(int array[][]) {
    int n = array.length;
    int sum = 0;

    for (int i = 0; i < n; i++) {
        // Primary diagonal
        sum += array[i][i];

        // Secondary diagonal
        //i+j=n-1
        //j=n-1-i
        if (i != n - 1 - i) {  // Avoid double-counting the middle element in odd matrix
            sum += array[i][n - 1 - i];
        }
    }

    System.out.println("The diagonal sum is: " + sum);
}

//searching for largest number in twodarray
    public static void largest(int matrix[][]){
        int largest_num=Integer.MIN_VALUE;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]>largest_num){
                    largest_num=matrix[i][j];
                }
            }
        }
        System.out.println("the largest number from the matrix is : "+largest_num);

    }

    //laddercase search in two d array start from top-right
    public static boolean laddercase(int matrix[][],int key){
        int row=matrix.length-1;
        int col=0;
    
            while(row>=0 && col<=matrix[0].length-1){
                if(key==matrix[row][col]){
                    System.out.println("key found at ("+row+","+col+")");
                    return true;
                }
                else if(key<matrix[row][col]){
                    row--;
                }
                else{
                    col++;
                }
            }
            System.out.println("key not found");
            return false;
        }

        //laddercase methods to search a key start from bottom-left
        public static boolean ladder_search(int arr[][],int key){
            int row=arr.length-1;
            int col=0;

            while(row>=0 && col<=arr[0].length-1){
                if(arr[row][col]==key){
                    System.out.println("key found at: "+row+" , "+col);
                    return true;
                }
                else if(key<arr[row][col]){
                    row--;
                }
                else if(key>arr[row][col]){
                    col++;
                }
            }
            System.out.println("key not found!");
            return false;
        }
    

        //transpose of a matrix row to col and col to row
        public static void transpose(int arr[][]){
            int rows=arr.length;
            int cols=arr[0].length;
            int newarr[][]=new int[cols][rows];
            for(int i=0;i<rows;i++){
                for(int j=0;j<cols;j++){
                    newarr[j][i]=arr[i][j];
                }
        }
    }

    //print array
    public static void printarray(int arr[][]){
        int rows=arr.length;
        int cols=arr[0].length;
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }

    //main function
public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int array[][]={{1,2,3},{4,5,6},{7,8,9}};
        spiral(array);
        System.out.println();
        printarray(array);

    }
}
    
