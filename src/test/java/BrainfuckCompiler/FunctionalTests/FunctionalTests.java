package BrainfuckCompiler.FunctionalTests;

import BrainfuckCompiler.compiler.Compiler;
import BrainfuckCompiler.compiler.Executor;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class FunctionalTests {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    public void testCompilorSquare() throws Exception {
        String brainfuckProgram = "++++[>+++++<-]>[<+++++>-]+<+[" +
                ">[>+>+<<-]++>>[<<+>>-]>>>[-]++>[-]+" +
                ">>>+[[-]++++++>>>]<<<[[<++++++++<++>>-]+<.<[>----<-]<]" +
                "<<[>>>>>[>>>[-]+++++++++<[>-<-]+++++++++>[-[<->-]+[<<<]]<[>+<-]>]<<-]<<-" +
                "]";

        StringBuilder testCaseSquare = new StringBuilder();
        for (int i = 0; i < 101; i++){
            testCaseSquare.append(i * i).append("\n");
        }

        Compiler compiler = new Compiler();
        Executor ex = new Executor();

        ex.execution(compiler.compileProgram(brainfuckProgram));
        Assertions.assertEquals(testCaseSquare.toString(), output.toString());
    }

    @Test
    public void testCompilorHiMom() throws Exception {
        String brainfuckProgram = "+[----->+++<]>+.+.[--->+<]>---.+[----->+<]>.++.--.";

        Compiler compiler = new Compiler();
        Executor ex = new Executor();

        ex.execution(compiler.compileProgram(brainfuckProgram));
        Assertions.assertEquals("hi mom", output.toString());
    }

    @AfterEach
    public void cleanUpStreams() {
        System.setOut(null);
    }
}
