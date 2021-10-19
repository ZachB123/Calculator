import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CalculatorCreator extends JFrame
{
	private JPanel panelField;
	private JPanel keys;
	private JPanel panel;
	
	private JTextField output;
	
	private JButton seven;
	private JButton eight;
	private JButton nine;
	private JButton divide;
	private JButton four;
	private JButton five;
	private JButton six;
	private JButton times;
	private JButton one;
	private JButton two;
	private JButton three;
	private JButton minus;
	private JButton zero;
	private JButton equals1;
	private JButton clear;
	private JButton add;
	
	private ArrayList<String> values = new ArrayList<String>();
	
	private double math(int one, String op, int two)
	{
		if(op.equals("/"))
		{
			return one / two;
		}
		if(op.equals("*"))
		{
			return one * two;
		}
		if(op.equals("-"))
		{
			return one - two;
		}
		if(op.equals("+"))
		{
			return one + two;
		}
		return Integer.MIN_VALUE;
	}
	
	private double math2(double answer, String op, int two)
	{
		if(op.equals("/"))
		{
			return answer / two;
		}
		if(op.equals("*"))
		{
			return answer * two;
		}
		if(op.equals("-"))
		{
			return answer - two;
		}
		if(op.equals("+"))
		{
			return answer + two;
		}
		return Integer.MIN_VALUE;
	}
	
	private void doMath()
	{
		double answer = 0;
		
		try
		{
		ArrayList<Integer> digits = new ArrayList<Integer>();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		ArrayList<String> operators = new ArrayList<String>();
		
		for(int i = 0; i < values.size(); i++)
		{
			
			if(values.get(i).equals("/") || (values.get(i).equals("*")) || (values.get(i).equals("-")) || (values.get(i).equals("+")))
			{
				operators.add(values.get(i));
				digits.add(Integer.MIN_VALUE);
				
			}
			else
			{
			digits.add(Integer.parseInt(values.get(i)));
			}
		}
		int j = 0;
		ArrayList<String> str = new ArrayList<String>();
		str.add("");
		for(int i = 0; i < digits.size(); i++)
		{
			
			
			if(digits.get(i) == Integer.MIN_VALUE)
			{
				j++;
				str.add("");
				
			}
			else
			{
			str.set(j, (str.get(j) + digits.get(i)));
			}
		}
		for(int i = 0; i < str.size(); i++)
		{
			numbers.add(Integer.parseInt(str.get(i)));
		}
		
		for(int i = 0; i < operators.size(); i++)
		{
		if(i == 0)
		answer += math(numbers.get(i), operators.get(i), numbers.get(i + 1));
		else
		{
			answer = math2(answer, operators.get(i), numbers.get(i + 1));
		}
		
		}
		int answero = (int)(answer);
		
		values = new ArrayList<String>();
		values.add(Integer.toString(answero));
		output.setText(arrToString());
		}
		catch(Throwable e)
		{
			output.setText("SYNTAX ERROR:");
			
		}
	}
	
	private String arrToString()
	{
		String result = "";
		for(String word : values)
		{
			result = result + word;
		}
		return result;
	}

	CalculatorCreator()
	{
		createComponents();
		connectButtons();
		addComponents();
		setSize(300, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setName("Calculator");
		setVisible(true);
		setTitle("Calculator");
	}
	
	public void connectButtons()
	{
		ActionListener  sev     = new seven();
		ActionListener eig     = new eight();
		ActionListener nin    = new nine();
		ActionListener div    = new divide();
		ActionListener fou     = new four();
		ActionListener  fiv      = new five();
		ActionListener  si     = new six();
		ActionListener  tim     = new times();
		ActionListener on     = new  one();
		ActionListener tw     = new  two();
		ActionListener thr     = new three();
		ActionListener min     = new minus();
		ActionListener zer     = new zero();
		ActionListener equ     = new equals1();
		ActionListener cle     = new clear();
		ActionListener plu    = new add();
		
	                                     
		seven.addActionListener(     sev      ); 
		eight.addActionListener(    eig       );
		nine.addActionListener(     nin      );  
		divide.addActionListener(   div        );
		four.addActionListener(     fou      );  
		five.addActionListener(      fiv     );  
		six.addActionListener(       si     );   
		times.addActionListener(     tim      ); 
		one.addActionListener(      on      );   
		two.addActionListener(      tw      );   
		three.addActionListener(    thr       ); 
		minus.addActionListener(    min       ); 
		zero.addActionListener(     zer      );  
		equals1.addActionListener(   equ        );
		clear.addActionListener(    cle       ); 
		add.addActionListener(      plu     );   
	}
	
	public void addComponents()
	{
		panel.setLayout(new BorderLayout());
		
		panelField.add(output);
		
		keys.setLayout(new GridLayout(4, 4));
		
		
		keys.add(  seven      );
		keys.add(  eight      );
		keys.add(  nine       );
		keys.add(  divide     );
		keys.add(  four       );
		keys.add(  five       );
		keys.add(  six        );
		keys.add(  times      );
		keys.add(  one        );
		keys.add(  two        );
		keys.add(  three      );
		keys.add(  minus      );
		keys.add(  zero       );
		keys.add(  equals1        );
		keys.add(  clear      );
		keys.add(  add        );
		
		panel.add(panelField, BorderLayout.NORTH);
		panel.add(keys, BorderLayout.CENTER);
		add(panel);
		
		
		
	}
	
	public void createComponents()
	{
		 panelField = new JPanel();        
		 keys = new JPanel(); 
		 panel = new      JPanel(); 
		             
		 output = new     JTextField(20); 
		 output.setEditable(false);
		 output.setHorizontalAlignment(SwingConstants.RIGHT);
		            
		 seven       = new   JButton( "7"            );        
		 eight   = new    JButton( "8"         ); 
		 nine     = new   JButton("9"); 
		 divide    = new     JButton("/"); 
		 four    = new    JButton("4"); 
		 five     = new       JButton("5"); 
		 six       = new  JButton("6"); 
		 times   = new    JButton("x"); 
		 one      = new       JButton("1"); 
		 two       = new  JButton("2"); 
		 three    = new   JButton("3");
		 minus   = new    JButton("-"); 
		 zero    = new    JButton("0"); 
		 equals1       = new     JButton("="); 
		 clear   = new    JButton("CE");
		 add      = new   JButton("+"); 
	}    
	
	private class seven implements ActionListener
	{

		
		public void actionPerformed(ActionEvent e) 
		{
			if(output.getText().equals("SYNTAX ERROR:"))
			{
				values = new ArrayList<String>();
				output.setText(arrToString());
			}
			values.add("7");
			output.setText(arrToString());
			
		}
		
	}
	
	private class eight implements ActionListener
	{

		
		public void actionPerformed(ActionEvent e) 
		{
			if(output.getText().equals("SYNTAX ERROR:"))
			{
				values = new ArrayList<String>();
				output.setText(arrToString());
			}
			values.add("8");
			output.setText(arrToString());
			
		}
		
	}
	
	private class nine implements ActionListener
	{

		
		public void actionPerformed(ActionEvent e) 
		{
			if(output.getText().equals("SYNTAX ERROR:"))
			{
				values = new ArrayList<String>();
				output.setText(arrToString());
			}
			values.add("9");
			output.setText(arrToString());
			
		}
		
	}
	
	private class divide implements ActionListener
	{

		
		public void actionPerformed(ActionEvent e) 
		{
			
			if(output.getText().equals("SYNTAX ERROR:"))
			{
				values = new ArrayList<String>();
				output.setText(arrToString());
			}
			values.add("/");
			output.setText(arrToString());
			
		}
		
	}
	
	private class four implements ActionListener
	{

		
		public void actionPerformed(ActionEvent e) 
		{
			
			if(output.getText().equals("SYNTAX ERROR:"))
			{
				values = new ArrayList<String>();
				output.setText(arrToString());
			}
			values.add("4");
			output.setText(arrToString());
			
		}
		
	}
	
	private class five implements ActionListener
	{

		
		public void actionPerformed(ActionEvent e) 
		{
			
			if(output.getText().equals("SYNTAX ERROR:"))
			{
				values = new ArrayList<String>();
				output.setText(arrToString());
			}
			values.add("5");
			output.setText(arrToString());
			
		}
		
	}
	
	private class six implements ActionListener
	{

		
		public void actionPerformed(ActionEvent e) 
		{
			
			if(output.getText().equals("SYNTAX ERROR:"))
			{
				values = new ArrayList<String>();
				output.setText(arrToString());
			}
			values.add("6");
			output.setText(arrToString());
			
		}
		
	}
	
	private class times implements ActionListener
	{

		
		public void actionPerformed(ActionEvent e) 
		{
			
			if(output.getText().equals("SYNTAX ERROR:"))
			{
				values = new ArrayList<String>();
				output.setText(arrToString());
			}
			values.add("*");
			output.setText(arrToString());
			
		}
		
	}
	
	private class one implements ActionListener
	{

		
		public void actionPerformed(ActionEvent e) 
		{
			
			if(output.getText().equals("SYNTAX ERROR:"))
			{
				values = new ArrayList<String>();
				output.setText(arrToString());
			}
			
			values.add("1");
			output.setText(arrToString());
		}
		
	}
	
	private class two implements ActionListener
	{

		
		public void actionPerformed(ActionEvent e) 
		{
			if(output.getText().equals("SYNTAX ERROR:"))
			{
				values = new ArrayList<String>();
				output.setText(arrToString());
			}
			
			values.add("2");
			output.setText(arrToString());
		}
		
	}
	
	private class three implements ActionListener
	{

		
		public void actionPerformed(ActionEvent e) 
		{
			
			if(output.getText().equals("SYNTAX ERROR:"))
			{
				values = new ArrayList<String>();
				output.setText(arrToString());
			}
			
			values.add("3");
			output.setText(arrToString());
		}
		
	}
	
	private class minus implements ActionListener
	{

		
		public void actionPerformed(ActionEvent e) 
		{
			
			if(output.getText().equals("SYNTAX ERROR:"))
			{
				values = new ArrayList<String>();
				output.setText(arrToString());
			}
			
			values.add("-");
			output.setText(arrToString());
		}
		
	}
	
	private class zero implements ActionListener
	{

		
		public void actionPerformed(ActionEvent e) 
		{
			if(output.getText().equals("SYNTAX ERROR:"))
			{
				values = new ArrayList<String>();
				output.setText(arrToString());
			}
			values.add("0");
			output.setText(arrToString());
			
		}
		
	}
	
	private class equals1 implements ActionListener
	{

		
		public void actionPerformed(ActionEvent e) 
		{
			
			doMath();
		}
		
	}
	
	private class clear implements ActionListener
	{

		
		public void actionPerformed(ActionEvent e) 
		{
			
			values = new ArrayList<String>();
			output.setText(arrToString());
			
		}
		
	}
	
	private class add implements ActionListener
	{

		
		public void actionPerformed(ActionEvent e) 
		{
			if(output.getText().equals("SYNTAX ERROR:"))
			{
				values = new ArrayList<String>();
				output.setText(arrToString());
			}
			values.add("+");
			output.setText(arrToString());
			
		}
		
	}
	
	public static void main(String[] args)
	{
		CalculatorCreator calc = new CalculatorCreator(); 
	}
	
	
	
}
