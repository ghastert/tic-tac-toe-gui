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
		JOptionPane p = new JOptionPane();
		char mark = 'a';
		String currentMark = "a";
		if(game.isTheBoardFull() && !game.isThereAWinner())
		{
			p.showMessageDialog(this, "The winner is TIE", "Game Over", JOptionPane.PLAIN_MESSAGE);
		}
		else if(game.isThereAWinner() && game.getCurrentMark(mark, currentMark).equals("X"))
		{
			p.showMessageDialog(this, "The winner is X", "Game Over", JOptionPane.PLAIN_MESSAGE);
		}
		else if(game.isThereAWinner() && game.getCurrentMark(mark, currentMark).equals("O"))
		{
			p.showMessageDialog(this, "The winner is O", "Game Over", JOptionPane.PLAIN_MESSAGE);
		}
		else game.changePlayer();
	}
	
	public void actionPerformed(ActionEvent event)
	{
		event.getSource();
		if(event.getSource() == location[0][0])
		{
			char mark = 'a';
			String currentMark = "a";
			if(game.isSpotAvailable(0,0)){
				game.placeMark(0,0);
				location[0][0].setText(game.getCurrentMark(mark, currentMark));
			}
			checkForWin();
			
		}
		else if(event.getSource() == location[0][1])
		{
			char mark = 'a';
			String currentMark = "a";
			if(game.isSpotAvailable(0,1)){
				game.placeMark(0,1);
				location[0][1].setText(game.getCurrentMark(mark, currentMark));
			}
			checkForWin();
		}
		else if(event.getSource() == location[0][2])
		{
			char mark = 'a';
			String currentMark = "a";
			if(game.isSpotAvailable(0,2)){ 
				game.placeMark(0,2);
				location[0][2].setText(game.getCurrentMark(mark, currentMark));
			}
			checkForWin();
		}
		else if(event.getSource() == location[1][0])
		{
			char mark = 'a';
			String currentMark = "a";
			if(game.isSpotAvailable(1,0))
			{
				game.placeMark(1,0);
				location[1][0].setText(game.getCurrentMark(mark, currentMark));
			}
			checkForWin();
		}
		else if(event.getSource() == location[1][1])
		{
			char mark = 'a';
			String currentMark = "a";
			if(game.isSpotAvailable(1,1)) 
			{
				game.placeMark(1,1);
				location[1][1].setText(game.getCurrentMark(mark,currentMark));
			}
			checkForWin();
		}
		else if(event.getSource() == location[1][2])
		{
			char mark = 'a';
			String currentMark = "a";
			if(game.isSpotAvailable(1,2)){
				game.placeMark(1,2);
				location[1][2].setText(game.getCurrentMark(mark, currentMark));
			}
			checkForWin();
		}
		else if(event.getSource() == location[2][0])
		{
			char mark = 'a';
			String currentMark = "a";
			if(game.isSpotAvailable(2,0)){
				game.placeMark(2,0);
				location[2][0].setText(game.getCurrentMark(mark, currentMark));
			}
			checkForWin();
		}
		else if(event.getSource() == location[2][1])
		{
			char mark = 'a';
			String currentMark = "a";
			if(game.isSpotAvailable(2,1)){
				game.placeMark(2,1);
				location[2][1].setText(game.getCurrentMark(mark, currentMark));
			}
			checkForWin();
		}
		else if(event.getSource() == location[2][2])
		{
			char mark = 'a';
			String currentMark = "a";
			if(game.isSpotAvailable(2,2)){
				game.placeMark(2,2);
				location[2][2].setText(game.getCurrentMark(mark, currentMark));
			}
			checkForWin();
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