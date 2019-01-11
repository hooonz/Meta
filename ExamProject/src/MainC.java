import java.io.IOException;

//file to console
public class MainC {
	public static void main(String[] args) throws IOException {
		Controller control = new Controller();
		control.control3(control.fileread());
		System.out.println("====완료====");
	}
}
