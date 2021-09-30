package com.xeype.service;

import java.util.HashMap;

public interface FileService {

    void createFile(String path);

    String readFile(String path);

    void createOutputFile(String path, HashMap<String, Integer> encounteredWords, int palindromesCount, int sentencesCount);
}
