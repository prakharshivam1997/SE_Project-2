package version1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import java.util.*;
import java.text.*;


public class Throwball implements ActionListener{

	
	
	private JFrame win;
	private JButton throwBall;
	private JLabel speedLabel,speeddesc, angleLabel,angledesc, positionLabel,positiondesc;
	private JTextField speedField, angleField, positionField;
	Lane lane;
	
	public Throwball(Lane l) {
		lane = l;
		win = new JFrame("Throw Ball");
		win.getContentPane().setLayout(new BorderLayout());
		((JPanel) win.getContentPane()).setOpaque(false);

		JPanel colPanel = new JPanel();
		colPanel.setLayout(new BorderLayout());
		
		JPanel patronPanel = new JPanel();
		patronPanel.setLayout(new GridLayout(6, 1));
		patronPanel.setBorder(new TitledBorder("throwing params"));
		
		
		
		JPanel nickPanel = new JPanel();
		nickPanel.setLayout(new FlowLayout());
		speedLabel = new JLabel("Speed");
		speedField = new JTextField("", 15);
		nickPanel.add(speedLabel);
		nickPanel.add(speedField);
		
		JPanel speedPanel = new JPanel(); 
		speedPanel.setLayout(new FlowLayout());
		speeddesc = new JLabel("enter a number between 0 and 10 where 10 be the highest");
		speedPanel.add(speeddesc);

		JPanel fullPanel = new JPanel();
		fullPanel.setLayout(new FlowLayout());
		angleLabel = new JLabel("Angle");
		angleField = new JTextField("", 15);
		fullPanel.add(angleLabel);
		fullPanel.add(angleField);
		
		JPanel anglePanel = new JPanel(); 
		anglePanel.setLayout(new FlowLayout());
		angledesc = new JLabel("enter a number between -60 and 60 where -60 be the leftmost");
		anglePanel.add(angledesc);

		JPanel emailPanel = new JPanel();
		emailPanel.setLayout(new FlowLayout());
		positionLabel = new JLabel("Position");
		positionField = new JTextField("", 15);
		emailPanel.add(positionLabel);
		emailPanel.add(positionField);

		JPanel positionPanel = new JPanel(); 
		positionPanel.setLayout(new FlowLayout());
		positiondesc = new JLabel("enter a number between -2 and 2 where -2 be the leftmost");
		positionPanel.add(positiondesc);
		
		patronPanel.add(nickPanel);
		patronPanel.add(speedPanel);
		patronPanel.add(fullPanel);
		patronPanel.add(anglePanel);
		patronPanel.add(emailPanel);
		patronPanel.add(positionPanel);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 1));

		Insets buttonMargin = new Insets(4, 4, 4, 4);

		throwBall = new JButton("Throwball");
		JPanel finishedPanel = new JPanel();
		finishedPanel.setLayout(new FlowLayout());
		throwBall.addActionListener(this);
		finishedPanel.add(throwBall);
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
		return;
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println("Throw the ball");
		try {
			String speed = speedField.getText();
			String angle = angleField.getText();
			String position = positionField.getText();
		
			int sp = Integer.parseInt(speed);
			int an = Integer.parseInt(angle);
			int po = Integer.parseInt(position);
			
			
			
			lane.gaming(sp,an,po);
			win.hide();
		}
		catch (Exception ex) {
			
			int sp = 5;
			int n = 0;
			int p = 0;
			lane.gaming(sp, n, p);
			win.hide();
		}
		
		
	}
	
	
}
