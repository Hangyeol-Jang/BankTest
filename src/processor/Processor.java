package processor;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import menu.Menu;

public class Processor {
//	프로그램 전체에 객체가 하나만 생성되도록 설정
	private static Processor singleton = new Processor();

	public static Processor instance() {
		return singleton;
	}

	private Processor() {	}

//	메뉴를 담은 배열을 받아서, 타겟 메서드로 바로 연결할 수 있는 딕셔너리(HashMap)을 생성하는 메서드.
//	딕셔너리를 반환한다.
	public Map<String, Method> menuMap(String[] menu) {
		Map<String, Method> menuMap = new HashMap<>();
		
		try {
			Class<?> cls = Class.forName(Menu.class.getTypeName());
			String[] str= new String[2]; // 0: 메뉴번호   1: 메서드이름
			
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
