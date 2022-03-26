package BrainfuckCompiler.compiler;

import BrainfuckCompiler.commands.Command;

import java.util.List;

public class Interpreter {
    public static void main(String[] args) throws Exception {
        String source = "++++[>+++++<-]>[<+++++>-]+<+["  +
                ">[>+>+<<-]++>>[<<+>>-]>>>[-]++>[-]+" +
                ">>>+[[-]++++++>>>]<<<[[<++++++++<++>>-]+<.<[>----<-]<]" +
                "<<[>>>>>[>>>[-]+++++++++<[>-<-]+++++++++>[-[<->-]+[<<<]]<[>+<-]>]<<-]<<-" +
                "]";

        Compiler compiler = new Compiler();
        Executor ex = new Executor();

        List<Command> program = compiler.compileProgram(source);
        ex.execution(program);
    }
}
