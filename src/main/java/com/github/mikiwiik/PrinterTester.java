package com.github.mikiwiik;

public class PrinterTester {
    public static void main(String[] args) throws Exception {
        String program = new WhiteSpaceProgram()
            .stackPushString(" LF:00001010    \t \t \n")
            .stackPushString(" j:01101010 \t\t \t \t \n")
            .stackPushString(" e:01100101 \t\t  \t \t\n")
            .stackPushString(" H:01001000 \t  \t   \n")
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
