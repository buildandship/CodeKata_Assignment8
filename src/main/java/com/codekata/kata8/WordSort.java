package com.codekata.kata8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSort {
	
	private Map<String,String> wordMap = new HashMap<>();
	private ArrayList<String> sixCount = new ArrayList<>();
	private Map<String,List<String>> resultMap = new HashMap<>();
	
	public void loadWords(List<String> words) {
		for(String word : words) {
			if (word.length() < 1) {
				continue;
			} else if (word.length() == 6) {
				sixCount.add(word);
				wordMap.put(word, word);
			} else {
				wordMap.put(word, word);
			}
		}
	}
	
	public void searchString() {
		for(String word : sixCount) {
			int count = 2;
			while(count <= 4) {
				String segmentOne = word.substring(0, count);
				String segmentTwo = word.substring(count);
				if(wordMap.containsKey(segmentOne) && wordMap.containsKey(segmentTwo)) {
					String combo = String.format("%s+%s,", segmentOne, segmentTwo);
					this.addToMap(combo, word);
				}
				count++;
			}
		}
	}
	
	public void printOutput() {
		for(Map.Entry<String, List<String>> entry : resultMap.entrySet()) {
			System.out.print("Word: "+entry.getKey()+" Combos: ");
			for(String sixLetterWord : entry.getValue()) {
				System.out.print(sixLetterWord + " ");
			}
			System.out.println();
		}
	}
	
	private void addToMap(String combo, String keyWord) {
		List<String> combos = resultMap.get(keyWord);
		if (combos == null) {
			combos = new ArrayList<>();
			combos.add(combo);
			resultMap.put(keyWord, combos);
		} else {
			combos.add(combo);
		}
	}
}
