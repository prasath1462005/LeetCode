class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        HashMap<String, Integer> wordMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }
        
        int wordLength = words[0].length(); 
        int totalWords = words.length;  
        int substringLength = totalWords * wordLength;
        int stringLength = s.length(); 
        for (int offset = 0; offset < wordLength; offset++) {
            int start = offset; 
            HashMap<String, Integer> currentMap = new HashMap<>();
            int matchedWords = 0;  
            for (int end = offset; end + wordLength <= stringLength; end += wordLength) {
                String currentWord = s.substring(end, end + wordLength);
                if (wordMap.containsKey(currentWord)) {
                    currentMap.put(currentWord, currentMap.getOrDefault(currentWord, 0) + 1);
                    matchedWords++;
                    while (currentMap.get(currentWord) > wordMap.get(currentWord)) {
                        String startWord = s.substring(start, start + wordLength);
                        currentMap.put(startWord, currentMap.get(startWord) - 1);
                        matchedWords--;
                        start += wordLength;
                    }
                    if (matchedWords == totalWords) {
                        result.add(start);
                    }
                } else {
                    currentMap.clear();
                    matchedWords = 0;
                    start = end + wordLength;
                }
            }
        }
        return result;
    }
}
