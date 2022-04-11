package BrainfuckCompiler.commands;

public class DoubleIncrement implements Command{
    public static char symbol = '!';

    @Override
    public void execute(Memory memory) {
        memory.doubleIncrement();
    }
}
