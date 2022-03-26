package BrainfuckCompiler.commands;

public class PointerToLeft implements Command{
    @Override
    public void execute(Memory memory) {
        memory.ptrToLeft();
    }
}
