package spaghetti;

import java.util.ArrayList;
import java.util.List;

//['HelloMars', 'HelloWorld', 'HelloWorldMars', 'HiHo']
//
//H -> [HelloMars, HelloWorld, HelloWorldMars, HiHo]
//HW -> [HelloWorld, HelloWorldMars]
//Ho -> []
//HeWorM -> [HelloWorldMars]
public class WordInit {


	public String[] getResult(String[] words, String prefixes){

		String[] prefixArray = splitCamelCase(prefixes);
		List<String> result = new ArrayList<>();

		for (String name: words){

			String[] wordTokens = splitCamelCase(name);
			boolean isPrefix = true;
			if (prefixArray.length <= wordTokens.length) {

				for (int i = 0; i < prefixArray.length; i++) {

					if (!wordTokens[i].startsWith(prefixArray[i]))
						isPrefix = false;
				}
				if (isPrefix) {
					result.add(name);
				}
			}
		}

		return result.toArray(new String[0]);
	}

	private String[] splitCamelCase(String prefixes) {
		assert (null != prefixes && prefixes.length() > 0) : "Invalid string";

		List<String> tokens = new ArrayList<>();
		int index = 0;

		while(index	< prefixes.length()){

			int wordStart = index;
			index++;
			while(index < prefixes.length() && !Character.isUpperCase(prefixes.charAt(index))){
				index++;
			}
			tokens.add(prefixes.substring(wordStart, index));
		}

		return tokens.toArray(new String[0]);
	}
}
