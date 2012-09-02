package com.github.mikiwiik;

import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;

class ShellHelper {
    // TODO: @Nullable
    static String runWSpaceInShell(String wspaceProgram) throws IOException {
        final File wsFile = File.createTempFile("wspace-generator_", ".ws");
        FileUtils.writeStringToFile(wsFile, wspaceProgram);
        final Process shellProcess = Runtime.getRuntime().exec(new String[]{"wspace", wsFile.getAbsolutePath()});

        final BufferedReader input = new BufferedReader(new InputStreamReader(shellProcess.getInputStream()));
        final Deque<String> outputLines = Lists.newLinkedList();
        String line;
        while((line = input.readLine()) != null){
            outputLines.add(line);
        }
        return outputLines.getFirst();
    }
}
