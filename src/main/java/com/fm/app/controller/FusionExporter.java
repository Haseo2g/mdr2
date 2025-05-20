package com.fm.app.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FusionExporter {
    public static void exportToCSV(Card[] cards, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write("C1,C2,Result\n");

            for (Card card : cards) {
                List<Integer> equips = card.Equips;
                for (Integer i : equips) {
                    writer.write(card.Id + "," + i + "\n");
                }
            }

            System.out.println("Arquivo CSV gerado com sucesso: " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

