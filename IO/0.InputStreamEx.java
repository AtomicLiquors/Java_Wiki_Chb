package ch13;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamEx {
	//IO�� ��� �� ��ƽ��ϴ�. Ŭ������ ���� ���ƿ�.
	//�׷��� �� ���� ������ ��븸 �ϸ� �˴ϴ�.
	
	public static void main(String[] args) {
		InputStream is = System.in; /*Ű����*/
		//Ű����� �ڹ� ������ InputStream���� ����.
		while(true) {
			try {
				int i = is.read();
				//�������� �����尡 ��� ����. Ű���� �Է��� �޾ƾ� ��� ����ȴ�.
				if(i==-1) break; 
				System.out.print((char)i);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			//�ѱ��� ©����. InputStream�� 1����Ʈ�ε�, �ѱ��� 2����Ʈ�� ������.

		}
	}
}


//Ű����� �Է��� ��