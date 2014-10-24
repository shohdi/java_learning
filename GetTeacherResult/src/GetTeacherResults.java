import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.*;
import java.io.*;
import java.net.*;

import javax.swing.*;

public class GetTeacherResults {
	public static void main(String[] args)
	{
		EventQueue.invokeLater(
				new Runnable()
				{
					public void run()
					{
						GetTeacherResultsFrame frame  = new GetTeacherResultsFrame(new HttpHelperClass());
						frame.setTitle("ارسال المدرسين");
						frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					}
				}
						
			);
	}
}


class GetTeacherResultsFrame extends JFrame
{
	private static final int DEFAULT_WIDTH = 800;
	private static final int DEFAULT_HEIGHT = 600;
	private JPanel pane;
	private GridBagLayout defaultLayout;
	private JLabel lblType;
	private JTextField txtType;
	private JLabel lblID;
	private JTextField txtID;
	private JLabel lblResult;
	private JTextArea txtResult;
	private IHttpHelper _helper;
	private JButton sendButton;
	
	
	public GetTeacherResultsFrame(IHttpHelper helper)
	{
		_helper = helper;
		//init
		this.setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
				
		initializeComponents();
		
		sendButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String result = "";
				Exception foundEx = new Exception();
				while (foundEx != null)
				{
					foundEx = null;
					try
					{
						result = _helper.sendPost("http://30job.moe.gov.eg", "Education="+txtType.getText()+"&NationalID=" + txtID.getText()+ "&FullName=&date_day=&date_month=&date_year=&Submit=" + URLEncoder.encode("(-+","UTF-8"),"");
						if (result.contains("للضغط على الخدمة"))
						{
							throw new Exception ("نظراً للضغط على الخدمة حاول مرة آخرى");
						}
						if (result.contains("Warning: mysql_connect(): No connection"))
						{
							throw new Exception ("Warning: mysql_connect(): No connection");
						}
					}
					catch(Exception ex)
					{
						foundEx = ex;
					    
					}
				}
				
				txtResult.setText(result);
				
			}
			
		});
		
		
	}
	
	private void initializeComponents()
	{
		defaultLayout = new GridBagLayout();
		pane = new JPanel(defaultLayout);
		this.add(pane);
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridheight=1;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.ipadx = 20;
		lblID = new JLabel("الرقم القومي");
		pane.add(lblID,c);
		
		
		c = new GridBagConstraints();
		c.gridheight=1;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 0;
		c.ipadx = 200;
		txtID = new JTextField();
		txtID.setText ("28606061600745");
		pane.add(txtID,c);
		
		
		c = new GridBagConstraints();
		c.gridheight=1;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 1;
		c.ipadx = 40;
		lblType = new JLabel("النوع 1 لمعلم عام , 2 لمعلم فني");
		pane.add(lblType,c);
		
		
		c = new GridBagConstraints();
		c.gridheight=1;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 1;
		c.ipadx = 200;
		txtType = new JTextField();
		txtType.setText("1");
		pane.add(txtType,c);
		
		
		c = new GridBagConstraints();
		c.gridheight=1;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 2;
		c.ipadx = 50;
		sendButton = new JButton("ارسال");
		

		
		pane.add(sendButton,c);
		
		
		c = new GridBagConstraints();
		c.gridheight=1;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy = 3;
		c.ipadx = 50;
		
		lblResult = new JLabel("النتيجة");
	
		pane.add(lblResult,c);
		
		
		c = new GridBagConstraints();
		c.gridheight=1;
		c.gridwidth = 1;
		c.gridx = 1;
		c.gridy = 3;
		c.ipadx = 400;
		c.ipady = 400;
		txtResult = new JTextArea();
	
		pane.add(txtResult,c);
		
		
		
		
		
	}
	
	
	
	
}
