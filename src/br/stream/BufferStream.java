package br.stream;

import java.nio.FloatBuffer;

public class BufferStream {
    public static void main(String[] args) {
        FloatBuffer buffer = FloatBuffer.allocate(5);

        buffer.put(3.1f);
        buffer.put(3.2f);
        buffer.put(3.3f);
        buffer.put(3.4f);
        buffer.put(3.4f);
        buffer.flip();
        while (buffer.hasRemaining()){ //confere se há mais dados no banco ou não
            System.out.println(buffer.get());

        }
    }
}
