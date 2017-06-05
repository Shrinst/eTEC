package com.e_tec.e_tecserverI.model;

public class Product {
	
	private String name;
    private String imageURL;
    private int id;
    private String description;
    private String category;
    private int amount;
    
    public Product() {
        
    }

    public Product(String name, String imageURL, int id, int amount, String category, String description) {
        this.name = name;
        this.imageURL = imageURL;
        this.id = id;
        this.amount = amount;
        this.category = category;
        this.description = description;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}     
}
