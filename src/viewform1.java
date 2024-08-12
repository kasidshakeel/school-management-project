import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date.*;
import javax.swing.table.*;
import java.awt.print.*;

public class viewform1 extends JFrame {
	Container c;
	JButton btn1;
	JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15, l16, l17, l18, r1, r2, r3, r4, r5, r6, r7,
			r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18;
	JPanel p1, p2;
	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	byte[] person_image = null;

	public viewform1() {
		c = getContentPane();
		p1 = new JPanel();
		p1.setBounds(10, 10, 520, 550);
		p1.setBackground(Color.white);
		p1.setLayout(null);
		c.add(p1);

		l1 = new JLabel("First Name :");
		l1.setBounds(10, 60, 70, 30);
		Font ft = new Font("Arial", Font.BOLD, 12);
		l1.setFont(ft);
		p1.add(l1);
		r1 = new JLabel();
		r1.setBounds(110, 60, 150, 30);
		r1.setFont(ft);
		p1.add(r1);

		l2 = new JLabel("Last Name :");
		l2.setBounds(10, 110, 70, 30);
		l2.setFont(ft);
		p1.add(l2);
		r2 = new JLabel();
		r2.setBounds(100, 110, 150, 30);
		r2.setFont(ft);
		p1.add(r2);

		l3 = new JLabel("Qualification : ");
		l3.setBounds(265, 360, 90, 30);
		l3.setFont(ft);
		p1.add(l3);
		r3 = new JLabel();
		r3.setBounds(355, 360, 200, 30);
		r3.setFont(ft);
		p1.add(r3);

		l4 = new JLabel("ID : ");
		l4.setBounds(10, 10, 90, 30);
		l4.setFont(ft);
		p1.add(l4);
		r4 = new JLabel();
		r4.setBounds(100, 10, 50, 30);
		r4.setForeground(Color.red);
		r4.setFont(ft);
		p1.add(r4);

		l5 = new JLabel("Gender : ");
		l5.setBounds(10, 160, 70, 30);
		l5.setFont(ft);
		p1.add(l5);
		r5 = new JLabel();
		r5.setBounds(100, 160, 150, 30);
		r5.setFont(ft);
		p1.add(r5);

		l6 = new JLabel("Age : ");
		l6.setBounds(10, 210, 70, 30);
		l6.setFont(ft);
		p1.add(l6);
		r6 = new JLabel();
		r6.setBounds(100, 210, 150, 30);
		r6.setFont(ft);
		p1.add(r6);

		l7 = new JLabel("Birth Date : ");
		l7.setBounds(265, 210, 70, 30);
		l7.setFont(ft);
		p1.add(l7);
		r7 = new JLabel();
		r7.setBounds(355, 210, 150, 30);
		r7.setFont(ft);
		p1.add(r7);

		l8 = new JLabel("Mobile No : ");
		l8.setBounds(10, 310, 70, 30);
		l8.setFont(ft);
		p1.add(l8);
		r8 = new JLabel();
		r8.setBounds(100, 310, 150, 30);
		r8.setFont(ft);
		p1.add(r8);

		l9 = new JLabel("Father Name : ");
		l9.setBounds(10, 260, 80, 30);
		l9.setFont(ft);
		p1.add(l9);
		r9 = new JLabel();
		r9.setBounds(100, 260, 150, 30);
		r9.setFont(ft);
		p1.add(r9);

		l10 = new JLabel("Mother Name :");
		l10.setBounds(265, 260, 90, 30);
		l10.setFont(ft);
		p1.add(l10);
		r10 = new JLabel();
		r10.setBounds(355, 260, 150, 30);
		r10.setFont(ft);
		p1.add(r10);

		l11 = new JLabel("Address : ");
		l11.setBounds(265, 310, 80, 30);
		l11.setFont(ft);
		p1.add(l11);
		r11 = new JLabel();
		r11.setBounds(355, 310, 150, 30);
		r11.setFont(ft);
		p1.add(r11);

		l12 = new JLabel("Address1 : ");
		l12.setBounds(10, 360, 80, 30);
		l12.setFont(ft);
		p1.add(l12);
		r12 = new JLabel();
		r12.setBounds(100, 360, 150, 30);
		r12.setFont(ft);
		p1.add(r12);

		l13 = new JLabel("Aadhar No : ");
		l13.setBounds(10, 410, 80, 30);
		l13.setFont(ft);
		p1.add(l13);
		r13 = new JLabel();
		r13.setBounds(100, 410, 150, 30);
		r13.setFont(ft);
		p1.add(r13);

		l14 = new JLabel("E-mail : ");
		l14.setBounds(10, 460, 70, 30);
		l14.setFont(ft);
		p1.add(l14);
		r14 = new JLabel();
		r14.setBounds(100, 460, 150, 30);
		r14.setFont(ft);
		p1.add(r14);

		l15 = new JLabel("Religion : ");
		l15.setBounds(265, 410, 80, 30);
		l15.setFont(ft);
		p1.add(l15);
		r15 = new JLabel();
		r15.setBounds(355, 410, 150, 30);
		r15.setFont(ft);
		p1.add(r15);

		l16 = new JLabel("Date : ");
		l16.setBounds(265, 510, 90, 30);
		l16.setFont(ft);
		p1.add(l16);
		r16 = new JLabel();
		r16.setBounds(355, 510, 150, 30);
		r16.setFont(ft);
		p1.add(r16);

		l17 = new JLabel("IFSC Code : ");
		l17.setBounds(10, 510, 90, 30);
		l17.setFont(ft);
		p1.add(l17);
		r17 = new JLabel();
		r17.setBounds(100, 510, 150, 30);
		r17.setFont(ft);
		p1.add(r17);

		l18 = new JLabel("Account No : ");
		l18.setBounds(265, 460, 90, 30);
		l18.setFont(ft);
		p1.add(l18);
		r18 = new JLabel();
		r18.setBounds(355, 460, 150, 30);
		r18.setFont(ft);
		p1.add(r18);

		l17 = new JLabel();
		l17.setBounds(255, 10, 150, 180);
		l17.setBackground(null);
		p1.add(l17);

		p2 = new JPanel();
		btn1 = new JButton(new ImageIcon("icons/print.png"));
		btn1.setBackground(Color.black);
		btn1.setForeground(Color.white);
		btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn1.setBounds(20, 570, 40, 40);
		p2.add(btn1);

		p2.setSize(520, 50);
		p2.setLayout(null);
		c.add(p2);

		setSize(547, 650);
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
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement","root","12345");

					if (!r4.getText().equals("")) {
						ps = con.prepareStatement("select * from staff where id like '" + r4.getText() + "%'");

					}
					rs = ps.executeQuery();
					while (rs.next()) {
						r1.setText(rs.getString(2));
						r2.setText(rs.getString(3));
						r3.setText(rs.getString(5));
						// r4 = id
						r5.setText(rs.getString(4));
						r6.setText(rs.getString(6));
						r7.setText(rs.getString(7));
						r8.setText(rs.getString(8));
						r9.setText(rs.getString(9));
						r10.setText(rs.getString(10));
						r11.setText(rs.getString(11));
						r12.setText(rs.getString(12));
						r14.setText(rs.getString(14));
						r13.setText(rs.getString(13));
						r15.setText(rs.getString(15));
						r18.setText(rs.getString(16));
						r17.setText(rs.getString(17));
						r16.setText(rs.getString(18));
						byte[] im = rs.getBytes("pic");
						ImageIcon im1 = new ImageIcon(new ImageIcon(im).getImage().getScaledInstance(l17.getWidth(),
								l17.getHeight(), Image.SCALE_SMOOTH));
						l17.setIcon(im1);
					}
					p1.disable();
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
				PrinterJob pj = PrinterJob.getPrinterJob();
				pj.setJobName(" Print Component ");

				pj.setPrintable(new Printable() {
					public int print(Graphics pg, PageFormat pf, int pageNum) {
						if (pageNum > 0) {
							return Printable.NO_SUCH_PAGE;
						}

						Graphics2D g2 = (Graphics2D) pg;
						g2.translate(pf.getImageableX(), pf.getImageableY());
						p1.paint(g2);
						return Printable.PAGE_EXISTS;
					}
				});
				if (pj.printDialog() == false)
					return;

				try {
					pj.print();
				} catch (PrinterException ex) {
					// handle exception
				}
			}
		});
	}
}