package notice.model.vo;

import java.sql.Date;

public class Notice {

	private int noticeNo;
	private String noticeTitle;
	private String noticewriter;
	private String noticeContent;
	private Date noticeDate;
	private String filePath;
	private String status;
	
	
	public Notice() {}


	public Notice(int noticeNo, String noticeTitle, String noticewriter, String noticeContent, Date noticeDate,
			String filePath, String status) {
		
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticewriter = noticewriter;
		this.noticeContent = noticeContent;
		this.noticeDate = noticeDate;
		this.filePath = filePath;
		this.status = status;
	}


	public int getNoticeNo() {
		return noticeNo;
	}


	public void setNoticeNo(int noticeNo) {
		this.noticeNo = noticeNo;
	}


	public String getNoticeTitle() {
		return noticeTitle;
	}


	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}


	public String getNoticewriter() {
		return noticewriter;
	}


	public void setNoticewriter(String noticewriter) {
		this.noticewriter = noticewriter;
	}


	public String getNoticeContent() {
		return noticeContent;
	}


	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}


	public Date getNoticeDate() {
		return noticeDate;
	}


	public void setNoticeDate(Date noticeDate) {
		this.noticeDate = noticeDate;
	}


	public String getFilePath() {
		return filePath;
	}


	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Notice [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticewriter=" + noticewriter
				+ ", noticeContent=" + noticeContent + ", noticeDate=" + noticeDate + ", filePath=" + filePath
				+ ", status=" + status + "]";
	}
	
	
	
	
}
