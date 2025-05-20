package com.fm.app.controller;

import java.io.InputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Map;

public class FileUtils {

    // Converte um array de 4 bytes em um inteiro (little-endian)
    public static int extractInt32(byte[] bytes) {
        return ((bytes[0] & 0xFF)) |
                ((bytes[1] & 0xFF) << 8) |
                ((bytes[2] & 0xFF) << 16) |
                ((bytes[3] & 0xFF) << 24);
    }

    // Converte um array de 2 bytes em um inteiro sem sinal (little-endian)
    public static int extractUInt16(byte[] bytes) {
        return ((bytes[0] & 0xFF)) |
                ((bytes[1] & 0xFF) << 8);
    }

    // Extrai uma fatia do arquivo, deslocando-se até a posição e lendo a quantidade indicada
    public static byte[] extractPiece(RandomAccessFile file, int length, long offset) throws IOException {
        byte[] buffer = new byte[length];
        file.seek(offset);
        file.readFully(buffer);
        return buffer;
    }

    // Lê texto codificado do jogo usando um dicionário personalizado
    public static String getText(RandomAccessFile file, Map<Byte, Character> dict) throws IOException {
        StringBuilder text = new StringBuilder();

        while (true) {
            byte b = file.readByte();

            if (dict.containsKey(b)) {
                text.append(dict.get(b));
            } else if ((b & 0xFF) == 0xFE) {
                text.append("\r\n");
            } else {
                if ((b & 0xFF) == 0xFF) {
                    break;
                }
                text.append(String.format("[%02X]", b));
            }
        }

        return text.toString();
    }

}
