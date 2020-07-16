package aop002;

public class Girl {
	
	public void runSomething() {
		System.out.println("열쇠로 문 열고 집 들어가기");
		
		try {
			System.out.println("요리한다.");
		} catch (Exception ex) {
			if (ex.getMessage().equals("집에 불 남")) {
				System.out.println("119 신고");
			}
		} finally {
			System.out.println("소등 후 취침");
		}
		System.out.println("자물쇠 잠그고 집 나서기");
	}


}
