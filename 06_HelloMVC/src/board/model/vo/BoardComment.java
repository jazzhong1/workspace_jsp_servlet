package board.model.vo;

import java.sql.Date;

public class BoardComment {
 
	private int boardCommentNO;
	private int boardCommentLevel;
	private String boardCommentWriter;
	private String boardCommentContent;
	private int boardRef;
	private int boardCommnetRef;
	private Date boardCommnetDate;
	
	
	public BoardComment() {
		// TODO Auto-generated constructor stub
	}
	
	public BoardComment(int boardCommentNO, int boardCommentLevel, String boardCommentWriter,
			String boardCommentContent, int boardRef, int boardCommnetRef, Date boardCommnetDate) {
		super();
		this.boardCommentNO = boardCommentNO;
		this.boardCommentLevel = boardCommentLevel;
		this.boardCommentWriter = boardCommentWriter;
		this.boardCommentContent = boardCommentContent;
		this.boardRef = boardRef;
		this.boardCommnetRef = boardCommnetRef;
		this.boardCommnetDate = boardCommnetDate;
	}
	

	public int getBoardCommentNO() {
		return boardCommentNO;
	}
	public void setBoardCommentNO(int boardCommentNO) {
		this.boardCommentNO = boardCommentNO;
	}
	public int getBoardCommentLevel() {
		return boardCommentLevel;
	}
	public void setBoardCommentLevel(int boardCommentLevel) {
		this.boardCommentLevel = boardCommentLevel;
	}
	public String getBoardCommentWriter() {
		return boardCommentWriter;
	}
	public void setBoardCommentWriter(String boardCommentWriter) {
		this.boardCommentWriter = boardCommentWriter;
	}
	public String getBoardCommentContent() {
		return boardCommentContent;
	}
	public void setBoardCommentContent(String boardCommentContent) {
		this.boardCommentContent = boardCommentContent;
	}
	public int getBoardRef() {
		return boardRef;
	}
	public void setBoardRef(int boardRef) {
		this.boardRef = boardRef;
	}
	public int getBoardCommnetRef() {
		return boardCommnetRef;
	}
	public void setBoardCommnetRef(int boardCommnetRef) {
		this.boardCommnetRef = boardCommnetRef;
	}
	public Date getBoardCommnetDate() {
		return boardCommnetDate;
	}
	public void setBoardCommnetDate(Date boardCommnetDate) {
		this.boardCommnetDate = boardCommnetDate;
	}
	@Override
	public String toString() {
		return "BoardComment [boardCommentNO=" + boardCommentNO + ", boardCommentLevel=" + boardCommentLevel
				+ ", boardCommentWriter=" + boardCommentWriter + ", boardCommentContent=" + boardCommentContent
				+ ", boardRef=" + boardRef + ", boardCommnetRef=" + boardCommnetRef + ", boardCommnetDate="
				+ boardCommnetDate + "]";
	}
	
	
	


}
