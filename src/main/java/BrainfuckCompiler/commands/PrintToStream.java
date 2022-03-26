package BrainfuckCompiler.commands;

public class PrintToStream implements Command {
    @Override
    public void execute(Memory memory) {
        memory.printToStream();
    }
}
