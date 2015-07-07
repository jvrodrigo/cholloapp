package org.cholloapp.adapterslist;

public class ProductItem {
	int id;
	String name, description;
	CharSequence created, modified;
	
	int image;

	public ProductItem(int id, String name, String description, int imgResID,
			CharSequence created, CharSequence modified) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.image = imgResID;
		this.created = created;
		this.modified = modified;
	}

	public ProductItem(String name, String description, int imgResID) {
		super();
		this.name = name;
		this.description = description;
		this.image = imgResID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getImage() {
		return image;
	}

	public void setImage(int image) {
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public CharSequence getCreated() {
		return created;
	}

	public void setCreated(CharSequence created) {
		this.created = created;
	}

	public CharSequence getModified() {
		return modified;
	}

	public void setModified(CharSequence modified) {
		this.modified = modified;
	}


}
