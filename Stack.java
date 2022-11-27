import java.util.Scanner;
public class Stack 
 {
   private int maxsize, top;
   private int[] st;
   public Stack(int size) 
   {
      maxsize = size;
      st = new int[maxsize];
      top = -1;
   }
      boolean isEmpty()
       {
         return top==-1;
       }
      boolean isFull()
       {
      return top==maxsize-1;
       }
public void push(int element) 
  {
    if(isFull())
      System.out.println("Overflow");
    else
      st[++top] = element;
   }
public int pop() 
   {
    if(isEmpty()) 
     {
        System.out.println("UnderFlow");
        return (-1);
     }
    return (st[top--]);
   }
public void printStack() 
  {
    System.out.print("Stack Elements:");
    for (int i = top; i>=0; i--)
    System.out.println(st[i]);
  }

public static void main(String[] args) 
  {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter stack size");
    int size=sc.nextInt();
    Stack obj = new Stack(size);
    while (true) 
  {
    System.out.println("\nSTACK\n*****\n1.PUSH\n2.POP\n3.Display\n4.EXIT\nEnter your choice");
    int ch = sc.nextInt();
    switch (ch) 
     {
       case 1:
          System.out.print("Enter Element");
          int n = sc.nextInt();
          obj.push(n);
          break;
	 case 2:
	    System.out.printf("Poped element is %d", obj.pop());
          break;
       case 3:
          obj.printStack();
          break;
       case 4:
          System.exit(0);
       default:
          System.out.println("Wrong option");
      }
    }
  }
}