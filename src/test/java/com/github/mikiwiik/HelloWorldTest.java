package com.github.mikiwiik;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class HelloWorldTest {

    @Test
    public void testHelloWorld() throws Exception {
        final String program = new WhiteSpaceProgram()
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
                .ioPopChar()
                .ioPopChar()
                .ioPopChar()
                .ioPopChar()
                .ioPopChar()
                .ioPopChar()
                .ioPopChar()
                .ioPopChar()
                .ioPopChar()
                .ioPopChar()
                .ioPopChar()
                .ioPopChar()
                .flowEndProgram()
                .toString();

        final String shellOutput = ShellHelper.runWSpaceInShell(program);
        assertEquals("Hello world", shellOutput);
    }

}
