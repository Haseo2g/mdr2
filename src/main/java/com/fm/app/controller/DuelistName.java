package com.fm.app.controller;

import com.fm.app.model.Drops;

public class DuelistName {

    public static Drops.CARD_ORIGIN getOrigin(String s) {
        switch (s) {
            case "BCDPow": return Drops.CARD_ORIGIN.BCD;
            case "Deck": return Drops.CARD_ORIGIN.DECK;
            case "SAPow": return Drops.CARD_ORIGIN.SAPOW;
            case "SATec": return Drops.CARD_ORIGIN.SATEC;
        }
        return null;
    }
    public static Integer getId(String duelistName) {
        switch (duelistName) {
            case "Movisterium" : return 1;
            case "Teager" : return 2;
            case "Tchell" : return 3;
            case "Thaliico" : return 4;
            case "LDSpeedruns" : return 5;
            case "MikeCastell" : return 6;
            case "Gui93" : return 7;
            case "Bad News Nate" : return 8;
            case "Salgadin" : return 9;
            case "Vash" : return 10;
            case "Komari" : return 11;
            case "Brenttro" : return 12;
            case "Neczin" : return 13;
            case "Krolm" : return 14;
            case "Thug" : return 15;
            case "Tato" : return 16;
            case "Winds" : return 17;
            case "A3r1us" : return 18;
            case "Namitai" : return 19;
            case "Brn" : return 20;
            case "Felix The Cat" : return 21;
            case "Flopsie" : return 22;
            case "Pdo" : return 23;
            case "Codorna" : return 24;
            case "Zigfried" : return 25;
            case "Quality Content" : return 26;
            case "Xan9br" : return 27;
            case "Dex" : return 28;
            case "Matt13" : return 29;
            case "Kanitz" : return 30;
            case "Ruimney" : return 31;
            case "LendarioZ" : return 32;
            case "Haseo" : return 33;
            case "027 Guy in Chat" : return 34;
            case "Fhelwanger" : return 35;
            case "Rhyse" : return 36;
            case "Azura" : return 37;
            case "Exarion" : return 38;
            case "FabuTk" : return 39;
        }
        return null;
    }
}
