package rpg;

public class Print {
    /**
     * Prints a newline.
     */
    public static void print() {
        System.out.println();
    }

    /**
     * Prints a message.
     *
     * @param message the message to print
     */
    public static <T> void print(T message) {
        System.out.println(message);
    }

    /**
     * Prints messages.
     *
     * @param messages the messages array to print
     */
    public static <T> void print(T[] messages) {
        for (T message : messages) {
            System.out.println(message);
        }
    }
}
