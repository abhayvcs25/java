package CIE;

public class Internals {
    public int[] internalMarks = new int[5];

    public Internals(int[] marks) {
        for (int i = 0; i < 5; i++) {
            this.internalMarks[i] = marks[i];
        }
    }
}
