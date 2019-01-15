package ABC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {
	public int fileread() throws IOException {
		String path = "D:/Test/test.txt";
		File file = new File(path);
		Count count = new Count();
		FileReader filereader = new FileReader(file);
		BufferedReader bufferedreader = new BufferedReader(filereader);
		int result = count.count(bufferedreader);
		return result;
	}

	public String fileread(int input) throws IOException {
		String path = "D:/Test/test.txt";
		File file = new File(path);
		Count count = new Count();
		FileReader filereader = new FileReader(file);
		BufferedReader bufferedreader = new BufferedReader(filereader);
		int result = count.count(bufferedreader);
		String str = String.valueOf(result);
		return str;
	}
}
