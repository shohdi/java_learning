import java.awt.EventQueue;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/*
* A program to view images
* @version 1.0 2014-10-07
* @author shohdi
*/
public class ImageViewer
{
	public static void main(String[] args)
	{
		EventQueue.invokeLater(
			new Runnable()
			{
				public void run()
				{
					ImageViewerFrame frame  = new ImageViewerFrame();
					frame.setTitle("عرض الصور");
					frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				}
			}
					
		);
	}
}

/*
* a class to view images
*/
class ImageViewerFrame extends JFrame
{
	private JLabel label;
	private JFileChooser chooser;
	private JMenuBar menuBar;
	private JMenu menu;
	private JMenuItem openItem;
	private JMenuItem exitItem;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 400;
	
	public ImageViewerFrame ()
	{
		initializeComponents();
	}
	
	private void initializeComponents()
	{
		//init
		this.setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		//label
		label = new JLabel ();
		add(label);
		
		//chooser
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		
		//menuBar
		menuBar = new JMenuBar();
		this.setJMenuBar(menuBar);
		
		//menu
		menu = new JMenu("ملف");
		menuBar.add(menu);
		
		//openItem
		openItem = new JMenuItem("فتح");
		menu.add(openItem);
		
		//exitItem
		exitItem = new JMenuItem("انهاء");
		menu.add(exitItem);
		
		//events
		openItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				int result = chooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION)
				{
					String path = chooser.getSelectedFile().getPath();
					ImageIcon icon = new ImageIcon(path);
					
					label.setIcon(icon);
				}
			}
		});
		
		exitItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		});
	}
}

			
	
