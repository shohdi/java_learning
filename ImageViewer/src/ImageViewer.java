import java.awt.EventQueue;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
/**
 * A program for viewing images.
 * @version 1.22 2007-05-21
 * @author Cay Horstmann
 *
 */
public class ImageViewer {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				// TODO Auto-generated method stub
				JFrame frame = new ImageViewerFrame();
			}
			
		});
		// TODO Auto-generated method stub

	}

}

class ImageViewerFrame extends JFrame
{
	private JLabel label;
	private JFileChooser chooser;
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 400;
	private JMenuBar menuBar;
	private JMenu menu ;
	public ImageViewerFrame()
	{
		setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		//use a label to display the images
		label = new JLabel();
		add(label);
		//set up  the file chooser
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		//set up the menu bar
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		menu = new JMenu("File");
		menuBar.add(menu);
	}
}
