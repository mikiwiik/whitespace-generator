package com.github.mikiwiik;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class BitUtilsTest {

    @Test
    public void testConvertingSingleChars() throws Exception {
        assertEquals("LF: 00001010    \t \t ",
            "     \t \t \n",
            BitUtils.charAsWspaceNumber('\n'));

        assertEquals("j: 01101010 \t\t \t \t ",
            "  \t\t \t \t \n",
            BitUtils.charAsWspaceNumber('j'));

        assertEquals("H: 01001000 \t  \t   ",
            "  \t  \t   \n",
            BitUtils.charAsWspaceNumber('H'));

        assertEquals("SPACE: 00100000  \t     ",
            "   \t     \n",
            BitUtils.charAsWspaceNumber(' '));
    }
}
