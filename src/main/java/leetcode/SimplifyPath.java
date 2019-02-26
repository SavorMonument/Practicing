package leetcode;

import java.util.LinkedList;

public class SimplifyPath
{
	public String simplifyPath(String path)
	{
		LinkedList<String> directories = new LinkedList<>();

		String[] tokens = path.split("/");

		for (String token: tokens)
			if (!token.isEmpty())
				if(token.equals(".."))
					directories.poll();
				else if (!token.equals("."))
					directories.push(token);

		if (directories.isEmpty())
			return "/";

		StringBuffer result = new StringBuffer();
		while(!directories.isEmpty())
			result.append("/").append(directories.pollLast());

		return result.toString();
	}
}
