import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
import java.sql.*;
import java.util.Vector;
import java.util.Date.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.swing.table.*;

public class adfee extends JFrame {
	JTextField t2;
	JLabel l1, r1, l2, r2, l3, r3, t1;
	JButton btn1, btn3;
	JPanel p1, p2;
	Container c;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	public adfee() {
		c = getContentPane();
		c.setLayout(null);
		p1 = new JPanel();
		p1.setSize(380, 60);
		p1.setBackground(Color.white);
		p1.setLayout(null);
		c.add(p1);

		t1 = new JLabel("ID");
		Font ft = new Font("Arial", Font.BOLD, 15);
		t1.setBounds(15, 20, 60, 30);
		t1.setFont(ft);
		p1.add(t1);

		t2 = new JTextField();
		t2.setBounds(50, 20, 245, 30);
		p1.add(t2);
		btn1 = new JButton(new ImageIcon("icons/find.png"));
		btn1.setContentAreaFilled(false);
		btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn1.setFocusable(true);
		btn1.setBounds(310, 20, 30, 30);
		p1.add(btn1);

		p2 = new JPanel();
		p2.setBounds(7, 65, 360, 200);
		p2.setBackground(Color.white);
		// p2.setBorder(BorderFactory.createTitledBorder(""));
		p2.setLayout(null);
		c.add(p2);

		l1 = new JLabel("ID :");
		l1.setBounds(25, 20, 60, 30);
		l1.setFont(ft);
		p2.add(l1);
		r1 = new JLabel();
		r1.setBounds(200, 20, 60, 30);
		r1.setForeground(Color.red);
		r1.setFont(ft);
		p2.add(r1);

		l2 = new JLabel("Name :");
		l2.setBounds(25, 65, 60, 30);
		l2.setFont(ft);
		p2.add(l2);
		r2 = new JLabel();
		r2.setFont(ft);
		r2.setBounds(200, 65, 160, 30);
		p2.add(r2);

		l2 = new JLabel("Class :");
		l2.setBounds(25, 108, 60, 30);
		l2.setFont(ft);
		p2.add(l2);
		r3 = new JLabel();
		r3.setFont(ft);
		r3.setBounds(200, 108, 60, 30);
		p2.add(r3);

		btn3 = new JButton("Check");
		btn3.setBounds(250, 150, 80, 40);
		btn3.setBackground(Color.black);
		btn3.setForeground(Color.white);
		btn3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn3.setFocusable(true);
		p2.add(btn3);

		setSize(380, 300);
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
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement","root","12345");

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
					if (!t2.getText().equals("")) {
						ps = con.prepareStatement("select * from student where id like '" + t2.getText() + "%'");

					} else {
						JOptionPane.showMessageDialog(null, "Please Enter Id");
					}

					rs = ps.executeQuery();
					while (rs.next()) {
						r1.setText(rs.getString(1));
						r2.setText(rs.getString(2) + " " + rs.getString(3));
						r3.setText(rs.getString(4));
					}
					t2.setText("");
					rs.close();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());

				}
			}
		});

		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (!r1.getText().equals("")) {
					chkfee chk = new chkfee();
					String ind = r1.getText();
					String in = r2.getText();
					String in1 = r3.getText();
					chk.setVisible(true);
					chk.s1.setText(ind);
					chk.s2.setText(in);
					chk.s3.setText(in1);
				} else {
					JOptionPane.showMessageDialog(null, "Please Search ID or name");
				}
			}
		});

		setVisible(true);
	}
}