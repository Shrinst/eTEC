package com.e_tec.e_tecserverI.model;

public class DistributionCenter {
	
	private String name;
	private String type;
	private int posX;
	private int posY;
	
	public DistributionCenter() {
		
	}
	
	public DistributionCenter(final String name, final String type, final int posX, final int posY) {
		this.name = name;
		this.type = type;
		this.posX = posX;
		this.posY = posY;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}	
}
