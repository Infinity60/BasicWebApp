package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        query = query.trim();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("which of the following numbers is the largest: ")) {
            String list = query.replaceAll("which of the following numbers is the largest:", ",");
            String[] array = list.split(", ");
            if (array.length < 1) return "no numbers!";
            int max = Integer.parseInt(array[1]);
            for (int i = 1; i < array.length; i++) if (Integer.parseInt(array[i]) > max) max = Integer.parseInt(array[i]);
            return String.valueOf(max);
        } else if (query.contains("what is ")) {
            String list = query.replaceAll("what is ", "");
            String[] array = list.split(" ");
            if (array.length < 4) return "no number!";
            return String.valueOf(Integer.parseInt(array[1]) + Integer.parseInt(array[3]));
        } else {
            return "Infinity70";
        }
    }
}
