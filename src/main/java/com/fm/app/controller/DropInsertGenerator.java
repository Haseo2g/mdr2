package com.fm.app.controller;

import com.fm.app.model.Drops;

import java.io.*;
import java.nio.file.*;
import java.util.stream.Stream;

public class DropInsertGenerator {

    public static void main(String[] args) throws IOException {
        Path baseDir = Paths.get("C:\\Users\\Haseo\\Downloads\\Mod dos Runners 2 - Duelists Decks and Drops\\Mod dos Runners 2 - Duelists Decks and Drops");
        String[] subDirs = {"BCD", "Decks", "SAPow", "SATec"};

        BufferedWriter writer = new BufferedWriter(new FileWriter("inserts.sql"));

        for (String subDir : subDirs) {
            Path dir = baseDir.resolve(subDir);
            try (Stream<Path> files = Files.list(dir)) {
                files.filter(path -> path.toString().endsWith(".csv"))
                        .forEach(file -> {
                            try {
                                String fileName = file.getFileName().toString().replace(".csv", "");
                                String[] parts = fileName.split(" - ");
                                if (parts.length < 2) return;

                                String idAndName = parts[0].trim(); // ex: 027 Guy in Chat
                                String rank = parts[1].trim(); // ex: BCDPow
                                Drops.CARD_ORIGIN origin = DuelistName.getOrigin(rank);

                                String[] nameParts = idAndName.split(" ", 2);
                                Integer duelistId = DuelistName.getId(idAndName); // 027
                                // String duelistName = nameParts[1].trim(); // Guy in Chat (não está sendo usado)

                                try (BufferedReader reader = new BufferedReader(new FileReader(file.toFile()))) {
                                    String line;
                                    while ((line = reader.readLine()) != null) {
                                        String[] columns = line.split(";");
                                        if (columns.length < 3) continue;

                                        String cardId = columns[0].trim();
                                        String chance = columns[2].trim();

                                        String sql = String.format("INSERT INTO `drops`(`chance`, `rank`, `carta_id`, `duelista_id`) VALUES ('%s','%s','%s','%s');",
                                                chance, origin.ordinal(), cardId, duelistId);

                                        writer.write(sql);
                                        writer.newLine();
                                    }
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });
            }
        }
        writer.close();
        System.out.println("Inserts gerados em 'inserts.sql'");
    }
}
