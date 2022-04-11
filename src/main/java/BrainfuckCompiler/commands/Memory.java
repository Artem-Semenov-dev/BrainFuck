package BrainfuckCompiler.commands;

public class Memory {
    private static final int MAX_NUMBER_OF_CELLS = 65535;
    private static final int MAX_VALUE_FOR_CELL = 255;
    private final byte[] tape = new byte[MAX_NUMBER_OF_CELLS];
    private int pointer = MAX_NUMBER_OF_CELLS / 2;

    public byte[] getTape() {
        return tape;
    }

    public int getPointer() {
        return pointer;
    }

    public void increment() {
        if (tape[pointer] == (byte) MAX_VALUE_FOR_CELL)
            tape[pointer] = 0;
        else
            tape[pointer]++;
    }

    public void decrement() {
        if (tape[pointer] == 0)
            tape[pointer] = (byte) MAX_VALUE_FOR_CELL;
        else
            tape[pointer]--;
    }

    public void doubleIncrement(){
        if (tape[pointer] == (byte) MAX_VALUE_FOR_CELL)
            tape[pointer] = 0;
        else {
            tape[pointer]++;
            tape[pointer]++;
        }
    }

    public void ptrToLeft() {
        try {
            pointer--;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void ptrToRight() {
        try {
            pointer++;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void printToStream() {
        System.out.print((char) (tape[pointer]));
    }

    public byte getValue() {
        return tape[pointer];
    }

    public void setValue(byte value) {
        tape[pointer] = value;
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }
}
