/**
 * lei
 * com.mic.bean
 * Select1Bean.java
 * 创建人:lei
 * 时间：2018年9月30日-下午11:30:04
 * 2018lei-版权所有
 */

package com.mic.bean.lei;

/**
 * 
 * Select1Bean
 * 创建人:lei
 * 时间：2018年9月30日-下午11:30:04
 * @version 1.0.0
 * 
 */

public class Select1Bean {
    private Integer s_id;
    //private String sName;
    private Integer Cid;
    private String cname;
    private String tname;
	public Integer getCid() {
		return Cid;
	}
	public void setCid(Integer cid) {
		Cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public Integer getS_id() {
		return s_id;
	}
	public void setS_id(Integer s_id) {
		this.s_id = s_id;
	}
//	public String getsName() {
//		return sName;
//	}
//	public void setsName(String sName) {
//		this.sName = sName;
//	}
       
}
