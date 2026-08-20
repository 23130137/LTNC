package bai27;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import bai19.Student;
import bai19.StudentManagement;
import bai19.Subject;

public class ScorePanel extends JPanel {
	JPanel pnTop, pnMid;
	
	JTextArea area;
	JScrollPane scroll;
	
	JLabel lblID, lblName, lblSuject, lblScore;

	JTextField txtID, txtName, txtScore;
	
	JComboBox<String> cbSubject;
	String[] subjects;

	JButton btnAdd, btnFind;

	StudentManagement model;
	Student currentStudent;

	public ScorePanel(StudentManagement model) {
		this.model = model;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		pnTop = new TopPanel();

		pnMid = new MidPanel();

		area = new JTextArea(10, 3);
		area.setText(fomatString("STT", "Tên môn học", "Điểm"));
		scroll = new JScrollPane(area);

		add(pnTop);
		add(pnMid);
		add(scroll);

	}

	public String fomatString(String stt, String name, String score) {
		while (stt.length() < 20) {
			stt += " ";
		}
		while (name.length() < 80) {
			name += " ";
		}
		while (score.length() < 10) {
			score += " ";
		}

		return stt + name + score + "\n";
	}

	class TopPanel extends JPanel {
		TopPanel() {
			Border b = BorderFactory.createLineBorder(Color.BLUE);
			setBorder(BorderFactory.createTitledBorder(b, "Them Mon hoc"));

			setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

			lblID = new JLabel("MSSV");
			txtID = new JTextField();
			txtID.setPreferredSize(new Dimension(200, 30));

			panel.add(lblID);
			panel.add(txtID);

			panel.setPreferredSize(new Dimension(400, 40));

			add(panel);
///////////////////////////////////////////////////////////
			panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

			lblName = new JLabel("Họ và Tên");
			txtName = new JTextField();
			txtName.setPreferredSize(new Dimension(200, 30));
			txtName.setEditable(false);

			panel.add(lblName);
			panel.add(txtName);
			panel.setPreferredSize(new Dimension(400, 40));
			add(panel);
//////////////////////////////////////////////////////////
			panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

			lblSuject = new JLabel("Môn học");

			subjects = new String[] { "1111 Lập trình nâng cao", "2222 Lý thuyết đồ thị", "3333 Lập trình cơ bản",
					"9999 Thiết kế Hướng đối tượng" };

			cbSubject = new JComboBox<String>(subjects);
			cbSubject.setPreferredSize(new Dimension(200, 30));

			panel.add(lblSuject);
			panel.add(cbSubject);
			panel.setPreferredSize(new Dimension(400, 40));
			add(panel);

			////////////////////////////////
			panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

			lblScore = new JLabel("Điểm");
			txtScore = new JTextField();
			txtScore.setPreferredSize(new Dimension(200, 30));

			panel.add(lblScore);
			panel.add(txtScore);
			panel.setPreferredSize(new Dimension(400, 40));
			add(panel);

		}
	}

	class MidPanel extends JPanel {
		MidPanel() {
			btnAdd = new JButton("Thêm Điểm");
			btnAdd.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (currentStudent == null) {
						JOptionPane.showConfirmDialog(null, "Vui lòng tìm sinh viên trước khi thêm điểm", "Cảnh báo",
								JOptionPane.WARNING_MESSAGE);
					} else {
						String subID = cbSubject.getSelectedItem().toString().split(" ")[0];
						Subject sub = currentStudent.findSubjectByID(subID);

						if (sub == null) {
							JOptionPane.showConfirmDialog(null, "Môn học không tồn tại, không thể thêm điểm",
									"Cảnh báo", JOptionPane.WARNING_MESSAGE);
						}

						else {
							sub.setScore(Double.parseDouble(txtScore.getText().trim()));

							area.setText(fomatString("STT", "Tên môn học", "Điểm"));

							for (int i = 0; i < currentStudent.getListOfSubject().size(); i++) {
								String subName = currentStudent.getListOfSubject().get(i).getName();
								double subScore = currentStudent.getListOfSubject().get(i).getScore();

								area.append(fomatString(i + 1 + "", subName, subScore + ""));
							}
						}
					}

				}
			});
			add(btnAdd);

			////////////////////////////
			btnFind = new JButton("Tìm sinh viên");
			btnFind.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					String stuID = txtID.getText().trim();

					currentStudent = model.findStudentByID(stuID);

					if (currentStudent == null) {
						JOptionPane.showConfirmDialog(null, "MSSV không tồn tại", "Cảnh báo",
								JOptionPane.WARNING_MESSAGE);
					} else {
						txtName.setText(currentStudent.getName());
							
						
						area.setText(fomatString("STT", "Tên môn học", "Điểm"));
						
						for (int i = 0; i < currentStudent.getListOfSubject().size(); i++) {
							String subName = currentStudent.getListOfSubject().get(i).getName();
							double subScore = currentStudent.getListOfSubject().get(i).getScore();

							area.append(fomatString(i + 1 + "", subName, subScore + ""));
						}
					}
				}
			});
			add(btnFind);

			Border b = BorderFactory.createLineBorder(Color.BLUE);
			setBorder(BorderFactory.createTitledBorder(b, "Thao tác"));
		}
	}

}
