package com.github.mikiwiik;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class HelloWorldTest {

    @Test
    public void testHelloWorld() throws Exception {
        final String program = new WhiteSpaceProgram()
                .stackCommand(" ", "\t\t\n") // Poison stack top with a negative number (-1)
                .stackPushChar('\n')
                .stackPushChar('d')
                .stackPushChar('l')
                .stackPushChar('r')
                .stackPushChar('o')
                .stackPushChar('w')
                .stackPushChar(' ')
                .stackPushChar('o')
                .stackPushChar('l')
                .stackPushChar('l')
                .stackPushChar('e')
                .stackPushChar('H')
                .flowCommand("  ", " \t\n")// Label 1
                .stackCommand("\n ") // Copy stack top so it can be tested (a read discards)
                .flowCommand("\t\t", "  \n") // If top neg, jump to 0
                .ioPopChar() // Otherwise, just pop the top value
                .flowCommand(" \n", " \t\n")// Jump to start
                .flowCommand("  ", "  \n")// Label 0
                .stackCommand("\n\n") // Be nice, clean the stack (there's a copy of -1)
                .flowEndProgram()
                .toString();

        // NOTE: Labels seem to need be positive
        final String shellOutput = WhiteSpaceUtils.runWSpaceInShell(program);
        assertEquals("Hello world", shellOutput);
    }

}
