package eu.jpereira.trainings.jee6.cdi.decorators.model;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Model;
import javax.inject.Inject;

import eu.jpereira.trainings.jee6.cdi.decorators.model.qualifiers.GoodAccount;
import eu.jpereira.trainings.jee6.cdi.decorators.model.qualifiers.StandardAccount;
import eu.jpereira.trainings.jee6.cdi.decorators.model.qualifiers.StudentAccount;


@SessionScoped
public @Model
class AccountManager implements Serializable {

	public enum AccountType {
		Standard,
		Student,
		Good;
	}
	
	private static final long serialVersionUID = -3101126362251953732L;
	private @Inject
	@StandardAccount
	Account stdAccount;
	private @Inject
	@StudentAccount
	Account studentAccount;
	private @Inject
	@GoodAccount
	Account goodAccount;
	
	private Float withdrawAmmount;

	public void withdraw(AccountType accountType) throws Exception{
		System.out.println("Withdraw from account " + accountType+" Ammount: "+this.withdrawAmmount);
		
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
			break;
		}
		this.withdrawAmmount = 0f;
		
		
	}

	/*** Getters and setters **/
	public void setStdAccount(Account stdAccount) {
		this.stdAccount = stdAccount;
	}

	public Account getStdAccount() {
		return stdAccount;
	}

	public void setStudentAccount(Account studentAccount) {
		this.studentAccount = studentAccount;
	}

	public Account getStudentAccount() {
		return studentAccount;
	}

	public void setGoodAccount(Account goodAccount) {
		this.goodAccount = goodAccount;
	}

	public Account getGoodAccount() {
		return goodAccount;
	}

	public void setWithdrawAmmount(Float withdrawAmmount) {
		this.withdrawAmmount = withdrawAmmount;
	}

	public Float getWithdrawAmmount() {
		return withdrawAmmount;
	}

}
