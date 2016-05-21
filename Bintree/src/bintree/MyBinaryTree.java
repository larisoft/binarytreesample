/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bintree;

/** 
 * @author Larry
 */
public class MyBinaryTree {
    
    Node root = null;
    
    public MyBinaryTree(){ 
    }
    
    
    /*this is the method accessible to outsiders with regards to inserting new
    items into the tree */
    public void insert(int i){
        
        root = insert(root, i);
    }
    
    /*This is the internal method that does the actual inserting using recursion *
    * We use recursion because we need to insert at the last generation of the tree - 
    not just  anywhere */
    private Node insert(Node n, int data){ 


        if(n==null){ 
            n  = new Node(data); 
        }
        else{
            
            //we are also trying to sort the data while inserting, 
            // hence, all values that are lower than this node's value go to the left
            //while those greater than it go to the right
            if(data < n.value()){
                
                n.left = insert(n.left, data);
            }
            else{
                n.right = insert(n.right, data);
            }
            
        }
        
        return n;
    }
    
    
    //this prints all the contents in the tree
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
    
    
    //get the least item, we use the internal getleast method to scan the left side 
    //recursively. The lowest value is always guaranteed to be in the left hand side of 
    //the leftmost node, due to our insertion method.
    public int getMin(){
        
        return getLeast(root);
    }  
    
   
    private  int getLeast(Node root){
        
        if(root.left==null) return root.value();
        
        return getLeast(root.left);
    }
    
    
     /*@Get the maximum value in this tree */
      //get the highest item, we use the internal getHighest method to scan the right side 
    //recursively. The Highest value is always guaranteed to be in the right hand side of 
    //the righttmost node, due to our insertion method.
 
    public int getMax(){
        
        return getHighest(root);
    }
    
    private int getHighest(Node root){
        
        if(root.right==null) return root.value();
        
        return getHighest(root.right);  
    }
    
    
    //count this node, then count the nodes under it.
    //recursion rocks!
    private int countNodes(Node n){
       
        if(n==null) return 0;
        
        else {
            
            int count = 1; 
            count+= countNodes(n.left);
            count+= countNodes(n.right);
            
            return count;
            
        }
        
        
    }
    

    //search the root node, then the nodes under it, going left first and then right
    //this search can be better optimized to perform in log(n) time.
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
