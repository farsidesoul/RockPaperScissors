package rockpaperscissors;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
import javax.swing.ImageIcon;
import javax.swing.border.*;

public class RPS extends JFrame {
	// Set width and height for window
	public static final int WIDTH = 400;
	public static final int HEIGHT = 300;

	private JLabel fillerL, fillerL2, fillerL3, fillerL4, fillerL5, fillerL6;
	private JLabel winnerL, winnerL2, computerL;
	private JButton rockB, paperB, scissorsB, lizardB, spockB;
	private JButton playAgainB, exitB;
	
	Border emptyBorder = BorderFactory.createEmptyBorder();

	public int playerSelection = 3;
	
	ImageIcon rockImage = new ImageIcon("Images/rock.png");
	ImageIcon paperImage = new ImageIcon("Images/paper.png");
	ImageIcon scissorsImage = new ImageIcon("Images/scissors.png");
	ImageIcon lizardImage = new ImageIcon("Images/lizard.png");
	ImageIcon spockImage = new ImageIcon("Images/spock.png");

	private RockButtonHandler rbHandler;
	private PaperButtonHandler pbHandler;
	private ScissorsButtonHandler sbHandler;
	private LizardButtonHandler lbHandler;
	private SpockButtonHandler spHandler;
	private PlayAgainButtonHandler abHandler;
	private ExitButtonHandler ebHandler;

	public RPS() {
		// Instantiate the filler labels
		fillerL = new JLabel("", SwingConstants.CENTER);
		fillerL2 = new JLabel("", SwingConstants.CENTER);
		fillerL3 = new JLabel("", SwingConstants.CENTER);
		fillerL4 = new JLabel("", SwingConstants.CENTER);
		fillerL5 = new JLabel("", SwingConstants.CENTER);
		fillerL6 = new JLabel("", SwingConstants.CENTER);
		winnerL = new JLabel("Winner: ", SwingConstants.RIGHT);
		winnerL.setFont(new Font("Ariel", Font.PLAIN, 26));
		winnerL.setForeground(new Color(255, 255, 255));
		winnerL2 = new JLabel("", SwingConstants.LEFT);
		winnerL2.setForeground(new Color(255, 255, 255));
		winnerL2.setFont(new Font("Ariel", Font.PLAIN, 26));
		computerL = new JLabel("", SwingConstants.CENTER);
		computerL.setForeground(new Color(255, 255, 255));

		// Set Buttons and their Action Listeners
		rockB = new JButton("Rock", rockImage);
		rockB.setBackground(new Color(0, 46, 79));
		rockB.setForeground(new Color(255, 255, 255));
		rockB.setFocusPainted(false);
		rockB.setBorderPainted(false);
		rbHandler = new RockButtonHandler();
		rockB.addActionListener(rbHandler);
		
		paperB = new JButton("Paper", paperImage);
		paperB.setBackground(new Color(0, 46, 79));
		paperB.setForeground(new Color(255, 255, 255));
		paperB.setFocusPainted(false);
		paperB.setBorderPainted(false);
		pbHandler = new PaperButtonHandler();
		paperB.addActionListener(pbHandler);

		scissorsB = new JButton("Scissors", scissorsImage);
		scissorsB.setBackground(new Color(0, 46, 79));
		scissorsB.setForeground(new Color(255, 255, 255));
		scissorsB.setFocusPainted(false);
		scissorsB.setBorderPainted(false);
		sbHandler = new ScissorsButtonHandler();
		scissorsB.addActionListener(sbHandler);

		lizardB = new JButton("Lizard", lizardImage);
		lizardB.setBackground(new Color(0, 46, 79));
		lizardB.setForeground(new Color(255, 255, 255));
		lizardB.setFocusPainted(false);
		lizardB.setBorderPainted(false);
		lbHandler = new LizardButtonHandler();
		lizardB.addActionListener(lbHandler);
		
	    spockB = new JButton("Spock", spockImage);
		spockB.setBackground(new Color(0, 46, 79));
		spockB.setForeground(new Color(255, 255, 255));
		spockB.setFocusPainted(false);
		spockB.setBorderPainted(false);
		spHandler = new SpockButtonHandler();
		spockB.addActionListener(spHandler);
		
		playAgainB = new JButton("Play Again?");
		abHandler = new PlayAgainButtonHandler();
		playAgainB.addActionListener(abHandler);

		exitB = new JButton("Exit");
		ebHandler = new ExitButtonHandler();
		exitB.addActionListener(ebHandler);

		// Set Window
		setTitle("Rock, Paper, Scissors, Lizard, Spock");
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(7, 2));

