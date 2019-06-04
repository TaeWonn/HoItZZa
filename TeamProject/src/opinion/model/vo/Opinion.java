package opinion.model.vo;

import java.sql.Date;

import board.model.vo.Board;

public class Opinion {
	
	private String boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardWriter;
	private int boardReadCount;
	private Date boardDate;
	
	public Opinion() {}

	public Opinion(String boardNo, String boardTitle, String boardContent, 
			String boardWriter, int boardReadCount, Date boardDate) {
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardWriter = boardWriter;
		this.boardReadCount = boardReadCount;
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

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	public int getBoardReadCount() {
		return boardReadCount;
	}

	public void setBoardReadCount(int boardReadCount) {
		this.boardReadCount = boardReadCount;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	@Override
	public String toString() {
		return "Opinion [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardWriter=" + boardWriter + ", boardReadCount=" + boardReadCount + ", boardDate=" + boardDate
				+ "]";
	}
	
	

}
