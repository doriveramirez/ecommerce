package net.doriv.onlineshop.dto;

public class Catalog {

	public int getId_catalog() {
		return id_catalog;
	}

	public void setId_catalog(int id_catalog) {
		this.id_catalog = id_catalog;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	private int id_catalog;
	private String name;
	private String image;
	private boolean active = true;
}
