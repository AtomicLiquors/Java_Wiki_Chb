package ch08;

import java.awt.Button;
import java.awt.FileDialog;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//���� ����, ���� ���� �޴��� ����� ����.
public class FileDialogEx extends MFrame implements ActionListener {
	
	FileDialog open, save;
	Button oBtn, sBtn;
	
	public FileDialogEx() {
		setTitle("FileDialog ����");
		open = new FileDialog(this, "���� ����", FileDialog.LOAD);
		save = new FileDialog(this, "���� ����", FileDialog.SAVE);
		Panel p = new Panel();
		p.add(oBtn = new Button("���� ����"));
		p.add(sBtn = new Button("���� ����"));
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
