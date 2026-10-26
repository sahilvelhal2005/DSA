import java.util.*;
public class patterns {


    //binary coefficient

    public static int factorial(int n,int r,int k){
        Scanner sc=new Scanner(System.in);{
        int n_fact=1;
        k=n-r;
        for(int i=1;i<=n;i++){
            n_fact=n_fact*i;
        }
        int r_fact=1;
        for(int i=1;i<=r;i++){
            r_fact=r_fact*i;
        }
        int k_fact=1;//k=n-r
        for(int i=1;i<=k;i++){
            k_fact=k_fact*i;
        }
        return n_fact/(r_fact*k_fact);
    }
}

    //binary to decimal

    public static int binnum(int binary){
            int decimal=0;
            int power=0;
            while(binary>0){
                decimal=decimal+(int)Math.pow(2, power);
                power++;
                binary/=10;
                
            }
            return decimal;
    }


     //decimal to binary

    public static int decimal(int num){
            int power=0;
            int binary=0;
            while(num>0){
            binary=binary+(((num)%2)*(int)Math.pow(10,power));
            power++;
            num=num/2;
            }
            return binary;

    }


    //average of three numbers

    public static void average(int num1,int num2,int num3){
        int average=(num1+num2+num3)/3;
        System.out.println("The average of three numbers is: "+average);
    }


    //is even

    public static void isEven(int num){
            boolean result=false;
            if(num%2==0){
                result=true;
                
            }
            
            System.out.println("The number is even : "+result);

    }


    //sum of digits of an integer

    public static void sum(int num){
        int sum=0;
        while(num>0){
        int rem=num%10;
        sum=sum+rem;
        num=num/10;
        }
        System.out.println("The sum of digits of a number is:"+sum);
    }


    //palindrome number check

    public static void palindrome(int num){
        int rev_num=0;
        int original_num=num;
        while(num>0){
            int digit=num%10;
            rev_num=rev_num*10+digit;
            num=num/10;
        }
        if(original_num==rev_num){
            System.out.println("The number is palindrome number.");
        }
        else{
            System.out.println("The number is not palindrome number.");
        }
    }


    //hollow rectangle

    public static void hollow_rect(int row,int col){
        for (int i=1;i<=row;i++){
            for(int j=1;j<=col;j++){
                if(i==1 || i==row || j==1 || j==col){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    //mirror trangle

    public static void mirror_tri(int row){
        for(int i=1;i<=row;i++){
            for(int j=1;j<=row-i;j++){
                System.out.print(" ");
            }
            for(int k=1;k<=i;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //inverted half pyramid with numbers
    public static void inverted_half_pyramid_numbers(int row){
        for(int i=0;i<row;i++){
            for(int j=1;j<=row-i;j++){
                System.out.print(j);
            }
            System.out.println();
        }
    }

    //floyds trangle
    public static void floyd_traingle(int row){
        int counter=1;
        for(int i=1;i<=row;i++){
            for(int j=1;j<=i;j++){
                System.out.print(" "+counter);
                counter+=1;
            }
            System.out.println();
        }
    }

    //0 1 traingle
    public static void zero_one_traingle(int row){
        for(int i=1;i<=row;i++){
            for(int j=1;j<=i;j++){
                if((i-j)%2==0){
                    System.out.print("1");
                }
                else{System.out.print("0");
            }
            }
            System.out.println();
        }
    }

    //butterfly pattern
    public static void butterfly(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int k=1;k<=2*(n-i);k++){
                System.out.print(" ");
            }
            for(int l=1;l<=i;l++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=0;i<n;i++){
        for(int j=1;j<=(n-i);j++){
            System.out.print("*");
        }
        for(int k=1;k<=(2*i);k++){
            if(i==0){
                continue;
            }
            System.out.print(" ");
        }
        for(int l=1;l<=(n-i);l++){
            System.out.print("*");
        }
        System.out.println();
    }

    }

    //solid rhombus
    public static void solid_rhombus(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            for(int k=1;k<=n;k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    //hollow rhombus
    public static void hollow_rhombus(int n){
        for(int i=1;i<=n;i++){
            if(i==1){
                for(int x=1;x<=(n-i);x++){
                    System.out.print(" ");
                }
                for(int y=1;y<=n;y++){
                    System.out.print("*");
                }
                System.out.println();
            }
            else if(i==n){
                for(int x=1;x<=n;x++){
                    System.out.print("*");
                }
            }
            else{
                for(int x=1;x<=(n-i);x++){
                    System.out.print(" ");
                }
                System.out.print("*");
                for(int x=1;x<=(n-2);x++){
                    System.out.print(" ");
                }
                System.out.print("*");
                System.out.println();
            }
        }
    }

    //diamond pattern
    public static void diamond(int n){
        for(int i=1;i<=n;i++){
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n;i>=1;i--){
            for(int j=1;j<=(n-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=2*i-1;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    

    //main function

    public static void main(String args[]) {
        Scanner sc=new Scanner(System.in);
        int n=5;
        diamond(n); 
        return;
}
}
