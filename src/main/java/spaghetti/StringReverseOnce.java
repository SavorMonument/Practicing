package spaghetti;

import java.util.HashSet;
import java.util.Set;

public class StringReverseOnce {

	private String str;

	public StringReverseOnce(String str) {

		this.str = str;
	}


	public String getResult() {
		assert (null != str) : "The string is null";

		Set<Character> found = new HashSet<>();
		StringBuffer result = new StringBuffer();

		for(int i = str.length() - 1; i >= 0; i--){

			char currentChar = str.charAt(i);
			if (found.add(currentChar)){

				result.append(currentChar);
			}
		}

		return result.toString();
	}
}
