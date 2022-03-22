package version1;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.lang.Thread;

public class TieBreakGame implements ActionListener {

	private int roll;
	private boolean initDone = true;

	JFrame frame;
	Container cpanel;
	Bowler first,second;
	public int highestScore,secondHighest;
	int cur;
	Iterator bowlIt;

	JPanel[][] balls;
	JLabel[][] ballLabel;
	JPanel[][] scores;
	JLabel[][] scoreLabel;
	JLabel[][] emojiLabel;
	JPanel[][] ballGrid;
	JPanel[] pins;

	JButton maintenance;
	Lane lane;

	public TieBreakGame(Bowler b1, Bowler b2, int highest, int secondHighest) {
		first = b1;
		second = b2;
		this.highestScore = highest;
		this.secondHighest = secondHighest;
		
		initDone = true;
		frame = new JFrame("Tie break game:");
		cpanel = frame.getContentPane();
		cpanel.setLayout(new BorderLayout());

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				frame.hide();
			}
		});

		cpanel.add(new JPanel());

	}

	public void show() {
		frame.show();
	}

	public void hide() {
		frame.hide();
	}

	private JPanel makeFrame() {

		initDone = false;
		
		int numBowlers =2;

		JPanel panel = new JPanel();

		panel.setLayout(new GridLayout(0, 1));

		balls = new JPanel[numBowlers][8];
		ballLabel = new JLabel[numBowlers][8];
		scores = new JPanel[numBowlers][4];
		scoreLabel = new JLabel[numBowlers][4];
		emojiLabel = new JLabel[numBowlers][4];
		ballGrid = new JPanel[numBowlers][4];
		pins = new JPanel[numBowlers];

		for (int i = 0; i != numBowlers; i++) {
			for (int j = 0; j != 8; j++) {
				ballLabel[i][j] = new JLabel(" ");
				balls[i][j] = new JPanel();
				balls[i][j].setBorder(
					BorderFactory.createLineBorder(Color.BLACK));
				balls[i][j].add(ballLabel[i][j]);
			}
		}

		for (int i = 0; i != numBowlers; i++) {
			for (int j = 0; j != 4; j++) {
				ballGrid[i][j] = new JPanel();
				ballGrid[i][j].setLayout(new GridLayout(0, 3));
				ballGrid[i][j].add(new JLabel("  "), BorderLayout.EAST);
				ballGrid[i][j].add(balls[i][2 * j], BorderLayout.EAST);
				ballGrid[i][j].add(balls[i][2 * j + 1], BorderLayout.EAST);
			}
			
		}
		Bowler bl = second;
		for (int i = 0; i != numBowlers; i++) {
			pins[i] = new JPanel();
			pins[i].setBorder(BorderFactory.createTitledBorder((bl).getNickName()));
			pins[i].setLayout(new GridLayout(0, 4));
			for (int k = 0; k != 4; k++) {
				scores[i][k] = new JPanel();
				scoreLabel[i][k] = new JLabel("  ", SwingConstants.CENTER);
				emojiLabel[i][k] = new JLabel("  ", SwingConstants.CENTER);
				scores[i][k].setBorder(BorderFactory.createLineBorder(Color.BLACK));
				scores[i][k].setLayout(new GridLayout(0, 1));
				scores[i][k].add(ballGrid[i][k], BorderLayout.EAST);
				scores[i][k].add(scoreLabel[i][k], BorderLayout.SOUTH);
				scores[i][k].add(emojiLabel[i][k], BorderLayout.NORTH);
				pins[i].add(scores[i][k], BorderLayout.EAST);
			}
			panel.add(pins[i]);
			bl = first;
		}

		initDone = true;
		return panel;
	}

	public int duplicateGame() {
	
			System.out.println("Making the frame.");
			cpanel.removeAll();
			cpanel.add(makeFrame(), "Center");
			// Button Panel
			JPanel buttonPanel = new JPanel();
			buttonPanel.setLayout(new FlowLayout());

			Insets buttonMargin = new Insets(4, 4, 4, 4);

			maintenance = new JButton("Maintenance Call");
			JPanel maintenancePanel = new JPanel();
			maintenancePanel.setLayout(new FlowLayout());
			maintenance.addActionListener(this);
			maintenancePanel.add(maintenance);

			buttonPanel.add(maintenancePanel);

			cpanel.add(buttonPanel, "South");

			frame.pack();

			show();	

			int[][] lescores = {{9,20,10,7},{0,9,19,9}};
			char[][] ballscores = {{'4','5','X',' ','6','/','5','2'},{'-','-','7','2','X',' ','6','3'}};
			int prev = secondHighest;
//			System.out.println(prev);
			for (int i = 0; i <= 3; i++) {
				for (int k = 0; k < 2; k++) {
					ballLabel[k][2*i].setText(Character.toString(ballscores[k][2*i]));
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ballLabel[k][2*i+1].setText(Character.toString(ballscores[k][2*i+1]));
					int temp = prev+lescores[k][i];
//					System.out.println(temp);
					scoreLabel[k][i].setText((new Integer(temp)).toString());
					int frame_score = 0;
					if(i==0){
						frame_score = lescores[k][i];
					}
					else {
						frame_score = lescores[k][i] - lescores[k][i-1];
					}
					java.net.URL imgURL ;
					if(frame_score >= 10) {
						imgURL = LaneView.class.getResource("/images/very.gif");
						
					}
					else if(frame_score == 0) {
						imgURL = LaneView.class.getResource("/images/cry.gif");
					}
					else if(frame_score>=7) {
						imgURL = LaneView.class.getResource("/images/smile.gif");

					}
					else {
						imgURL = LaneView.class.getResource("/images/sad.gif");
					}
					ImageIcon imgIcon ;
				      if (imgURL != null) {
				        imgIcon =  new ImageIcon(imgURL, "java");
				      } else {            
				         System.err.println("Couldn't find file: ");
				         continue;
				      }
					emojiLabel[k][i].setIcon(imgIcon);
					if(k==0) {
						secondHighest += lescores[k][i];
						prev = highestScore;

					}
					else {
						highestScore += lescores[k][i];
						prev = secondHighest;

					}
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//					System.out.println(secondHighest+" "+ highestScore);
					if(i==0 && k==0 && secondHighest<highestScore) {
						return 0;
					}
			
			}
				
			}

			return 1;
				
			
}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(maintenance)) {
			//lane.pauseGame();
			lane.gameIsHalted = true;
			lane.publish(lane.lanePublish());
		}
	}

}
