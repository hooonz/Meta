package ABC;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileSave {
	public void Files(String result) throws IOException {

		File f1 = new File("D:/Test/exam.txt");
		PrintWriter p1 = new PrintWriter(new FileWriter(f1, false));
		p1.write(result);
		p1.close();
	}

}
