package menu;

import java.lang.reflect.Method;
import java.util.Map;

public class Menu {
	// Singleton으로 하나의 객체만 생성되도록 설정.
	private static Menu singleton = new Menu();

	public static Menu instance() {
		return singleton;
	}

	private Menu() {
	}

	// 종료 플래그. 해당 플래그를 통해 프로그램의 종료를 컨트롤한다.
	// 플래그의 변경은 Menu 클래스에서만 가능하다.
	private boolean exit = false;

	public void setExit() {
		this.exit = true;
	}

	public boolean getExit() {
		return this.exit;
	}

	public void mainMenu() {
		this.frame_menu(Arg.menu1);
	}
	public void test1() {}
	public void test2() {}
	public void test3() {}
	public void test4() {this.setExit();}

	// 메뉴 실행 틀을 만드는 메서드. 모든 메뉴 메서드에서 사용된다.
	private void frame_menu(String[] menuArr) {
		String str;
		Map<String, Method> menuMap = Arg.prc.menuMap(menuArr);

		while (!this.exit) {
			Arg.prnt.menu(menuArr);
			System.out.print(">> 메뉴 번호를 입력해 주세요 : ");
			str = Arg.in.input();
			if (str == null) {
				System.out.println("\n # 강제종료를 입력하셨습니다.");
				this.setExit();
			} else if (menuMap.containsKey(str)) {
				try {
					menuMap.get(str).invoke(Arg.me);
				} catch (Exception e) {
					this.setExit();
					e.printStackTrace();
				}
			} else {
				System.out.println(" # 잘못된 입력입니다.");
			}
			System.out.println();
		}
	}
}
