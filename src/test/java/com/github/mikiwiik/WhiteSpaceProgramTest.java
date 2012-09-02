package com.github.mikiwiik;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class WhiteSpaceProgramTest {

    @Test
    public void testPushSingleChar() {
        final String program = new WhiteSpaceProgram().stackPushChar('j').toString();
        assertEquals("SS(Stack IMP, push nr) S(pos nr) STTSTSTS(j) CR",
            "   \t\t \t \t \r", program);
    }
}
