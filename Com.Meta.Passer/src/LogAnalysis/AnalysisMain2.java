package LogAnalysis;

import java.io.IOException;
import java.text.ParseException;

public class AnalysisMain2 {
public static void main(String[] args) throws IOException, ParseException {
	 UseMemory memory = new UseMemory();
	 memory.start();
	 LogAnalysis2 log = new LogAnalysis2();
	 log.log_analysis();
	 String str = log.test();
	 log.writer(str);
	 
	 
	 memory.end();
}
}
