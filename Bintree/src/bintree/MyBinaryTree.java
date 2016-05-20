/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bintree;

/**
 *
 * @author Larry
 */
public class MyBinaryTree {
    
    Node root = null;
    
    public MyBinaryTree(){ 
    }
    
    
    public void insert(int i){
        
        root = insert(root, i);
    }
    
    private Node insert(Node n, int data){ 
        if(n==null){ 
            n  = new Node(data); 
        }
        else{
            
            if(data < n.value()){
                
                n.left = insert(n.left, data);
            }
            else{
                n.right = insert(n.right, data);
            }
            
        }
        
        return n;
    }
    
    
    
    public void printInOrder(){
        
        printInOrder(root);
        
    }
    
    private void printInOrder(Node n){
        
        System.out.print("  " + n.value());
        if(n.left !=null){
        printInOrder(n.left );
        }
        
        if(n.right !=null){
        printInOrder(n.right );
        }
        
    }
    
    
    public int getMin(){
        
        return getLeast(root);
    }  
    
   
    private  int getLeast(Node root){
        
        if(root.left==null) return root.value();
        
        return getLeast(root.left);
    }
    
    
     /*@Get the maximum value in this tree */
    public int getMax(){
        
        return getHighest(root);
    }
    
    private int getHighest(Node root){
        
        if(root.right==null) return root.value();
        
        return getHighest(root.right);  
    }
    
    
    
    private int countNodes(Node n){
       
        if(n==null) return 0;
        
        else {
            
            int count = 1; 
            count+= countNodes(n.left);
            count+= countNodes(n.right);
            
            return count;
            
        }
        
        
    }
    
    public boolean contains(int value){
        
        return exists(value, root);
        
    }
    
    private boolean exists(int val, Node root){
        
        if(root == null ) return false;
        
        if(root.value() == val) return true;
        
        if(!exists(val, root.left)){
            
            return exists(val, root.right);
        }
        else{
            
            return true;
        }
         
    }
    
    public boolean isEmpty(){
        
        return root == null;
    }
    private void log(String message){
        System.out.println(message);
    }
}
