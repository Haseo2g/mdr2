package com.fm.app.controller;

import org.thymeleaf.util.StringUtils;

import java.io.*;
import java.util.*;

public class DataScrambler {

    private final Random random;
    private final int seed;

    public DataScrambler() {
        this.random = new Random();
        this.seed = random.nextInt();
    }

    public DataScrambler(int seed) {
        this.random = new Random(seed);
        this.seed = seed;
    }

    public static void main(String[] args) throws IOException {
        Dict.createDict();
        new DataScrambler().loadDataFromSlus();
    }

    public void loadDataFromSlus() throws IOException {
        try (RandomAccessFile file = new RandomAccessFile("C:\\Users\\Haseo\\Downloads\\mdr2\\SLUS_014.11", "r")) {
//            file.seek(0x1C4A44);
//            System.out.println("Id\tAtk\tDef\tGs1\tGs2\tType");
//
//            for (int i = 0; i < 722; i++) {
//                int int32 = readInt32(file);
//                Integer atk = (int32 & 0x1FF) * 10;
//                Integer def = ((int32 >> 9) & 0x1FF) * 10;
//                Integer gs1 = ((int32 >> 22) & 0xF);
//                Integer gs2 = ((int32 >> 18) & 0xF);
//                Integer type = ((int32 >> 26) & 0x1F);
//                System.out.println(String.format("%s\t%s\t%s\t%s\t%s\t%s", (i + 1), atk, def, gs1, gs2, type));
//            }

            System.out.println("Iniciou suave");
            Card[] cards = new Card[722];

            for (int i = 0; i < 722; i++) {
                cards[i] = new Card();
                cards[i].Id = i + 1;
            }

            file.seek(0x1C5B33L);
            for (int i = 0; i < 722; i++) {
                int num = file.readByte() & 0xFF;
                cards[i].setLevel(num & 0xF);
                cards[i].setAttribute((num >> 4) & 0xF);
            }

            for (int i = 0; i < 722; i++) {
                file.seek(0x1C6002 + i * 2);
                int offset = readUInt16(file) & 0xFFFF;
                file.seek(0x1C6800 + offset - 0x6000);
                cards[i].setName(FileUtils.getText(file, Dict.dict));
            }

            for (int i = 0; i < 722; i++) {
                file.seek(0x1B0A02 + i * 2);
                int offset = readUInt16(file);
                file.seek(0x1B11F4 + (offset - 0x9F4));
                cards[i].setDescription(FileUtils.getText(file, Dict.dict));
            }

            System.out.println(cards.length);

            for (int i = 0; i < cards.length; i++) {
                System.out.println(String.format("%s\t%s\t%s\t%s\t%s", cards[i].Id, cards[i].name, cards[i].attribute, cards[i].level, cards[i].description.replaceAll("\\s+", " ")));
            }

//            for (int i = 0; i < 39; i++) {
//                file.seek(0x1C6652 + i * 2);
//                int offset = readUInt16(file);
//                file.seek(0x1C6800 + offset - 0x6000);
//                Static.duelists[i] = new Duelist(FileUtils.getText(file, Dict.dict));
//            }
        }
    }

