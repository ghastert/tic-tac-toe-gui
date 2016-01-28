import edu.jsu.mcis.*;

public class TicTacToeKeywords {
	
	private TicTacToe ticTacToe = new TicTacToe();
	public char[][] testBoard = new char[3][3];
	
	public void startNewGame() {
		ticTacToe.initializeBoard();
	}
	
	public void markLocation(int row, int col) {
		ticTacToe.placeMark(row, col);
	}
	
	public char getMark(int row, int col) {
		if(!ticTacToe.isThereAWinner())
		{
			ticTacToe.changePlayer();
		}
		return ticTacToe.getCurrentMark(testBoard, row, col);
	}
    
	public String getWinner() {
		String tie = "TIE";
		char currentMark = 'a';
		String stringCurrentMark = "a";
		if(ticTacToe.isTheBoardFull())
		{
			return tie;
		}
		ticTacToe.isThereAWinner();
		return ticTacToe.getCurrentMark(currentMark, stringCurrentMark);
	}
}
