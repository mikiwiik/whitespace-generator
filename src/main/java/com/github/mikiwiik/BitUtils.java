package com.github.mikiwiik;

/**
 * Miscellaneous bit-operation related util methods
 */
public class BitUtils {

    /**
     * Convert the given char into a String containing whitespace representation of a character number.<br/>
     * From:
     * <a href="http://compsoc.dur.ac.uk/whitespace/tutorial.php">http://compsoc.dur.ac.uk/whitespace/tutorial.php</a>:
     * <blockquote>Numbers can be any number of bits wide, and are simply represented as a series of [Space] and [Tab],
     * terminated by a [LF]. [Space] represents the binary digit 0, [Tab] represents 1. The sign of a number is given
     * by its first character, [Space] for positive and [Tab] for negative. Note that this is not twos complement, it
     * just indicates a sign.</blockquote>
     *
     * <br/>
     * NOTE: Behaviour is very much undefined for non-ascii chars.
     *
     * @param character
     * @return 
     */
    public static String charAsWspaceNumber(char character) {
        // NOTE: all characters are positive wspace numbers.
        final StringBuilder stringBuilder = new StringBuilder(" ");

        int asciiValue = (int)character;
        for (int i = 0; i < 8; i++) {
            final boolean binaryValue = (asciiValue & 128) != 0;
            stringBuilder.append(binaryValue ? '\t' : ' ');
            asciiValue <<= 1;
        }
        // Numbers are terminated by a [LF].
        stringBuilder.append('\n');
        return stringBuilder.toString();
    }
}
