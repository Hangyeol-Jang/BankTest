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
	public static final String[] menu1 = {"�׽�Ʈ1.test1","�׽�Ʈ2.test2","�׽�Ʈ3.test3","�׽�Ʈ4.test4"};
	
}
