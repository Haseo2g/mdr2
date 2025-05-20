package com.fm.app.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dict {
    public static Map<Byte, Character> dict = new HashMap<>();
    public static Map<Character, Byte> rdict = new HashMap<>();

    public static void createDict() throws IOException {

        System.out.println("iniciou legal");
        List<String> lines = Files.readAllLines(Paths.get("C:\\Users\\Haseo\\Downloads\\fmscrambler-master\\fmscrambler-master\\ScramblerUI\\CharacterTable.txt"));

        System.out.println("leu o arquivo");
        Pattern pattern = Pattern.compile("^([A-Fa-f0-9]{2})=(.*)$");

        for (String line : lines) {
            Matcher matcher = pattern.matcher(line);
            if (matcher.matches()) {
                char k1 = matcher.group(2).charAt(0);
                byte k2 = (byte) Integer.parseInt(matcher.group(1), 16);
                System.out.println(k1 + " - " + k2);
                dict.put(k2, k1);
                rdict.putIfAbsent(k1, k2);
            }
        }
    }

}