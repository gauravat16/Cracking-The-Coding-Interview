package com.cci.queue;

import java.util.ArrayList;

public class Queue<E> {
	
	Node<E> root=null;
	
	public Queue() {
	}
	
	
	public void add (E e){
		if(root==null){
			root=new Node<>();
			root.data=e;
		}else{
			
			if(root.childList.size()<10){
				root.childList.add(new Node<E>());
			}else{
				
			}
			
			
		}
		
		
	}
	
	public Node<E> getNodeToAddOn(Node<E> n){
		
		if(n.childList.size()<10){
			return n;
		}
		
		if(n.childList.size()==10){
			
		}
		
		return null;
		
	}
	
//	public Node depthFirstSearch(Node n){
//		
//		if(n.childList.size()==0){
//			return n;
//		}
//		
//		return depthFirstSearch(n.childList.)
//		
//		
//		return null;
//	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
