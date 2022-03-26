package BrainfuckCompiler.commands;

import java.util.List;

public class Loop implements Command{
    private final List<Command> innerCommands;

    public Loop(List<Command> innerList){
        this.innerCommands = innerList;
    }

    @Override
    public void execute(Memory memory) {
        byte [] tapeForLoopInnerCommands = memory.getTape();
        while (tapeForLoopInnerCommands[memory.getPointer()] != 0){
            innerCommands.forEach(x -> x.execute(memory));
        }
    }
}
