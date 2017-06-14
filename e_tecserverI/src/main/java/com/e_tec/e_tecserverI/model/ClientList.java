package com.e_tec.e_tecserverI.model;



public class ClientList {

	private Client _head;
	
	public ClientList(){
		_head = null;
	}
	
	public boolean isEmpty(){ 
		return _head == null;
	}
	
	public void insertFirst(Client newNode){
		if  (!(this.isEmpty())){
			newNode.setNext(this.getHead());
			this.setHead(newNode);
		}
		this.setHead(newNode);
	}
	
	public void insertLast(Client newNode){
		if (!(this.isEmpty())){
			Client temp = _head;
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
				Client temp = _head;
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
				Client temp = _head;
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
	
	
	public Client search(String element){
		Client temp =  _head;
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
	

	public void updateNode(String name, Client newInfo){
		Client oldInfo = this.search(name);
		if (oldInfo != null ){
			oldInfo.setCart(newInfo.getCart());
			oldInfo.setPhoto(newInfo.getPhoto());
		}
		
	}

	

	public Client getHead() {
		return _head;
	}

	public void setHead(Client head) {
		_head = head;
	}
	
	public void print(){
		if (!(this.isEmpty())){
			String res = "";
			Client temp = _head;
			while (temp!=null){
				res += temp.getName().toString() +  " -> "; 
				temp = temp.getNext();
			}
			System.out.println(res + "null");

		}
		else{
			System.out.println("List is empty");
		}
	}

}
