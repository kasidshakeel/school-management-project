import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;
import java.sql.*;

public class user extends JFrame {
	Container c;
	JButton btn1, btn2;
	JTextField t1;
	JPasswordField t2;
	JLabel lbl1, lbl2;
	JPanel p1, p2;
	Dimension dm;
	PreparedStatement ps;
	ResultSet rs;
	Connection con;

	public user() {
		c = getContentPane();
		c.setLayout(null);
		c.setBackground(Color.white);

		p1 = new JPanel();
		p1.setBounds(10, 1, 370, 230);
		p1.setBackground(Color.white);
		c.add(p1);
		ImageIcon background_image = new ImageIcon("images\\logo.png");
		Image img = background_image.getImage();
		Image temp_img = img.getScaledInstance(300, 225, Image.SCALE_SMOOTH);
		background_image = new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_image, JLabel.CENTER);
		p1.add(background);

		p2 = new JPanel();
		p2.setLayout(null);
		p2.setBounds(1, 232, 390, 180);
		p2.setBackground(Color.white);
		c.add(p2);

		lbl1 = new JLabel("USERNAME");
		Font ft = new Font("Arial", Font.BOLD, 15);
		lbl1.setBounds(50, 25, 120, 30);
		lbl1.setFont(ft);
		p2.add(lbl1);
		t1 = new JTextField();
		t1.setBounds(220, 25, 120, 30);
		p2.add(t1);

		lbl2 = new JLabel("PASSWORD");
		lbl2.setBounds(50, 80, 120, 30);
		lbl2.setFont(ft);
		p2.add(lbl2);
		t2 = new JPasswordField();
		t2.setBounds(220, 80, 120, 30);
		p2.add(t2);

		btn1 = new JButton("Login");
		btn1.setBackground(Color.black);
		btn1.setForeground(Color.white);
		btn1.setBounds(50, 130, 80, 30);
		btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn1.setFocusable(true);
		p2.add(btn1);

		btn2 = new JButton("Back");
		btn2.setBackground(Color.black);
		btn2.setForeground(Color.white);
		btn2.setBounds(220, 130, 70, 30);
		btn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn2.setFocusable(true);
		p2.add(btn2);

		setTitle("School Management");
		ImageIcon icon = new ImageIcon("images\\logo.png");
		setIconImage(icon.getImage());
		Toolkit tk = Toolkit.getDefaultToolkit();
		dm = tk.getScreenSize();
		int swidth = (int) dm.getWidth();
		int sheight = (int) dm.getHeight();
		setBounds(swidth / 2 - 200, sheight / 2 - 220, 400, 440);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		addWindowListener(new WindowAdapter() {
			public void windowOpened(WindowEvent we) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/schoolmanagement", "root", "12345");
				} catch (ClassNotFoundException e) {
					JOptionPane.showMessageDialog(null, "JDBC Driver not found.");
				} catch (SQLException e) {
					JOptionPane.showMessageDialog(null, "Failed to connect to database.");
				}
			}

			public void windowClosing(WindowEvent we) {
				try {
					if (con != null && !con.isClosed()) {
						con.close();
					}
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(null, "Error closing connection.");
				}
			}
		});

		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					String username = t1.getText();
					String password = new String(t2.getPassword());
					if (!username.equals("") && !password.equals("")) {
						ps = con.prepareStatement("select * from user where Username=? and Password=?");
						ps.setString(1, username);
						ps.setString(2, password);
						rs = ps.executeQuery();
						if (rs.next()) {
							uname.uname = t1.getText().toString();
							dispose();
							indexuser ob = new indexuser();
						} else {
							JOptionPane.showMessageDialog(null, "User is Invalid");
						}
						rs.close();
					} else if (!username.equals("") && !password.equals("")) {
						if (!t1.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Please Enter Password");
						} else {
							JOptionPane.showMessageDialog(null, "Please Enter Username");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Please Enter Username And Password");
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
					login ob = new login();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});

		setVisible(true);
	}

}