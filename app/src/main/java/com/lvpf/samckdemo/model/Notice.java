package com.lvpf.samckdemo.model;

import com.lvpf.samckdemo.utils.StringUtils;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * 消息实体.
 * 
 * @author shimiso
 */
public class Notice implements Serializable, Comparable<Notice> {
	/**
	 * 
	 */
//	private static final long serialVersionUID = 1L;
	public static final int ADD_FRIEND = 1;// 好友请求
	public static final int SYS_MSG = 2; // 系统消息
	public static final int READ = 0;
	public static final int UNREAD = 1;

	private String id; // 主键
	private String title; // 标题
	private String content; // 内容
	private Integer status; // 状态 0已读 1未读
	private String from; // 通知来源
	private String to; // 通知去向
	private String noticeTime; // 通知时间
	private Integer noticeType; // 消息类型 1.好友请求 2.系统消息
	

	

	public Integer getNoticeType() {
		return noticeType;
	}

	public void setNoticeType(Integer noticeType) {
		this.noticeType = noticeType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getNoticeTime() {
		return noticeTime;
	}

	public void setNoticeTime(String noticeTime) {
		this.noticeTime = noticeTime;
	}

	@Override
	public int compareTo(Notice oth) {
		if (null == this.getNoticeTime() || null == oth.getNoticeTime()) {
			return 0;
		}
		String format = null;
		String time1 = "";
		String time2 = "";
		if (this.getNoticeTime().length() == oth.getNoticeTime().length()
				&& this.getNoticeTime().length() == 23) {
			time1 = this.getNoticeTime();
			time2 = oth.getNoticeTime();
		} else {
			time1 = this.getNoticeTime().substring(0, 19);
			time2 = oth.getNoticeTime().substring(0, 19);
		}
		Date da1 = StringUtils.toDate(time1);
		Date da2 =StringUtils.toDate(time2);
		if (da1.before(da2)) {
			return 1;
		}
		if (da2.before(da1)) {
			return -1;
		}

		return 0;
	}

}
