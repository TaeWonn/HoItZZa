package file.model.vo;

public class FileTable {
	
	private String originalFileName;
	private String renamedFileName;
	private int boardNo;
	private String boardWriter;
	
	public FileTable() {}
	
	public FileTable(String originalFileName, String renamedFileName, int boardNo, String boardWriter, String boardSubject) {
		this.originalFileName = originalFileName;
		this.renamedFileName = renamedFileName;
		this.boardNo = boardNo;
		this.boardWriter = boardWriter;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public String getRenamedFileName() {
		return renamedFileName;
	}

	public void setRenamedFileName(String renamedFileName) {
		this.renamedFileName = renamedFileName;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardWriter() {
		return boardWriter;
	}

	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}

	

	@Override
	public String toString() {
		return "FileTable [originalFileName=" + originalFileName + ", renamedFileName=" + renamedFileName + ", boardNo="
				+ boardNo + ", boardWriter=" + boardWriter + "]";
	}
	
	
	
}


