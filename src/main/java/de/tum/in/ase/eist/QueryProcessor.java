package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("which of the following numbers is the largest: ")) {
            String list = query.replaceAll("which of the following numbers is the largest: ", "");
            int[] array = Arrays.stream(list.split(", ")).mapToInt(Integer::parseInt).toArray();
            if (array.length == 0) return "no number!";
            int max = array[0];
            for (int i : array) if (i > max) max = i;
            return String.valueOf(max);
        } else {
            return "Infinity70";
        }
    }
}
