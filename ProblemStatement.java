package com.test.trp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class ProblemStatement {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader br = new BufferedReader (new FileReader("C:\\Input\\input.txt"));
		
		
		File ouputFile =  new File("C:\\Input\\output.txt");
		
		Map<String,Integer> mapRanger = new HashMap<String,Integer>();
		
		int totalcount = Integer.parseInt(br.readLine());
		if(totalcount >= 1 && totalcount <= 5000){
		String wordS= br.readLine();
		int count = 0;
		boolean checkpt = true;
		while(count< totalcount){
			//condition check for string and number
			if(wordS.trim().length()<1 || wordS.trim().length() >=100 ){
				System.out.println("Word are not in speciifed range");
				checkpt = false;
				break;
			}
			mapRanger.put(wordS.toLowerCase().trim(), count);
			wordS = br.readLine();
			count++;
			
		}
		br.close();
		if(checkpt){
			if(!ouputFile.exists()){
				ouputFile.createNewFile();
			}
			FileWriter writeContent = new FileWriter (ouputFile);
		TreeMap<String,Integer> treMap = new TreeMap<String,Integer>(mapRanger);
		for (Map.Entry<String, Integer> entry:treMap.entrySet()){
			if(!entry.getKey().isEmpty()){
			System.out.println(entry.getKey());
			writeContent.write(entry.getKey());		
			writeContent.write("\r\n");
			}
		}
		writeContent.flush();
		writeContent.close();
		}
		
	}else{
		System.out.println("Value entered is not defined!! should be between 1 and 5000");
	}
		
	}

	
}
