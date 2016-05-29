package nodes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Alejandro Guzman
 * Software Engineering major - UTD
 * 
 * Simple program that takes asks user for the list they wish to make a tree
 * the list is then converted into individual nodes and added to a list
 * once in the list, we assign each node their respective left and right child
 * we then use the list to print out each node and their respective left and right child, if they have any
 */
public class Nodes 
{
    public static List<Node<Integer>> btree(int[] number, int root)
    {
        List<Node<Integer>> nodeList = new ArrayList<Node<Integer>>();
        Node<Integer> rootNode = new Node<Integer>(root);
        int index = 0;
        Node<Integer> currNode;
        
        nodeList.add(rootNode);
        
        for(int i = 0; i < number.length; i++)
        {
            currNode = new Node<Integer>(number[i]);
            nodeList.add(currNode);
        }
        
        for(int k = 0; k < nodeList.size(); k++)
        {
            if(index == nodeList.size()-1)
            {
                break;
            }
            index++;
            nodeList.get(k).left = nodeList.get(index);
            if(index == nodeList.size()-1)
            {
                break;
            }
            index++;
            nodeList.get(k).right = nodeList.get(index);
            
        }
        System.out.print(printer.print(nodeList));
        return nodeList;
    }
    public static void main(String[] args) 
    {
        int[] numbers;
        int size;
        int root;
        Scanner scan = new Scanner(System.in);
        
        System.out.print("Please enter the size of the data set: ");
        size = scan.nextInt();
        numbers = new int[size-1];
        
        System.out.print("Please enter the root number: ");
        root = scan.nextInt();
        
        for(int i = 0; i < size -1; i++)
        {
            System.out.print("Plese enter the next number: ");
            numbers[i] = scan.nextInt();
        }
        btree(numbers, root);
    }
}

class Node<T extends Comparable<?>>
{
    Node<T> left, right;
    T data;
    public Node(T data)
    {
        this.data = data;
    }
}

class printer
{
    public static int print(List<Node<Integer>> list)
    {
        System.out.println();
        for(int i = 0; i < list.size(); i++)
        {
            System.out.println("The " + (i+1) + " number is: " + list.get(i).data);
            if(list.get(i).left == null)
            {
                System.out.println("This node has no children");
                System.out.println();
                continue;
            }
            
            System.out.println("Its left child is: " + list.get(i).left.data);
            
            if(list.get(i).right == null)
            {
                System.out.println("This node has no right child");
                System.out.println();
                continue;
            }
            System.out.println("Its right child is: "+ list.get(i).right.data);
            System.out.println();
        }
        
        return 0;
    }
}
