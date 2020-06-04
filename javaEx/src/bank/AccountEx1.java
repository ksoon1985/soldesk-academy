package bank;

import bank.exception.OwnerCheckException;
import bank.exception.subBalanceException;

public class AccountEx1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//									계좌번호 	이름 		번호
		AccountInfo ainfo1 = new AccountInfo("123","권순환","123");
		
		// 입금
		try {
			ainfo1.addBalance(10000);
			System.out.println("잔액 : "+  ainfo1.getBalance());
			
		} catch (OwnerCheckException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		// 출금
		try {
			ainfo1.subBalance(20000);
			System.out.println("잔액 : "+  ainfo1.getBalance());
		}catch (OwnerCheckException e) {
			System.out.println(e.getMessage() + " " + e.getClass());
		}catch(subBalanceException e) {
			System.out.println(e.getMessage() + " " + e.getClass());
		}

	}
}
