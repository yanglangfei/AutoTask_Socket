package com.jc.ui;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.WindowConstants;

public class MyUi extends JFrame{
	private static final long serialVersionUID = -1513207114652328568L;
	public MyUi() {
		//  FlowLayout   ��ʽ����  ��˳������ �ռ䲻��ʱ����
		//  BorderLayout  ���� �� �� �� �� ����
		//  GridLayout   ������������   ��������
		//  JTable       ��񲼾�  ��������
		//  GridBagLayout ���Ӳ���
		this.getContentPane().setLayout(null);
		//JTable table=new JTable(5, 5);
		/*JButton button=new JButton();
		button.setText("hello");
		button.setBounds(0, 0, 100, 50);
		JButton button2=new JButton();
		button2.setText("hello1");
		button2.setBounds(0, 50, 100, 50);
		this.add(button);
		this.add(button2);*/
		JList<String> list=new JList<>();
		list.setBounds(0, 0, 500, 500);
	    String []arrays=new String[20];
		for(int i=0;i<10;i++){
			arrays[i]="hello"+i;
		}
		
		list.setListData(arrays);
		this.add(list);
		setVisible(true);
		this.setSize(500, 500);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//����JFrame ״̬  ���/��С��
	//	this.setState(NORMAL);
	}
	
	public static void main(String[] args) {
		MyUi ui=new MyUi();
	}
	
	
	/**
	 * @param str
	 * @return   JLabel �ؼ�
	 */
	public JLabel getLabel(String str){
		JLabel label=new JLabel(str);
		label.setBounds(0, 0, 100, 50);
		return label;
	}
	
	

}
