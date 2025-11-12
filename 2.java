import java.util.*;

class student
{

    static Scanner sc = new Scanner(System.in);
    static float  credSum = 0;
    static float  PointSum =0;
    static float SGPA;
    static String name,usn;

    public static float sgpa(){
        System.out.print("Enter Number of subjects = ");
        int n = sc.nextInt();
        int cred[]=new int[n];//array for storing credits
        int marks[]=new int[n];//array to store marks

        for (int i = 0 ; i<n ; i++){
            System.out.print("Enter subject "+(i+1)+" Credits = ");
            cred[i] = sc.nextInt();
            credSum += cred[i];
            System.out.print("Enter your Marks = ");
            marks[i]=sc.nextInt();
            PointSum += credits(marks[i])*cred[i];
        }
    
        SGPA = PointSum/credSum;
        return SGPA;
    }
    
    public static void accept(){
        System.out.print("Enter your Name = ");
        name=sc.nextLine();
        System.out.print("Enter your USN = ");
        usn=sc.nextLine();        
    }

    public static int credits(int score)
    {
        if (score>90)return 10;
        else if (score>=80)return 9;
        else if (score>=70)return 8;
        else if (score>=60)return 7;
        else if (score>=50)return 6;
        else return 0;
    }

    public static void display(){
        sgpa();
        System.out.println("\n\nStudent name = "+name);
        System.out.println("Student USN = "+usn);
        System.out.println("Student SGPA = "+SGPA);

    }

    public static void main(String[] args) {
        accept();
        display();
    }
}

