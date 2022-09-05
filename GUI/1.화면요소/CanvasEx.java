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
	
	//스크롤바는 너무 불편해서 Swing에서 합시다.

}
