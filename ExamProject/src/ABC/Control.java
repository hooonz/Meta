package ABC;

import java.io.IOException;

public class Control {
	Write write = new Write();
	Read read = new Read();
	Count count = new Count();
	FileSave fileSave = new FileSave();
	FileRead fileRead = new FileRead();

	public void ConsoleToConsole() throws IOException {

		String str = read.read();
		int cnt = count.count(str);
		write.write(cnt);
	}

	public int ConsoleToFile() throws IOException {
		String str = read.read();
		int cnt = count.count(str);
		return cnt;
	}

	public void FileToConsole() throws IOException {
		write.write(fileRead.fileread());
	}

	public void FileToFile() throws IOException {

	}
}
