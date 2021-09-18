package input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Input {
	private static Input singleton = new Input();

	public static Input instance() {
		return singleton;
	}
	
	BufferedReader br;
	private Input() {
		InputStream is = System.in;
		InputStreamReader isr = new InputStreamReader(is);
		this.br = new BufferedReader(isr);
	}
	
	public String input() {
		String str = null;
		try {
			str = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return str;
	}
}
