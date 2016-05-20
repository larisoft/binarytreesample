/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bintree;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Larry
 * we demonstrate the use of binary tree here.
 */
public class BinaryTreeSample {
   
    static  MyBinaryTree tree = new MyBinaryTree();
    
    public static void main(String[] args){
         
        
         //instructions: modify it to suit your whims!!!
         String instructions = "This program demonstrates the use of a Binary Tree data structure. Press: \n"
                 + "\n1. To Insert value \n2. To Print Lowest Value \n"
                 + "3. To Print Maximum \n4. To Search value"
                 + "\n5. To Exit";
         
         Scanner scanner = new Scanner(System.in);
          
         
         boolean running = true;
         while(running){ 
             output(instructions);
             int  n = scanner.nextInt();  
             //move to the end of the line....scanner object has issues when you acept integer values,.
             scanner.nextLine();
             
             switch(n){
                 case 1:
                     insert();
                     break;
                     
                 case 2:
                     lowest();
                     break;
                 case 3:
                     maximum();
                     break;
                 case 4:
                     search();
                     break;
                     
                 case 5:
                     running = false;
                     break; 
             } 
         }  
    }
    
    
    private static void insert(){
        
        int count = 1;
        Scanner sc = new Scanner(System.in);
        int num = 0;
        while(num!=-1){
            
            output("Value no "+ count+"; Enter -1 to finish inserting");
            
            num = sc.nextInt();
            sc.nextLine();
            
            if(num!=-1){
                tree.insert(num);
            }
            else{
                break;
            }
            
            count++;
        }
    }
        
        private static void output(String message){
            System.out.println(message);
        }
    
        
        private static void lowest(){
            if(tree.isEmpty()){
                output("Tree is Empty!");
                return;
            }
            output("lowest is " + tree.getMin());
        }
        
        private static void maximum(){
            
            if(tree.isEmpty()){
                output("Tree is Empty!");
                return;
            }
            output("Highest is " + tree.getMax());
        }
        
        private static void search(){
            if(tree.isEmpty()){
                output("Tree is Empty!");
                return;
            }
              
            output("Enter value to search for: " );
            
            Scanner sc = new Scanner(System.in);
            int s = sc.nextInt();
            
            sc.nextLine(); 
            boolean found = tree.contains(s);
            
            if(found){ 
                output(s + " Found in tree");
            }
            else{  
                output(s + " Does not exist in tree");
            }
            
        }
}
