package ABC;

import java.io.IOException;

public class ControlMain {
	public static void main(String[] args) throws IOException {
		Control start = new Control();
		 start.ConsoleToConsole(); //console > console
		// start.ConsoleToFile(); //console > file
		// start.FileToConsole(); //file > console
		// start.FileToFile();
	}
}
