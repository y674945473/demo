package com.demo.entity;

import java.util.Date;

public class AuditVO {

	private String id;
	//人员id
	private String userId;
	//自评分数
	private String selfScore;
	//审核人Id
	private String auditId;
	//分数
	private String score;
	//分数
	private Date authDate;
	//备注
	private String note;
	//添加日期
	private Date addDate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSelfScore() {
		return selfScore;
	}
	public void setSelfScore(String selfScore) {
		this.selfScore = selfScore;
	}
	public String getAuditId() {
		return auditId;
	}
	public void setAuditId(String auditId) {
		this.auditId = auditId;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	
	
	public Date getAuthDate() {
		return authDate;
	}
	public void setAuthDate(Date authDate) {
		this.authDate = authDate;
	}
	
	public AuditVO(String id, String userId, String selfScore, String auditId, String score, Date authDate, String note,
			Date addDate) {
		super();
		this.id = id;
		this.userId = userId;
		this.selfScore = selfScore;
		this.auditId = auditId;
		this.score = score;
		this.authDate = authDate;
		this.note = note;
		this.addDate = addDate;
	}
	public AuditVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
