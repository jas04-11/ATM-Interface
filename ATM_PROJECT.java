package JavaProject;
import java.util.Scanner;

class BankAccount{
	String name;
	String userName;
	String password;
	String accountNo;
	float balance=0f;
	int transaction = 0;
	String transactionHistory="";
	
//register	
	public void register() {
		System.out.println("\n**********************ATM INTERFACE**********************");
		System.out.println("\nRegister here for your Bank Account!");
		Scanner sc=new Scanner(System.in);
		System.out.println("\nEnter your Name: ");
		this .name=sc.nextLine();
		System.out.println("\nEnter your Username: ");
		this .userName=sc.nextLine();
		System.out.println("\nEnter your Password: ");
		this .password=sc.nextLine();
		System.out.println("\nEnter your Account Number: ");
		this .accountNo=sc.nextLine();
		
		System.out.println("\nRegistration Successful. Please Log in to your Bank Account.");		
	}
//login
	public boolean login() {
		boolean inLogin=false;
		Scanner sc=new Scanner(System.in);
			while(!inLogin) {
				System.out.println("\nEnter Your username:");
				String Username=sc.nextLine();
				if(Username.equals(userName)) {
					while(!inLogin) {
						System.out.println("\nEnter your Password: ");
						String Password=sc.nextLine();
						if(Password.equals(password)) {
							System.out.println("\nLogin Successful.");
							inLogin=true;
						}
						else {
							System.out.println("\nIncorrect Password!");
						}
					}
				}else {
					System.out.println("\nUsername not found!");
				}
			}
			return inLogin;
			
	}
//withdraw
	public void withdraw() {
		System.out.println("\nEnter amount to withdraw");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		try {
			if(balance>=amount) {
				transaction++;
				balance-=amount;
				System.out.println("\nWithdraw Successful!");
				String str=amount+" Rs Withdrawn\n";
				transactionHistory=transactionHistory.concat(str);
			}else {
				System.out.println("\nInsufficient Balance");
			}
		}catch(Exception e){
			
		}
		
	}
	
//deposit
	public void deposit() {
		System.out.println("\nEnter amount to deposit");
		Scanner sc=new Scanner(System.in);
		float amount=sc.nextFloat();
		try {
			if(amount<=10000f) {
				transaction++;
				balance+=amount;
				System.out.println("\nDeposit Successful!");
				String str=amount+" Rs Deposited\n";
				transactionHistory=transactionHistory.concat(str);
			}else {
				System.out.println("\n Sorry . Limit is 10000/-");
			}
		}catch(Exception e){
			
		}
		
	}

//transfer
	public void transfer() {
		Scanner sc=new Scanner(System.in);

		System.out.println("\nEnter Recipients name:");
		String recepient=sc.nextLine();
		System.out.println("\nEnter amount to tranfer:");
		
		float amount=sc.nextFloat();
		try {
			if(balance>=amount) {

			if(amount<=50000f) {
				transaction++;
				balance-=amount;
				System.out.println("\nTransfer Successful to "+recepient);
				String str=amount+" Rs Transferred to "+recepient+ "\n";
				transactionHistory=transactionHistory.concat(str);
			}else {
				System.out.println("\n Sorry . Limit is 50000/-");
			}
		}else{
			System.out.println("\nInsufficient Balance!!");
			}}catch(Exception e){
		}
			
		}

	//checkBalance
	public void checkBalance() {
		System.out.println("\n"+balance +"Rs");
		
	}

//transaction history
	public void transactionHistory() {
		if(transaction==0) {
			System.out.println("No transaction happened!");
		}else {
			System.out.println("\n"+transactionHistory);
		}
}
}

//ATM Interface
public class ATM_PROJECT {
	public static int takenIntegerInput(int limit) {
		int input=0;
		boolean flag=false;
		while(!flag) {
			try {
				Scanner sc=new Scanner(System.in);
				input=sc.nextInt();
				flag=true;
				
				if(flag && input>limit || input<1) {
					System.out.println("Choose number between 1 to " + limit);
					flag=false;
				}
				
			}catch(Exception e) {
				System.out.println("\nEnter only integer value.");
						flag=false;
			}
		}
		return input;
	}
	
	
	public static void main(String args[]) {
		System.out.println("*********************************WELCOME TO ATM INTERFACE********************************");
		System.out.println("\n 1. Register \n 2. Exit");
		System.out.println("Choose one option");
		int choose=takenIntegerInput(2);
		
		if(choose==1) {
			BankAccount b=new BankAccount();
			b.register();
			while(true) {
				System.out.println("\n 1. Login \n 2. Exit");
				System.out.println("Choose one option");
				int ch=takenIntegerInput(2);
				
				if(ch==1) {
					if(b.login()) {
						System.out.println("*********************************WELCOME BACK "+ b.name +"********************************");
						boolean isFinished=false;
						while(!isFinished) {
							System.out.println("\n 1. Widhdraw \n 2. Deposit \n 3. Transfer \n 4. Check Balance \n 5. Transaction History \n 6. Exit");
							System.out.println("Choose one option");
							int c=takenIntegerInput(6);
							
							switch(c) {
							case 1:
								b.withdraw();
								break;
							case 2:
								b.deposit();
								break;
							case 3:
								b.transfer();
								break;
							case 4:
								b.checkBalance();
								break;
							case 5:
								b.transactionHistory();
								break;
							case 6:
								isFinished=true;
								break;
							
							}
														
						}
					}
					else {
						System.exit(0);
					}
				}else {
					System.exit(0);
				}

			}
		}


	}
}
