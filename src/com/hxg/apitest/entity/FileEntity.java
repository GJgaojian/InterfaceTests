package com.hxg.apitest.entity;

public class FileEntity {

	private String name;
	private String path;
	private boolean isFile = true;
	
	public FileEntity(String name, String path, boolean isFile) {
		super();
		this.name = name;
		this.path = path;
		this.isFile = isFile;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isFile() {
		return isFile;
	}
	public void setFile(boolean isFile) {
		this.isFile = isFile;
	}
	
}
