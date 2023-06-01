package com.ottt.ottt.dto;

import java.util.Objects;

/*
 * content_no			bigint			generated always as identity primary key
	,ott_no				smallint		not null
	,content_nm			varchar(100)	not null
	,content_info		varchar(10000)	not null
	,content_runtime	int				not null
	,previewUrl			text			not null
	,thumbnail			text			not null
	,age				smallint		not null
 */
public class ContentDTO {
	
	private Integer content_no;
	private int ott_no;
	private String content_nm;
	private String content_info;
	private int content_runtime;
	private String previewUrl;
	private String thumbnail;
	private int age;

	public ContentDTO() {}

	public Integer getContent_no() {
		return content_no;
	}

	public void setContent_no(Integer content_no) {
		this.content_no = content_no;
	}

	public int getOtt_no() {
		return ott_no;
	}

	public void setOtt_no(int ott_no) {
		this.ott_no = ott_no;
	}

	public String getContent_nm() {
		return content_nm;
	}

	public void setContent_nm(String content_nm) {
		this.content_nm = content_nm;
	}

	public String getContent_info() {
		return content_info;
	}

	public void setContent_info(String content_info) {
		this.content_info = content_info;
	}

	public int getContent_runtime() {
		return content_runtime;
	}

	public void setContent_runtime(int content_runtime) {
		this.content_runtime = content_runtime;
	}

	public String getPreviewUrl() {
		return previewUrl;
	}

	public void setPreviewUrl(String previewUrl) {
		this.previewUrl = previewUrl;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, content_nm, content_no, ott_no);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContentDTO other = (ContentDTO) obj;
		return age == other.age && Objects.equals(content_nm, other.content_nm)
				&& Objects.equals(content_no, other.content_no) && ott_no == other.ott_no;
	}

	@Override
	public String toString() {
		return "ContentDTO [content_no=" + content_no + ", ott_no=" + ott_no + ", content_nm=" + content_nm
				+ ", content_info=" + content_info + ", content_runtime=" + content_runtime + ", previewUrl="
				+ previewUrl + ", thumbnail=" + thumbnail + ", age=" + age + "]";
	}

	
}
