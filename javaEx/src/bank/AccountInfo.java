package bank;
import java.util.Scanner;

import bank.exception.OwnerCheckException;
import bank.exception.subBalanceException;

public class AccountInfo {
	private String accountNumber; // 계좌 번호
	private String ownerName; // 계좌주 명
	private int balance = 0; // 잔액
	private String ownerTel; // 전화번호
	private boolean ownerCheck = false; // 계좌주 확인 
	private int chance = 3;
	
	AccountInfo(){}
	
	AccountInfo(String accountNumber,String ownerName, String ownerTel){
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.ownerTel = ownerTel;
	}

	// getter/setter
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	protected int getBalance() throws Exception {
		if(ownerCheck) {
			return balance;
		}else {
			throw new OwnerCheckException("계좌주 확인필요 ");
		}
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getOwnerTel() {
		return ownerTel;
	}
	public void setOwnerTel(String ownerTel) {
		this.ownerTel = ownerTel;
	}
	public boolean isOwnerCheck() {
		return ownerCheck;
	}
	public void setOwnerCheck(boolean ownerCheck) {
		this.ownerCheck = ownerCheck;
	}
	
	public boolean isOwnerAccept() {
		
		return false;
	}
	
	// 계좌주 확인 
	protected boolean ownerCheckMethod() {
		Scanner sc = new Scanner(System.in);
		System.out.print("계좌주 :  ");
		String ownerName = sc.nextLine();
		System.out.print("계좌주 전화번호 :  ");
		String ownerTel = sc.nextLine();
		
		if(this.ownerName.equals(ownerName) && this.ownerTel.equals(ownerTel)){
			System.out.println("계좌주 확인되었습니다.");
			ownerCheck = true;
			chance = 3;
			return true;
			}
		else {
			System.out.println("확인실패 !!");
			ownerCheck = false;
			chance--;
			return false;
		}

	}
	
	// 입금
	protected int addBalance(int money) throws Exception{
		if(ownerCheckMethod()) { 
			System.out.println("입금합니다. ");
			balance += money;
			return balance;
		}else {
			throw new OwnerCheckException("계좌주 확인필요 ");
		}
	}
	
	// 출금 
	protected int subBalance(int money)throws Exception{
		if(ownerCheckMethod()) {
			if(balance >= money ) {
				System.out.println("출금합니다. ");
				balance -= money;
				return balance;
			}else {
				throw new subBalanceException("잔액이 부족합니다. ");
			}
		}else {
			throw new OwnerCheckException("계좌주 확인필요 ");
		}
	}
}
