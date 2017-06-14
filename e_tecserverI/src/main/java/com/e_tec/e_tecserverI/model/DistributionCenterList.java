package com.e_tec.e_tecserverI.model;

public class DistributionCenterList {

	private DistributionCenter _head; 

	public DistributionCenterList(){
		_head = null;
	}
	
	public boolean isEmpty(){ 
		return _head == null;
	}
	
	public void insertFirst(DistributionCenter newNode){
		if  (!(this.isEmpty())){
			newNode.setNext(this.getHead());
			this.setHead(newNode);
		}
		this.setHead(newNode);
	}
	
	public void insertLast(DistributionCenter newNode){
		if (!(this.isEmpty())){
			DistributionCenter temp = _head;
			while (temp.getNext()!=null){
				temp = temp.getNext();
			}
			temp.setNext(newNode);
		}
		else{
			this.setHead(newNode);
		}
	}
	
	
	public void deleteFirst(){
		if (!(this.isEmpty())){
			this.setHead(this.getHead().getNext());
		}
		else{
			System.out.println("List is empty");
		}
	}
	
	
	public void deleteLast(){
		if (!(this.isEmpty())){
			if (this.getHead().getNext() == null){
				DistributionCenter temp = _head;
				while (temp.getNext().getNext()!=null){
					temp = temp.getNext();
				}
				temp.setNext(null);
			}
			else{
				this.setHead(null);
			}
		}
		else{
			System.out.println("List is empty");
		}
	}
	
	public void delete(String element){
		if (!this.isEmpty()){
			if (_head.getName() == element && _head.getNext() == null){
				_head = null;
			}
			else if (_head.getName() == element){
				this.deleteFirst();
			}
			else{
				DistributionCenter temp = _head;
				while (temp.getNext() != null){
					if (temp.getNext().getName() == element){
						temp.setNext(temp.getNext().getNext());
						break;
					}
					else{
						temp = temp.getNext();
					}
				}
			}
		}
		
		else{
			System.out.println("List is empty");
		}
	}
	
	
	public DistributionCenter search(String element){
		DistributionCenter temp =  _head;
		boolean flag = false;
		if (!(this.isEmpty())){
			while (temp!=null){
				if (temp.getName()==element){
					flag = true;
					break;
				}
				else{
					temp = temp.getNext();
				}
			}
			if (flag){
				return temp;
			}
			else{
				return null;
			}
		}
		else{
			return null;
		}
	}
	
	
	

	public DistributionCenter getHead() {
		return _head;
	}

	public void setHead(DistributionCenter head) {
		_head = head;
	}
	
	public void print(){
		if (!(this.isEmpty())){
			String res = "";
			DistributionCenter temp = _head;
			while (temp!=null){
				res += temp.getName() +  " -> "; 
				temp = temp.getNext();
			}
			System.out.println(res + "null");

		}
		else{
			System.out.println("List is empty");
		}
	}
}
