package buy.model.vo;

import java.sql.Date;

import board.model.vo.Board;

public class Buy extends Board{

	public Buy() {}
	public Buy(String boardNo,String boardCode,String boardTitle,String boardContent,String boardDeal,
			String boardWriter,String boardCodeNo,int  boardReadCounter,Date boardDate) {
		super(boardNo, boardTitle, boardContent, boardDeal,
				boardWriter, boardCodeNo, boardReadCounter, boardDate);
	}
}
