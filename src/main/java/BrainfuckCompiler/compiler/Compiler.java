package BrainfuckCompiler.compiler;

import BrainfuckCompiler.commands.*;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Compiler {
    public List<Command> compileProgram(String brainfuckCode) throws Exception {
        Deque<List<Command>> stack = new ArrayDeque<>();

        char[] brainfuckCommands = brainfuckCode.toCharArray();

        stack.push(new ArrayList<>());
        for (char command : brainfuckCommands){
            switch (command){
                case('+') -> stack.peek().add(new Increment());
                case('-') -> stack.peek().add(new Decrement());
                case('>') -> stack.peek().add(new PointerToRight());
                case('<') -> stack.peek().add(new PointerToLeft());
                case('.') -> stack.peek().add(new PrintToStream());

                case('[') -> stack.push(new ArrayList<>());
                case(']') -> {
                    List<Command> innerCommandsList = stack.pop();
                    stack.peek().add(new Loop(innerCommandsList));
                }

                default -> throw new Exception("Unexpected character '" + command + "'");
            }
        }

        return stack.pop();
    }







}
