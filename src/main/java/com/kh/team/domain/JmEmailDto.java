package com.kh.team.domain;

public class JmEmailDto {
	
	private String from = "aoyamamin@gmail.com";
	private String to;
	private String subject;
	private String contents;
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getFrom() {
		return from;
	}
	@Override
	public String toString() {
		return "JmEmailDto [from=" + from + ", to=" + to + ", subject=" + subject + ", contents=" + contents + "]";
	}
	
	
	
	
	
}
