package ch13;

import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamEx {

	public static void main(String[] args) {
		int i = 'A';
		System.out.println(i);
		char c = 'b';
		char c1 = '��'; //����ϸ� �ѱ��� ���� ���̴�.
		try {
			OutputStream os = System.out;
			//out�� �ܼ�â�� �ش��Ѵ�.
			os.write(i);
			os.write(c);
			os.write(c1);
			//write... print... "���� �̴ϴ�."
			
			os.flush();
			//��Ʈ���� �����ִ� �����͸� ����ּ���.
			os.close();
			//������� �ʴ� ��Ʈ���� �ݵ�� �ݾ��ݴϴ�.
			
		} catch (IOException e) {
			e.printStackTrace();
		}
				
	}

}
