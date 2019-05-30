package opinion.model.vo;

import java.sql.Date;

import board.model.vo.Board;

public class Opinion extends Board {
	
	public Opinion() {}

	public Opinion(String boardNo, String boardCode, String boardTitle, String boardContent, String boardDeal,
			String boardWriter, String boardCodeNo, int boardReadCounter, Date boardDate) {
		super(boardNo, boardTitle, boardContent, boardDeal, boardWriter, boardCodeNo, boardReadCounter, boardDate);
	}
	

}
