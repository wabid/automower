package com.blablacar.mower.application;

/**
 * Created by wassim on 02/12/2019.
 */
public class LineNumberScanner {

    private java.util.Scanner scanner ;
    private int lineNumber = 0;

    public LineNumberScanner(String toScan) {
        this.scanner = new java.util.Scanner(toScan);
    }

    public boolean hasNextLine() {
        return this.scanner.hasNextLine();
    }

    public String nextLine() {
        this.lineNumber++;
        return this.scanner.nextLine();
    }

    public int getLineNumber() {
        return lineNumber;
    }
}
