package com.test.el.model.vo;

public class Board {
 private int no;
 private String title;
 private String content;
 private int count;
 
 public Board() {
	// TODO Auto-generated constructor stub
}
 
 
 
public Board(int no, String title, String content, int count) {
	this.no = no;
	this.title = title;
	this.content = content;
	this.count = count;
}



@Override
public String toString() {
	return "Board [no=" + no + ", title=" + title + ", content=" + content + ", count=" + count + "]";
}



public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
}
