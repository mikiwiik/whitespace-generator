package com.github.mikiwiik;

public class PrinterTester {
    public static void main(String[] args) throws Exception {
        String program = new WhiteSpaceProgram()
            .stackPushChar('\n')
            .stackPushChar('j')
            .stackPushChar('e')
            .stackPushChar('H')
            .ioPopChar()
            .ioPopChar()
            .ioPopChar()
            .ioPopChar()
            .flowEndProgram()
            .toString();

        String shellOutput = ShellHelper.runWSpaceInShell(program);
        System.out.print(shellOutput);
    }
}
