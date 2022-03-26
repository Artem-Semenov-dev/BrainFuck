package BrainfuckCompiler.commands;

public class PointerToRight implements Command{
    @Override
    public void execute(Memory memory) {
        memory.ptrToRight();
    }
}
