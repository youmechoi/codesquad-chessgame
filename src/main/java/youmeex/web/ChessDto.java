package youmeex.web;

import chess.Board;
import chess.ChessGame;
import pieces.Piece.Color;

public class ChessDto {
	
	
	private Board board;
	
	private double whitePoint;
	private double blackPoint;

	public Board getBoard() {
		return board;
	}
	
	  public double getPointByWhite() {
	      return whitePoint;
	  }

	  public double getPointByBlack() {
	      return blackPoint; 
	  }

	public static ChessDto create(ChessGame chessGame) {
		ChessDto chessDto = new ChessDto();
		chessDto.board = chessGame.getBoard();
		chessDto.whitePoint = chessGame.getPointByWhite();
		chessDto.blackPoint = chessGame.getPointByBlack();
		return chessDto;
	}
	


}
