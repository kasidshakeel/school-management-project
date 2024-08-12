import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class indexuser extends JFrame {
	JMenuBar mb;
	JButton btn1, btn2, btn3, btn4, btn5;
	JMenu m1, m2, m3, m4;
	JLabel lb1;
	JMenuItem i1, i2, i3, i4, i5, i6, i7;
	Container c;
	Dimension dm;

	public indexuser() {

		c = getContentPane();
		mb = new JMenuBar();
		m1 = new JMenu("File");
		mb.add(m1);
		m2 = new JMenu("Student");
		mb.add(m2);
		m3 = new JMenu("Staff");
		mb.add(m3);
		m4 = new JMenu("User");
		mb.add(m4);
		i1 = new JMenuItem("Exit", new ImageIcon("icons/exit.png"));
		m1.add(i1);
		i2 = new JMenuItem("Add", new ImageIcon("icons/add.png"));
		m2.add(i2);
		i3 = new JMenuItem("View", new ImageIcon("icons/find.png"));
		m2.add(i3);
		i4 = new JMenuItem("Add ", new ImageIcon("icons/add.png"));
		m3.add(i4);
		i5 = new JMenuItem("View", new ImageIcon("icons/find.png"));
		m3.add(i5);
		i6 = new JMenuItem("Change Pass", new ImageIcon("icons/update.png"));
		m4.add(i6);
		i7 = new JMenuItem("Logout", new ImageIcon("icons/logout.png"));
		m4.add(i7);

		lb1 = new JLabel(new ImageIcon("images\\logo.png"));
		lb1.setBounds(500, 80, 350, 350);
		c.add(lb1);

		btn1 = new JButton(new ImageIcon("icons/logout.png"));
		c.add(btn1);
		btn1.setContentAreaFilled(false);
		btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn1.setFocusable(true);
		btn1.setBounds(850, 10, 25, 25);

		btn2 = new JButton("STUDENTS", new ImageIcon("icons/add1.png"));
		btn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Font f = new Font("Arial", Font.BOLD, 17);
		btn2.setBackground(Color.black);
		btn2.setForeground(Color.white);
		btn2.setFont(f);
		c.add(btn2);
		btn2.setBounds(270, 280, 180, 100);

		btn3 = new JButton("STAFFS", new ImageIcon("icons/add1.png"));
		btn3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn3.setFont(f);
		btn3.setBackground(Color.black);
		btn3.setForeground(Color.white);
		c.add(btn3);
		btn3.setBounds(50, 280, 180, 100);

		btn4 = new JButton("Check Fee", new ImageIcon("icons/cash.png"));
		btn4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn4.setBackground(Color.black);
		btn4.setForeground(Color.white);
		c.add(btn4);
		btn4.setFont(f);
		btn4.setBounds(270, 140, 180, 100);

		btn5 = new JButton("Notice", new ImageIcon("icons/cash.png"));
		btn5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn5.setBackground(Color.black);
		btn5.setForeground(Color.white);
		c.add(btn5);
		btn5.setFont(f);
		btn5.setBounds(50, 140, 180, 100);

		setJMenuBar(mb);
		setSize(900, 650);
		Toolkit tk = Toolkit.getDefaultToolkit();
		dm = tk.getScreenSize();
		int swidth = (int) dm.getWidth();
		int sheight = (int) dm.getHeight();

		ImageIcon background_image = new ImageIcon("images\\background.jpg");
		Image img = background_image.getImage();
		Image temp_img = img.getScaledInstance(swidth, sheight, Image.SCALE_SMOOTH);
		background_image = new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_image, JLabel.CENTER);
		c.add(background);

		setTitle("School Management");
		ImageIcon icon = new ImageIcon("images\\logo.png");
		setResizable(false);
		setIconImage(icon.getImage());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		i1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				dispose();
			}
		});

		i2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				stdform ob = new stdform();
			}
		});

		i3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				checkstd ob = new checkstd();
			}
		});

		i4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				teaform ob = new teaform();
			}
		});

		i5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				checkstaff ob = new checkstaff();
			}
		});

		i6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				changepass ob = new changepass();
			}
		});

		i7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {

					int a = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout");
					if (a == JOptionPane.YES_OPTION) {
						disable();
						dispose();
						login ob = new login();
					}

					// userbtn ob=new userbtn();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});

		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {

					int a = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout");
					if (a == JOptionPane.YES_OPTION) {
						disable();
						dispose();
						login ob = new login();
					}

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}

			}
		});

		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					student ob = new student();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});

		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					teacher ob = new teacher();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}

			}
		});

		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					feesform ob = new feesform();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}

			}
		});

		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					// feesform ob=new feesform();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}

			}
		});
		setVisible(true);
	}

}
