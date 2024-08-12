import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date.*;
import javax.swing.table.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import javax.swing.table.*;

public class stdform extends JFrame {
	Container c;
	JButton btn1, btn2;
	JTextField t1, t2, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13;
	JLabel js, l1, l2, t3, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18;
	JComboBox cmb, cmb1;
	ButtonGroup grp;
	JRadioButton male, female;
	JPanel p1, p2, p3;
	Dimension dm;
	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	byte[] person_image = null;
	int l = 0;

	public stdform() {
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		SimpleDateFormat odf = new SimpleDateFormat("dd-MM-yyyy");
		String dd = odf.format(sqlDate);

		c = getContentPane();
		p1 = new JPanel();
		c.add(p1, BorderLayout.CENTER);
		c.setBackground(Color.white);
		p1.setLayout(null);
		l1 = new JLabel("First Name :");
		l1.setBounds(20, 80, 70, 30);
		Font ft = new Font("Arial", Font.BOLD, 12);
		l1.setFont(ft);
		p1.add(l1);
		t1 = new JTextField();
		t1.setBounds(140, 80, 150, 30);
		p1.add(t1);
		l2 = new JLabel("Last Name :");
		l2.setBounds(20, 130, 70, 30);
		l2.setFont(ft);
		p1.add(l2);
		t2 = new JTextField();
		t2.setBounds(140, 130, 150, 30);
		p1.add(t2);
		l3 = new JLabel("Class :");
		l3.setBounds(20, 480, 70, 30);
		l3.setFont(ft);
		p1.add(l3);
		cmb = new JComboBox();
		cmb.setBounds(140, 480, 150, 30);
		cmb.addItem("LKG");
		cmb.addItem("UKG");
		cmb.addItem("Ist");
		cmb.addItem("IInd");
		cmb.addItem("IIIrd");
		cmb.addItem("IVth");
		cmb.addItem("Vth");
		cmb.addItem("VIth");
		cmb.addItem("VIIth");
		cmb.addItem("VIIIth");
		cmb.addItem("IXth");
		cmb.addItem("Xth");
		cmb.addItem("XIth");
		cmb.addItem("XIIth");
		p1.add(cmb);

		l4 = new JLabel("ID :");
		l4.setBounds(20, 30, 90, 30);
		l4.setFont(ft);
		p1.add(l4);
		t3 = new JLabel();
		t3.setBounds(140, 30, 50, 30);
		p1.add(t3);

		l5 = new JLabel("Gender :");
		l5.setBounds(20, 180, 70, 30);
		l5.setFont(ft);
		p1.add(l5);
		p3 = new JPanel();
		male = new JRadioButton("Male");
		female = new JRadioButton("Female");
		grp = new ButtonGroup();
		grp.add(male);
		grp.add(female);
		p3.add(male);
		p3.add(female);
		p3.setBounds(140, 180, 150, 30);
		p1.add(p3);
		l6 = new JLabel("Age :");
		l6.setBounds(20, 230, 70, 30);
		l6.setFont(ft);
		p1.add(l6);
		t4 = new JTextField();
		t4.setBounds(140, 230, 150, 30);
		p1.add(t4);
		l7 = new JLabel("Birth Date :");
		l7.setBounds(320, 230, 70, 30);
		l7.setFont(ft);
		p1.add(l7);
		t5 = new JTextField();
		t5.setBounds(420, 230, 150, 30);
		p1.add(t5);
		l8 = new JLabel("Mobile No :");
		l8.setBounds(20, 330, 70, 30);
		l8.setFont(ft);
		p1.add(l8);
		t6 = new JTextField();
		t6.setBounds(140, 330, 150, 30);
		p1.add(t6);
		l9 = new JLabel("Father Name :");
		l9.setBounds(20, 280, 80, 30);
		l9.setFont(ft);
		p1.add(l9);
		t7 = new JTextField();
		t7.setBounds(140, 280, 150, 30);
		p1.add(t7);
		l10 = new JLabel("Mother Name :");
		l10.setBounds(320, 280, 90, 30);
		l10.setFont(ft);
		p1.add(l10);
		t8 = new JTextField();
		t8.setBounds(420, 280, 150, 30);
		p1.add(t8);
		l11 = new JLabel("Address :");
		l11.setBounds(320, 330, 80, 30);
		l11.setFont(ft);
		p1.add(l11);
		t9 = new JTextField();
		t9.setBounds(420, 330, 150, 30);
		p1.add(t9);
		l12 = new JLabel("Address1 :");
		l12.setBounds(20, 380, 80, 30);
		l12.setFont(ft);
		p1.add(l12);
		t10 = new JTextField();
		t10.setBounds(140, 380, 150, 30);
		p1.add(t10);
		l13 = new JLabel("Aadhar No :");
		l13.setBounds(20, 430, 80, 30);
		l13.setFont(ft);
		p1.add(l13);
		t11 = new JTextField();
		t11.setBounds(140, 430, 150, 30);
		p1.add(t11);
		l14 = new JLabel("E-mail :");
		l14.setBounds(320, 380, 90, 30);
		l14.setFont(ft);
		p1.add(l14);
		t12 = new JTextField();
		t12.setBounds(420, 380, 150, 30);
		p1.add(t12);
		l15 = new JLabel("Religion :");
		l15.setBounds(320, 430, 80, 30);
		l15.setFont(ft);
		p1.add(l15);
		cmb1 = new JComboBox();
		cmb1.addItem("Hindu");
		cmb1.addItem("Muslim");
		cmb1.setBounds(420, 430, 150, 30);
		p1.add(cmb1);
		l16 = new JLabel("Date :");
		l16.setBounds(320, 480, 90, 30);
		l16.setFont(ft);
		p1.add(l16);
		js = new JLabel(dd);
		js.setBounds(420, 480, 150, 30);
		p1.add(js);
		btn2 = new JButton("Choose");
		btn2.setBounds(480, 180, 75, 30);
		btn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		p1.add(btn2);
		l17 = new JLabel("        	  Photo");
		l17.setFont(ft);
		l17.setBounds(320, 30, 150, 180);
		l17.setBackground(null);
		p1.add(l17);
		btn1 = new JButton("Submit");
		btn1.setBackground(Color.black);
		btn1.setForeground(Color.white);
		btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		p1.add(btn1);
		btn1.setBounds(15, 535, 80, 30);
		setSize(610, 620);
		setResizable(false);
		setTitle("School Management");
		ImageIcon icon = new ImageIcon("images\\logo.png");
		setIconImage(icon.getImage());
		setLocationRelativeTo(p1);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent we) {
				try {

					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement", "root", "12345");
					if (!t3.getText().equals("")) {
						btn1.setText("Update");
						if (!t3.getText().equals("")) {
							ps = con.prepareStatement("select * from student where id like '" + t3.getText() + "%'");

						}
						rs = ps.executeQuery();
						while (rs.next()) {
							t1.setText(rs.getString(2));
							t2.setText(rs.getString(3));
							cmb.setSelectedItem(rs.getString(4));
							String gen = rs.getString(5);
							if (gen.equals("Male")) {
								male.setSelected(true);
							} else {
								female.setSelected(true);
							}
							t4.setText(rs.getString(6));
							t5.setText(rs.getString(7));
							t6.setText(rs.getString(8));
							t7.setText(rs.getString(9));
							t8.setText(rs.getString(10));
							t9.setText(rs.getString(11));
							t10.setText(rs.getString(12));
							t11.setText(rs.getString(13));
							t12.setText(rs.getString(14));
							cmb1.setSelectedItem(rs.getString(15));
							js.setText(rs.getString(16));
							byte[] im = rs.getBytes("pic");
							ImageIcon im1 = new ImageIcon(new ImageIcon(im).getImage().getScaledInstance(l17.getWidth(),
									l17.getHeight(), Image.SCALE_SMOOTH));
							l17.setIcon(im1);

						}
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}

			public void windowClosing(WindowEvent we) {
				try {
					con.close();
					if (btn1.getText().equals("Update")) {
						checkstd o = new checkstd();
					}
				} catch (Exception ex) {
				}
			}
		});

		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ea) {
				try {
					if (btn1.getText().equals("Submit")) {
						int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to add record?",
								"Add Record", JOptionPane.YES_NO_OPTION);
						if (p == 0) {
							ps = con.prepareStatement(
									"INSERT INTO student(fname, lname, class, gender, age, birth, phone, father, mother, address, address1, aadhar, email, religion, date, pic) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
							ps.setString(1, t1.getText());
							ps.setString(2, t2.getText());
							ps.setString(3, cmb.getSelectedItem() + "");
							ps.setString(4, male.isSelected() ? "Male" : "Female");
							ps.setString(5, t4.getText());
							ps.setString(6, t5.getText());
							ps.setString(7, t6.getText());
							ps.setString(8, t7.getText());
							ps.setString(9, t8.getText());
							ps.setString(10, t9.getText());
							ps.setString(11, t10.getText());
							ps.setString(12, t11.getText());
							ps.setString(13, t12.getText());
							ps.setString(14, cmb1.getSelectedItem() + "");
							ps.setString(15, js.getText());
							ps.setBytes(16, person_image);
							ps.execute();
							JOptionPane.showMessageDialog(null, "Student has been Added");
							clearFields();
						}
					} else {
						int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to Update record?",
								"Update Record", JOptionPane.YES_NO_OPTION);
						if (p == 0) {
							if (l >= 1) {
								ps = con.prepareStatement(
										"update student set fname=?,lname=?,class=?,gender=?,age=?,birth=?,phone=?,father=?,mother=?,address=?,address1=?,aadhar=?,email=?,religion=?,date=?,pic=? where id=?");
								ps.setString(1, t1.getText());
								ps.setString(2, t2.getText());
								ps.setString(3, cmb.getSelectedItem() + "");
								ps.setString(4, male.isSelected() ? "Male" : "Female");
								ps.setString(5, t4.getText());
								ps.setString(6, t5.getText());
								ps.setString(7, t6.getText());
								ps.setString(8, t7.getText());
								ps.setString(9, t8.getText());
								ps.setString(10, t9.getText());
								ps.setString(11, t10.getText());
								ps.setString(12, t11.getText());
								ps.setString(13, t12.getText());
								ps.setString(14, cmb1.getSelectedItem() + "");
								ps.setString(15, js.getText());
								ps.setBytes(16, person_image);
								ps.setString(17, t3.getText());
							} else {
								ps = con.prepareStatement(
										"update student set fname=?,lname=?,class=?,gender=?,age=?,birth=?,phone=?,father=?,mother=?,address=?,address1=?,aadhar=?,email=?,religion=?,date=? where id=?");
								ps.setString(1, t1.getText());
								ps.setString(2, t2.getText());
								ps.setString(3, cmb.getSelectedItem() + "");
								ps.setString(4, male.isSelected() ? "Male" : "Female");
								ps.setString(5, t4.getText());
								ps.setString(6, t5.getText());
								ps.setString(7, t6.getText());
								ps.setString(8, t7.getText());
								ps.setString(9, t8.getText());
								ps.setString(10, t9.getText());
								ps.setString(11, t10.getText());
								ps.setString(12, t11.getText());
								ps.setString(13, t12.getText());
								ps.setString(14, cmb1.getSelectedItem() + "");
								ps.setString(15, js.getText());
								ps.setString(16, t3.getText());
							}
							ps.executeUpdate();
							JOptionPane.showMessageDialog(null, "Record Updated");
							con.close();
							dispose();
							checkstd ob3 = new checkstd();
							// }
						}
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}

			}

			private void clearFields() {
				t1.setText("");
				t2.setText("");
				t3.setText("");
				t4.setText("");
				t5.setText("");
				t6.setText("");
				t7.setText("");
				t8.setText("");
				t9.setText("");
				person_image = null;
				t10.setText("");
				t11.setText("");
				t12.setText("");
			}

		});

		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ea) {
				l17.setText("");
				try {
					JFileChooser chooser = new JFileChooser();
					chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
					chooser.showOpenDialog(null);
					File f = chooser.getSelectedFile();
					String filename = f.getAbsolutePath();
					ImageIcon img = new ImageIcon(f.toString());
					Image img1 = img.getImage();
					Image img2 = img1.getScaledInstance(l17.getWidth(), l17.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon icon = new ImageIcon(img2);
					l17.setIcon(icon);
					try {
						File image = new File(filename);
						FileInputStream fis = new FileInputStream(image);
						ByteArrayOutputStream bos = new ByteArrayOutputStream();
						byte[] buf = new byte[1024];
						for (int readNum; (readNum = fis.read(buf)) != -1;) {
							bos.write(buf, 0, readNum);
						}
						person_image = bos.toByteArray();
						l = 1;
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, e);
					}
				} catch (Exception e) {
				}
			}
		});

		setVisible(true);
	}
}