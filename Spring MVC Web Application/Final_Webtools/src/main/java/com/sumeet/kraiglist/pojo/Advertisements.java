package com.sumeet.kraiglist.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="ADVERTISEMENTS_TABLE")
public class Advertisements {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ADVERT_ID", unique = true, nullable = false, length = 10)
	private long advertId;
	
	@Column(name = "CATEGORY", nullable = false, length = 30)
	private String category;
	
	@Column(name = "TITLE", nullable = false, length = 100)
	private String title;
	
	@Column(name = "PRICE", nullable = false, length = 30)
	private double price;
	
	@Column(name = "DESCRIPITION", nullable = false, length = 500)
	private String descripition;
	
	@Column(name = "YEAR_OLD", nullable = false)
	private String yearOld;
	
	@Column(name = "PHOTOS", nullable = false, length = 500)
	private String photos;
	
	
	
	@Transient
	private MultipartFile imageFile;
	
	public MultipartFile getImageFile() {
		return imageFile;
	}

	public void setImageFile(MultipartFile imageFile) {
		this.imageFile = imageFile;
	}

	@ManyToOne
	@JoinColumn(name="USER_ID")
	private User user;
	
	@Column(name = "EMAIL", nullable = false, length = 30)
	private String email;
	
	public Advertisements() {

	}

	public Advertisements(String category, String title, double price, String descripition, String yearOld, String photos, User user, String email) {
		super();
		this.category = category;
		this.title = title;
		this.price = price;
		this.descripition = descripition;
		this.yearOld = yearOld;
		this.photos = photos;
		this.user = user;
		this.email = email;
	}

	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getAdvertId() {
		return advertId;
	}

	public void setAdvertId(long advertId) {
		this.advertId = advertId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescripition() {
		return descripition;
	}

	public void setDescripition(String descripition) {
		this.descripition = descripition;
	}

	public String getYearOld() {
		return yearOld;
	}

	public void setYearOld(String yearOld) {
		this.yearOld = yearOld;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	

}
