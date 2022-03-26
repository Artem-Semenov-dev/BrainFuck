package BrainfuckCompiler.UnitTests;

import BrainfuckCompiler.commands.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

public class CompilerUnitTests {
    @Test
    public void testIncrement(){
        Increment increment = new Increment();
        Memory memory= new Memory();
        increment.execute(memory);
        Assertions.assertEquals(1, memory.getValue());
    }

    @Test
    public void overflowIncrementTest(){
        Increment increment = new Increment();
        Memory memory= new Memory();
        memory.setValue((byte)255);
        increment.execute(memory);
        Assertions.assertEquals(0, memory.getValue());
    }

    @Test
    public void testDecrement(){
        Decrement decrement = new Decrement();
        Memory memory = new Memory();
        memory.setValue((byte)1);
        decrement.execute(memory);
        Assertions.assertEquals(0, memory.getValue());
    }

    @Test
    public void overflowDecrementTest(){
        Decrement decrement = new Decrement();
        Memory memory = new Memory();
        decrement.execute(memory);
        Assertions.assertEquals((byte)255, memory.getValue());
    }

    @Test
    public void testPointerToLeft(){
        PointerToLeft ptl = new PointerToLeft();
        Memory memory = new Memory();
        ptl.execute(memory);
        Assertions.assertEquals((65535/2)-1, memory.getPointer());
    }


    @Test
    public void testPointerToRight(){
        PointerToRight ptr = new PointerToRight();
        Memory memory = new Memory();
        ptr.execute(memory);
        Assertions.assertEquals((65535/2)+1, memory.getPointer());
    }

    @Test
    public void testLoop(){
        Increment inc5 = new Increment();
        Decrement dec = new Decrement();
        Decrement dec1 = new Decrement();
        Decrement dec2 = new Decrement();
        Decrement dec3 = new Decrement();
        Decrement dec4 = new Decrement();
        PointerToRight ptr = new PointerToRight();
        Increment inc = new Increment();
        Increment inc1 = new Increment();
        Increment inc2 = new Increment();
        PointerToLeft ptl = new PointerToLeft();
        List<Command> list = new ArrayList<>();
        list.add(dec);
        list.add(dec1);
        list.add(dec2);
        list.add(dec3);
        list.add(dec4);
        list.add(ptr);
        list.add(inc);
        list.add(inc1);
        list.add(inc2);
        list.add(ptl);
        Memory memory = new Memory();
        inc5.execute(memory);
        Loop loop = new Loop(list);
        loop.execute(memory);
        PointerToRight ptr1 = new PointerToRight();
        ptr1.execute(memory);
        Assertions.assertEquals((byte)103, memory.getValue());
    }
}
