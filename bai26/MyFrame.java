package bai26;

import javax.swing.JFrame;

public class MyFrame extends JFrame {
	MyFrame() {
		setTitle("Painting");

		getContentPane().add(new MyPanel());

		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
//		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new MyFrame();
	}
}
