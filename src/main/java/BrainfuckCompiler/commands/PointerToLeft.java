package BrainfuckCompiler.commands;

public class PointerToLeft implements Command{
    public static char symbol = '<';

    @Override
    public void execute(Memory memory) {
        memory.ptrToLeft();
    }
}
