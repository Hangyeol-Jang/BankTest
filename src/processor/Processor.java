package processor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import menu.Menu;

public class Processor {
//	���α׷� ��ü�� ��ü�� �ϳ��� �����ǵ��� ����
	private static Processor singleton = new Processor();

	public static Processor instance() {
		return singleton;
	}

	private Processor() {	}

//	�޴��� ���� �迭�� �޾Ƽ�, Ÿ�� �޼���� �ٷ� ������ �� �ִ� ��ųʸ�(HashMap)�� �����ϴ� �޼���.
//	��ųʸ��� ��ȯ�Ѵ�.
	public Map<String, Method> menuMap(String[] menu) {
		Map<String, Method> menuMap = new HashMap<>();
		
		try {
			Class<?> cls = Class.forName(Menu.class.getTypeName());
			String[] str= new String[2]; // 0: �޴���ȣ   1: �޼����̸�
			
			int cnt = 1;
			for(String s : menu) {
				str = s.split("\\.");
				menuMap.put(""+cnt++, cls.getMethod(str[1]));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return menuMap;
	}
}
