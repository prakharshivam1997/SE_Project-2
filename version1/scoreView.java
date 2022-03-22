package version1;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

import java.util.*;
import java.text.*;


public class scoreView implements ActionListener,ListSelectionListener {
	
	private JFrame win;
	private JButton topplayer, topscore,leastscore,leastplayer,abort;
	private static String SCOREHISTORY_DAT = "C:\\Users\\Sk Abukhoyer\\eclipse-workspace\\unit2\\src\\SCOREHISTORY.DAT";
	String data,player="",name="";
	int maximum=-1,i,minimum=300;
	JList allBowlers,allBowlers1;
	JLabel scored  = new JLabel(); 
	
	public scoreView() {
		
		win = new JFrame("Queries");
		win.getContentPane().setLayout(new BorderLayout());
		((JPanel) win.getContentPane()).setOpaque(false);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 1));

		Insets buttonMargin = new Insets(4, 4, 4, 4);

		topplayer = new JButton("Best player");
		JPanel topplayerPanel = new JPanel();
		topplayerPanel.setLayout(new FlowLayout());
		topplayer.addActionListener(this);
		topplayerPanel.add(topplayer);
		
		leastplayer = new JButton("worst player");
		JPanel leastplayerPanel = new JPanel();
		leastplayerPanel.setLayout(new FlowLayout());
		leastplayer.addActionListener(this);
		leastplayerPanel.add(leastplayer);

		topscore = new JButton("Highest score of a player");
		JPanel topscorePanel = new JPanel();
		topscorePanel.setLayout(new FlowLayout());
		topscore.addActionListener(this);
		topscorePanel.add(topscore);
		
		leastscore = new JButton("Lowest score of a player");
		JPanel leastscorePanel = new JPanel();
		leastscorePanel.setLayout(new FlowLayout());
		leastscore.addActionListener(this);
		leastscorePanel.add(leastscore);
		
		abort = new JButton("close");
		JPanel abortPanel = new JPanel();
		abortPanel.setLayout(new FlowLayout());
		abort.addActionListener(this);
		abortPanel.add(abort);
		
		
		buttonPanel.add(topplayerPanel);
		buttonPanel.add(leastplayerPanel);
		buttonPanel.add(topscorePanel);
		buttonPanel.add(leastscorePanel);
		buttonPanel.add(abortPanel);
		
		win.getContentPane().add("Center", buttonPanel);

		win.pack();

		// Center Window on Screen
		Dimension screenSize = (Toolkit.getDefaultToolkit()).getScreenSize();
		win.setLocation(
			((screenSize.width) / 2) - ((win.getSize().width) / 2),
			((screenSize.height) / 2) - ((win.getSize().height) / 2));
		win.show();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		// TODO Auto-generated method stub
		
		
		if(e.getSource().equals(topplayer)) {
			try {
				BufferedReader in =
						new BufferedReader(new FileReader(SCOREHISTORY_DAT));
				
			
			
				while((data = in.readLine()) != null) {
					String[] scoredata = data.split("\t");
					i=Integer.parseInt(scoredata[2]);
					if(i>maximum) {
						maximum=i;
						player = scoredata[0];
					}
				}
			}
			catch(Exception ex){
				System.err.println("Error..." + ex);
			}
			JFrame sub; 		
			sub = new JFrame("Best Player");
			sub.getContentPane().setLayout(new BorderLayout());
			((JPanel) sub.getContentPane()).setOpaque(false);
			JPanel colPanel = new JPanel();
			colPanel.setLayout(new GridLayout());
			
			JPanel nickPanel = new JPanel();
			nickPanel.setLayout(new FlowLayout());
			JLabel nickLabel = new JLabel(player);
			nickPanel.add(nickLabel);
			System.out.println(player);
			
			JPanel emailPanel = new JPanel();
			emailPanel.setLayout(new FlowLayout());
			JLabel emailLabel = new JLabel(Integer.toString(maximum));
			emailPanel.add(emailLabel);
			
	
			JPanel images = new JPanel(); 
			images.setLayout(new FlowLayout());
			JLabel imageLabel = new JLabel(new ImageIcon("/images/congo.gif"));
			images.add(imageLabel);
			
			colPanel.add(nickPanel);
			//colPanel.add(fullPanel);
			colPanel.add(emailPanel);
			colPanel.add(images);
			
			sub.getContentPane().add("Center", colPanel);
			
	

			sub.pack();

			// Center Window on Screen
			Dimension screenSize = (Toolkit.getDefaultToolkit()).getScreenSize();
			sub.setLocation(
				((screenSize.width) / 2) - ((win.getSize().width) / 2),
				((screenSize.height) / 2) - ((win.getSize().height) / 2));
			sub.show();
			
			
		}
		if(e.getSource().equals(leastplayer)) {
				try {
					BufferedReader in =
							new BufferedReader(new FileReader(SCOREHISTORY_DAT));
					
				
				
					while((data = in.readLine()) != null) {
						String[] scoredata = data.split("\t");
						i=Integer.parseInt(scoredata[2]);
						if(i<minimum) {
							minimum=i;
							player = scoredata[0];
						}
					}
				}
				catch(Exception ex){
					System.err.println("Error..." + ex);
				}
				JFrame sub; 		
				sub = new JFrame("Worst Player");
				sub.getContentPane().setLayout(new BorderLayout());
				((JPanel) sub.getContentPane()).setOpaque(false);
				JPanel colPanel = new JPanel();
				colPanel.setLayout(new GridLayout());
				
				JPanel nickPanel = new JPanel();
				nickPanel.setLayout(new FlowLayout());
				JLabel nickLabel = new JLabel(player);
				nickPanel.add(nickLabel);
				System.out.println(player);
				
				JPanel emailPanel = new JPanel();
				emailPanel.setLayout(new FlowLayout());
				JLabel emailLabel = new JLabel(Integer.toString(minimum));
				emailPanel.add(emailLabel);
				
		
				JPanel images = new JPanel(); 
				images.setLayout(new FlowLayout());
				JLabel imageLabel = new JLabel(new ImageIcon("/images/booing.jpeg"));
				images.add(imageLabel);
				
				colPanel.add(nickPanel);
				//colPanel.add(fullPanel);
				colPanel.add(emailPanel);
				colPanel.add(images);
				
				sub.getContentPane().add("Center", colPanel);
				
		

				sub.pack();

				// Center Window on Screen
				Dimension screenSize = (Toolkit.getDefaultToolkit()).getScreenSize();
				sub.setLocation(
					((screenSize.width) / 2) - ((win.getSize().width) / 2),
					((screenSize.height) / 2) - ((win.getSize().height) / 2));
				sub.show();
		}
		if(e.getSource().equals(topscore)) {
			
			JFrame sub; 		
			sub = new JFrame("Players Top Scores");
			sub.getContentPane().setLayout(new BorderLayout());
			((JPanel) sub.getContentPane()).setOpaque(false);
			
			JPanel colPanel = new JPanel();
			colPanel.setLayout(new GridLayout(1, 3));
			
			
			
			JPanel bowlerPanel = new JPanel();
			bowlerPanel.setLayout(new FlowLayout());
			bowlerPanel.setBorder(new TitledBorder("Bowler Database"));
			Vector bowlerdb;
			
			try {
				bowlerdb = new Vector(BowlerFile.getBowlers());
			} catch (Exception ex) {
				System.err.println("File Error");
				bowlerdb = new Vector();
			}
			allBowlers = new JList(bowlerdb);
			allBowlers.setVisibleRowCount(8);
			allBowlers.setFixedCellWidth(120);
			JScrollPane bowlerPane = new JScrollPane(allBowlers);
			bowlerPane.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			allBowlers.addListSelectionListener(this);
			bowlerPanel.add(bowlerPane);
			
			
			JPanel scoredPanel = new JPanel();
			scoredPanel.add(scored);
			
			colPanel.add(bowlerPanel);
			colPanel.add(scoredPanel);
			sub.getContentPane().add("Center", colPanel);

			sub.pack();

			// Center Window on Screen
			Dimension screenSize = (Toolkit.getDefaultToolkit()).getScreenSize();
			sub.setLocation(
				((screenSize.width) / 2) - ((win.getSize().width) / 2),
				((screenSize.height) / 2) - ((win.getSize().height) / 2));
			sub.show();
				
			
			
		}
		if(e.getSource().equals(leastscore)) {
			JFrame sub; 		
			sub = new JFrame("Players least Scores");
			sub.getContentPane().setLayout(new BorderLayout());
			((JPanel) sub.getContentPane()).setOpaque(false);
			
			JPanel colPanel = new JPanel();
			colPanel.setLayout(new GridLayout(1, 3));
			
			
			
			JPanel bowlerPanel = new JPanel();
			bowlerPanel.setLayout(new FlowLayout());
			bowlerPanel.setBorder(new TitledBorder("Bowler Database"));
			Vector bowlerdb;
			
			try {
				bowlerdb = new Vector(BowlerFile.getBowlers());
			} catch (Exception ex) {
				System.err.println("File Error");
				bowlerdb = new Vector();
			}
			allBowlers1 = new JList(bowlerdb);
			allBowlers1.setVisibleRowCount(8);
			allBowlers1.setFixedCellWidth(120);
			JScrollPane bowlerPane = new JScrollPane(allBowlers1);
			bowlerPane.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			allBowlers1.addListSelectionListener(this);
			bowlerPanel.add(bowlerPane);
			
			
			JPanel scoredPanel = new JPanel();
			scoredPanel.add(scored);
			
			colPanel.add(bowlerPanel);
			colPanel.add(scoredPanel);
			sub.getContentPane().add("Center", colPanel);

			sub.pack();

			// Center Window on Screen
			Dimension screenSize = (Toolkit.getDefaultToolkit()).getScreenSize();
			sub.setLocation(
				((screenSize.width) / 2) - ((win.getSize().width) / 2),
				((screenSize.height) / 2) - ((win.getSize().height) / 2));
			sub.show();
				
			
		}
		if(e.getSource().equals(abort)) {
			win.hide();
		}
		
	
		
		
	}
	
	

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(allBowlers)) {
			player =
				((String) ((JList) e.getSource()).getSelectedValue());
			try {
				BufferedReader in =
						new BufferedReader(new FileReader(SCOREHISTORY_DAT));
				
			
			
				while((data = in.readLine()) != null) {
					String[] scoredata = data.split("\t");
					i=Integer.parseInt(scoredata[2]);
					if(i>maximum && player.equals(scoredata[0])) {
						maximum=i;
					}
				}
			}
			catch(Exception ex){
				System.err.println("Error..." + ex);
			}
		scored.setText(Integer.toString(maximum));
		maximum=-1;
		}
		if (e.getSource().equals(allBowlers1)) {
			player =
				((String) ((JList) e.getSource()).getSelectedValue());
			try {
				BufferedReader in =
						new BufferedReader(new FileReader(SCOREHISTORY_DAT));
				
			
			
				while((data = in.readLine()) != null) {
					String[] scoredata = data.split("\t");
					i=Integer.parseInt(scoredata[2]);
					if(i<minimum && player.equals(scoredata[0])) {
						minimum=i;
					}
				}
			}
			catch(Exception ex){
				System.err.println("Error..." + ex);
			}
		scored.setText(Integer.toString(minimum));
		minimum=300;
		}
	}

}
