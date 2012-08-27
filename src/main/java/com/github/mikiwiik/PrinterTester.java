package com.github.mikiwiik;

public class PrinterTester {
    public static void main(String[] args) throws Exception {
        String program = new WhiteSpaceProgram()
            .stackPushString(" LF:1010\t \t \n")
            .stackPushString(" j:1101010\t\t \t \t \n")
            .stackPushString(" e:1100101\t\t  \t \t\n")
            .stackPushString(" H:1001000\t  \t   \n")
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
