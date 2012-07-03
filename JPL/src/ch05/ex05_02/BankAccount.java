package ch05.ex05_02;

import java.util.Date;


public class BankAccount {
	
	private History history = new History();
	private long number;
	private long balance;
	
	public class Action {
		private String act;
		private long amount;
		private Date date; 
		
		Action(String act, long amount) {
			this.act = act;
			this.amount = amount;
			this.date = new Date();
		}
		
		public String toString() {
			return date+": " + act + " " + amount;
		}
	}
	
	public class History {
		private Action[] actions = new Action[10];
		
		private void addAction(Action action) {
			Action currentAction = action;
			Action preAction = null;
			for (int i = 0; i < actions.length; i++) {
				preAction = actions[i];
				actions[i] = currentAction;
				currentAction = preAction;
			}
		}
		
		public String toString() {
			String result = "AccountNumber:"+ number+ "\n";
			for (int i = 0; i < actions.length; i++) {
				result += "["+ i + "]" + actions[i].toString() + "\n";
			}
			
			return result;
		}
	}
	
	public BankAccount(long number) {
		this.number = number;
	}
	public History history() {
		return history;
	}
	
	public void deposit(long amount) {
		balance += amount;
		history.addAction(this.new Action("deposit", amount));
	}
	
	public void withdraw(long amount) {
		balance -= amount;
		history.addAction(new Action("withdraw", amount));
	}
	
	public static void main(String args[]) {
		
		BankAccount ba = new BankAccount(10000);
		for (int i = 0; i < 9; i++)
			ba.deposit(20000);
		
		ba.withdraw(10000);
		BankAccount.History history = ba.history();
		System.out.println("BankAccount History\n"+history);
		
		ba.withdraw(100000);
		ba.deposit(1000);
		System.out.println("BankAccount History\n"+history);

		
	}
}

