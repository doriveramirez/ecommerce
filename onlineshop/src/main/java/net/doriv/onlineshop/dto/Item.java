package net.doriv.onlineshop.dto;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Item {

	public int getId_item() {
		return id_item;
	}
	public void setId_item(int id_item) {
		this.id_item = id_item;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getId_catalog() {
		return id_catalog;
	}
	public void setId_catalog(int id_catalog) {
		this.id_catalog = id_catalog;
	}
	public int getPurchases() {
		return purchases;
	}
	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}
	public int getViews() {
		return views;
	}
	public void setViews(int views) {
		this.views = views;
	}

	@Override
	public String toString() {
		return "Item [id_item=" + id_item + ", code=" + code + ", name=" + name + ", stock=" + stock + ", price="
				+ price + ", active=" + active + ", id_catalog=" + id_catalog + ", purchases=" + purchases + ", views="
				+ views + "]";
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_item;
	private String code;
	@NotBlank(message = "Name required.")
	private String name;
	@Min(value=0, message="Stock can't be negative.")
	private int stock;
	@Min(value=0, message="Price can't be negative.")
	@Column(name= "price")
	private double price;
	@Column(name= "is_active")
	private boolean active = true;
	@JsonIgnore
	@Column(name= "id_catalog")
	private int id_catalog;
	private int purchases;
	private int views;
	
	@Transient
	private MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public Item() {
		this.code = UUID.randomUUID().toString();
	}
}
