package BrainfuckCompiler.commands;

import BrainfuckCompiler.commands.Memory;

public class Decrement implements Command{
    @Override
    public void execute(Memory memory) {
        memory.decrement();
    }
}
