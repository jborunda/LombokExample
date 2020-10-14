package Lombok.examples.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import lombok.Cleanup;
import lombok.SneakyThrows;


public class LombokAnnotations {

	public static void main(String[] args) {
		String filePath = "C:/est/text.txt";

		read(filePath);
		
	}

	@SneakyThrows()
	public static void read(String filePath) {
		@Cleanup
		BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
		
		
		String line = null;
		while ((line = br.readLine()) != null) {
			System.out.println(line);
		}
	}

	public static void readWithOutLombok(String filePath) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(new File(filePath)));
		String line = null;

		try {
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			br.close();
		}

	}

}
