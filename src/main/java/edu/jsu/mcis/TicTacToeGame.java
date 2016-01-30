package edu.jsu.mcis;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToeGame extends JFrame implements ActionListener{

    public TicTacToe game = new TicTacToe();
	
	private JPanel board = new JPanel();
	private JButton[][] location = new JButton[3][3];
    
	public TicTacToeGame() {
        setPreferredSize(new Dimension(300,300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new GridLayout(3,3));
		for(int i = 0; i < 3; i++)
	{
		for(int j = 0; j < 3; j++)
		{
			location[i][j] = new JButton();
			add(location[i][j]);
			location[i][j].addActionListener(this);
			location[i][j].setName("Location" + i + "" + j);
		}
	}
		
		
    }
	
	private void checkForWin()
	{
		char mark = 'a';
		String currentMark = "a";
		final String s;
		if(game.isTheBoardFull() && !game.isThereAWinner())
		{
			s = "TIE";			
		}
		else if(game.isThereAWinner() && game.getCurrentMark(mark, currentMark).equals("X"))
		{
			s = "X";
		}
		else if(game.isThereAWinner() && game.getCurrentMark(mark, currentMark).equals("O"))
		{
			s = "O";
		}
		else{
			s = "";
		}
		if(s.length() > 0){
			new Thread(new Runnable(){
				public void run(){
					JOptionPane.showMessageDialog(null, "The winner is " + s, "Game Over", JOptionPane.INFORMATION_MESSAGE);
				}
		}).start();
		}
	}
	
	public void actionPerformed(ActionEvent event)
	{
		JButton b = (JButton)event.getSource();
		String loc = b.getName().substring(8);
		int row = Integer.parseInt(loc.substring(0, 1));
		int col = Integer.parseInt(loc.substring(1, 2));
		char mark = 'a';
		String currentMark = "a";
		if(game.isSpotAvailable(row,col))
		{
			game.placeMark(row,col);
			b.setText(game.getCurrentMark(mark, currentMark));
		}
		checkForWin();
		if(!game.isTheBoardFull() || !game.isThereAWinner())
		{
			game.changePlayer();
		}
	}
    
    public static void main(String args[]) {
		TicTacToe newGame = new TicTacToe();
       newGame.initializeBoard();
	   TicTacToeGame newBoard = new TicTacToeGame();
	   newBoard.pack();
	   newBoard.setTitle("Tic Tac Toe");
	   newBoard.setVisible(true);
       
    }

    
}