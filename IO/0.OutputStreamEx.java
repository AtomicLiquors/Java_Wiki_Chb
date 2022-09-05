package ch13;

import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamEx {

	public static void main(String[] args) {
		int i = 'A';
		System.out.println(i);
		char c = 'b';
		char c1 = '한'; //출력하면 한글은 깨질 것이다.
		try {
			OutputStream os = System.out;
			//out은 콘솔창에 해당한다.
			os.write(i);
			os.write(c);
			os.write(c1);
			//write... print... "같은 겁니다."
			
			os.flush();
			//스트림에 남아있는 데이터를 비워주세요.
			os.close();
			//사용하지 않는 스트림은 반드시 닫아줍니다.
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}

}
