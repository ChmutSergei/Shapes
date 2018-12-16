package by.chmut.shapes.util;


public class IdGenerator {

    private static final long MIN = 10_000;
    private static final long MAX = 1_000_000;

    private static long id = MIN;

    private IdGenerator() {
    }

    public static long getId(){
        if (id == MAX) {
            id = MIN;
        }
        return id++;
    }
}
