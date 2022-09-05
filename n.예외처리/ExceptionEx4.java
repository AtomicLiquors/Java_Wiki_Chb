package ch03_1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionEx4 {

	public static void main(String[] args) throws FileNotFoundException {
		try {
			FileReader fr = 
					//FilenotFoundException 발생 가능성 있는 메소드.
					new FileReader("ch03_1/test.txt");
			int i;
			while((i=fr.read())!=-1) {
			System.out.print((char)i);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}//... 값이 없으면 -1이 됩니다.
