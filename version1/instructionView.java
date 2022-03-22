package version1;

import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

public class instructionView implements ActionListener{
	private JButton close;
	private  JFrame win;
	private  JLabel first,second,third,fourth;

	instructionView(){
		win = new JFrame("INSTRUCTIONS");
		win.getContentPane().setLayout(new BorderLayout());
		((JPanel) win.getContentPane()).setOpaque(false);

		JPanel colPanel = new JPanel();
		colPanel.setLayout(new BorderLayout());
		
		
		JPanel patronPanel = new JPanel();
		patronPanel.setLayout(new GridLayout(5, 1));
		patronPanel.setBorder(new TitledBorder("instructions"));
		
		
		JPanel maxPatronPanel1 = new JPanel();
		maxPatronPanel1.setLayout(new FlowLayout());
		first = new JLabel("1. Decide the maxpatron and then create the control desk ,if not given default six will be there");
		maxPatronPanel1.add(first);
		
		JPanel maxPatronPanel2 = new JPanel();
		maxPatronPanel2.setLayout(new FlowLayout());
		second = new JLabel("2. Add the party to start the game");
		maxPatronPanel2.add(second);
		
		JPanel maxPatronPanel3 = new JPanel();
		maxPatronPanel3.setLayout(new FlowLayout());
		third = new JLabel("3.  we can set the speed and angle, position in ViewLane to throw the ball and get scores");
		maxPatronPanel3.add(third);
		
		JPanel maxPatronPanel4 = new JPanel();
		maxPatronPanel4.setLayout(new FlowLayout());
		fourth = new JLabel("4.We can end the controdesk using Finish option in ControlDesk");
		maxPatronPanel4.add(fourth);
		
		patronPanel.add(maxPatronPanel1);
		patronPanel.add(maxPatronPanel2);
		patronPanel.add(maxPatronPanel3);
		patronPanel.add(maxPatronPanel4);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 1));

		Insets buttonMargin = new Insets(4, 4, 4, 4);

		close = new JButton("close");
		JPanel finishedPanel = new JPanel();
		finishedPanel.setLayout(new FlowLayout());
		close.addActionListener(this);
		finishedPanel.add(close);
		
		buttonPanel.add(finishedPanel);
		colPanel.add(patronPanel, "Center");
		colPanel.add(buttonPanel, "East");

		win.getContentPane().add("Center", colPanel);

		win.pack();

		// Center Window on Screen
		Dimension screenSize = (Toolkit.getDefaultToolkit()).getScreenSize();
		win.setLocation(
			((screenSize.width) / 2) - ((win.getSize().width) / 2),
			((screenSize.height) / 2) - ((win.getSize().height) / 2));
		win.show();
		
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(close)) {
			win.hide();
		}
		
		
	}

}
