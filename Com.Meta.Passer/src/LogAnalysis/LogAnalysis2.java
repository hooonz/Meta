package LogAnalysis;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LogAnalysis2 {
	LogVo2 logVo;
	Map<String, LogVo2> map = new HashMap<String, LogVo2>();
	HashSet<String> hashStart = new HashSet<String>();
	HashSet<String> hashE = new HashSet<String>();
	int cnt;
	int cnt1;
	String value = "";

	public void log_analysis() throws IOException, ParseException {
		File file = new File("C:/Users/Hoonz/Desktop/test.log");
		BufferedReader br = new BufferedReader(new FileReader(file));

		while ((value = br.readLine()) != null) {

			String[] str = value.split(",");
			
			for(int i = 0 ; i<str.length;i++) {//공백 제거
				str[i] = str[i].trim();
			}
			
			String start = str[0].substring(0, 14);
			long runtime = parseDate(str[0], str[1]);
			long size = Long.parseLong(str[3]);
			boolean flag = map.containsKey(start);
			
			if (flag) {
				LogVo2 lv2 = map.get(start);
				lv2.setSumTime((lv2.getSumTime()) + runtime); // 시간 합계
				lv2.setProcess(lv2.getProcess()+1); // 처리건수
				lv2.setAvgTime(lv2.getSumTime()/lv2.getProcess()); // 시간 평균
				lv2.setSumSize(lv2.getSumSize()+size); // 사이즈합계
				lv2.setAvgSize(lv2.getSumSize()/lv2.getProcess()); //사이즈 평균
				if (lv2.getMinTime() > runtime) {
					lv2.setMinTime(runtime); //최소 시간
				}if (lv2.getMaxTime()< runtime)  {
					lv2.setMaxTime(runtime); //최대 시간
				}
				if (lv2.getMinSize() > size) {
					lv2.setMinSize(size);
				}if (lv2.getMaxSize()< size) {
					lv2.setMaxSize(size);
				}
				
			} else {
				LogVo2 lv = new LogVo2();

				lv.setTime(start); 
				lv.setProcess(1);
				lv.setMaxSize(size);
				lv.setMinSize(size);
				lv.setMaxTime(runtime);
				lv.setMinTime(runtime);

				map.put(start, lv);
			}
		}

	}

	public long parseDate(String start, String end) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yy.MM.dd hh:mm:ss");
		Date startDate = sdf.parse(start);
		Date endDate = sdf.parse(end);
		long runtime = endDate.getTime() - startDate.getTime();
		return runtime;
	}

	public String test() {
		ArrayList<LogVo2> list = new ArrayList<LogVo2>(map.values());
		StringBuffer buffer = new StringBuffer();
		Collections.sort(list);
		for (LogVo2 vo : list) {
			buffer.append(vo.toString() + "\n");
		}
		return buffer.toString();
	}

	public void writer(String result) throws IOException { // 로그분석후에 파일로저장
		File file1 = new File("C:/Users/Hoonz/Desktop/test2.log");
		BufferedWriter bw = new BufferedWriter(new FileWriter(file1));
		bw.write(result);

		bw.close();

	}

}
