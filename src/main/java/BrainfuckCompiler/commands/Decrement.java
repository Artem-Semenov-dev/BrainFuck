package BrainfuckCompiler.commands;

public class Decrement implements Command{
    public static char symbol = '-';

    @Override
    public void execute(Memory memory) {
        memory.decrement();
    }
}
