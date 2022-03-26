package BrainfuckCompiler.compiler;

import BrainfuckCompiler.commands.Command;
import BrainfuckCompiler.commands.Memory;

import java.util.List;

public class Executor {
    public void execution(List<Command> programm){
        Memory memory = new Memory();
        programm.forEach(x -> x.execute(memory));
    }
}
