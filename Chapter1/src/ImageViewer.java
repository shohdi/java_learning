import java.awt.EventQueue;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


/**
* @version 1.0 4/10/2014
* @author shohdi elsheemy
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
					JFrame frame = new ImageViewerFrame();
					frame.setTitle("ImageViewer");
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				}
			}
		);
	}
	
	
	
/**
* this frame for view images
*/
public class ImageViewerFrame extends JFrame
{
	private JLabel label;
	private JFileChooser chooser;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 400;
	public ImageViewerFrame()
	{
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		label = new JLable();
		add(label);
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		JMenuBar menuBar = new JMenuBar ();
		setJMenuBar (menuBar);
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		JMenuItem openItem = new JMenuItem("Open");
		menu.add(openItem);
		openItem.addActionListener(
			new ActionListener()
			{
				
			}
		);
		
	}
}
	
	
	
}
