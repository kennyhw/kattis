import java.util.HashMap;
import java.io.*;

class WhatDoesTheFoxSay {
    public static void main(String[] args) {
        FastIO fio = new FastIO();
        int n = fio.nextInt();
        
        for (int a = 0; a < n; a++) {
            HashMap<String, Integer> ht = new HashMap<String, Integer>();
            String input = fio.nextLine();
            
            String info;

            while (!(info = fio.nextLine()).equals("what does the fox say?")) {
                String[] infoArr = info.split(" goes ");
                ht.put(infoArr[1], 1);
            }

            String[] inputArr = input.split(" ");   
            
            boolean firstFoxSoundFound = false;

            for (int b = 0; b < inputArr.length; b++) {
                if (ht.get(inputArr[b]) == null) {
                    if (firstFoxSoundFound) {
                        fio.print(" " + inputArr[b]);
                    } else {
                        firstFoxSoundFound = true;
                        fio.println();
                        fio.print(inputArr[b]);
                    }
                }
            }
        }

        fio.close();
    }
}
