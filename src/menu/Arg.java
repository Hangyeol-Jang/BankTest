package menu;

import input.Input;
import printer.Printer;
import processor.Processor;

public class Arg {
	public static final Processor prc = Processor.instance();
	public static final Menu me = Menu.instance();
	public static final Printer prnt = Printer.instance();	
	public static final Input in = Input.instance();
	
	public static final int num_of_print_menu_per_line = 3;
	public static final String[] menu1 = {"테스트1.test1","테스트2.test2","테스트3.test3","테스트4.test4"};
	
}
