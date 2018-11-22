package spaghetti;

public class ReverseString {

	public static void main(String[] args) {

		String code = "1123";

		for (char c : code.toCharArray()) {

			System.out.print((char)(c - '1' + 'a'));
		}
	}

//	public Set decode (String prefix, String code){
//		Set set = new HashSet();
//		if (code.length() == 0) {
//			set.add(prefix);
//			return set;
//		}
//		if (code.charAt(0) == '0') return set;
//		set.addAll(decode(prefix + (char) (code.charAt(0) - '1' + 'a'), code.substring(1)));
//		if (code.length() >= 2 && code.charAt(0) == '1') {
//			set.addAll(decode(prefix + (char) (10 + code.charAt(1) - '1' + 'a'), code.substring(2)));
//		}
//		if (code.length() >= 2 && code.charAt(0) == '2' && code.charAt(1) <= '6') {
//			set.addAll(decode(prefix + (char) (20 + code.charAt(1) - '1' + 'a'), code.substring(2)));
//		}
//		return set;
//	}
}
