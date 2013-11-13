package ygz.jinsui.yys;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class YysServiceSelfDebugger implements YysServiceDebugger {
	
	private String flag;
	
	private void resetFlag() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-hhmmss");
		String date = sdf.format(new Date());
		flag = date;
	}
	
	public void outRequest(String id, String str1, String str2) {
		resetFlag();
		try {
			File newFile = new File("e:/temp/log/yys/" + flag + "-" + id + ".txt");			 
			FileWriter write = new FileWriter(newFile,true);
			BufferedWriter bufferedWriter = new BufferedWriter(write);
			bufferedWriter.write("------------------ request ----------------------");
			bufferedWriter.newLine();
			bufferedWriter.write(YysServiceUtils.formatXML(str1));
			bufferedWriter.newLine();
			bufferedWriter.newLine();
			bufferedWriter.write("-------------------------------------------------");
			bufferedWriter.newLine();
			bufferedWriter.write(str2);
			bufferedWriter.newLine();
			bufferedWriter.newLine();
			bufferedWriter.flush();
			write.close();
			bufferedWriter.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
		
	public void outResponse(String id, String str1, String str2) {
		try {

			File newFile = new File("e:/temp/log/yys/" + flag + "-" + id + ".txt");			 
			FileWriter write = new FileWriter(newFile,true);
			BufferedWriter bufferedWriter = new BufferedWriter(write);
			bufferedWriter.write("------------------ response ---------------------");
			bufferedWriter.newLine();
			bufferedWriter.write(str1);
			bufferedWriter.newLine();
			bufferedWriter.newLine();
			bufferedWriter.write("-------------------------------------------------");
			bufferedWriter.newLine();
			bufferedWriter.write(YysServiceUtils.formatXML(str2));
			bufferedWriter.flush();
			write.close();
			bufferedWriter.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
