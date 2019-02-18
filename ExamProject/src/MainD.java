import java.io.IOException;

//file to file
public class MainD {

	public static void main(String[] args) throws IOException {

		Controller control = new Controller();
		int result = control.fileread();
		control.Files(result);
		System.out.println("====완료====");
	}

}
