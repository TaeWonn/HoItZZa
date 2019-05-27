package sell.model.vo;

import java.sql.Date;

import board.model.vo.Board;

public class Sell extends Board{
	
	
	public Sell() {}
	
	public Sell(int boardNo, String boardCode, String boardTitle, String boardContent, String boardDeal,
			String boardWriter, String boardCodeNo, int boardReadCounter, Date boardDate) {
		super(boardNo, boardCode, boardTitle, boardContent, boardDeal,
				boardWriter, boardCodeNo, boardReadCounter, boardDate);
	}
}
