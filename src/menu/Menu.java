package menu;

import java.lang.reflect.Method;
import java.util.Map;

public class Menu {
	// Singleton���� �ϳ��� ��ü�� �����ǵ��� ����.
	private static Menu singleton = new Menu();

	public static Menu instance() {
		return singleton;
	}

	private Menu() {
	}

	// ���� �÷���. �ش� �÷��׸� ���� ���α׷��� ���Ḧ ��Ʈ���Ѵ�.
	// �÷����� ������ Menu Ŭ���������� �����ϴ�.
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

	// �޴� ���� Ʋ�� ����� �޼���. ��� �޴� �޼��忡�� ���ȴ�.
	private void frame_menu(String[] menuArr) {
		String str;
		Map<String, Method> menuMap = Arg.prc.menuMap(menuArr);

		while (!this.exit) {
			Arg.prnt.menu(menuArr);
			System.out.print(">> �޴� ��ȣ�� �Է��� �ּ��� : ");
			str = Arg.in.input();
			if (str == null) {
				System.out.println("\n # �������Ḧ �Է��ϼ̽��ϴ�.");
				this.setExit();
			} else if (menuMap.containsKey(str)) {
				try {
					menuMap.get(str).invoke(Arg.me);
				} catch (Exception e) {
					this.setExit();
					e.printStackTrace();
				}
			} else {
				System.out.println(" # �߸��� �Է��Դϴ�.");
			}
			System.out.println();
		}
	}
}
