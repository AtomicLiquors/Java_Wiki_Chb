package ch08;

import java.awt.Button;
import java.awt.FileDialog;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//파일 열기, 파일 저장 메뉴를 출력해 보자.
public class FileDialogEx extends MFrame implements ActionListener {
	
	FileDialog open, save;
	Button oBtn, sBtn;
	
	public FileDialogEx() {
		setTitle("FileDialog 예제");
		open = new FileDialog(this, "파일 열기", FileDialog.LOAD);
		save = new FileDialog(this, "파일 저장", FileDialog.SAVE);
		Panel p = new Panel();
		p.add(oBtn = new Button("파일 열기"));
		p.add(sBtn = new Button("파일 저장"));
		oBtn.addActionListener(this);
		sBtn.addActionListener(this);
		add(p);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==oBtn)
			open.setVisible(true);
		else if(e.getSource()==sBtn)
			save.setVisible(true);
	}

	public static void main(String[] args) {
		new FileDialogEx();
	}

}
