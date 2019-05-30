package file.model.vo;

public class FileTable {
	
	private String originalFileName;
	private String renamedFileName;
	private String boardNo;
	
	public FileTable() {}
	
	public FileTable(String originalFileName, String renamedFileName, String boardNo) {
		this.originalFileName = originalFileName;
		this.renamedFileName = renamedFileName;
		this.boardNo = boardNo;
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

	public String getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(String boardNo) {
		this.boardNo = boardNo;
	}


	

	@Override
	public String toString() {
		return "FileTable [originalFileName=" + originalFileName + ", renamedFileName=" + renamedFileName + ", boardNo="
				+ boardNo + "]";
	}
	
	
	
}


