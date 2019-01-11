package ABC;

import java.util.Scanner ;

public class Read implements  ReadAble {
	@Override
	public String read() {
		Scanner sc = new Scanner(System.in);
		String result = sc.nextLine();
		return result;
	}
}
