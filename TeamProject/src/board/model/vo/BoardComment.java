package board.model.vo;

import java.sql.Date;

public class BoardComment {
	// field
	private int commentNo;
	private String commentContent;
	private int commentLevel;
	private String boardNo;
	private int commentNoRef;
	private Date commentDate;
	private String commentWriter;
	private String commentSubject;
	
	// constructor
	public BoardComment() {}

	public BoardComment(int commentNo, String commentContent, int commentLevel, String boardNo, int commentNoRef,
			Date commentDate, String commentWriter, String commentSubject) {
		this.commentNo = commentNo;
		this.commentContent = commentContent;
		this.commentLevel = commentLevel;
		this.boardNo = boardNo;
		this.commentNoRef = commentNoRef;
		this.commentDate = commentDate;
		this.commentWriter = commentWriter;
		this.commentSubject = commentSubject;
	}

	// getter/setter
	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public int getCommentLevel() {
		return commentLevel;
	}

	public void setCommentLevel(int commentLevel) {
		this.commentLevel = commentLevel;
	}

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}

	public int getCommentNoRef() {
		return commentNoRef;
	}

	public void setCommentNoRef(int commentNoRef) {
		this.commentNoRef = commentNoRef;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getCommentWriter() {
		return commentWriter;
	}

	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}

	public String getCommentSubject() {
		return commentSubject;
	}

	public void setCommentSubject(String commentSubject) {
		this.commentSubject = commentSubject;
	}
	
	// toString
	@Override
	public String toString() {
		return "BoardComment [commentNo=" + commentNo + ", commentContent=" + commentContent + ", commentLevel="
				+ commentLevel + ", boardNo=" + boardNo + ", commentNoRef=" + commentNoRef + ", commentDate="
				+ commentDate + ", commentWriter=" + commentWriter + ", commentSubject=" + commentSubject + "]";
	}
	
}
