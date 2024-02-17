package bi240clean;

/*
 * @Author Jacob Elbirt 
 * Simple line-by-line output test for data cleaning/org script written for
 * WSU Human Performance and Assisted Learning Lab (HPALL)
 * Fall 2023
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestReadFile {
	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("FILENAME.txt");
		Scanner sc = new Scanner(file);
		while (sc.hasNext()) {
			System.out.println(sc.next());
		}
	}
}
