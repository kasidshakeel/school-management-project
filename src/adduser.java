import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.event.*;
import java.awt.event.*;

public class adduser extends JFrame {
	Container c;
	JPanel p1;
	Connection con;
	PreparedStatement ps;
	JLabel l1, l2;
	JTextField t1, t2;
	JButton btn1;

	public adduser() {
		c = getContentPane();
		c.setBackground(Color.white);
		c.setLayout(null);

		p1 = new JPanel();
		p1.setBounds(1, 1, 380, 300);
		p1.setBackground(Color.white);
		p1.setLayout(null);
		c.add(p1);

		l1 = new JLabel("User Name");
		l1.setBounds(20, 20, 150, 30);
		Font ft = new Font("Arial", Font.BOLD, 20);
		l1.setFont(ft);
		p1.add(l1);

		t1 = new JTextField();
		t1.setBounds(20, 60, 250, 30);
		t1.setFont(ft);
		p1.add(t1);

		l2 = new JLabel("Password");
		l2.setBounds(20, 120, 100, 30);
		l2.setFont(ft);
		p1.add(l2);

		t2 = new JTextField();
		t2.setBounds(20, 160, 250, 30);
		t2.setFont(ft);
		p1.add(t2);

		btn1 = new JButton("ADD");
		btn1.setBounds(20, 210, 60, 30);
		btn1.setBackground(Color.black);
		btn1.setForeground(Color.white);
		btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn1.setFocusable(true);
		p1.add(btn1);

		setSize(300, 300);
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
					String username = t1.getText();
					String password = t2.getText();
					if (!username.equals("") && !password.equals("")) {
						ps = con.prepareStatement("insert into user(Username,Password)values(?,?)");
						ps.setString(1, t1.getText());
						ps.setString(2, t2.getText());
						ps.execute();
						JOptionPane.showMessageDialog(null, "User has been Added");
						t1.setText("");
						t2.setText("");
					} else if (!t1.getText().equals("") || !t2.getText().equals("")) {
						if (!t1.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Please Enter Password");
						} else {
							JOptionPane.showMessageDialog(null, "Please Enter Username");
						}
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});

		setVisible(true);
	}

}