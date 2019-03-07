package LogAnalysis;
import java.util.Date;

public class UseMemory {
	static long startTime;
	static long preUseMemory;

	public static void start() {
		Runtime.getRuntime().gc();
		startTime = System.currentTimeMillis();
		preUseMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
	}

	public static void end() {
		long afterUseMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long useMemory = (afterUseMemory - preUseMemory) / 1000;
		long endTime = System.currentTimeMillis();
		long elapsedTime = endTime - startTime;
		System.out.println(new Date() + " | Elapsed Time : " + elapsedTime + " | Use Memory : " + useMemory);
	}
}
