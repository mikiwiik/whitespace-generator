package com.github.mikiwiik;

public class PrinterTester {
    public static void main(String[] args) throws Exception {
        String wspace =
            "   LF:1010\t \t \n\r"+
            "   j:1101010\t\t \t \t \n\r"+
            "   e:1100101\t\t  \t \t\n\r"+
            "   H:1001000\t  \t   \n\r"+
            "\t\n  \r"+
            "\t\n  \r"+
            "\t\n  \r"+
            "\t\n  \r"+
            "\n\n\n";

        String shellOutput = ShellHelper.runWSpaceInShell(wspace);
        System.out.print(shellOutput);
    }
}
