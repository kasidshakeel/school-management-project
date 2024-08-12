import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class splash extends JFrame {
	JWindow jw;
	JPanel p1, p2;
	JProgressBar pb;
	Timer tm1;

	public splash() {
		pb = new JProgressBar();
		p1 = new JPanel();
		p2 = new JPanel();
		jw = new JWindow(this);
		jw.setBackground(Color.white);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension dim = tk.getScreenSize();
		int x = (int) dim.getWidth() / 2 - 250;
		int y = (int) dim.getHeight() / 2 - 180;
		jw.setBounds(x, y, 500, 360);
		jw.add(p2, BorderLayout.NORTH);
		ImageIcon background_image1 = new ImageIcon("images\\img3.png");
		Image img1 = background_image1.getImage();
		Image temp_img1 = img1.getScaledInstance(800, 120, Image.SCALE_SMOOTH);
		background_image1 = new ImageIcon(temp_img1);
		JLabel background1 = new JLabel("", background_image1, JLabel.CENTER);
		p2.add(background1);
		jw.add(p1, BorderLayout.CENTER);
		ImageIcon background_image = new ImageIcon("images\\sheet.jpeg");
		Image img = background_image.getImage();
		Image temp_img = img.getScaledInstance(800, 710, Image.SCALE_SMOOTH);
		background_image = new ImageIcon(temp_img);
		JLabel background = new JLabel("", background_image, JLabel.CENTER);
		p1.add(background);
		jw.add(pb, BorderLayout.SOUTH);
		pb.setForeground(Color.red);
		tm1 = new Timer(20, new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				pb.setValue(pb.getValue() + 1);
				if (pb.getValue() == 100) {
					tm1.stop();
					dispose();
					login ob = new login();
				}
			}
		});

		tm1.start();
		jw.setVisible(true);
	}

}