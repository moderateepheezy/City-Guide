package com.cchub.cityguide;

public class Child {
	public int childIcon;
	public String childText;
	public String[] content;
	public int[] contentID;
	public int childID;
//	public Child(int childIcon, String childText) {
//		this.childIcon = childIcon;
//		this.childText = childText;
//	}
	public int getChildIcon() {
		return childIcon;
	}
	public void setChildIcon(int childIcon) {
		this.childIcon = childIcon;
	}
	public String getChildText() {
		return childText;
	}
	public void setChildText(String childText) {
		this.childText = childText;
	}
	
	public int getChildID() {
		return childID;
	}
	public void setChildID(int childID) {
		this.childID = childID;
	}
	public String[] getContent() {
		return content;
	}
	public void setContent(String[] content) {
		this.content = content;
	}
	
	public int[] getContentID() {
		return contentID;
	}
	public void setContentID(int[] contentid) {
		this.contentID = contentid;
	}
}