		// Add items to the board
		pane.add(rockB);
		pane.add(fillerL);
		pane.add(paperB);
		pane.add(fillerL2);
		pane.add(scissorsB);
		pane.add(computerL);
		pane.add(lizardB);
		pane.add(fillerL3);
		pane.add(spockB);
		pane.add(fillerL4);
		pane.add(winnerL);
		pane.add(winnerL2);
		pane.add(playAgainB);
		pane.add(exitB);

		// Other panel options
		setSize(WIDTH, HEIGHT);
		setLocationRelativeTo(null);
		setVisible(true);
		pane.setBackground(new Color(0, 46, 79));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public int cpuSelection() {
		Random rand = new Random();

		int selection = rand.nextInt((5 - 1) + 1);
		
		switch (selection){
		case 0:
			computerL.setIcon(rockImage);
			computerL.setText("Rock");
			break;
		case 1:
			computerL.setIcon(paperImage);
			computerL.setText("Paper");
			break;
		case 2:
			computerL.setIcon(scissorsImage);
			computerL.setText("Scissors");
			break;
		case 3:
			computerL.setIcon(lizardImage);
			computerL.setText("Lizard");
			break;
		case 4:
			computerL.setIcon(spockImage);
			computerL.setText("Spock");
			break;
		}

		return selection;
	}

	public void playerChoice(int n) {
		switch (n) {
		case 0:
			playerSelection = 0;
			rockB.removeActionListener(rbHandler);
			paperB.setEnabled(false);
			scissorsB.setEnabled(false);
			lizardB.setEnabled(false);
			spockB.setEnabled(false);
			break;

		case 1:
			playerSelection = 1;
			paperB.removeActionListener(pbHandler);
			rockB.setEnabled(false);
			scissorsB.setEnabled(false);
			lizardB.setEnabled(false);
			spockB.setEnabled(false);
			break;

		case 2:
			playerSelection = 2;
			scissorsB.removeActionListener(sbHandler);
			rockB.setEnabled(false);
			paperB.setEnabled(false);
			lizardB.setEnabled(false);
			spockB.setEnabled(false);
			break;
			
		case 3:
			playerSelection = 3;
			lizardB.removeActionListener(lbHandler);
			rockB.setEnabled(false);
			paperB.setEnabled(false);
			scissorsB.setEnabled(false);
			spockB.setEnabled(false);
			break;
			
		case 4:
			playerSelection = 4;
			spockB.removeActionListener(spHandler);
			rockB.setEnabled(false);
			paperB.setEnabled(false);
			scissorsB.setEnabled(false);
			lizardB.setEnabled(false);
			break;

		}
	}

	private class RockButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			playerChoice(0);
			int cpu = cpuSelection();

