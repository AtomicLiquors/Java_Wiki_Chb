import java.awt.Color;
import java.awt.Frame;

public class MyFrame extends Frame{
	
	public MyFrame() {
		setSize(400, 300);
		setBackground(Color.orange);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new MyFrame();
	}
	
}