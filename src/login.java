import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class login extends JFrame
{
	Container c;
	JButton btn1,btn2;
	GridLayout g;
	Dimension dm;
	JPanel p1,p2;
	
    public login()
    {
    	c=getContentPane();
		btn1=new JButton("Admin Login");
		btn1.setBackground(Color.black);
		btn1.setForeground(Color.white);
		btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn1.setFocusable(true);
		btn2=new JButton("User Login");
		btn2.setBackground(Color.black);
		btn2.setForeground(Color.white);
		btn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn2.setFocusable(true);
		g=new GridLayout(1,1);
		p1=new JPanel();
		p1.setBackground(Color.white);
		p2=new JPanel();
		p2.setBackground(Color.white);
		setTitle("School Management");
		ImageIcon icon=new ImageIcon("images\\logo.png");
		setIconImage(icon.getImage());
		Toolkit tk=Toolkit.getDefaultToolkit();
		dm=tk.getScreenSize();
		int swidth=(int)dm.getWidth();
		int sheight=(int)dm.getHeight();
		setBounds(swidth/2-200,sheight/2-190,400,380);		
		c.add(p1,BorderLayout.NORTH);
    	ImageIcon background_image=new ImageIcon("images\\logo.png");
    	Image img=background_image.getImage();
    	Image temp_img=img.getScaledInstance(300,300,Image.SCALE_SMOOTH);
		background_image=new ImageIcon(temp_img);
		JLabel background=new JLabel("",background_image,JLabel.CENTER);
		p1.add(background);
		c.add(p2,BorderLayout.CENTER);
		p2.setLayout(g);
		p2.add(btn2);
		p2.add(btn1);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		btn1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				try
				{	
					dispose();
					admin ob=new admin();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
			}
		});
		
		btn2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					dispose();
    				user ob=new user();	
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
			}
		});
		
		setVisible(true);
    }
    
    
}