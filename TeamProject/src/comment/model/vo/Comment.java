package comment.model.vo;

import java.sql.Date;

public class Comment {

	private String commentNo;
	private String commentContent;
	private String boardNo;
	private String commentWriter;
	private int commentLevel;
	private String commentNoRef;
	private Date commentDate;
	
	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public Comment() {}
	
	public Comment(String commentContent, String boardNo, String commentWriter,int commentLevel, String commentNoRef) {
		this.commentContent = commentContent;
		this.boardNo = boardNo;
		this.commentWriter = commentWriter;
		this.commentLevel = commentLevel;
		this.commentNoRef=commentNoRef;
	}
	
	public Comment(String commentNo, String commentContent, String boardNo, String commentWriter, int commentLevel,String commentNoRef
				,Date commentDate) {
		this.commentNo = commentNo;
		this.commentContent = commentContent;
		this.boardNo = boardNo;
		this.commentWriter = commentWriter;
		this.commentLevel = commentLevel;
		this.commentNoRef = commentNoRef;
		this.commentDate = commentDate;
	}

	public String getCommentWriter() {
		return commentWriter;
	}

	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}

	public String getCommentNoRef() {
		return commentNoRef;
	}

	public void setCommentNoRef(String commentNoRef) {
		this.commentNoRef = commentNoRef;
	}

	public String getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(String comme) {
		this.commentNo = comme;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}

	public String getCommnetWriter() {
		return commentWriter;
	}

	public void setCommnetWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}

	public int getCommentLevel() {
		return commentLevel;
	}

	public void setCommentLevel(int commentLevel) {
		this.commentLevel = commentLevel;
	}

	@Override
	public String toString() {
		return "Comment [commentNo=" + commentNo + ", commentContent=" + commentContent + ", boardNo=" + boardNo
				+ ", commentWriter=" + commentWriter + ", commentLevel=" + commentLevel + ",commentNoRef="
				+ commentNoRef + "]";
	}
	
	
	
	
}
