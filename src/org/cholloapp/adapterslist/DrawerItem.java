package org.cholloapp.adapterslist;

public class DrawerItem{

	String title, itemName;
	int icon;

	public DrawerItem(String itemName, int imgResID) {
		super();
		this.itemName = itemName;
		this.icon = imgResID;
		this.title = null;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public DrawerItem(String title) {
		this(null, 0);
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getIcon() {
		return icon;
	}

	public void setIcon(int icon) {
		this.icon = icon;
	}

}