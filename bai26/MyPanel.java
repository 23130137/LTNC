package bai26;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

public class MyPanel extends JPanel {
	JPanel pnInfo, pnChosen, pnOperation, pnResult;
	JLabel lblName, lblAddress, lblPhone, lblResult;
	JTextField txtName, txtAddress, txtPhone;
	JCheckBox chkBTT, chkTSTC, chkKTCB, chkTSTM;
	JButton btnOrder, btnExit, btnDelete, btnPay;
	
	JTable table;
	String[] header;
	DefaultTableModel model;
	JScrollPane scroll;

	int stt;

	MyPanel() {
		stt = 1;

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		pnInfo = new InfoPanel();
		pnChosen = new ChosenPanel();
		pnOperation = new OperationPanel();

		header = new String[] { "STT", "Ten San Pham", "Don Gia" };
		model = new DefaultTableModel(header, 0);
		table = new JTable(model);
		scroll = new JScrollPane(table);
		scroll.setEnabled(false);

		pnResult = new ResultPanel();

		add(pnInfo);
		add(pnChosen);
		add(pnOperation);
		add(scroll);
		add(pnResult);

	}

	class InfoPanel extends JPanel {
		InfoPanel() {
			setLayout(new GridLayout(3, 2, 5, 5));
			lblName = new JLabel("Ho va Ten");
			lblAddress = new JLabel("Dia chi");
			lblPhone = new JLabel("So dien thoai");

			txtName = new JTextField(30);
			txtAddress = new JTextField(100);
			txtPhone = new JTextField(10);

			add(lblName);
			add(txtName);

			add(lblAddress);
			add(txtAddress);

			add(lblPhone);
			add(txtPhone);

			Border b = BorderFactory.createLineBorder(Color.BLUE);
			setBorder(BorderFactory.createTitledBorder(b, "Thong Tin Khach Hang"));
		}
	}

	class ChosenPanel extends JPanel {
		ChosenPanel() {
			setLayout(new GridLayout(2, 2, 5, 5));
			chkBTT = new JCheckBox("Banh Trang Tron(15000)");

			chkTSTC = new JCheckBox("Tra sua tran chau(20000)");

			chkKTCB = new JCheckBox("Khoai tay chien bo(5000)");

			chkTSTM = new JCheckBox("Tra sua thach matcha(30000)");

			add(chkBTT);
			add(chkTSTC);
			add(chkKTCB);
			add(chkTSTM);

			Border b = BorderFactory.createLineBorder(Color.BLUE);
			setBorder(BorderFactory.createTitledBorder(b, "Chon San pham"));
		}

	}

	class OperationPanel extends JPanel {
		OperationPanel() {
			btnOrder = new JButton("Dat Hang");
			btnOrder.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (chkBTT.isSelected()) {
						model.addRow(new Object[] { stt++, "Banh trang tron", 15000 });
					}
					if (chkTSTC.isSelected()) {
						model.addRow(new Object[] { stt++, "Tra sua tran chau", 20000 });
					}
					if (chkTSTM.isSelected()) {
						model.addRow(new Object[] { stt++, "Tra sua thach matcha", 30000 });
					}
					if (chkKTCB.isSelected()) {
						model.addRow(new Object[] { stt++, "Khoai tay chien bo", 5000 });
					}
				}
			});

			btnExit = new JButton("Thoat");
			btnExit.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int choice = JOptionPane.showConfirmDialog(null, "Ban muon thoat", "Xac nhan",
							JOptionPane.YES_NO_OPTION);

					if (choice == JOptionPane.YES_OPTION)
						System.exit(0);

				}
			});

			btnDelete = new JButton("Xoa SP");
			btnDelete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int selectedRow = table.getSelectedRow();

					if (selectedRow >= 0) {
						model.removeRow(selectedRow);
						for (int i = 0; i < model.getRowCount(); i++) {
							model.setValueAt(i + 1, i, 0);
						}
						stt = model.getRowCount() + 1;
					}

				}
			});

			btnPay = new JButton("Thanh Toan");
			btnPay.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int total = 0;
					for (int i = 0; i < model.getRowCount(); i++) {
						total += (Integer) model.getValueAt(i, model.getColumnCount() - 1);
					}
					String txt = "Ten Khach hang: " + txtName.getText() + "         " + 
							"Dia chi: " + txtAddress.getText()+ "          " + 
							"SDT: " + txtPhone.getText() + "           " + 
							"Tong tien: " + total;
					lblResult.setText(txt);
					
					txtName.setEditable(false);
					txtAddress.setEditable(false);
					txtPhone.setEditable(false);
					
					chkBTT.setEnabled(false);
					chkKTCB.setEnabled(false);
					chkTSTC.setEnabled(false);
					chkTSTM.setEnabled(false);
					
					btnDelete.setEnabled(false);
					btnOrder.setEnabled(false);
					btnPay.setEnabled(false);

				}
			});

			add(btnOrder);
			add(btnExit);
			add(btnDelete);
			add(btnPay);

			Border b = BorderFactory.createLineBorder(Color.BLUE);
			setBorder(BorderFactory.createTitledBorder(b, "Thao tac dat hang"));
		}
	}

	class ResultPanel extends JPanel {
		ResultPanel() {
			setLayout(new FlowLayout(FlowLayout.LEFT));
			lblResult = new JLabel("0.0");
			add(lblResult);

			Border b = BorderFactory.createLineBorder(Color.BLUE);
			setBorder(BorderFactory.createTitledBorder(b, "Thao tac dat hang"));
		}
	}
}
