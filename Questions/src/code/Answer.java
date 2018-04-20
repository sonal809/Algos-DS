package code;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * This is the file with your answer, do not rename or move it.
 * Write your code in it, and save it before submitting your answer.
 */

/**
 * This class is a container for your answer,
 * and its declaration must be kept unmodified.
 */
public class Answer {
   
	
	
	
	/**
     * Returns an array of IP addresses that are deemed suspicious.
     *
     * This method declaration must be kept unmodified.
     *
     * @param logPath The full path of a log file.
     * @return An array of IP addresses.
     */
    public static String[] findSuspiciousIps(String logPath) {
        Map<String, List<java.util.Date>> map = new HashMap<>();
        List<String> suspectList = new ArrayList<String>();
        //String[] suspectList = new String[500];
        File f = new File(logPath);
        BufferedReader br;
		try {
			FileInputStream fstream = new FileInputStream(logPath);
			br = new BufferedReader(new InputStreamReader(fstream));
			String line = br.readLine();
			while(line != null) {
				String logEntry = line;
			//	System.out.println(logEntry);
				processLog(logEntry, map);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        for (String ip: map.keySet()) {
            List<java.util.Date> eachIPDate = map.get(ip);
            if (issuspiciousIP(eachIPDate)) {
                suspectList.add(ip);
            }
        }
        return suspectList.toArray(new String[suspectList.size()]);
    }

    private static void processLog(String logEntry, Map<String, List<java.util.Date>> map) {
        String[] splits = logEntry.split("\\s+");
        String ip = splits[0];
        java.util.Date date = processDate(splits[3]+" "+splits[4]);
        String url = splits[6];
        int errCode = Integer.parseInt(splits[8]);
        
        if ((errCode >= 400 && errCode < 500) && url.startsWith("/account/information")) {
            if (!map.containsKey(ip)) {
                List<java.util.Date> dateList = new ArrayList<>();
                dateList.add(date);
                map.put(ip, dateList);
            } else {
                map.get(ip).add(date);
            }
        }
        
    }

    private static Date processDate(String date) {
        Date pdate = null;
        try { 
            pdate = new SimpleDateFormat("[dd/MMM/yyyy:hh:mm:ss:S Z]").parse(date);
        } catch (Exception e) {
            System.out.println("Error in parsing date");
        }
        return pdate;
    }

    private static boolean issuspiciousIP(List<java.util.Date> eachIPDate) {
        int suspectCount =0;
        if (eachIPDate.size() < 3) {
            return false;
        }
        for (int i =0; i < eachIPDate.size() -2; i++) {
            if(suspectCount >= 3) {
                return true;
            }
            if ((eachIPDate.get(i+2).getTime() - eachIPDate.get(i).getTime()) <= 1000L) {
                suspectCount +=3;
            }
        }
        if(suspectCount >= 3) {
            return true;
        } else {
            return false;
        }
    }
    class LogSort implements Comparator<String> {

		@Override
		public int compare(String arg0, String arg1) {
			// TODO Auto-generated method stub
			//Character.isL
			return 0;
		}
    	
    }
    /**
     * Tests the method with the examples given in the question. 
     * This test code is provided only for your convenience.
     */
    public static void main(String[] args) {
        System.out.println("example.log:");
        for (String ip : findSuspiciousIps("/Users/sonaggarwal/workspace/Practice/Questions/src/code/example.log"))
        {
            System.out.println(ip);
        }
        System.out.println("bank_logs.log:");
      //  for (String ip : findSuspiciousIps("bank_logs.log"))
        {
        //    System.out.println(ip);
        }
    }
}
