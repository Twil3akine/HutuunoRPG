package rpg;

import java.util.Scanner;

public class ScanCommand {
	// fields
	final private static Scanner scan = new Scanner(System.in);
	// constructor
	public ScanCommand() {  }
	// methods
	public static int scan() {
		while (true) {
			try {
                return scan.nextInt();
			} catch(Exception e) {
				System.out.println("正しい値を入力してください。");
				scan.next();
			}
		}
	}
	
	public static void close() { scan.close(); }
}