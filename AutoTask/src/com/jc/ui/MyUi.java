package com.jc.ui;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MyUi extends JFrame{
	private static final long serialVersionUID = -1513207114652328568L;
	public MyUi() {
		//1��  FlowLayout   ��ʽ����  ��˳������ �ռ䲻��ʱ����
		//2��  BorderLayout  ���� �� �� �� �� ����
		//3��  GridLayout   ������������   ��������
		//4��  JTable       ��񲼾�  ��������
		//5��  GridBagLayout ���Ӳ���
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
		final JList<String> list=new JList<>();
		list.setBounds(0, 0, 500, 500);
		//����ѡ�еı�����ɫ
		list.setSelectionBackground(Color.BLUE);
	    String []arrays=new String[10];
	    String [][]array={{""},{""}};
		for(int i=0;i<10;i++){
			arrays[i]="hello"+i;
		}
		
		//����List ����
		list.setListData(arrays);
		//��JList ���ѡ���¼�
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
			     System.out.println("e:"+list.getSelectedIndex());
			}
		});
		
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
	
	
	/**
	 * @return  JPasswordField
	 */
	public JPasswordField getPasswordFild(){
		JPasswordField passwordField=new JPasswordField(23);
		passwordField.setBounds(0, 0, 50, 100);
		return passwordField;
	}
	
	/**
	 * @return  JTextField
	 */
	public JTextField getTextField(){
		JTextField textField=new JTextField(23);
		textField.setBounds(0, 0, 50, 100);
		return textField;
	}
	
	
	/**
	 * @param datas
	 * @return  JList
	 */
	public JList<String>  getList(String [] datas){
		JList<String> list=new JList<String>();
		list.setBounds(0, 0, 500, 500);
		list.setListData(datas);
		return list;
	}
	
	/**
	 * @param text
	 * @return  JCheckBox
	 */
	public JCheckBox getCheckBox(String text){
		JCheckBox checkBox=new JCheckBox();
		checkBox.setText(text);
		return checkBox;
	}
	
	/**
	 * @return  JMenu
	 */
	public JMenu getMenu(){
		JMenu menu=new JMenu();
		JMenuItem item=new JMenuItem("��");
		menu.add(item);
		return menu;
	}
	
	
	/**
	 * @return JButton
	 */
	public JButton getButton(){
		JButton button=new JButton();
		button.setText("button");
		button.setBounds(0, 0, 50, 100);
		return button;
	}
	
	/**
	 * @return JTextArea
	 */
	public JTextArea getTextArea(){
		JTextArea area=new JTextArea();
		area.setBounds(0, 0, 500, 100);
		return area;
	}
	
	/**
	 * @return  JPanel
	 */
	public JPanel getPanel(){
		JPanel panel=new JPanel();
		return panel;
	}
	
	/**
	 * @return  JRadioButton
	 */
	public JRadioButton getRadioButton(){
		JRadioButton radioButton=new JRadioButton();
		radioButton.setText("button");
		radioButton.setBounds(0, 0, 20, 20);
		return radioButton;
	}
	
	/**
	 * @return  JSpinner
	 */
	public JSpinner getSpinner(){
		JSpinner spinner=new JSpinner();
		spinner.setBounds(0, 0, 500, 10);
		return spinner;
	}
	

}
