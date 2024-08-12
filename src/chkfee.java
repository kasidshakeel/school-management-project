import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import java.util.Date.*;
import javax.swing.table.*;
import java.awt.Graphics.*;
import java.awt.print.*;

public class chkfee extends JFrame {
	JLabel l1, l2, b1, s1, s2, s3, l3, l4, l5, l6, r3, r4, r5, r6, l7, l8, l9, l10, r7, r8, r9, r10;
	JPanel p1, p2, p3;
	JButton btn1, btn2;
	Container c;
	JTable tb;
	DefaultTableModel md1;
	Vector<String> row, col;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;

	void inittable() {
		col = new Vector<String>();
		col.add("Month");
		col.add("Fees");
		col.add("Exam");
		col.add("Date");
		row = new Vector<String>();
		md1 = new DefaultTableModel(col, 0);
		tb = new JTable(md1);
		tb.setAutoCreateColumnsFromModel(true);
		tb.setPreferredScrollableViewportSize(new Dimension(300, 190));
		p1.add(new JScrollPane(tb));
	}

	public chkfee() {
		c = getContentPane();
		c.setLayout(null);

		p2 = new JPanel();
		p2.setBackground(Color.white);
		p2.setBounds(5, 10, 320, 80);
		p2.setLayout(null);
		c.add(p2);

		l1 = new JLabel("ID :");
		l1.setBounds(20, 10, 60, 30);
		Font ft = new Font("Arial", Font.BOLD, 15);
		l1.setFont(ft);
		p2.add(l1);
		s1 = new JLabel();
		s1.setBounds(50, 10, 40, 30);
		s1.setForeground(Color.red);
		s1.setFont(ft);
		p2.add(s1);

		l2 = new JLabel("Name :");
		l2.setBounds(130, 10, 60, 30);
		l2.setFont(ft);
		p2.add(l2);
		s2 = new JLabel();
		s2.setFont(ft);
		s2.setBounds(190, 10, 150, 30);
		p2.add(s2);

		b1 = new JLabel("Class :");
		b1.setBounds(20, 45, 60, 30);
		b1.setFont(ft);
		p2.add(b1);
		s3 = new JLabel();
		s3.setBounds(70, 45, 60, 30);
		s3.setFont(ft);
		p2.add(s3);

		p1 = new JPanel();
		p1.setBounds(5, 100, 320, 250);
		p1.setBackground(Color.white);
		inittable();
		c.add(p1);

		p3 = new JPanel();
		p3.setBackground(Color.white);
		p3.setBounds(340, 10, 340, 380);
		p3.setLayout(null);
		c.add(p3);

		JLabel l11 = new JLabel();
		l11.setBounds(25, 15, 300, 30);
		Font f = new Font("Arial", Font.BOLD, 20);
		l11.setFont(f);
		p3.add(l11);

		JLabel r = new JLabel("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		r.setBounds(1, 50, 340, 5);
		p3.add(r);

		l3 = new JLabel();
		l3.setBounds(25, 60, 60, 30);
		l3.setFont(ft);
		p3.add(l3);
		r3 = new JLabel();
		r3.setForeground(Color.red);
		r3.setFont(ft);
		r3.setBounds(200, 60, 50, 30);
		p3.add(r3);

		l4 = new JLabel();
		l4.setBounds(25, 100, 60, 30);
		l4.setFont(ft);
		p3.add(l4);
		r4 = new JLabel();
		r4.setFont(ft);
		r4.setBounds(200, 100, 150, 30);
		p3.add(r4);

		l5 = new JLabel();
		l5.setBounds(25, 140, 60, 30);
		l5.setFont(ft);
		p3.add(l5);
		r5 = new JLabel();
		r5.setFont(ft);
		r5.setBounds(200, 140, 150, 30);
		p3.add(r5);

		l6 = new JLabel();
		l6.setBounds(25, 180, 60, 30);
		l6.setFont(ft);
		p3.add(l6);
		r6 = new JLabel();
		r6.setFont(ft);
		r6.setBounds(200, 180, 150, 30);
		p3.add(r6);

		l7 = new JLabel();
		l7.setBounds(25, 220, 60, 30);
		l7.setFont(ft);
		p3.add(l7);
		r7 = new JLabel();
		r7.setFont(ft);
		r7.setBounds(200, 220, 150, 30);
		p3.add(r7);

		l8 = new JLabel();
		l8.setBounds(25, 260, 60, 30);
		l8.setFont(ft);
		p3.add(l8);
		r8 = new JLabel();
		r8.setFont(ft);
		r8.setBounds(200, 260, 150, 30);
		p3.add(r8);

		JLabel ra = new JLabel("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		ra.setBounds(1, 295, 340, 5);
		p3.add(ra);

		l9 = new JLabel();
		l9.setBounds(25, 303, 60, 30);
		l9.setFont(ft);
		p3.add(l9);
		r9 = new JLabel();
		r9.setFont(ft);
		r9.setBounds(200, 303, 150, 30);
		p3.add(r9);

		JLabel rb = new JLabel("= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =");
		rb.setBounds(1, 335, 340, 5);
		p3.add(rb);

		l10 = new JLabel();
		l10.setBounds(25, 343, 60, 30);
		l10.setFont(ft);
		p3.add(l10);
		r10 = new JLabel();
		r10.setFont(ft);
		r10.setBounds(200, 343, 150, 30);
		p3.add(r10);

		btn1 = new JButton("Generate Reciept");
		btn1.setBackground(Color.black);
		btn1.setForeground(Color.white);
		btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn1.setFocusable(true);
		btn1.setBounds(20, 360, 130, 30);
		c.add(btn1);

		btn2 = new JButton("Print");
		btn2.setBackground(Color.black);
		btn2.setForeground(Color.white);
		btn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn2.setFocusable(true);
		btn2.setBounds(280, 360, 52, 30);
		c.add(btn2);

		setSize(700, 450);
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
					if (!s1.getText().equals("")) {
						ps = con.prepareStatement("select * from fees where id like '" + s1.getText() + "%'");
					}
					rs = ps.executeQuery();

					while (rs.next()) {
						row = new Vector<String>();
						row.add(rs.getString(2));
						row.add(rs.getString(3));
						row.add(rs.getString(4));
						row.add(rs.getString(5));
						md1.addRow(row);
					}
					rs.close();

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
				if (tb.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Please select Reciept");
				} else {
					l11.setText("School Management");
					l3.setText("ID");
					String i0 = s1.getText();
					r3.setText(i0);
					l4.setText("Name");
					String i1 = s2.getText();
					r4.setText(i1);
					l5.setText("Class");
					String i2 = s3.getText();
					r5.setText(i2);
					l6.setText("Month");
					l7.setText("Fees");
					l8.setText("Exam");
					l9.setText("Total");
					l10.setText("Date");
					int ind = tb.getSelectedRow();
					TableModel mod = tb.getModel();
					String id1 = md1.getValueAt(ind, 0).toString();
					r6.setText(id1);
					String id2 = md1.getValueAt(ind, 1).toString();
					r7.setText(id2);
					String id3 = md1.getValueAt(ind, 2).toString();
					r8.setText(id3);
					int a = Integer.parseInt(id2);
					int b = Integer.parseInt(id3);
					int ab = a + b;
					r9.setText(ab + "");
					String id4 = md1.getValueAt(ind, 3).toString();
					r10.setText(id4);
				}

			}
		});

		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (tb.getSelectedRow() == -1) {
					JOptionPane.showMessageDialog(null, "Please select Reciept");
				} else {
					PrinterJob pj = PrinterJob.getPrinterJob();
					pj.setJobName(" Print Component ");

					pj.setPrintable(new Printable() {
						public int print(Graphics pg, PageFormat pf, int pageNum) {
							if (pageNum > 0) {
								return Printable.NO_SUCH_PAGE;
							}

							Graphics2D g2 = (Graphics2D) pg;
							g2.translate(pf.getImageableX(), pf.getImageableY());
							p3.paint(g2);
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
			}
		});
	}
}