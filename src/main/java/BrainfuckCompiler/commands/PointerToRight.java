package BrainfuckCompiler.commands;

public class PointerToRight implements Command{
    public static char symbol = '>';

    @Override
    public void execute(Memory memory) {
        memory.ptrToRight();
    }
}