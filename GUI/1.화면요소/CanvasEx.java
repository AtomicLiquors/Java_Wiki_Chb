package ch08;

import java.awt.Canvas;
import java.awt.Color;

public class CanvasEx extends MFrame {
	
	Canvas c;
	
	public CanvasEx() {
		c = new Canvas();
		c.setSize(100, 100);
		c.setBackground(Color.RED);
		add(c);
	}
	
	public static void main(String[] args) {
		new CanvasEx();
	}
	
	//��ũ�ѹٴ� �ʹ� �����ؼ� Swing���� �սô�.

}
