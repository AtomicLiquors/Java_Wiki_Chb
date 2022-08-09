package ch08;

import java.awt.Color;
import java.util.Random;

public class MColor {
	
	public static Color rColor(){
		Random rd = new Random();
		int r,g,b;
		r = rd.nextInt(256);
		g = rd.nextInt(256);
		b = rd.nextInt(256);
		return new Color(r,g,b);
	}
	
	public static Color[] rColor2(){
		Random rd = new Random();
		int r,g,b;
		r = rd.nextInt(256);//0~255 ³­¼ö
		g = rd.nextInt(256);
		b = rd.nextInt(256);
		Color c[] = new Color[2];
		c[0] = new Color(r,g,b);
		c[1] = new Color(255-r,255-g,255-b);
		return c;
	}
}
