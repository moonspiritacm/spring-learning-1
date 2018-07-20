package com.moonspirit.springlearning.setting.profile;

/**
 * @ClassName      BasicBean
 * @Description    基本实体类，不使用注解
 *
 * @author         moonspirit
 * @date           2018年7月20日    下午3:23:46
 * @version        1.0.0
 */
public class BasicBean {

	private String content;

	public BasicBean(String content) {
		super();
		this.content = content;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
