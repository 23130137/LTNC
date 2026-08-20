package bai27;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import bai19.StudentManagement;
import bai26.MyPanel;

public class MyFrame extends JFrame {
	public static final String HOME = "HOME";
	public static final String SUBJECT = "SUBJECT";
	public static final String SCORE = "SCORE";
	
	CardLayout card;
	JPanel myPanel;
	
	StudentManagement model;
	
	MyFrame(){
		setTitle("Khoa Công nghệ Thông tin");
		
		card = new CardLayout();
		myPanel = new JPanel(card);
		
		model = new StudentManagement();
		
		myPanel.add(new HomePanel(), HOME);
		myPanel.add(new SubjectPanel(this, model), SUBJECT);
		myPanel.add( new ScorePanel(model), SCORE);
		
		getContentPane().add(myPanel);
		
		JMenuBar bar = new JMenuBar();
		
		JMenuItem item;
		
		JMenu mnFile = new JMenu("File");
		item = new JMenuItem("Exit");
		item.setMnemonic(KeyEvent.VK_E);
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);				
			}
		});
		mnFile.add(item);
		
		JMenu mnManage = new JMenu("Quản lý sinh viên");
		item = new JMenuItem("Quản lý Môn học");
		item.setMnemonic(KeyEvent.VK_M);
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showCard(card, SUBJECT);
				
			}
		});
		mnManage.add(item);
		
		item = new JMenuItem("Quản lý Điểm");
		item.setMnemonic(KeyEvent.VK_D);
		item.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				showCard(card, SCORE);
				
			}
		});
		mnManage.add(item);
		
		bar.add(mnFile);
		bar.add(mnManage);
		
		setJMenuBar(bar);

//		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void showCard(CardLayout card, String name) {
		card.show(myPanel, name);
	}

	public static void main(String[] args) {
		new MyFrame();
	}
}
