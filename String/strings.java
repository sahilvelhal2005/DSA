import java.util.*;

public class strings {

    //shortest path to reach destination
    public static void desti(){
        String path="WNEENESENNN";
        int x=0,y=0;
        for(int i=0;i<=path.length()-1;i++){
            //east
            if(path.charAt(i)=='E'){
                x++;
            }
            //west
            else if(path.charAt(i)=='W'){
                x--;
            }
            //north
            else if(path.charAt(i)=='N'){
                y++;
            }
            //south
            else if(path.charAt(i)=='S'){
                y--;
            }
        }
        double dist=Math.sqrt(x*x+y*y);
        System.out.println(dist);

    }

    //maing substrings
    public static String substring(String str,int in_1,int in_2){
        String sub_string=str.substring(in_1,in_2);
        return sub_string;
    }

    //comparing two strings
    public static int compare(String str1, String str2){
        int result=str1.compareTo(str2);
        if(result==0){
            System.out.println("Strings are equal");
        }
        else if(result<0){
            System.out.println("second string is largest.");
        }
        else{
            System.out.println("first string is largest.");
        }
        return result;
    }

    //first letters of string to uppercase
    public static void uppercase(String str){
        StringBuilder sb=new StringBuilder("");
        char ch=Character.toUpperCase(str.charAt(0));
        sb.append(ch);
        for(int i=1;i<str.length();i++){
            if(str.charAt(i)==' ' && i<str.length()-1){
            sb.append(str.charAt(i));
            i++;
            sb.append(Character.toUpperCase(str.charAt(i)));
            }
            else{
            sb.append(str.charAt(i));
        }

        }
        System.out.println(sb);
        
    }

    //count of lower case vowels appeered
    public static void count_lower_vowels(String str){
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u'){
                count++;
            }
        }
        System.out.println(count);
    }

    //check if palindrome

    public static boolean palindrome(String word){
        int start=0;
        int end=word.length()-1;
        int n=word.length()/2;
        while(start<=n && end>=n){
            if(word.charAt(start)!=word.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    //shortest path to reach destination
    public static int s_path(String path){
        int X=0;
        int Y=0;
        for(int i=0;i<=path.length()-1;i++){
            if(path.charAt(i)=='W'){
                X=X-1;
            }
            else if(path.charAt(i)=='E'){
                X=X+1;
            }
            else if(path.charAt(i)=='N'){
                Y=Y+1;
            }
            else if(path.charAt(i)=='S'){
                Y=Y-1;
            }

        }
        int result=(int)Math.sqrt(Math.pow(X, 2)+Math.pow(Y, 2));
        return result;
    }

    //MAIN function
    public static void main(String args[]){
            Scanner sc= new Scanner(System.in);
            String str="hello";
            String path="WNEENESENNN";
            System.out.println(s_path(path));
    }
    
}


//if you want to check if the value inside two strings are equal or not
//you can use equals() function it return boolean value
//eg: str1.equals(str2) -> returns true if both strings are equal otherwise false



//to get the substring of a string 
//use function .substring(si,ei) -> si is starting index and ei is ending index(not included)
//eg: String str="hello";
//String substr=str.substring(0,3); -> it will return "hel"


//if you want to compare two strings
//use compareTo() function it returns integer value
//eg: str1.compareTo(str2) -> returns 0 if both strings are equal
//returns negative value if str1<str2
//returns positive value if str1>str2
//in lexicographical order i.e A and a are considered different
//if you want to keep A and a same then use equalsIgnoreCase() and compareToIgnoreCase() functions


//string builder
