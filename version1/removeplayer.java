package version1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import java.util.*;
import java.text.*;

public class removeplayer implements ActionListener{
	private int maxSize;

	private JFrame win;
	private boolean done;
	private JButton abort, finished;
	private JLabel nickLabel;
	private JTextField nickField;
	private String nick;
	private AddPartyView addParty;

	public removeplayer(AddPartyView v) {
		addParty=v;	
		done = false;

		win = new JFrame("Remove Patron");
		win.getContentPane().setLayout(new BorderLayout());
		((JPanel) win.getContentPane()).setOpaque(false);
		
		JPanel colPanel = new JPanel();
		colPanel.setLayout(new BorderLayout());
		
		JPanel patronPanel = new JPanel();
		patronPanel.setLayout(new GridLayout(3, 1));
		patronPanel.setBorder(new TitledBorder("Info"));
		
		JPanel nickPanel = new JPanel();
		nickPanel.setLayout(new FlowLayout());
		nickLabel = new JLabel("Nick Name");
		nickField = new JTextField("", 15);
		nickPanel.add(nickLabel);
		nickPanel.add(nickField);
		
		patronPanel.add(nickPanel);
		// Button Panel
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 1));

		Insets buttonMargin = new Insets(4, 4, 4, 4);

		finished = new JButton("Remove Patron");
		JPanel finishedPanel = new JPanel();
		finishedPanel.setLayout(new FlowLayout());
		finished.addActionListener(this);
		finishedPanel.add(finished);

		abort = new JButton("Abort");
		JPanel abortPanel = new JPanel();
		abortPanel.setLayout(new FlowLayout());
		abort.addActionListener(this);
		abortPanel.add(abort);

		buttonPanel.add(abortPanel);
		buttonPanel.add(finishedPanel);

		// Clean up main panel
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
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(abort)) {
			done = true;
			win.hide();
		}

		if (e.getSource().equals(finished)) {
			nick = nickField.getText();
			done = true;
			addParty.removePatron( this );
			win.hide();
		}
		
	}
	
	public boolean done() {
		return done;
	}

	public String getNick() {
		return nick;
	}

	
	
	
}
