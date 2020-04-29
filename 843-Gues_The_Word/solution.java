/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    public void findSecretWord(String[] wordList, Master master) {
        List<String> list = Arrays.asList(wordList);
         
        while (!list.isEmpty()) {
            //hashmap having word with the number of words it had no characters matching
            Map<String, Integer> zeroMatch = new HashMap<>();
            
            //compare words and check if they don't match any character add it to the hashmap
            for (String cand : list) {
                for (String word : list) {
                    if (match(cand, word) == 0) 
                        zeroMatch.put(cand, zeroMatch.getOrDefault(cand, 0) + 1);
                }
            }    
             
            //we want to find the word in zeromatch that looks more like the others in order to delete a max part of words, we select a candidate who has a big "family" (fewest 0 match).
            //if there isn't a word with a zeromatch, we guess the first word in list
            String guess = list.get(0);
            int min = Integer.MAX_VALUE;
            for (Map.Entry<String, Integer> entry : zeroMatch.entrySet()) {
                System.out.println(entry.getKey() + " -> " + entry.getValue());
                //if there is a word with zeromatch 
                if (min > entry.getValue()) {
                    min = entry.getValue();
                    guess = entry.getKey();
                }
            }
            System.out.println("guess: " + guess);
            //int m = matching characters of guess word
            //if the word we guess match, end it
            int m = master.guess(guess);
            if (m == 6) return;
             
            //create a new list that has the words with the number of characters
            //that match what m currently has
            List<String> tmp = new ArrayList<>();
            for (String s : list) {
                if (m == match(s, guess)) {
                    tmp.add(s);    
                }
            }
            
            //list = to new list
            list = tmp;
        }
    }
     
    private int match(String a, String b) {
        int m = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i)) m++;
        }
         
        return m;
    }
}