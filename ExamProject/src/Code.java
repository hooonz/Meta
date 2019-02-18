import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public class Code implements  ReadAble, WriteAble, CountAble {

	@Override
	public String read() {
		Scanner sc = new Scanner(System.in);
		String result = sc.nextLine();
		return result;
	}

	@Override
	public void write(int cnt) {
		System.out.println(cnt);
	}

	@Override
	public int count(String str) {

		return str.length();
	}

	public int count(BufferedReader letters) {
		String s = "";
		String str = "";
		try {
			while ((s = letters.readLine()) != null) {
				str = str + s;

			}
		} catch (IOException e) {

			e.printStackTrace();
		}
		int a = str.length();
		return a;
	}

}
