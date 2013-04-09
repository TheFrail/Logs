package org.kslazarev;

import java.io.*;
import java.util.Map;

class TextProcessing {
    private final MatcherCommand command;
    private BufferedReader reader;
    private final String fileNameInput, fileNameOutput;
    private String line;

    public TextProcessing(String fileNameInput, String fileNameOutput, MatcherCommand command) {
        this.command = command;
        this.fileNameInput = fileNameInput;
        this.fileNameOutput = fileNameOutput;
    }

    void openFile() throws IOException {
        File file = new File(fileNameInput);
        reader = new BufferedReader(new FileReader(file));
    }

    public void run() throws IOException {
        openFile();
        while ((line = reader.readLine()) != null) { command.execute(line); }
        saveToFile();
    }

    void saveToFile() throws FileNotFoundException {
        PrintWriter out = new PrintWriter(fileNameOutput);

        for (Map.Entry<String, StringBuilder> entry : command.getMap().entrySet()) {
            out.println(entry.getKey() + ' ' + entry.getValue().toString());
        }

        out.close();
    }
}
