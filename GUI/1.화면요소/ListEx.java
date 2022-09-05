package ch08;

import java.awt.Label;
import java.awt.List;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ListEx extends MFrame implements ItemListener {
	
	List list1, list2;
	Label label1, label2;
	String team1[] ={"롯데","삼성","한화","KIA","NC"};
	String team2[] ={"LG","두산","넥센","SK","KT"};
	
	public ListEx() {
		setTitle("List 예제");
		list1 = new List(3, false); //단일선택
		list2 = new List(4, true); //다중선택
		for (int i = 0; i < team1.length; i++) {
			list1.add(team1[i]);
			list2.add(team2[i]);
		}
		list1.addItemListener(this);
		list2.addItemListener(this);
		add(list1);
		add(list2);
		add(label1 = new Label("team1:                      "));
		add(label2 = new Label("team2:                    "));
	}
	
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		String str1 = list1.getSelectedItem();
		label1.setText("team1 :" + str1);
		str1 = "";
		
		String str2[] = list2.getSelectedItems();
		for (int i = 0; i < str2.length; i++) {
			str1+=str2[i] + " ";
		}
		label2.setText("team2 : " + str1);
		
	}

	
	public static void main(String[] args) {
		new ListEx();
	}

}
