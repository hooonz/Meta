import java.io.IOException;
//console to file
public class MainB {
	public static void main(String[] args) throws IOException {
		Controller control = new Controller();
		int result;
		result = control.control2();
		control.Files(result);
		System.out.println("---TXT파일 저장완료 ---");
	}
}
