package dynamic;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.ThrowingConsumer;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Function;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.stream;

public class StreamExampleTest {

    @TestFactory
    Stream<DynamicTest> streamTest() {
        Iterator<Integer> inputGenerator = Arrays.asList(2, 4, 6).iterator();
        Function<Integer, String> displayNameGenerator = input -> "Data input:" + input;

        ThrowingConsumer<Integer> testExecutor = (input) -> {
            System.out.println(input);
            assertEquals(0, input % 2);
        };

        return stream(inputGenerator, displayNameGenerator, testExecutor);
    }
}
