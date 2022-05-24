package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class NoGarbage {
	public static void main(String[] args) {
		String filename = "test.txt";
		byte[] inputBytes = { 0 };
		long startTime, endTime;
		
		try {
			inputBytes = Files.readAllBytes(Paths.get(filename));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		startTime = System.currentTimeMillis();
		StringBuilder outputStringBuilder = new StringBuilder();
		for (byte b : inputBytes) {
			outputStringBuilder.append((char)b);
		}
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime); // 1
	}

}
