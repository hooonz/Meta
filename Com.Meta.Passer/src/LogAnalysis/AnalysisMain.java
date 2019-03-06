package LogAnalysis;

import java.io.IOException;

public class AnalysisMain {
public static void main(String[] args) throws IOException {
	LogAnalysis log = new LogAnalysis();
	String result = log.read_log();
	log.writer(result);
	System.out.println("¿Ï·á");
}
}
