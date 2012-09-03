package com.github.mikiwiik;

import com.google.common.collect.Lists;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;

class WhiteSpaceUtils {

    /**
     * Convert the given char into a String containing whitespace representation of a character number.<br/>
     * From:
     * <a href="http://compsoc.dur.ac.uk/whitespace/tutorial.php">http://compsoc.dur.ac.uk/whitespace/tutorial.php</a>:
     * <blockquote>Numbers can be any number of bits wide, and are simply represented as a series of [Space] and [Tab],
     * terminated by a [LF]. [Space] represents the binary digit 0, [Tab] represents 1. The sign of a number is given
     * by its first character, [Space] for positive and [Tab] for negative. Note that this is not twos complement, it
     * just indicates a sign.</blockquote>
     *
     * <br/>
     * NOTE: Behaviour is very much undefined for non-ascii chars.
     *
     * @param character
     * @return 
     */
    @NotNull
    static String charAsNumber(char character) {
        byte asciiValue = (byte)character;
        // NOTE: all characters are positive wspace numbers.
        return " " + bytesAsWspaceNumber(new byte[]{asciiValue});
    }

    /**
     * Convert gíven bytes to wspace number representation.<br/>
     * NOTE: The signum must be handled by the caller.
     *
     * @param bytes
     * @return
     */
    private static String bytesAsWspaceNumber(@NotNull byte[] bytes) {
        final StringBuilder stringBuilder = new StringBuilder(bytes.length *8 + 1);
        for (byte asciiValue : bytes) {
            for (byte i = 0; i < 8; i++) {
                final boolean binaryValue = (asciiValue & 128) != 0;
                stringBuilder.append(binaryValue ? '\t' : ' ');
                asciiValue <<= 1;
            }
        }

        // Numbers are terminated by a [LF].
        stringBuilder.append('\n');
        return stringBuilder.toString();
    }

    /**
     * Output given String to file, then run it as WhiteSpace in a shell. Return the output of the program.<br/>
     * NOTE: Assumes the wspace binary is found in the path
     *
     * @param wspaceProgram
     * @return
     * @throws java.io.IOException
     */
    // TODO: @Nullable
    static String runWSpaceInShell(@Nullable String wspaceProgram) throws IOException {
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
