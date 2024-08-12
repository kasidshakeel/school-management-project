import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
import java.sql.*;
import java.util.Vector;
import javax.swing.table.*;

public class checkstaff extends JFrame {
	JTextField t1, t2;
	JButton btn1, btn2;
	JPanel p1, p2;
	Container c;
	JTable tb;
	DefaultTableModel md1;
	Vector<String> row, col;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	void LoadRecord() {
		try {
			String s = "select * from staff";
			ps = con.prepareStatement(s);
			rs = ps.executeQuery();
			int x = tb.getRowCount();
			for (int i = 0; i < x; i++) {
				md1.removeRow(0);
			}
			while (rs.next()) {
				row = new Vector<String>();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
				row.add(rs.getString(4));
				md1.addRow(row);

			}
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}

	void inittable() {
		col = new Vector<String>();
		col.add("ID");
		col.add("First Name");
		col.add("Last Name");
		col.add("Gender");
		row = new Vector<String>();
		md1 = new DefaultTableModel(col, 0);
		tb = new JTable(md1);
		tb.setAutoCreateColumnsFromModel(true);
		tb.setPreferredScrollableViewportSize(new Dimension(400, 360));
		p1.add(new JScrollPane(tb));
		// p1.setBorder(BorderFactory.createTitledBorder("List of Staffs"));
	}

	public checkstaff() {
		c = getContentPane();
		c.setBackground(Color.white);
		c.setLayout(null);
		p2 = new JPanel();
		p2.setBackground(Color.white);
		p2.setSize(480, 60);
		p2.setLayout(null);
		c.add(p2);
		t1 = new JTextField();
		t1.setBounds(25, 20, 60, 30);
		p2.add(t1);
		t2 = new JTextField();
		t2.setBounds(90, 20, 240, 30);
		p2.add(t2);
		btn1 = new JButton("search");
		btn1.setBackground(Color.black);
		btn1.setForeground(Color.white);
		btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn1.setFocusable(true);
		btn1.setBounds(340, 20, 80, 30);
		p2.add(btn1);
		p1 = new JPanel();
		p1.setBackground(Color.white);
		p1.setBounds(5, 65, 440, 470);
		inittable();
		btn2 = new JButton("View");
		btn2.setBackground(Color.black);
		btn2.setForeground(Color.white);
		btn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn2.setFocusable(true);
		btn2.setBounds(200, 25, 60, 30);
		p1.add(btn2);
		JButton btn3 = new JButton("Edit");
		btn3.setBackground(Color.black);
		btn3.setForeground(Color.white);
		btn3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn3.setFocusable(true);
		btn3.setBounds(260, 25, 60, 30);
		p1.add(btn3);

		c.add(p1);
		setSize(450, 530);
		setTitle("School Management");
		ImageIcon icon = new ImageIcon("images\\logo.png");
		setIconImage(icon.getImage());
		setResizable(false);
		setLocationRelativeTo(p1);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent we) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement", "root", "12345");

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}

			public void windowClosing(WindowEvent we) {
				try {
					con.close();
				} catch (Exception ex) {
				}
			}
		});

		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					String staffId = t1.getText();
					String staffName = t2.getText();

					if (!staffId.equals("") || !staffName.equals("")) {
						int count = tb.getRowCount();
						for (int i = 0; i < count; i++) {
							md1.removeRow(0);
						}

						if (!staffId.equals("") && !staffName.equals("")) {
							ps = con.prepareStatement("select * from staff where id like '" + t1.getText()
									+ "%' and fname like '" + t2.getText() + "%'");
						} else if (!staffId.equals("")) {
							ps = con.prepareStatement("select * from staff where id like '" + t1.getText() + "%'");

						} else if (!staffName.equals("")) {
							ps = con.prepareStatement("select * from staff where fname like '" + t2.getText() + "%'");

						}

						rs = ps.executeQuery();
						while (rs.next()) {
							row = new Vector<String>();
							row.add(rs.getString(1));
							row.add(rs.getString(2));
							row.add(rs.getString(3));
							row.add(rs.getString(4));

							md1.addRow(row);
						}
						rs.close();
					} else {
						JOptionPane.showMessageDialog(null, "Please Search ID or Name");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});

		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ea) {

				if (tb.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Please select item to View");
				} else {
					viewform1 vf1 = new viewform1();
					int ind = tb.getSelectedRow();
					String id = md1.getValueAt(ind, 0).toString();
					vf1.setVisible(true);
					vf1.r4.setText(id);

				}
			}
		});
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ea) {

				if (tb.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Please select Staff to Edit");
				} else {
					teaform vf = new teaform();
					int ind = tb.getSelectedRow();
					String id = md1.getValueAt(ind, 0).toString();
					vf.t1.setText(id);
					vf.t1.disable();
					dispose();

				}
			}
		});

		setVisible(true);
	}
}