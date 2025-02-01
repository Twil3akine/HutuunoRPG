package rpg;

import java.util.Scanner;
import static rpg.Print.print;

public class ScanCommand {
	// fields
	final private static Scanner scan = new Scanner(System.in);
	// constructor
	public ScanCommand() {  }
	// methods
	/**
	 * 入力された値を返す
	 *
	 * @return 入力された値
	 */
	public static int scan() {
		while (true) {
			try {
                return scan.nextInt();
			} catch(Exception e) {
				print("正しい値を入力してください。");
				scan.next();
			}
		}
	}

	/**
	 * Scannerを閉じる
	 */
	public static void close() { scan.close(); }
}