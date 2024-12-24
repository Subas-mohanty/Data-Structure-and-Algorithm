package Lecture_practice_problems_kunal_kushwaha._52_StringBuffer_01;

import java.util.Random;

public class RandomString {
    static String generate(int size) {
        StringBuffer sb = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int randomChar = 97 + (random.nextInt(0,25));
            sb.append((char) randomChar);
        }
        return sb.toString();
    }
}
