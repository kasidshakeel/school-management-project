import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.sql.*;

public class changepass extends JFrame {
	Container c;
	JPanel p1, p2;
	JButton btn1, btn2;
	JPasswordField t1, t2, t3;
	JLabel lbl1, lbl2, lbl3;
	Dimension dm;
	PreparedStatement ps;
	ResultSet rs;
	Connection con;

	public changepass() {
		c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.white);

		p1 = new JPanel();
		// p1.setLayout(null);
		p1.setBounds(1, 1, 390, 250);
		p1.setBackground(Color.white);
		c.add(p1);
		ImageIcon background_image = new ImageIcon("images\\logo.png");
		Image img = background_image.getImage();
		Image temp_img = img.getScaledInstance(320, 245, Image.SCALE_SMOOTH);
		background_image = new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_image, JLabel.CENTER);
		p1.add(background);

		p2 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(1, 252, 400, 188);
		p2.setBackground(Color.white);
		c.add(p2);

		lbl1 = new JLabel("Old Password");
		Font ft = new Font("Arial", Font.BOLD, 15);
		lbl1.setBounds(50, 5, 120, 30);
		lbl1.setFont(ft);
		p2.add(lbl1);
		t1 = new JPasswordField();
		t1.setBounds(220, 5, 120, 30);
		p2.add(t1);

		lbl2 = new JLabel("New Password");
		lbl2.setBounds(50, 45, 120, 30);
		lbl2.setFont(ft);
		p2.add(lbl2);
		t2 = new JPasswordField();
		t2.setBounds(220, 45, 120, 30);
		p2.add(t2);

		lbl3 = new JLabel("Confirm Pass");
		lbl3.setBounds(50, 85, 120, 30);
		lbl3.setFont(ft);
		p2.add(lbl3);
		t3 = new JPasswordField();
		t3.setBounds(220, 85, 120, 30);
		p2.add(t3);

		btn1 = new JButton("Change");
		btn1.setBackground(Color.black);
		btn1.setForeground(Color.white);
		btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn1.setFocusable(true);
		btn1.setBounds(50, 120, 80, 30);
		p2.add(btn1);

		btn2 = new JButton("Cancel");
		btn2.setBackground(Color.black);
		btn2.setForeground(Color.white);
		btn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn2.setFocusable(true);
		btn2.setBounds(220, 120, 80, 30);
		p2.add(btn2);

		setTitle("School Management");
		ImageIcon icon = new ImageIcon("images\\logo.png");
		setIconImage(icon.getImage());
		Toolkit tk = Toolkit.getDefaultToolkit();
		dm = tk.getScreenSize();
		int swidth = (int) dm.getWidth();
		int sheight = (int) dm.getHeight();
		setBounds(swidth / 2 - 200, sheight / 2 - 225, 400, 450);
		setResizable(false);
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
					if (!t1.getText().equals("") && !t2.getText().equals("") && !t3.getText().equals("")) {

						ps = con.prepareStatement("select * from user where Username=? and Password=?");
						ps.setString(1, uname.uname);
						ps.setString(2, t1.getText());
						rs = ps.executeQuery();
						JOptionPane.showConfirmDialog(null, "Are you sure, that you want to change the password");
						if (rs.next()) {
							rs.close();
							ps = con.prepareStatement("update user set Password=? where Username=?");
							ps.setString(1, t2.getText());
							ps.setString(2, uname.uname);
							ps.executeUpdate();
							JOptionPane.showMessageDialog(null, "Password Have Been Changed");
							dispose();
						} else {
							JOptionPane.showMessageDialog(null, "You Are Not Valid User To Change The Password");
						}
						rs.close();
					} else if (!t1.getText().equals("") && !t2.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please Enter Confirmation Password");
					} else if (!t1.getText().equals("") && !t3.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please Enter New Password");
					} else if (!t2.getText().equals("") && !t3.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please Enter Old Password");
					} else if (!t1.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please Enter New Password and Confirmation");
					} else if (!t2.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please Enter Old Password and Confirmation");
					} else if (!t3.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Please Enter Old Password and New Password");
					} else {
						JOptionPane.showMessageDialog(null, "Please Fill All Blocks");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});

		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					dispose();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});

		setVisible(true);
	}

}