    public void loadDataFromWaMrg() throws IOException {
        try (RandomAccessFile file = new RandomAccessFile("C:\\Users\\Haseo\\Downloads\\mdr2\\DATA\\WA_MRG.MRG", "r")) {

//            byte[] fusionData = FileUtils.extractPiece(file, 0x10000, 0xB87800);
            Card[] cards = new Card[722];

            for (int i = 0; i < 722; i++) {
                cards[i] = new Card();
                cards[i].Id = i + 1;
            }
            // Loop pelas 722 cartas
//            for (int i = 0; i < 722; i++) {
//                // Calcula o offset do ponteiro dentro do array fusionData
//                int pointerOffset = 2 + i * 2;
//                int pointer = ((fusionData[pointerOffset + 1] & 0xFF) << 8) | (fusionData[pointerOffset] & 0xFF);
//
//                if (pointer != 0) {
//                    // Cria um novo stream somente para ler os dados a partir do ponteiro
//                    ByteArrayInputStream fusionStream = new ByteArrayInputStream(fusionData);
//                    fusionStream.skip(pointer);
//
//                    int num1 = fusionStream.read();
//                    if (num1 == 0) {
//                        num1 = 511 - fusionStream.read();
//                    }
//
//                    int num2 = num1;
//
//                    while (num2 > 0) {
//                        int b1 = fusionStream.read();
//                        int b2 = fusionStream.read();
//                        int b3 = fusionStream.read();
//                        int b4 = fusionStream.read();
//                        int b5 = fusionStream.read();
//
//                        int f1 = ((b1 & 0b00000011) << 8) | (b2 & 0xFF);
//                        int f2 = ((b1 >> 2 & 0b00000011) << 8) | (b3 & 0xFF);
//                        int f3 = ((b1 >> 4 & 0b00000011) << 8) | (b4 & 0xFF);
//                        int f4 = ((b1 >> 6 & 0b00000011) << 8) | (b5 & 0xFF);
//
//                        Fusion fu1 = new Fusion(i + 1, f1, f2);
//                        cards[i].addFusion(fu1);
//                        num2--;
//
//                        if (num2 > 0) {
//                            Fusion fu2 = new Fusion(i + 1, f3, f4);
//                            cards[i].addFusion(fu2);
//                            num2--;
//                        }
//                    }
//                }
//            }
//            FusionExporter.exportToCSV(cards, "C:\\Users\\Haseo\\Downloads\\mdr2\\Fusions.csv");
//            List<Fusion> fusions = cards[1].Fusions;
//            for (Fusion f : fusions) {
//                System.out.println(f);
//            }

//            byte[] equipData = FileUtils.extractPiece(file, 10240, 12079104);
//            ByteArrayInputStream equipStream = new ByteArrayInputStream(equipData);
//
//            while (true) {
//                int cardId = readUInt16(equipStream);
//                if (cardId == 0) break;
//
//                int count = readUInt16(equipStream);
//                for (int i = 0; i < count; i++) {
//                    int equipId = readUInt16(equipStream);
//                    cards[cardId - 1].addEquip(equipId);
//                }
//            }
//            FusionExporter.exportToCSV(cards, "C:\\Users\\Haseo\\Downloads\\mdr2\\Equips.csv");

//
//            byte[] costData = FileUtils.extractPiece(file, 722 * 8, 0xFB9808);
//            ByteArrayInputStream costStream = new ByteArrayInputStream(costData);
//
//            for (int i = 0; i < 722; i++) {
//                byte[] costBytes = costStream.readNBytes(4);
//                int cost = FileUtils.extractInt32(costBytes);
//
//                byte[] passBytes = costStream.readNBytes(4);
//                StringBuilder passwordStr = new StringBuilder();
//                for (int j = 3; j >= 0; j--) {
//                    String hex = String.format("%02X", passBytes[j]);
//                    passwordStr.append(hex);
//                }
//
////                int password = Integer.parseInt(passwordStr.toString());
//
//                Starchips sc = new Starchips();
//                sc.setCost(cost);
////                sc.setPassword(password);
//                sc.setPassword(123);
//                sc.setPasswordStr(passwordStr.toString());
//
//                cards[i].setStarchip(sc);
//            }
//            for (int i = 0; i < cards.length; i++) {
//                if (!cards[i].Starchips.PasswordStr.equals("FFFFFFFE"))
//                System.out.println(String.format("%s\t%s\t%s", cards[i].Id
//                        , cards[i].Starchips.Cost
////                        , cards[i].Starchips.Password
//                        , cards[i].Starchips.PasswordStr
//                ));
//            }
        }
    }
//
    // Helper methods (assume all are defined in FileUtils or elsewhere)
    private int readInt32(RandomAccessFile file) throws IOException {
        byte[] bytes = new byte[4];
        file.readFully(bytes);
        return FileUtils.extractInt32(bytes);
    }

    private int readUInt16(RandomAccessFile file) throws IOException {
        byte[] bytes = new byte[2];
        file.readFully(bytes);
        return FileUtils.extractUInt16(bytes);
    }

    private int readUInt16(InputStream is) throws IOException {
        return ((is.read() & 0xFF) | ((is.read() & 0xFF) << 8));
    }
}
