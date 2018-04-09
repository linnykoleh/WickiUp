package com.linnyk.ocp;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap2 {

    public static void main(String[] args) {
        String sentence1 = "Carpe diem. Seize the day, oys. Make your lives extraordinary.";
        String sentence2 = "Frankly, my dear, I don,t give a damn!";
        String sentence3 = "Do I look like I give a damn!";

        List<String> sentences = Arrays.asList(sentence1, sentence2, sentence3);

        List<String> strm = sentences.stream()
                .flatMap(str->Stream.of(str.split("[ ,.!?\r\n]")))
                // flatMap результат
                //[Carpe, diem, , Seize, the, day, , oys, , Make, your, lives, extraordinary, Frankly, ,
                // my, dear, , I, don, t, give, a, damn, Do, I, look, like, I, give, a, damn]
                .filter(s->s.length()>0)
                .distinct()
                .collect(Collectors.toList());

        System.out.println(strm);
        //[Carpe, diem, Seize, the, day, oys, Make, your, lives, extraordinary,
        // Frankly, my, dear, I, don, t, give, a, damn, Do, look, like]
    }
}
