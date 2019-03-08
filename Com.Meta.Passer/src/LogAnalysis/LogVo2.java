package LogAnalysis;

public class LogVo2 implements Comparable<LogVo2>{
	private String time;
	private long process;
	private long avgTime;
	private long minTime;
	private long maxTime;
	private long avgSize;
	private long minSize;
	private long maxSize;
	private long sumTime;
	private long sumSize;

	public long getSumSize() {
		return sumSize;
	}

	public void setSumSize(long sumSize) {
		this.sumSize = sumSize;
	}

	public long getSumTime() {
		return sumTime;
	}

	public void setSumTime(long sumTime) {
		this.sumTime = sumTime;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public long getProcess() {
		return process;
	}

	public void setProcess(long process) {
		this.process = process;
	}

	public long getAvgTime() {
		return avgTime;
	}

	public void setAvgTime(long avgTime) {
		this.avgTime = avgTime;
	}

	public long getMinTime() {
		return minTime;
	}

	public void setMinTime(long minTime) {
		this.minTime = minTime;
	}

	public long getMaxTime() {
		return maxTime;
	}

	public void setMaxTime(long maxTime) {
		this.maxTime = maxTime;
	}

	public long getAvgSize() {
		return avgSize;
	}

	public void setAvgSize(long avgSize) {
		this.avgSize = avgSize;
	}

	public long getMinSize() {
		return minSize;
	}

	public void setMinSize(long minSize) {
		this.minSize = minSize;
	}

	public long getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(long maxSize) {
		this.maxSize = maxSize;
	}

	@Override
	public String toString() {
		return time + ", " + process + ", " + avgTime + ", " + minTime + ", " + maxTime + ", " + avgSize + ", "
				+ minSize + ", " + maxSize;
	}

	@Override
	public int compareTo(LogVo2 arg0) {
		return time.compareTo(arg0.getTime());
	}
}
