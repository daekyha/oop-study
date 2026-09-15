
public class Account {
	public static int id = 20251015;
	int account_id;
	int money;

	/* ==================생성자===================== */
	public Account(int money_init) {
		this.account_id = id++;
		this.money = money_init;

		System.out.println("========= 계좌 생성 ==========");
		System.out.println("[계좌번호] " + this.account_id);
		System.out.println("[잔액] " + this.money + "원");
		System.out.println("==============================");
	}

	/* ==================매서드===================== */

	// 입금 - 단일입력
	public void deposit(int money_in) {
		this.money += money_in;
	}

	// 입금 - 다중입력
	public void deposit(int[] money_in) {
		for (int n : money_in) {
			this.money += n;
		}
	}

	// 현재 잔액 리턴
	public int getBalance() {
		return money;
	}

	// 인출 요청 금액 -> 잔액 비교후 인출
	public int withdraw(int money_out) {
		try {
			if (money - money_out < 0) {
				throw new IllegalArgumentException("잔금부족");
			}
			// 잔금 여유
			System.out.print("[정상인출] ");
			money -= money_out;
			return money_out;
			
		} catch (IllegalArgumentException e) {
			System.out.print("[잔금부족] ");
			int tmp = money;
			money = 0;
			return tmp;

		}

	}

	/* ==================메인===================== */
	public static void main(String[] args) {
		// Account a
		Account a = new Account(100);
		a.deposit(5000);
		System.out.println("잔금은 " + a.getBalance() + "원 입니다.");

		int bulk[] = { 100, 500, 200, 700 };
		a.deposit(bulk);
		System.out.println("잔금은 " + a.getBalance() + "원 입니다.");

		int money = 10000;
		int wMoney = a.withdraw(money);
		if (wMoney < money) {
			System.out.println(wMoney + "원만 인출");
		} else {
			System.out.println(wMoney + "원 인출");
		}
		System.out.println("잔금은 " + a.getBalance() + "원입니다.");

		// Account b
		System.out.print("\n");
		Account b = new Account(100000);
		b.deposit(7000);
		System.out.println("잔금은 " + b.getBalance() + "원 입니다.");

		money = 10000;
		wMoney = b.withdraw(money);

		if (wMoney < money) {
			System.out.println(wMoney + "원만 인출");
		} else {
			System.out.println(wMoney + "원 인출");
		}
		System.out.println("잔금은 " + b.getBalance() + "원입니다.");

	}

}
