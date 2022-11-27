import java.util.*;

class NegativeAmtException extends Exception
  {
	String msg;
	NegativeAmtException(String msg)
	 {
	    this.msg=msg;
	 }
public String toString()
  {
     return msg;
  }
  }
class BankAccount
  {
      private double balance;
	private int accountNumber;
	public BankAccount(int accountNumber,double initialBalance)throws 
	NegativeAmtException
  {
if(initialBalance<0)
	throw new NegativeAmtException("Initial amount should not be negative!");
	balance = initialBalance;
	this.accountNumber = accountNumber;
  }
public void deposit(double amount)throws NegativeAmtException
   {
	if (amount < 0)
	  {
	      throw new NegativeAmtException("Don't deposit negative amount!");
	  }
	      balance = balance + amount;
	      System.out.println("Amount deposited");
	      System.out.println("Balance amount : "+getBalance());
   }
public void withdraw(double amount)throws NegativeAmtException
   {
	if (amount < 0) 
  	  {
	  throw new NegativeAmtException("Don't withdraw a negative amount!");
}
else if(amount<=balance)
{
balance = balance - amount;
}
else
{
System.out.println("Insufficient amount");
}
System.out.println("Balance amount : "+getBalance());
}
public double getBalance() 
{
return balance;
}
public int getAccountNumber() 
{
return accountNumber;
}
public String toString () 
{
return "Account Number :" + accountNumber + " Balance :" + balance;
}
}
public class UserDefinedException
  {
    public static void main(String[] args)
     {
       int ch,amt;
	 Scanner sc=new Scanner(System.in);
	 System.out.print("Enter Account Number:");
	 int a=sc.nextInt();
	 System.out.print("Enter the initial Amount:");
 	 int b=sc.nextInt();
	 BankAccount ac;
 	 try
	   {
		ac=new BankAccount(a,b);
		while(true)
	        {
System.out.println("Main Menu");
System.out.println("1.Deposit \n2.Withdraw \n3.Check Balance \n4.Display \n5.Exit");
System.out.print("Enter your Choice: ");
ch=sc.nextInt();
switch(ch)
{
case 1:
System.out.print("Enter the amount to deposit:");
amt=sc.nextInt();
ac.deposit(amt);
break;
case 2:
System.out.print("Enter the amount to Withdraw:");
amt=sc.nextInt();
ac.withdraw(amt);
break;
case 3:
System.out.println("Balance amount :"+ac.getBalance());
break;
case 4:
System.out.println("Your account details\n"+ac);
break;
case 5:
sc.close();
System.exit(0);
default:
System.out.println("Invalid Choice");
}
}
}
catch(NegativeAmtException e)
{
System.out.println("Exception Caught : "+e);
}
}
}