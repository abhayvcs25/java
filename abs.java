abstract class shapes{
    int a,b;
    abstract void printarea();
}
 class rectangle extends shapes{

    rectangle(int x, int y) {
        a=x;
        b=y;
    }
    
    void printarea(){
        System.out.println("the area of rectangle is = "+(a*b));
    }
 }

class triangle extends shapes{

    public triangle(int x, int y) {
        a=x;
        b=y;
    }
    
    void printarea(){
        System.out.println("the area of rectangle is = "+(.5*a*b));
    }
 }
 
 class circle extends shapes{

    public circle(int x) {
        a=x;
    }
    
    void printarea(){
        System.out.println("the area of rectangle is = "+(3.14*a*a));
    }
 }

 class abs{
    public static void main(String args[]){
        rectangle rec = new rectangle(5,6);
        rec.printarea();

        triangle tri = new triangle(5,6);
        tri.printarea();

        circle cri = new circle(5);
        cri.printarea();
    }
 }