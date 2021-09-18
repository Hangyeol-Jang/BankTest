package printer;

import menu.Arg;

public class Printer {
	private static Printer singleton = new Printer();

	public static Printer instance() {
		return singleton;
	}

	private int num_menu;
	private Printer() {
//		메뉴를 출력할 때, 한 줄에 출력하는 메뉴의 개수는 최소 3개이다.
		this.num_menu = Arg.num_of_print_menu_per_line;
		this.num_menu = (this.num_menu>3?this.num_menu:3);
	}
	
//	상단 라인을 출력하는 메서드
	public void upperLine() {
		System.out.print("┌");
		for (int i = 0; i < this.num_menu; i++) {
			if (i == 0)	System.out.print("───────────────");
			else		System.out.print("────────────────");
		}
		System.out.println("┐");
	}
//	상단 라인을 출력하는 메서드
	public void lowerLine() {
		System.out.print("└");
		for (int i = 0; i < this.num_menu; i++) {
			if (i == 0)
				System.out.print("───────────────");
			else
				System.out.print("────────────────");
		}
		System.out.println("┘");
	}
//	메뉴를 출력하는 메서드
	public void menu(String[] menu) {
		this.upperLine();
		
		int cycle = menu.length / this.num_menu;
		if (menu.length % this.num_menu > 0)
			cycle = cycle + 1;
		
		String temp = "";
		int cnt = 0;
		for (int i = 0; i < cycle; i++) {

			for (int j = 0; j < this.num_menu; j++) {
				
				temp = "";

				if (j == 0)	temp += "| ";
				else		temp += "  ";

				if (cnt < menu.length)
					temp += ((cnt + 1) + "." + ((menu[cnt]).split("\\."))[0]);
				
				System.out.print(temp + "\t");
				
				if (temp.length() < 7)	System.out.print("\t");
				
				cnt++;
			}
			System.out.println("|");
		}
		
		this.lowerLine();
	}
}
