package LogAnalysis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogAnalysis {
	boolean flag = true;
	ArrayList<LogVo> arr = new ArrayList<LogVo>();
	StringBuffer stringbuffer = new StringBuffer();
	String value = "";
	Map<String, LogVo> map = new HashMap<String, LogVo>();
	String ID = "";
	Pattern threadId = Pattern.compile("(eclipse.galileo-bean-thread-\\d{1,8})");
	Pattern startPattern = Pattern
			.compile("([0-9.]{8} [0-9:]{8}).*?(eclipse.galileo.bean.thread-[0-9]{8}).*?(##galileo_bean start)");
	Pattern endPattern = Pattern
			.compile("([0-9.]{8} [0-9:]{8}).*?(eclipse.galileo.bean.thread-[0-9]{8}).*?(##galileo_bean end).*?");
	Pattern esbId = Pattern.compile("(eclipse.galileo.bean.thread-[0-9]{8}).*?(IF_[0-9a-z-_]{41,44})");
	Pattern callTime = Pattern.compile("(eclipse.galileo.bean.thread-[0-9]{8}).*?(#galileo call time:[0-9]{3,4})");
	Pattern length = Pattern.compile("(eclipse.galileo.bean.thread-[0-9]{8}).*?Content-Length:([0-9]{3,5})");
	String str = "";
	File file = new File("C:/Users/Hoonz/Desktop/galileo.log");
	Date startDate = new Date();

	public String read_log() throws IOException { // 로그 분석
		BufferedReader br = new BufferedReader(new FileReader(file));
		while ((value = br.readLine()) != null) {
			Matcher startPatternMacher = startPattern.matcher(value); // 패턴Macher 생성
			Matcher esbIdMacher = esbId.matcher(value);
			Matcher callTimeMacher = callTime.matcher(value);
			Matcher endPatternMacher = endPattern.matcher(value);
			Matcher lengthMacher = length.matcher(value);
			if (flag) { // flag 값을 줘서 stopWatch를 만나면 else문으로 이동
				if (startPatternMacher.find()) {
					LogVo logVo = new LogVo();
					logVo.setStart(startPatternMacher.group(1));
					map.put(startPatternMacher.group(2), logVo);
				} else if (esbIdMacher.find()) {
					if (map.containsKey(esbIdMacher.group(1))) {
						map.get(esbIdMacher.group(1)).setEsbId(esbIdMacher.group(2));
					}
				} else if (callTimeMacher.find()) {
					if (map.containsKey(callTimeMacher.group(1))) {
						map.get(callTimeMacher.group(1)).setCallTime(callTimeMacher.group(2));
					}
				} else if (lengthMacher.find()) {
					if (map.containsKey(lengthMacher.group(1))) {
						map.get(lengthMacher.group(1)).setLength(lengthMacher.group(2));
					}
				} else if (value.contains("StopWatch")) { // stopWatch를 만날시 flag 값 false로 else로 이동
					Matcher stopMatcher = threadId.matcher(value);
					if (stopMatcher.find()) {
						ID = stopMatcher.group(0);
						flag = false;
					}
				} else if (endPatternMacher.find()) {
					if (map.containsKey(endPatternMacher.group(2))) {
						map.get(endPatternMacher.group(2)).setEnd(endPatternMacher.group(1));

						arr.add(map.get(endPatternMacher.group(2)));
					}
				}
			} else { // stopWatch다음 라인에 오는 마샬링들을 저장함
				if (value.contains("1. Before Marshalling")) {
					if (map.containsKey(ID)) {
						map.get(ID).setBeforeMarshaling(value.substring(0, 5));
					}
				} else if (value.contains("2. Marshalling")) {
					if (map.containsKey(ID)) {
						map.get(ID).setMarshalling(value.substring(0, 5));
					}
				} else if (value.contains("3. Invoking galileo")) {
					if (map.containsKey(ID)) {
						map.get(ID).setInvokingGalileo(value.substring(0, 5));
					}
				} else if (value.contains("4. Unmarshalling and Send to CmmMod Server")) {
					if (map.containsKey(ID)) {
						map.get(ID).setServer(value.substring(0, 5));
					}
				} else if (value.charAt(0) != '-' && value.charAt(0) != 'm') {
					flag = true;
				}

			}

		}
		Collections.sort(arr);
		for (LogVo log : arr) {
			stringbuffer.append(log.toString() + "\n");

		}
		return stringbuffer.toString();

	}

	public void writer(String result) throws IOException { // 로그분석후에 파일로저장
		File file1 = new File("C:/Users/Hoonz/Desktop/test.log");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file1));
		bw.write(result);
		Date endDate = new Date();
		System.out.println((double) (endDate.getTime() - startDate.getTime()) / 1000 + "초");
		bw.close();

	}
}
