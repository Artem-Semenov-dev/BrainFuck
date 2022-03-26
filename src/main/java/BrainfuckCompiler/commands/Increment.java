package BrainfuckCompiler.commands;

public class Increment implements Command{
    @Override
    public void execute(Memory memory) {
        memory.increment();
    }
}
