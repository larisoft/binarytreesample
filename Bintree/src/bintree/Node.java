/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bintree;
/** Node models a nonempty tree node, holding a value and two subtrees  */
public class Node
{ private int data;
  public Node left;
  public Node right;
 
  public Node(int data)
  { this.data = data; 
  }

  public int value()
  { return data; } 

}
