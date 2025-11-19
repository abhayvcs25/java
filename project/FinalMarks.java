import java.util.*;
import CIE.*;
import SEE.*;

public class FinalMarks {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        Internals[] internals = new Internals[n];
        External[] externals = new External[n];

        for(int i = 0; i < n; i++) {

            System.out.println("\n--- Enter details for Student " + (i+1) + " ---");

            System.out.print("USN: ");
            String usn = sc.next();

            System.out.print("Name: ");
            String name = sc.next();

            System.out.print("Semester: ");
            int sem = sc.nextInt();

            int[] internalMarks = new int[5];
            int[] seeMarks = new int[5];

            System.out.println("Enter 5 Internal Marks:");
            for(int j = 0; j < 5; j++) {
                internalMarks[j] = sc.nextInt();
            }

            System.out.println("Enter 5 SEE Marks:");
            for(int j = 0; j < 5; j++) {
                seeMarks[j] = sc.nextInt();
            }

            internals[i] = new Internals(internalMarks);
            externals[i] = new External(usn, name, sem, seeMarks);
        }

        // Printing Final Marks
        System.out.println("\n====== Final Marks of Students ======");
        for(int i = 0; i < n; i++) {
            System.out.println("\nStudent: " + externals[i].name + " (" + externals[i].usn + ")");
            System.out.println("Semester: " + externals[i].sem);

            System.out.println("Course-wise Final Marks:");
            for(int j = 0; j < 5; j++) {
                int finalMarks = internals[i].internalMarks[j] + (externals[i].seeMarks[j] / 2);
                System.out.println("Course " + (j+1) + ": " + finalMarks);
            }
        }

        sc.close();
    }
}
