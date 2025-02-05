package br.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelSaidaFileStream {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Unifan\\Stream\\resources\\arquivo.txt";
        String text = "Exemplo utilizando o FileChannel";
        try (
                FileOutputStream fos = new FileOutputStream(filePath);
                FileChannel fileChannel = fos.getChannel();
        ){
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put(text.getBytes());
            buffer.flip();
            fileChannel.write(buffer);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
