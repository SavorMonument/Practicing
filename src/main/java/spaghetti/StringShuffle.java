package spaghetti;

import java.util.*;

public class StringShuffle {

	public String getResult(String input) {

		StringBuilder result = new StringBuilder();
		Map<Character, Integer> inputChars = new HashMap<>();

		mapChars(input, inputChars);
		Map.Entry<Character, Integer>[] entryArray = inputChars.entrySet().toArray(new Map.Entry[0]);
		List<Map.Entry<Character, Integer>> entries = new ArrayList<>(Arrays.asList(entryArray));

//		Arrays.copyOf(new Integer[], 1, n);
//
//		new ArrayList<>().toArray(Integer.class);

		entries.sort(new Comparator<Map.Entry<Character, Integer>>() {
			@Override
			public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
				return -Integer.compare(o1.getValue(), o2.getValue());
			}
		});

		int index = 0;
		while (index < entries.size()) {

			if (result.length() != 0){
				if (entries.get(0).getKey() == result.charAt(result.length() - 1)) {
					if (entries.size() > 1)
						index = 1;
				} else {
					index = 0;
				}
			}

			//Append highest occurrence character
			result.append(entries.get(index).getKey());
			entries.get(index).setValue(entries.get(index).getValue() - 1);

			if (entries.get(index).getValue() == 0) {
				entries.remove(index);
			}
		}

		return result.toString();
	}

	private void mapChars(String input, Map<Character, Integer> inputChars) {
		for (char c : input.toCharArray()) {

			Integer prevAmount = inputChars.get(c);
			inputChars.put(c, prevAmount != null ? prevAmount + 1 : 1);
		}
	}
}
