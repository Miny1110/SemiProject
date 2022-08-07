package com.ccookat;

public class ReplyDTO {
	private int replyNum;
	private String customerId;
	private String replyContent;
	private String replyCreated;
	
	
	public int getReplyNum() {
		return replyNum;
	}
	public void setReplyNum(int replyNum) {
		this.replyNum = replyNum;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getReplyContent() {
		return replyContent;
	}
	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}
	public String getReplyCreated() {
		return replyCreated;
	}
	public void setReplyCreated(String replyCreated) {
		this.replyCreated = replyCreated;
	}
	
}
