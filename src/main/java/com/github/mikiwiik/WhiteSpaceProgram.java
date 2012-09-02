package com.github.mikiwiik;

public class WhiteSpaceProgram {

    final static private String CR = "\r";

    //[Space]	Stack Manipulation
    final static private String IMP_STACK = " ";
    // [Space]	Number	Push the number onto the stack
    final static private String STACK_PUSH_NR = " ";
    /*[LF][Space]	-	Duplicate the top item on the stack
    [Tab][Space]	Number	Copy the nth item on the stack (given by the argument) onto the top of the stack
    [LF][Tab]	-	Swap the top two items on the stack
    [LF][LF]	-	Discard the top item on the stack
    [Tab][LF]	Number	Slide n items off the stack, keeping the top item*/

    //[Tab][Space]	Arithmetic
    //[Tab][Tab]	Heap access
    //[LF]	Flow Control
    final static private String IMP_FLOW = "\n\n";

    //[Tab][LF]	I/O
    final static private String IMP_IO = "\t\n";
    final static private String IO_POP_CHAR = "  ";
    /* [Space][Tab]	-	Output the number at the top of the stack
    [Tab][Space]	-	Read a character and place it in the location given by the top of the stack
    [Tab][Tab]	-	Read a number and place it in the location given by the top of the stack */


    //private final StringBuilder sb = new StringBuilder(IMP_STACK);
    private final StringBuilder program = new StringBuilder();

    /*Stack Manipulation (IMP: [Space])
    Stack manipulation is one of the more common operations, hence the shortness of the IMP [Space]. There are four stack instructions.

    // TODO: push(Char) & push(BigInteger) -> Convert to ws binary notation
    public WhiteSpaceProgram stackPushString(String string) {
        // NOTE: Characters are always positive, negative gives "Fail: Prelude.chr: bad argument"
        program.append(IMP_STACK).append(" ").append(string).append(CR);
        return this;
    }

    /**
     * Push given char to stack as positive wspace number
     * @param character
     * @return
     */
    public WhiteSpaceProgram stackPushChar(char character) {
        final String charAsWspace = BitUtils.charAsWspaceNumber(character);
        program.append(IMP_STACK)
            .append(STACK_PUSH_NR)
            .append(charAsWspace)
            .append(CR);
        return this;
    }

    /**
     * Output the character at the top of the stack.
     * @return
     */
    public WhiteSpaceProgram ioPopChar() {
        program.append(IMP_IO)
            .append(IO_POP_CHAR)
            .append(CR);
        return this;
    }

    /* Flow Control (IMP: [LF])
    Flow control operations are also common. Subroutines are marked by labels, as well as the targets of conditional and unconditional jumps, by which loops can be implemented. Programs must be ended by means of [LF][LF][LF] so that the interpreter can exit cleanly.

    Command	Parameters	Meaning
    [Space][Space]	Label	Mark a location in the program
    [Space][Tab]	Label	Call a subroutine
    [Space][LF]	Label	Jump unconditionally to a label
    [Tab][Space]	Label	Jump to a label if the top of the stack is zero
    [Tab][Tab]	Label	Jump to a label if the top of the stack is negative
    [Tab][LF]	-	End a subroutine and transfer control back to the caller
    [LF][LF]	-	End the program */

    /**
     * [LF][LF]	-	End the program
     * @return
     */
    public WhiteSpaceProgram flowEndProgram() {
        program.append(IMP_FLOW).append("\n\n");
        return this;
    }

    /**
     * @return The current program as a String.
     */
    @Override
    public String toString() {
        return program.toString();
    }
}
