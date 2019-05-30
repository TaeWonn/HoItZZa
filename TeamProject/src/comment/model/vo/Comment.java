package comment.model.vo;

public class Comment {

	private int commentNo;
	private String commentContent;
	private String boardNo;
	private String commentWriter;
	private int commentLevel;
	
	public Comment() {}
	
	public Comment(String commentContent, String boardNo, String commentWriter,int commentLevel) {
		this.commentContent = commentContent;
		this.boardNo = boardNo;
		this.commentWriter = commentWriter;
		this.commentLevel = commentLevel;
	}
	
	public Comment(int commentNo, String commentContent, String boardNo, String commentWriter, int commentLevel) {
		this.commentNo = commentNo;
		this.commentContent = commentContent;
		this.boardNo = boardNo;
		this.commentWriter = commentWriter;
		this.commentLevel = commentLevel;
	}

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
				+ ", commentWriter=" + commentWriter + ", commentLevel=" + commentLevel + "]";
	}
	
	
	
	
}
