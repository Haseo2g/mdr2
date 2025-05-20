package com.fm.app.controller;

public class Fusion {
    private int c1, c2, result;

    public Fusion(int c1, int c2, int result) {
        this.c1 = c1;
        this.c2 = c2;
        this.result = result;
    }

    public int getC1() {
        return c1;
    }

    public void setC1(int c1) {
        this.c1 = c1;
    }

    public int getC2() {
        return c2;
    }

    public void setC2(int c2) {
        this.c2 = c2;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Fusion { " +
                "[" + c1 +
                "] + [" + c2 +
                "] = " + result +
                " }";
    }
}
