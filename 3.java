import java.util.*;

class book{
    String name;
    String author;
    int price;
    int num_pages;
    Scanner sc = new Scanner(System.in);

    book(String name,String author, int price , int num_pages){
        this.name=name;
        this.author=author;
        this.price=price;
        this.num_pages=num_pages;
    }

    void set_get(){
        System.out.println("\n-----MENU-----");
        System.out.println("1   name");
        System.out.println("2   Author");
        System.out.println("3   price");
        System.out.println("4   num of pages");
        System.out.print("Enter your choice = ");
        int choice;
        choice = sc.nextInt();
        sc.nextLine();
        
        switch(choice){
            case 1 -> {
                System.out.print("Enter the name = ");
                String name1 = sc.nextLine();
                name = name1;
            }
            case 2 -> {
                System.out.print("Enter the Author name = ");
                String author1 = sc.nextLine();
                author = author1;
            }
            case 3 -> {
                System.out.print("Enter the price = ");
                int price1 = sc.nextInt();
                price = price1;
            }
            case 4 -> {
                System.out.print("Enter the Num of pages = ");
                int num_pages1 = sc.nextInt();
                num_pages = num_pages1;
            }
            default -> System.out.println("Invalid choice");
        } 
    }

    void display(){
        System.out.println("");
        System.out.println("Name = "+name);
        System.out.println("Author Name = "+author);
        System.out.println("price = "+price);
        System.out.println("number of pages = "+num_pages);
    }
}

class demo{
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
       int choice=0,n,i=0,j;
        System.out.print("Enter number of books = ");
        n = sc.nextInt();
        book[] books = new book[n];
        while(choice!= 4 || i<n){
                System.out.println("\n-----MENU-----");
                System.out.println("1   insert");
                System.out.println("2   change details");
                System.out.println("3   display");
                System.out.println("4   exit");
                System.out.print("Enter your choice = ");
                choice = sc.nextInt();
                sc.nextLine();

                switch(choice){
                case 1 -> {
                        System.out.print("Enter name = ");
                        String name = sc.nextLine();
                        System.out.print("Enter author = ");
                        String author = sc.nextLine();
                        System.out.print("Enter price = ");
                        int price = sc.nextInt();
                        System.out.print("Enter pages = ");
                        int pages = sc.nextInt();
                        
                        books[i] = new book(name,author,price,pages);
                        i++;
                        }
                case 2 -> {
                        System.out.print("Enter book num to change = ");
                        j= sc.nextInt();
                        books[j-1].set_get();
                }
                case 3 -> {
                        System.out.print("Enter book num to display = ");
                        j= sc.nextInt();
                        books[j-1].display();
                }
                case 4 -> {
                }
                default -> System.out.println("Invalid choice");
        } 

        }

    }
}