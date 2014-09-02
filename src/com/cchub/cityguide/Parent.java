package com.cchub.cityguide;

import java.util.ArrayList;

public class Parent {
	public int parentIcon;
	public String parentText;
	
	private ArrayList<Child> children;

//	public Parent(int icon, String text, ArrayList<Child> children) {
//		this.parentIcon = icon;
//		this.parentText = text;
//		this.children = children;
//	}

	public int getIcon() {
		return parentIcon;
	}

	public void setIcon(int icon) {
		this.parentIcon = icon;
	}

	public String getText() {
		return parentText;
	}

	public void setText(String text) {
		this.parentText = text;
	}

	public ArrayList<Child> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Child> children) {
		this.children = children;
	}

	
	
	
}

