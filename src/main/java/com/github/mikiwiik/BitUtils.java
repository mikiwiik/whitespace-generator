package com.github.mikiwiik;

import com.google.common.collect.ImmutableList;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Miscellaneous bit-operation related util methods
 */
public class BitUtils {

    /**
     * Convert the given String into Lists of boolean values representing the String as Ascii bits
     * Inspired by
     *      <a href="http://stackoverflow.com/questions/917163/convert-a-string-like-testing123-to-binary-in-java">
     *      http://stackoverflow.com/questions/917163/convert-a-string-like-testing123-to-binary-in-java</a>
     * @param string
     * @return
     * @throws UnsupportedEncodingException
     */
    public static List<Boolean> asciiAsBinary(String string) throws UnsupportedEncodingException {

        final ImmutableList.Builder<Boolean> bits = new ImmutableList.Builder<Boolean>();

        // Could do byte[] bytes = string.getBytes("US-ASCII");
        byte[] bytes = string.getBytes();
        for (byte b : bytes) {
            int val = b;
            for (int i = 0; i < 8; i++) {
                bits.add((val & 128) != 0);
                val <<= 1;
            }
        }
        return bits.build();
    }
}
