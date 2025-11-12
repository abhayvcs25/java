import java.util.Scanner;
class quad
{
    float eq(float a, float b)
    {
        return (-b/(2 * a)) ;
    }
}

class demo
{
    public static void main (String args[])
    {
        float a,b,c;
        float dis,r1,r2,d;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter value for a =");
        a=input.nextFloat();
        System.out.print("Enter value for b =");
        b=input.nextFloat();
        System.out.print("Enter value for c =");
        c=input.nextFloat();
        
        dis =(b*b)-(4*a*c);

        if (dis == 0)
        {
            quad e = new quad();
            float res= e.eq(a,b);
            System.out.println("the roots are real and equal");
            System.out.println("root1="+res);
            System.out.println("root2="+res);
        }
        else if (dis > 0)
        {
            d=(b*b)-(4*a*c);
            r1=(float) (-b+Math.sqrt(d))/(2*a);
            r2=(float) (-b-Math.sqrt(d))/(2*a);

            System.out.println("roots are real and disinct");
            System.out.println("root1 = "+r1);
            System.out.println("root2 = "+r2);
        }
        else
        {
            System.out.println("roots are distinct and virtual");
        }

    }
}