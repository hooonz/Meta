import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Controller extends Code {
	public void control() {
		String str = read();
		int cnt = count(str);
		Code code = new Code();
		write(cnt);
	}


	public int control2() {
		String str = read();
		int cnt = count(str);
		return cnt;
	}
	public void control3(int input) {
		
		write(input);
		
	}
	
/*----------------file Save -------------------------------*/
	public void Files(String result) throws IOException {

		File f1 = new File("D:/Test/exam.txt");
		PrintWriter p1 = new PrintWriter(new FileWriter(f1, false));
		p1.write(result);
		p1.close();
	}

	public void Files(int result) throws IOException {
		Files(String.valueOf(result));
	}
	/*-------------file read----------------------------------*/
	public int fileread() throws IOException {
		String path = "D:/Test/test.txt";
		File file= new File(path);
		FileReader filereader = new FileReader(file);
		BufferedReader bufferedreader = new BufferedReader(filereader);
		int result= count(bufferedreader);
		return result;
	}

}
