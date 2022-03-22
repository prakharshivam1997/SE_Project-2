package version1;
import java.util.Vector;
import java.io.*;

import java.util.Vector;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;
import version1.ControlDesk;
import java.util.*;
public class drive implements ActionListener {
	private JButton createThings,instructions;
	private  JFrame win;
	private  JLabel patronLabel,laneLabel;
	private JTextField patronField,laneField;
	drive() {
		win = new JFrame("Basic Info");
		win.getContentPane().setLayout(new BorderLayout());
		((JPanel) win.getContentPane()).setOpaque(false);

		JPanel colPanel = new JPanel();
		colPanel.setLayout(new BorderLayout());
		
		JPanel patronPanel = new JPanel();
		patronPanel.setLayout(new GridLayout(3, 1));
		patronPanel.setBorder(new TitledBorder("enter details"));
		
		
		JPanel maxPatronPanel = new JPanel();
		maxPatronPanel.setLayout(new FlowLayout());
		patronLabel = new JLabel("Max Patrons");
		patronField = new JTextField("", 15);
		maxPatronPanel.add(patronLabel);
		maxPatronPanel.add(patronField);
		
		JPanel maxPatronPanel1 = new JPanel();
		maxPatronPanel1.setLayout(new FlowLayout());
		laneLabel = new JLabel("number of lanes:");
		laneField = new JTextField("", 15);
		maxPatronPanel1.add(laneLabel);
		maxPatronPanel1.add(laneField);
		
		patronPanel.add(maxPatronPanel);
		patronPanel.add(maxPatronPanel1);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 1));

		Insets buttonMargin = new Insets(4, 4, 4, 4);

		createThings = new JButton("Create Control Desk");
		JPanel finishedPanel = new JPanel();
		finishedPanel.setLayout(new FlowLayout());
		createThings.addActionListener(this);
		finishedPanel.add(createThings);
		
		instructions = new JButton("Instructions");
		JPanel finishedPanel1 = new JPanel();
		finishedPanel1.setLayout(new FlowLayout());
		instructions.addActionListener(this);
		finishedPanel1.add(instructions);	
		
		
		buttonPanel.add(finishedPanel);
		buttonPanel.add(finishedPanel1);
		
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
		if (e.getSource().equals(createThings)) {
			String lanes = laneField.getText();
			String maxPatrons=patronField.getText(); 
			int numLanes = 3;
			int maxPatronsPerParty = 6;
			try {
			maxPatronsPerParty=Integer.parseInt(maxPatrons);
			numLanes=Integer.parseInt(lanes);
			}
			catch(Exception em) {
					;
			}
			if(maxPatronsPerParty>6) {
				maxPatronsPerParty = 6;
			}
			
			ControlDesk controlDesk = new ControlDesk(numLanes);

			ControlDeskView cdv = new ControlDeskView( controlDesk, maxPatronsPerParty);
			controlDesk.subscribe( cdv );
		}
		else if(e.getSource().equals(instructions)) {
			
			new instructionView();
		}
		
		
		
		
	}
	
	
	
	public static void main(String[] args) {

		new drive();

	}

	
}

