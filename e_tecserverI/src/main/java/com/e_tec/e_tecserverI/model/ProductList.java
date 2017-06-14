package com.e_tec.e_tecserverI.model;

public class ProductList {

private Product _head;
	
	public ProductList(){
		_head = null;
	}
	
	public boolean isEmpty(){ 
		return _head == null;
	}
	
	public void insertFirst(Product newNode){
		if  (!(this.isEmpty())){
			newNode.setNext(this.getHead());
			this.setHead(newNode);
		}
		this.setHead(newNode);
	}
	
	public void insertLast(Product newNode){
		if (!(this.isEmpty())){
			Product temp = _head;
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
				Product temp = _head;
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
			if (_head.getId() == element && _head.getNext() == null){
				_head = null;
			}
			else if (_head.getId() == element){
				this.deleteFirst();
			}
			else{
				Product temp = _head;
				while (temp.getNext() != null){
					if (temp.getNext().getId() == element){
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
	
	
	public Product search(int element){
		Product temp =  _head;
		boolean flag = false;
		if (!(this.isEmpty())){
			while (temp!=null){
				if (temp.getId()==element){
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
	
	public void updateNode(int id, Product newInfo){
		Product oldInfo = this.search(id);
		if (oldInfo != null){
			oldInfo.setAmount(newInfo.getAmount());
			oldInfo.setCategory(newInfo.getCategory());
			oldInfo.setDescription(newInfo.getDescription());
			oldInfo.setImageURL(newInfo.getImageURL());
			oldInfo.setPrice(newInfo.getPrice());
		}
	}
	

	public Product getHead() {
		return _head;
	}

	public void setHead(Product head) {
		_head = head;
	}
	
	public void print(){
		if (!(this.isEmpty())){
			String res = "";
			Product temp = _head;
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
