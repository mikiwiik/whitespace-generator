package com.github.mikiwiik;

import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class WhiteSpacePrinterTest {

    @Ignore
    @Test
    public void testStack(){
        /*
        [Space]	Number	Push the number onto the stack
        [LF][Space]	-	Duplicate the top item on the stack
        [Tab][Space]	Number	Copy the nth item on the stack (given by the argument) onto the top of the stack
        [LF][Tab]	-	Swap the top two items on the stack
        [LF][LF]	-	Discard the top item on the stack
        [Tab][LF]	Number	Slide n items off the stack, keeping the top item*/
    }

        @Test
    public void testIO(){
        // [Tab][LF]	I/O
        final String ioIMP = "\t\n";
        assertEquals(
            "[Space][Space] - Output the character at the top of the stack",
            ioIMP + "  " + "\r",
            new WhiteSpaceProgram().ioPopChar().toString()
        );

         /*

        [Space][Tab]	-	Output the number at the top of the stack
        [Tab][Space]	-	Read a character and place it in the location given by the top of the stack
        [Tab][Tab]	-	Read a number and place it in the location given by the top of the stack
        */

    }

}
