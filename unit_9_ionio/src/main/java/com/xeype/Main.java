package com.xeype;

import com.xeype.service.FileServiceImpl;
import com.xeype.util.FileUtil;

public class Main {

    public static void main(String[] args) {
        FileServiceImpl fileService = new FileServiceImpl();
        String data = fileService.readFile("input.txt");
        fileService.createOutputFile("output.txt", FileUtil.encounteredWords(data), FileUtil.palindromesCount(data), FileUtil.sentencesCount(data));
    }
}
