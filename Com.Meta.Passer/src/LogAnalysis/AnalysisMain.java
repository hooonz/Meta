package LogAnalysis;

import java.io.IOException;
import java.util.Date;

public class AnalysisMain {
public static void main(String[] args) throws IOException {
	UseMemory memory = new UseMemory();
	memory.start();
	LogAnalysis log = new LogAnalysis();
	
	String result = log.read_log();
	log.writer(result);
	System.out.println("¿Ï·á");
	memory.end();
}
}
