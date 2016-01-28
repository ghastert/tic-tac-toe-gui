package edu.jsu.mcis;

import java.util.*;

public class TicTacToe 
{

	private char[][] board;
	private char currentPlayerMark;

	public TicTacToe()
	{
		board = new char[3][3];
		currentPlayerMark = 'X';
		initializeBoard();
	}

	public void initializeBoard()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				board[i][j] = '-';
			}
		}
	
	}
	public boolean isBoardEmpty()
	{
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(board[i][j] == '-') return true;
			}
		}
		return false;
	}

	public String getCurrentMark(char currentMark, String stringCurrentMark)
	{
		currentMark = currentPlayerMark;
		stringCurrentMark = Character.toString(currentMark);
		return stringCurrentMark;
	}

	public boolean isTheBoardFull()
	{
		boolean boardIsFull = true;
		
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				if(board[i][j] == '-')
				{
					boardIsFull = false;
				}
			}
		}
		return boardIsFull;
	}
	
	public boolean isSpotAvailable(int row, int column)
	{
		return (board[row][column] == '-');
	}
	
	private boolean isThereThreeInARow(char spot1, char spot2, char spot3)
	{
		return(spot1 != '-') && (spot1 == spot2) && (spot2 == spot3);
	}
	
	public boolean isThereAWinner()
	{
		return (checkRowsForWin() || checkColumnsForWin() || checkDiagnolsForWin());
	}
	
	private boolean checkRowsForWin()
	{
		for(int i = 0; i < 3; i++)
		{
			if(isThereThreeInARow(board[i][0], board[i][1], board[i][2]) == true)
			{
				return true;
			}
		}
		return false;
	}
	
	private boolean checkColumnsForWin()
	{
		for(int i = 0; i < 3; i++)
		{
			if(isThereThreeInARow(board[0][i], board[1][i], board[2][i]) == true)
			{
				return true;
			}
		}
		return false;
	}
	
	private boolean checkDiagnolsForWin()
	{
		return((isThereThreeInARow(board[0][0], board[1][1], board[2][2]) == true) || (isThereThreeInARow(board[0][2], board[1][1], board[2][0]) == true));
		
	}
	
	public char changePlayer()
	{
		if(currentPlayerMark == 'X')
		{
			currentPlayerMark = 'O';
		}
		else
		{
			currentPlayerMark = 'X';
		}
		return currentPlayerMark;
	}
	
	
	
	public void placeMark(int row, int column)
	{
		if((row>= 0) && (row < 3))
		{
			if((column >= 0) && (column < 3))
			{
				board[row][column] = currentPlayerMark;						
			}
		}
	}
	
	
	}
