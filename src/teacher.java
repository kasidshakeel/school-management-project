import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.event.*;

public class teacher extends JFrame
{
	Container c;
	JButton btn1,btn2;
	GridLayout g;
	Dimension dm;
	JPanel p1,p2;
	
	public teacher()
	{
		c=getContentPane();
		btn1=new JButton("Add Staffs",new ImageIcon("icons/add2.png"));
		btn1.setBackground(Color.black);
		btn1.setForeground(Color.white);
		btn2=new JButton("Check & Update",new ImageIcon("icons/update.png"));
		btn2.setBackground(Color.black);
		btn2.setForeground(Color.white);
		g=new GridLayout(2,1);
		setTitle("School Management");
		ImageIcon icon=new ImageIcon("images\\logo.png");
		setIconImage(icon.getImage());
		Toolkit tk=Toolkit.getDefaultToolkit();
		dm=tk.getScreenSize();
		int swidth=(int)dm.getWidth();
		int sheight=(int)dm.getHeight();
		setBounds(swidth/2-150,sheight/2-70,300,140);
		c.setLayout(g);
		Font f=new Font("Arial",Font.BOLD,15);
		c.add(btn1);
		btn1.setFont(f);
		btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		c.add(btn2);
		btn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn2.setFont(f);
		setResizable(false);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		
		btn1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				try
				{	
					dispose();
					teaform ob=new teaform();
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
					checkstaff ob=new checkstaff();
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