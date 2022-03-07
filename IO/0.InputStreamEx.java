package ch13;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamEx {
	//IO는 사실 좀 어렵습니다. 클래스가 정말 많아요.
	//그래도 잘 만든 예제를 사용만 하면 됩니다.
	
	public static void main(String[] args) {
		InputStream is = System.in; /*키보드*/
		//키보드와 자바 파일을 InputStream으로 연결.
		while(true) {
			try {
				int i = is.read();
				//내부적인 쓰레드가 대기 상태. 키보드 입력을 받아야 계속 실행된다.
				if(i==-1) break; 
				System.out.print((char)i);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//한글은 짤린다. InputStream은 1바이트인데, 한글은 2바이트기 때문에.

		}
	}
}


//키보드로 입력한 값