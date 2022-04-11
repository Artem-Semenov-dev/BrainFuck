package BrainfuckCompiler.compiler;

import BrainfuckCompiler.commands.Command;
import org.reflections.Reflections;

import java.util.*;
import java.util.stream.Collectors;

public class Compiler {
    public List<Command> compileProgram(String brainfuckCode) throws Exception {
        Reflections reflections = new Reflections("BrainfuckCompiler.commands");
        Set<Class<? extends Command>> classes = reflections.getSubTypesOf(Command.class);

        Map<Character, Class<? extends Command>> mapOfCommands = getMapOfCommands(classes);

        Deque<List<Command>> stack = new ArrayDeque<>();

        char[] brainfuckCommands = brainfuckCode.toCharArray();

        stack.push(new ArrayList<>());
        for (char command : brainfuckCommands){
            if (command == '['){
                stack.push(new ArrayList<>());
            }
            else if (command == ']'){
                List<Command> innerCommandsList = stack.pop();
                stack.peek().add(mapOfCommands.get(command).getDeclaredConstructor(List.class).newInstance(innerCommandsList));
            }
            else {
                try {
                    stack.peek().add(mapOfCommands.get(command).getDeclaredConstructor().newInstance());
                }
                catch (Exception e){
                    throw new Exception("No such symbol expected");
                }
            }
        }

        return stack.pop();
    }

    private Map<Character, Class<? extends Command>> getMapOfCommands(Set<Class<? extends Command>> classes) {
        return classes.stream().collect(Collectors.toMap(
                x -> {
                    try {
                        return x.getDeclaredField("symbol").getChar(null);
                    } catch (IllegalAccessException | NoSuchFieldException e) {
                        e.printStackTrace();
                    }
                    return null;
                }
                , y -> y));
    }
}