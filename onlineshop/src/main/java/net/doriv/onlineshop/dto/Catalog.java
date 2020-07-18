package net.doriv.onlineshop.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
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

	
	
	@Override
	public String toString() {
		return "Catalog [id_catalog=" + id_catalog + ", name=" + name + ", image=" + image + ", active=" + active + "]";
	}



	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_catalog;
	private String name;
	@Column(name= "image")
	private String image;
	@Column(name= "is_active")
	private boolean active = true;
}
