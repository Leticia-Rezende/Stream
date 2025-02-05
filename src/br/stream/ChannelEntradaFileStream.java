package br.stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ChannelEntradaFileStream {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Unifan\\Stream\\resources\\arquivo.txt";
        try (FileInputStream fis = new FileInputStream(filePath)
            FileChannel fileChannel = fis.getChannel()){

            ByteBuffer buffer = ByteBuffer.allocate(1024); //cria um ByteBuffer para armazenar os dados lidos
            int bytesRead = fileChannel.read(buffer); // lê os dados do canal para o buffer

            while (bytesRead != -1){
                buffer.flip(); //muda o buufer para leitura

                while (buffer.hasRemaining()){
                    System.out.println((char) buffer.get()); //converte os bytes para string e imprime
                }
                buffer.clear();
                bytesRead = fileChannel.read(buffer);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
