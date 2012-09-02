package com.github.mikiwiik;

import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;

class ShellHelper {
    /**
     * Output given String to file, then run it as WhiteSpace in a shell. Return the output of the program.<br/>
     * NOTE: Assumes the wspace binary is found in the path
     *
     * @param wspaceProgram
     * @return
     * @throws IOException
     */
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
        // Just assuming whatever is to be printed is on a single line...
        return outputLines.getFirst();
    }
}
