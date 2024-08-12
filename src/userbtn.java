import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class userbtn extends JFrame {
	Container c;
	JButton btn1, btn2;
	GridLayout g;
	Dimension dm;
	JPanel p1, p2;

	public userbtn() {
		c = getContentPane();
		btn1 = new JButton("Change Password", new ImageIcon("icons/update.png"));
		btn1.setBackground(Color.black);
		btn1.setForeground(Color.white);
		btn2 = new JButton("Logout", new ImageIcon("icons/logout.png"));
		btn2.setBackground(Color.black);
		btn2.setForeground(Color.white);
		g = new GridLayout(2, 1);
		setTitle("School Management");
		ImageIcon icon = new ImageIcon("images\\logo.png");
		setIconImage(icon.getImage());
		Toolkit tk = Toolkit.getDefaultToolkit();
		dm = tk.getScreenSize();
		int swidth = (int) dm.getWidth();
		int sheight = (int) dm.getHeight();
		setBounds(swidth / 2 - 200, sheight / 2 - 70, 300, 140);
		c.setLayout(g);
		c.add(btn1);
		c.add(btn2);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {

				try {
					dispose();
					changepass ob = new changepass();

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
				dispose();
			}
		});

		setVisible(true);
	}

}