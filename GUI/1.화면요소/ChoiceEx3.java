package ch08;

//디버그하세요.

import java.awt.Choice;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoiceEx3 extends MFrame implements ItemListener {

	Choice gender, star;
	String ms[] = { "현 빈", "원 빈", "이민호", "김수현", "김우빈", "이종석" };
	String fs[] = { "고아라", "이연희", "이하늬", "문채원", "수 지", "김연아" };

	public ChoiceEx3() {
		setTitle("Choice 예제 3");
		gender = new Choice();
		gender.add("남자 연예인");
		gender.add("여자 연예인");

		gender.addItemListener(this);
		star = new Choice();
		
		inputItem(star, ms);
		add(gender);
		add(star);
	}

	public void inputItem(Choice c, String item[]) {
		//여기 지웠던 코드를 다시 넣어야 할듯.
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// itmeStateChanged: 아이템의 상태가 변경되었을 때
				// 성별을 바꾸면 이 항목이 실행된다.
				if (gender.getSelectedItem().equals("남자연예인")) {
					inputItem(star, ms);
				} else {
					inputItem(star, fs);
				}
	}

	public static void main(String[] args) {
		new ChoiceEx3();
	}

}
