import java.awt.EventQueue;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class CalculateDepartment {
	public static void main(String[] args)
	{
		
		EventQueue.invokeLater(
				new Runnable()
				{
					public void run()
					{
						CalcFrame frame  = new CalcFrame();
						frame.setTitle("حساب الشقق");
						frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
						frame.setVisible(true);
					}
				}
						
			);
	}
	
	
	
}


class CalcFrame extends JFrame
{
	private static final int DEFAULT_WIDTH = 300;
	private static final int DEFAULT_HEIGHT = 400;
	private JPanel panel;
	private JLabel lblStart;
	private JTextField txtStart;
	private JLabel lblVal;
	private JTextField txtVal;
	private JLabel lblYears;
	private JTextField txtYears;
	private JLabel lblPercent;
	private JTextField txtPercent;
	private JLabel lblResult;
	private JLabel lblResultValue;
	private JButton btnCalc;
	
	
	public CalcFrame ()
	{
		initializeComponents();
	}
	
	private void initializeComponents()
	{
		//init
		this.setSize(DEFAULT_WIDTH,DEFAULT_HEIGHT);
		
		panel = new JPanel(true);
		
		this.add (panel);
		
		lblStart = new JLabel("المقدم");
		panel.add(lblStart);
		txtStart = new JTextField();
		txtStart.setText("25000");
		panel.add(txtStart);
		
		lblVal = new JLabel("القسط");
		panel.add(lblVal);
		txtVal = new JTextField();
		txtVal.setText("1800");
		panel.add(txtVal);
		
		lblYears = new JLabel("السنين");
		panel.add(lblYears);
		txtYears = new JTextField();
		txtYears.setText("15");
		panel.add(txtYears);
		
		lblPercent = new JLabel("النسبة المئوية");
		panel.add(lblPercent);
		txtPercent = new JTextField();
		txtPercent.setText("0.08");
		panel.add(txtPercent);
		
		lblResult = new JLabel("النتيجة");
		panel.add(lblResult);
		lblResultValue = new JLabel();
		
		panel.add(lblResultValue);
		
		btnCalc = new JButton("حساب");
		panel.add(btnCalc);
		
		btnCalc.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int start = Integer.parseInt(txtStart.getText());
				double val = Double.parseDouble(txtVal.getText());
				int years = Integer.parseInt(txtYears.getText());
				double percent = Double.parseDouble(txtPercent.getText());
				
				double res = calc(start,val,years,percent);
				lblResultValue.setText(new Double(res).toString());
			}
			
			
			
		});
		
	}
	
	public double calc(int start,double val,int years,double percentage)
	{
		double ret = start;
		for (int i=0;i<years;i++)
		{
			ret += (val * 12);
			val = val + (val * percentage);
		}
		
		return ret;
		
	}
	
}
