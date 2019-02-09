package by.chmut.shapes.util;

public class IdGenerator {

    private static final long START = 10_000;
    private static final long MAX = 1_000_000;

    private static long id = START;

    private IdGenerator() {
    }

    public static long generateId(){
        if (id == MAX) {
            id = START;
        }
        return id++;
    }
}
