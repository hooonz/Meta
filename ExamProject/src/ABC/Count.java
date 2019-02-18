package ABC;

import java.io.BufferedReader;
import java.io.IOException;

public class Count implements CountAble {
	@Override
	public int count(String str) { //다형성

		return str.length();
	}

	public int count(BufferedReader letters) { //다형성
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
