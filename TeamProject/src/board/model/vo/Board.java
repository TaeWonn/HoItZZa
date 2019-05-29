package board.model.vo;

import java.sql.Date;

public class Board {
	private String boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardDeal;
	private String boardWriter;
	private String boardCodeNo;
	private int boardReadCounter;
	private Date boardDate;
	
	public Board() {}
	
	public Board(String boardNo, String boardTitle, String boardContent, String boardDeal,
			String boardWriter, String boardCodeNo, int boardReadCounter, Date boardDate) {
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardDeal = boardDeal;
		this.boardWriter = boardWriter;
		this.boardCodeNo = boardCodeNo;
		this.boardReadCounter = boardReadCounter;
		this.boardDate = boardDate;
	}

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getBoardDeal() {
		return boardDeal;
	}

	public void setBoardDeal(String boardDeal) {
		this.boardDeal = boardDeal;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public String getBoardCodeNo() {
		return boardCodeNo;
	}

	public void setBoardCodeNo(String boardCodeNo) {
		this.boardCodeNo = boardCodeNo;
	}

	public int getBoardReadCounter() {
		return boardReadCounter;
	}

	public void setBoardReadCounter(int boardReadCounter) {
		this.boardReadCounter = boardReadCounter;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	@Override
	public String toString() {
		return "Sell [boardNo=" + boardNo + ", boardTitle=" + boardTitle
				+ ", boardContent=" + boardContent + ", boardDeal=" + boardDeal + ", boardWriter=" + boardWriter
				+ ", boardCodeNo=" + boardCodeNo + ", boardReadCounter=" + boardReadCounter + ", boardDate=" + boardDate
				+ "]";
	}
}
