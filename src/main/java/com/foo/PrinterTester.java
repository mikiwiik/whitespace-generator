package com.foo;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class PrinterTester {
    public static void main(String[] args) throws IOException{
        String wspace =
            "   j1101010\t\t \t \t \n\r"+
            "   e1100101\t\t  \t \t\n\r"+
            "   H1001000\t  \t   \n\r"+
            "\t\n  \r"+
            "\t\n  \r"+
            "\t\n  \r"+
            "\n\n\n";
        FileUtils.writeStringToFile(new File("test.ws"), wspace);
    }
}
