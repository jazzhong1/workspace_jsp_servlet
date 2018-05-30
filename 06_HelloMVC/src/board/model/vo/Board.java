package board.model.vo;

import java.sql.Date;

public class Board {
	
	private int boardNo;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private String boardOriginalFileName;
	private String boardRenameFileName;
	private Date boardDate;
	private int boardReadCount;
	
	
	public Board() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Board(int boardNo, String boardTitle, String boardWriter, String boardContent, String boardOriginalFileName,
			String boardRenameFileName, Date boardDate, int boardReadCount) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardWriter = boardWriter;
		this.boardContent = boardContent;
		this.boardOriginalFileName = boardOriginalFileName;
		this.boardRenameFileName = boardRenameFileName;
		this.boardDate = boardDate;
		this.boardReadCount = boardReadCount;
	}

	
	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardWriter=" + boardWriter
				+ ", boardContent=" + boardContent + ", boardOriginalFileName=" + boardOriginalFileName
				+ ", boardRenameFileName=" + boardRenameFileName + ", boardDate=" + boardDate + ", boardReadCount="
				+ boardReadCount + "]";
	}


	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardWriter() {
		return boardWriter;
	}
	public void setBoardWriter(String boardWriter) {
		this.boardWriter = boardWriter;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public String getBoardOriginalFileName() {
		return boardOriginalFileName;
	}
	public void setBoardOriginalFileName(String boardOriginalFileName) {
		this.boardOriginalFileName = boardOriginalFileName;
	}
	public String getBoardRenameFileName() {
		return boardRenameFileName;
	}
	public void setBoardRenameFileName(String boardRenameFileName) {
		this.boardRenameFileName = boardRenameFileName;
	}
	public Date getBoardDate() {
		return boardDate;
	}
	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}
	public int getBoardReadCount() {
		return boardReadCount;
	}
	public void setBoardReadCount(int boardReadCount) {
		this.boardReadCount = boardReadCount;
	}
	
	

}
