package ch08;

//������ϼ���.

import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoiceEx3 extends MFrame implements ItemListener {

	Choice gender, star;
	String ms[] = { "�� ��", "�� ��", "�̹�ȣ", "�����", "����", "������" };
	String fs[] = { "��ƶ�", "�̿���", "���ϴ�", "��ä��", "�� ��", "�迬��" };

	public ChoiceEx3() {
		setTitle("Choice ���� 3");
		gender = new Choice();
		gender.add("���� ������");
		gender.add("���� ������");

		gender.addItemListener(this);
		star = new Choice();
		
		inputItem(star, ms);
		add(gender);
		add(star);
	}

	public void inputItem(Choice c, String item[]) {
		//���� ������ �ڵ带 �ٽ� �־�� �ҵ�.
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// itmeStateChanged: �������� ���°� ����Ǿ��� ��
				// ������ �ٲٸ� �� �׸��� ����ȴ�.
				if (gender.getSelectedItem().equals("���ڿ�����")) {
					inputItem(star, ms);
				} else {
					inputItem(star, fs);
				}
	}

	public static void main(String[] args) {
		new ChoiceEx3();
	}

}
