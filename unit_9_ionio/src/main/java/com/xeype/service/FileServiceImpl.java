package com.xeype.service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class FileServiceImpl implements FileService {

    @Override
    public void createFile(String path) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8))) {
            writer.write("Encountered words: ");
        } catch (IOException e) {
            System.out.println("Something wrong: " + e.getMessage());
        }
    }

    @Override
    public String readFile(String path) {
        String fileString = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

            StringBuilder stringBuilder = new StringBuilder();
            String line = bufferedReader.readLine();

            while (line != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
            fileString = stringBuilder.toString();

        } catch (IOException e) {
            System.out.println("Something wrong: " + e.getMessage());
        }
        return fileString;
    }

    @Override
    public void createOutputFile(String path, HashMap<String, Integer> encounteredWords, int palindromesCount, int sentencesCount) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), StandardCharsets.UTF_8))) {
            writer.write("Encountered words: ");
            writer.write(System.lineSeparator());

            for (Map.Entry<String, Integer> result : encounteredWords.entrySet()) {
                writer.write(result.getKey() + " : " + result.getValue());
                writer.write(System.lineSeparator());
            }

            writer.write("\n");
            writer.write(System.lineSeparator());
            writer.write("Count of palindromes: " + palindromesCount);
            writer.write(System.lineSeparator());
            writer.write("\n");
            writer.write(System.lineSeparator());
            writer.write("Count of sentences: " + sentencesCount);
        } catch (IOException e) {
            System.out.println("Something wrong: " + e.getMessage());
        }
    }
}
