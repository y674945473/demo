package com.demo.entity;

public class User {

	private String id;
	//名称
	private String name;
	//邀请编码
	private String invitationCode;
	//编码
	private String code;
	//手机
	private String iphone;
	//邮箱
	private String email;
	//权限
	private String auth;
	//职位
	private String position;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getIphone() {
		return iphone;
	}
	public void setIphone(String iphone) {
		this.iphone = iphone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	
	public String getInvitationCode() {
		return invitationCode;
	}
	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}
	
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String id, String name, String invitationCode, String code, String iphone, String email, String auth,
			String position) {
		super();
		this.id = id;
		this.name = name;
		this.invitationCode = invitationCode;
		this.code = code;
		this.iphone = iphone;
		this.email = email;
		this.auth = auth;
		this.position = position;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", invitationCode=" + invitationCode + ", code=" + code
				+ ", iphone=" + iphone + ", email=" + email + ", auth=" + auth + ", position=" + position + "]";
	}
	
	
	
	
}
