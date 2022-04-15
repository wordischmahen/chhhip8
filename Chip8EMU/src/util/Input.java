package util;

import java.util.HashMap;
import java.util.Map;

public class Input {
	private final static Map<String, Integer> keyMap = new HashMap<>();
	
	static {
		keyMap.put("0", 0x0);
		keyMap.put("1", 0x1);
		keyMap.put("2", 0x2);
		keyMap.put("3", 0x3);
		keyMap.put("4", 0x4);
		keyMap.put("5", 0x5);
		keyMap.put("6", 0x6);
		keyMap.put("7", 0x7);
		keyMap.put("8", 0x8);
		keyMap.put("9", 0x9);
		keyMap.put("a", 0xa);
		keyMap.put("b", 0xb);
		keyMap.put("c", 0xc);
		keyMap.put("d", 0xd);
		keyMap.put("e", 0xe);
		keyMap.put("f", 0xf);
	
	}
	
	public static void map(int i, String text) {
		if(text != null && !text.isEmpty()) {
			keyMap.put(text.toLowerCase(), i);
		}
	}
	
	private Input() {
	}
	
	private static int KEYS = -1;
	
	public static void press(int i) {
		KEYS = 0x0000000F & i;
	}
	
	public static void press(String input) {
		input = input.toLowerCase();
		if (keyMap.containsKey(input)) {
			KEYS = 0x0000000F & keyMap.get(input);
		}
	
	}
	
	public static void unpress(String input) {
		input = input.toLowerCase();
		
		if(keyMap.containsKey(input)) {
			KEYS = -1;
		}
	}
	
	public static void unpress() {
		KEYS = -1;
	}
	
	public static int read() {
		return KEYS;

    }	
}
