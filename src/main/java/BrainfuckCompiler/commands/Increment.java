package BrainfuckCompiler.commands;

public class Increment implements Command{
    public static char symbol = '+';

    @Override
    public void execute(Memory memory) {
        memory.increment();
    }
}
