package bai27;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import bai19.StudentManagement;

public class SubjectPanel extends JPanel {
	MyFrame frame;

	public SubjectPanel(MyFrame myFrame, StudentManagement model) {
		setLayout(new BorderLayout());
		this.frame = myFrame;
		JLabel lbl = new JLabel("QUẢN LÝ MÔN HỌC", SwingConstants.CENTER);
		add(lbl, BorderLayout.CENTER);

		JButton btn = new JButton("Back");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.showCard(frame.card, frame.HOME);

			}
		});

		add(btn);

	}

}
