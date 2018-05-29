package notice.model.vo;

import java.sql.Date;

public class Notice {
	private int notice_no;
	private String notice_title;
	private String notice_writer;
	private String notice_content;
	private Date notice_date;
	private String filePath;
	private String status;
	

	public Notice() {

	}
	
	
	public Notice(int notice_no, String notice_title, String notice_writer, String notice_content, Date notice_date,
			String filePath, String status) {
		this.notice_no = notice_no;
		this.notice_title = notice_title;
		this.notice_writer = notice_writer;
		this.notice_content = notice_content;
		this.notice_date = notice_date;
		this.filePath = filePath;
		this.status = status;
	}




	public int getNotice_no() {
		return notice_no;
	}



	public void setNotice_no(int notice_no) {
		this.notice_no = notice_no;
	}



	public String getNotice_title() {
		return notice_title;
	}



	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}



	public String getNotice_writer() {
		return notice_writer;
	}



	public void setNotice_writer(String notice_writer) {
		this.notice_writer = notice_writer;
	}



	public String getNotice_content() {
		return notice_content;
	}



	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}



	public Date getNotice_date() {
		return notice_date;
	}



	public void setNotice_date(Date notice_date) {
		this.notice_date = notice_date;
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
		return "Notice [notice_no=" + notice_no + ", notice_title=" + notice_title + ", notice_writer=" + notice_writer
				+ ", notice_content=" + notice_content + ", notice_date=" + notice_date + ", filePath=" + filePath
				+ ", status=" + status + "]";
	}



}