			switch (cpu) {
			case 0:
				winnerL2.setText("Draw!");
				break;

			case 1:
				winnerL2.setText("CPU wins!");
				winnerL.setForeground(new Color(255, 50, 50));
				winnerL2.setForeground(new Color(255, 50, 50));
				break;

			case 2:
				winnerL2.setText("You win!");
				winnerL.setForeground(new Color(154, 205, 50));
				winnerL2.setForeground(new Color(154, 205, 50));
				break;
				
			case 3:
				winnerL2.setText("You win!");
				winnerL.setForeground(new Color(154, 205, 50));
				winnerL2.setForeground(new Color(154, 205, 50));
				break;
				
			case 4:
				winnerL2.setText("CPU wins!");
				winnerL.setForeground(new Color(255, 50, 50));
				winnerL2.setForeground(new Color(255, 50, 50));
				break;
			}
		}
	}

	private class PaperButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			playerChoice(1);
			int cpu = cpuSelection();

			switch (cpu) {
			case 0:
				winnerL2.setText("You win!");
				winnerL.setForeground(new Color(154, 205, 50));
				winnerL2.setForeground(new Color(154, 205, 50));
				break;

			case 1:
				winnerL2.setText("Draw!");
				break;

			case 2:
				winnerL2.setText("CPU wins!");
				winnerL.setForeground(new Color(255, 50, 50));
				winnerL2.setForeground(new Color(255, 50, 50));
				break;
				
			case 3:
				winnerL2.setText("CPU wins!");
				winnerL.setForeground(new Color(154, 205, 50));
				winnerL2.setForeground(new Color(154, 205, 50));
				break;
				
			case 4:
				winnerL2.setText("You win!");
				winnerL.setForeground(new Color(255, 50, 50));
				winnerL2.setForeground(new Color(255, 50, 50));
				break;
			}
		}
	}

	private class ScissorsButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			playerChoice(2);
			int cpu = cpuSelection();

			switch (cpu) {
			case 0:
				winnerL2.setText("CPU wins!");
				winnerL.setForeground(new Color(255, 50, 50));
				winnerL2.setForeground(new Color(255, 50, 50));
				break;

			case 1:
				winnerL2.setText("You win!");
				winnerL.setForeground(new Color(154, 205, 50));
				winnerL2.setForeground(new Color(154, 205, 50));
				break;

			case 2:
				winnerL2.setText("Draw!");
				break;
				
			case 3:
				winnerL2.setText("You win!");
				winnerL.setForeground(new Color(154, 205, 50));
				winnerL2.setForeground(new Color(154, 205, 50));
				break;
				
			case 4:
				winnerL2.setText("CPU wins!");
				winnerL.setForeground(new Color(255, 50, 50));
				winnerL2.setForeground(new Color(255, 50, 50));
				break;
			}
		}
	}
	
	private class LizardButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			playerChoice(3);
			int cpu = cpuSelection();

			switch (cpu) {
			case 0:
				winnerL2.setText("CPU Wins!");
				winnerL.setForeground(new Color(255, 50, 50));
				winnerL2.setForeground(new Color(255, 50, 50));
				break;

			case 1:
				winnerL2.setText("You win!");
				winnerL.setForeground(new Color(154, 205, 50));
				winnerL2.setForeground(new Color(154, 205, 50));
				break;

			case 2:
				winnerL2.setText("CPU wins!");
				winnerL.setForeground(new Color(255, 50, 50));
				winnerL2.setForeground(new Color(255, 50, 50));
				break;
				
			case 3:
				winnerL2.setText("Draw!");
				break;
				
			case 4:
				winnerL2.setText("You win!");
				winnerL.setForeground(new Color(154, 205, 50));
				winnerL2.setForeground(new Color(154, 205, 50));
				break;
			}
		}
	}
	
	private class SpockButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			playerChoice(4);
			int cpu = cpuSelection();

			switch (cpu) {
			case 0:
				winnerL2.setText("You win!");
				winnerL.setForeground(new Color(154, 205, 50));
				winnerL2.setForeground(new Color(154, 205, 50));
				break;

			case 1:
				winnerL2.setText("CPU wins!");
				winnerL.setForeground(new Color(255, 50, 50));
				winnerL2.setForeground(new Color(255, 50, 50));
				break;

			case 2:
				winnerL2.setText("You win!");
				winnerL.setForeground(new Color(154, 205, 50));
				winnerL2.setForeground(new Color(154, 205, 50));
				break;
				
			case 3:
				winnerL2.setText("CPU wins!");
				winnerL.setForeground(new Color(255, 50, 50));
				winnerL2.setForeground(new Color(255, 50, 50));
				break;
				
			case 4:
				winnerL2.setText("Draw!");
				break;
			}
		}
	}

	private class PlayAgainButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			RPS rps = new RPS();
		}
	}

	public class ExitButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		RPS rps = new RPS();

	}

}
