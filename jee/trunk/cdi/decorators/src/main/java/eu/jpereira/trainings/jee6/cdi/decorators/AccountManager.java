package eu.jpereira.trainings.jee6.cdi.decorators;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;


@SessionScoped
public @Model
class AccountManager implements Serializable {

	public enum AccountType {
		Standard,
		Student,
		Good;
	}
	
	private static final long serialVersionUID = -3101126362251953732L;
	//1 - Uncomment the following line
	//private @Inject @StandardAccount Account stdAccount;

	//2 - Uncomment the following line
	//private @Inject @StudentAccount Account studentAccount;
	
	//3 - Uncomment the following line
	//private @Inject @GoodAccount Account goodAccount;
	
	private Float withdrawAmmount;

	public void withdraw(AccountType accountType) throws Exception{
		System.out.println("Withdraw from account " + accountType+" Ammount: "+this.withdrawAmmount);
		// 4 - Ucomment the following switch statement
		/*
		switch (accountType) {
		case Standard:
			this.stdAccount.withdraw(this.withdrawAmmount);
			break;
		case Student:
			this.studentAccount.withdraw(this.withdrawAmmount);
			break;
		case Good:
			this.goodAccount.withdraw(this.withdrawAmmount);
			break;
		default:
			throw new Exception("Are you ok?");
		}*/
		this.withdrawAmmount = 0f;
		
		
	}

	/*** Getters and setters **/
	//5 - Create getters and setters for stdAccount, studentAccount and goodAccount. Use eclipse.
	
	public void setWithdrawAmmount(Float withdrawAmmount) {
		this.withdrawAmmount = withdrawAmmount;
	}

	public Float getWithdrawAmmount() {
		return withdrawAmmount;
	}

}
