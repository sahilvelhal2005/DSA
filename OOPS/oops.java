import java.util.*;

public class oops {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Complex c1 = new Complex();
        Complex c2 = new Complex();
        System.out.print("Enter real part of first number: ");
        c1.real = sc.nextInt();
        System.out.print("Enter img part of first number: ");
        c1.img = sc.nextInt();
        System.out.print("Enter real part of second number: ");
        c2.real = sc.nextInt();
        System.out.print("Enter img part of second number: ");
        c2.img = sc.nextInt();

        System.out.println("The sum is: " + Complex.sum(c1.real, c1.img, c2.real, c2.img));

        System.out.println("The diff is: " + Complex.sub(c1.real, c1.img, c2.real, c2.img));

        System.out.println("The product is: " + Complex.pro(c1.real, c1.img, c2.real, c2.img));
    }

}

// sum diff pro of two complex numbers

class Complex {
    int real;
    int img;

    static String sum(int real1, int img1, int real2, int img2) {
        return (real1 + real2) + "+" + (img1 + img2) + "i";
    }

    static String sub(int real1, int img1, int real2, int img2) {
        return (real1 - real2) + "+" + (img1 - img2) + "i";
    }

    static String pro(int real1, int img1, int real2, int img2) {
        int real = real1 * real2 - img1 * img2;
        int img = real1 * img2 + img1 * real2;
        return real + "+" + img + "i";
    }
}

class Student {
    String name;
    int marks;

    Student() {
    }

    // constructor
    Student(Student s1) {
        this.marks = s1.marks;
        this.name = s1.name;
    }

    void newMarks(int newMarks) {
        marks = newMarks;

    }

    void newname(String newName) {
        name = newName;
    }
}
