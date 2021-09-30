package com.xeype.util;

import java.util.*;
import java.util.stream.Collectors;

public class FileUtil {

    public static int sentencesCount(String data) {
        String[] sentences = data.split("[.!?]");
        return sentences.length - 1;
    }

    public static int palindromesCount(String data) {
        String[] words = getWords(data);
        int result = 0;
        for (String word : words) {
            if (word.length() > 1 && word.equalsIgnoreCase(new StringBuilder(word).reverse().toString())) {
                result++;
            }
        }
        return result;
    }

    public static HashMap<String, Integer> encounteredWords(String data) {
        String[] words = getWords(data);
        HashMap<String, Integer> wordsFreq = new HashMap<>();
        for (String word : words) {
            int freq = wordsFreq.getOrDefault(word, 0);
            wordsFreq.put(word, ++freq);
        }
        return sortByValue(wordsFreq);
    }

    private static String[] getWords(String data) {
        data = data.replaceAll(System.lineSeparator(), "");
        data = data.replaceAll("[.?!,:;-]", "");
        return data.split(" ");
    }

    private static HashMap<String, Integer> sortByValue(HashMap<String, Integer> unsortedMap) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(unsortedMap.entrySet());

        list.sort((o1, o2) -> {
            if (o2.getValue().compareTo(o1.getValue()) != 0) {
                return o2.getValue().compareTo(o1.getValue());
            }
            return o2.getKey().compareTo(o1.getKey());
        });
        return list.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));
    }
}
