package rpg;

public class Print {
    /**
     * 改行を行う
     */
    public static void print() {
        System.out.println();
    }

    /**
     * 引数を出力する
     *
     * @param message the message to print
     */
    public static <T> void print(T message) {
        System.out.println(message);
    }

    /**
     * 配列の要素を出力する
     *
     * @param messages the messages array to print
     */
    public static <T> void print(T[] messages) {
        for (T message : messages) {
            System.out.println(message);
        }
    }
}
