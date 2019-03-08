package LogAnalysis;

public class LogVo implements Comparable<LogVo> {
private String start;
private String esbId;
private String length;
private String callTime;
private String beforeMarshaling;
private String Marshalling;
private String invokingGalileo;
private String server;


public String getStart() {
	return start;
}
public void setStart(String start) {
	this.start = start;
}
public String getEsbId() {
	return esbId;
}
public void setEsbId(String esbId) {
	this.esbId = esbId;
}
public String getLength() {
	return length;
}
public void setLength(String length) {
	this.length = length;
}
public String getCallTime() {
	return callTime;
}
public void setCallTime(String callTime) {
	this.callTime = callTime;
}
public String getBeforeMarshaling() {
	return beforeMarshaling;
}
public void setBeforeMarshaling(String beforeMarshaling) {
	this.beforeMarshaling = beforeMarshaling;
}
public String getMarshalling() {
	return Marshalling;
}
public void setMarshalling(String marshalling) {
	Marshalling = marshalling;
}
public String getInvokingGalileo() {
	return invokingGalileo;
}
public void setInvokingGalileo(String invokingGalileo) {
	this.invokingGalileo = invokingGalileo;
}
public String getServer() {
	return server;
}
public void setServer(String server) {
	this.server = server;
}
public String getEnd() {
	return end;
}
public void setEnd(String end) {
	this.end = end;
}
private String end;


@Override
public String toString() {
	return start + ", " + end + ", " + esbId + ", " + length
			+ ", " + beforeMarshaling + ", " + Marshalling + ", "
			+ invokingGalileo + ", " + server ;
}
@Override
public int compareTo(LogVo o) {
	
	return start.compareTo(o.getStart()) ;
}

}

