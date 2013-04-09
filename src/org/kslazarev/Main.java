package org.kslazarev;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        MatcherCommand matcherCommand = new MatcherCommand("^(\\w+) ([0-9]+ )?([CMQS]) ", 1, 3);
        TextProcessing processing = new TextProcessing(args[0], args[1], matcherCommand);
        processing.run();
    }
}
