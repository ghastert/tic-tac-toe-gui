package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.*;

public class TicTacToeTest {
	
	private TicTacToe t;
	
	@Before
	public void setup()
	{
		t = new TicTacToe();
	}
	
	@Test
	public void testInitialBoardIsEmpty() {
		t.initializeBoard();
		assertTrue(t.isBoardEmpty());
	}
	
	@Test
	public void testMarkXInUpperRightCorner() {
		char mark = 'X';
		String currentMark = "O";
		t.initializeBoard();
		t.placeMark(0, 2);
		boolean isMarkX = (t.isSpotAvailable(0,2) == false) && (t.getCurrentMark(mark, currentMark).equals("X"));
		assertTrue(isMarkX);
	}
	
    @Test
	public void testMarkOInBottomLeftCorner() {
		char mark = 'a';
		String currentMark = "a";
		t.initializeBoard();
		t.changePlayer();
		t.placeMark(2, 0);
		boolean isMarkO = (t.isSpotAvailable(2,0) == false) && (t.getCurrentMark(mark, currentMark).equals("O"));
		assertTrue(isMarkO);
	}
	
	@Test
	public void testUnableToMarkOverExistingMark() {
		t.initializeBoard();
		t.placeMark(0,0);
		t.changePlayer();
		assertFalse(t.isSpotAvailable(0,0));
	}
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		t.initializeBoard();
		t.placeMark(0,0);
		assertFalse(t.isThereAWinner());
	}
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		t.initializeBoard();
		t.placeMark(0,0);
		t.changePlayer();
		t.placeMark(1,0);
		t.changePlayer();
		t.placeMark(0,1);
		t.changePlayer();
		t.placeMark(1,1);
		t.changePlayer();
		t.placeMark(0,2);
		assertTrue(t.isThereAWinner());
	}
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		t.initializeBoard();
		t.placeMark(0,0);
		t.changePlayer();
		t.placeMark(1,0);
		t.changePlayer();
		t.placeMark(2,0);
		t.changePlayer();
		t.placeMark(0,1);
		t.changePlayer();
		t.placeMark(0,2);
		t.changePlayer();
		t.placeMark(1,1);
		t.changePlayer();
		t.placeMark(1,2);
		t.changePlayer();
		t.placeMark(2,2);
		t.changePlayer();
		t.placeMark(2,1);
		assertTrue(t.isTheBoardFull());
	}
}
