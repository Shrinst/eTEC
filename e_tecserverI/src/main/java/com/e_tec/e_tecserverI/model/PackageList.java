package com.e_tec.e_tecserverI.model;

public class PackageList {
	
	private Package _head; 

	public PackageList(){
		_head = null;
	}
	
	public boolean isEmpty(){ 
		return _head == null;
	}
	
	public void insertFirst(Package newNode){
		if  (!(this.isEmpty())){
			newNode.setNext(this.getHead());
			this.setHead(newNode);
		}
		this.setHead(newNode);
	}
	
	public void insertLast(Package newNode){
		if (!(this.isEmpty())){
			Package temp = _head;
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
				Package temp = _head;
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
	
	public void delete(int element){
		if (!this.isEmpty()){
			if (_head.getCode() == element && _head.getNext() == null){
				_head = null;
			}
			else if (_head.getCode() == element){
				this.deleteFirst();
			}
			else{
				Package temp = _head;
				while (temp.getNext() != null){
					if (temp.getNext().getCode() == element){
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
	
	
	public Package search(int element){
		Package temp =  _head;
		boolean flag = false;
		if (!(this.isEmpty())){
			while (temp!=null){
				if (temp.getCode()==element){
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
	
	public void updateNode(int code, Package newInfo){
		Package oldInfo = this.search(code);
		if (oldInfo != null){
			
			oldInfo.setStatus(newInfo.getStatus());
		}
	}
	

	public Package getHead() {
		return _head;
	}

	public void setHead(Package head) {
		_head = head;
	}
	
	public void print(){
		if (!(this.isEmpty())){
			String res = "";
			Package temp = _head;
			while (temp!=null){
				res += temp.getCode() +  " -> "; 
				temp = temp.getNext();
			}
			System.out.println(res + "null");

		}
		else{
			System.out.println("List is empty");
		}
	}
}
