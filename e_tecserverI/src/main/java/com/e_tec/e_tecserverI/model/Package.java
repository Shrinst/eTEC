package com.e_tec.e_tecserverI.model;

public class Package {
	
	private int code;
	private int initPosX, initPosY;
	private int finPosX, finPosY;
	
	public Package() {
		
	}
	
	public Package(final int code, final int initPosX, final int initPosY) {
		this.code = code;
		this.initPosX = initPosX;
		this.initPosY = initPosY;
		this.finPosX = 0;
		this.finPosY = 0;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getInitPosX() {
		return initPosX;
	}

	public void setInitPosX(int initPosX) {
		this.initPosX = initPosX;
	}

	public int getInitPosY() {
		return initPosY;
	}

	public void setInitPosY(int initPosY) {
		this.initPosY = initPosY;
	}

	public int getFinPosX() {
		return finPosX;
	}

	public void setFinPosX(int finPosX) {
		this.finPosX = finPosX;
	}

	public int getFinPosY() {
		return finPosY;
	}

	public void setFinPosY(int finPosY) {
		this.finPosY = finPosY;
	}
	
}
