package bai27;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class HomePanel extends JPanel {
	public HomePanel() {
		setLayout(new BorderLayout());
		
		JLabel lbl = new JLabel("QUẢN LÝ SINH VIÊN K.CNTT", SwingConstants.CENTER);
		add(lbl, BorderLayout.CENTER);
	}
}
