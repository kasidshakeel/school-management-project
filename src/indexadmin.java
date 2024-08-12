import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class indexadmin extends JFrame
{
	JMenuBar mb;
	JButton btn1,btn2,btn3,btn4;
	JMenu m1,m2,m3,m4;
	JLabel lb1;
	JMenuItem i1,i2,i3,i4,i5,i6;
	Container c;
	Dimension dm;

    public indexadmin()
    {
    	
    	c=getContentPane();
    //	p1=new JPanel();
		mb=new JMenuBar();
		m1=new JMenu("File");
		mb.add(m1);
		m2=new JMenu("Student");
		mb.add(m2);
		m3=new JMenu("Staff");
		mb.add(m3);
		m4=new JMenu("User");
		mb.add(m4);
		i1=new JMenuItem("Exit",new ImageIcon("icons/exit.png"));
		m1.add(i1);
		i2=new JMenuItem("View",new ImageIcon("icons/find.png"));
		m2.add(i2);
		i3=new JMenuItem("View",new ImageIcon("icons/find.png"));
		m3.add(i3);
		i4=new JMenuItem("Add User",new ImageIcon("icons/add.png"));
		m4.add(i4);
		i5=new JMenuItem("Change Pass",new ImageIcon("icons/update.png"));
		m4.add(i5);
		i6=new JMenuItem("Logout",new ImageIcon("icons/logout.png"));
		m4.add(i6);
		btn1=new JButton(new ImageIcon("icons/logout.png"));
		c.add(btn1);
		btn1.setContentAreaFilled(false);
		btn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btn1.setFocusable(true);
		btn1.setBounds(850,10,25,25);
		
		lb1=new JLabel(new ImageIcon("images\\logo.png"));
		lb1.setBounds(450,80,350,350);
		c.add(lb1);
		
		btn2=new JButton("SEARCH STUDENTS",new ImageIcon("icons/add1.png"));
		btn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		Font f=new Font("Arial",Font.BOLD,17);
    	btn2.setFont(f);
		c.add(btn2);
		btn2.setForeground(Color.white);
		btn2.setBackground(Color.black);
		btn2.setBounds(50,240,270,75);
		
		btn3=new JButton("SEARCH STAFFS",new ImageIcon("icons/add1.png"));	
		btn3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    	btn3.setFont(f);
		c.add(btn3);
		btn3.setForeground(Color.white);
		btn3.setBackground(Color.black);
		btn3.setBounds(50,360,270,75);
		
		btn4=new JButton("Fees Enquiry");
		btn4.setForeground(Color.white);
		btn4.setBackground(Color.black);
		btn4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		c.add(btn4);
		btn4.setFont(f);
		btn4.setBounds(50,120,270,75);
		setJMenuBar(mb);
		
		setSize(900,650);
		Toolkit tk=Toolkit.getDefaultToolkit();
		dm=tk.getScreenSize();
		int swidth=(int)dm.getWidth();
		int sheight=(int)dm.getHeight();
		
		ImageIcon background_image=new ImageIcon("images\\background.jpg");
    	Image img=background_image.getImage();
    	Image temp_img=img.getScaledInstance(swidth,sheight,Image.SCALE_SMOOTH);
		background_image=new ImageIcon(temp_img);
		JLabel background=new JLabel("",background_image,JLabel.CENTER);
		c.add(background);
		
		setTitle("School Management");
		ImageIcon icon=new ImageIcon("images\\logo.png");
		setResizable(false);
		setIconImage(icon.getImage());
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	
		i1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				dispose();
			}
		});
		
		i2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				checkstd ob=new checkstd();
			}
		});
		
		i3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				checkstaff ob=new checkstaff();
			}
		});
		
		i4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				adduser ob=new adduser();
			}
		});
		
		i5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				changepass ob=new changepass();	
			}
		});
		
		i6.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
					
				try
				{
					
					int a=JOptionPane.showConfirmDialog(null,"Are you sure you want to logout");
					if(a==JOptionPane.YES_OPTION)
					{  
					disable();	
      				dispose();
					login ob=new login();
					} 
					
    			//	userbtn ob=new userbtn();	
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
			}
		});
		
		btn1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					
					int a=JOptionPane.showConfirmDialog(null,"Are you sure you want to logout");
					if(a==JOptionPane.YES_OPTION)
					{  
					disable();	
      				dispose();
					login ob=new login();
					} 
					
    			//	userbtn ob=new userbtn();	
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
    				checkstd ob=new checkstd();	
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
				
			}
		});
		
		btn3.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
    				checkstaff ob=new checkstaff();	
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(null,ex.getMessage());
				}
				
			}
		});
		
		btn4.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				try
				{
					adfee ob=new adfee();
					
    			
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
