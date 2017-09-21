package testreflect;

import org.junit.Test;

import droolscours.Account;

public class TestFeflect {
	Account account = new Account();

	class Box<T> {
		private T data;
		
		public Box() {
			
		}

		public T getData() {
			return data;
		}

		public void setData(T data) {
			this.data = data;
		}
		
	}
	
	@Test
	public void test1() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		System.out.println("输出类名看看"+Account.class);
		Class name = Class.forName("droolscours.Account");
	    Object o = name.newInstance();
	    System.out.println("看看tostring 的结果"+o.toString());
	    
	}
	
	@Test
	public void test2() {
		Box<Account> temp = new Box<Account>();
		
	}
	
}
