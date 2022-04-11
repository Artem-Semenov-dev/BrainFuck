package BrainfuckCompiler.commands;

public class PrintToStream implements Command {
    public static char symbol = '.';

    @Override
    public void execute(Memory memory) {
        memory.printToStream();
    }
}
