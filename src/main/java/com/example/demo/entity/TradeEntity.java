package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TradeEntity {
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	public TradeEntity(int id, String stockSymbol, int stockQuantity, String stockType, double stockPrice) {
		super();
		this.id = id;
		this.stockSymbol = stockSymbol;
		this.stockQuantity = stockQuantity;
		this.stockType = stockType;
		this.stockPrice = stockPrice;
	}
	 public TradeEntity() {
		super();
	}
	@Column(nullable = false,unique = true)
	private String stockSymbol;
	 @Column(nullable = false)
	private int stockQuantity;
	 @Column(nullable = false)
	private String stockType;
	 @Column(nullable = false)
	private double stockPrice;
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	public String getStockType() {
		return stockType;
	}
	public void setStockType(String stockType) {
		this.stockType = stockType;
	}
	public double getStockPrice() {
		return stockPrice;
	}
	public void setStockPrice(double stockPrice) {
		this.stockPrice = stockPrice;
	}
	@Override
	public String toString() {
		return "TradeEntity [id=" + id + ", stockSymbol=" + stockSymbol + ", stockQuantity=" + stockQuantity
				+ ", stockType=" + stockType + ", stockPrice=" + stockPrice + ", getId()=" + getId()
				+ ", getStockSymbol()=" + getStockSymbol() + ", getStockQuantity()=" + getStockQuantity()
				+ ", getStockType()=" + getStockType() + ", getStockPrice()=" + getStockPrice() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
	
	

}
