package br.stream;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelClient {
    public static void main(String[] args) {
        try {
            SocketChannel socketChannel = SocketChannel.open();// abre a conexão
            socketChannel.connect(new InetSocketAddress("localhost" , 5000));

            String message = "Olá servidor, essa é uma mensagem do cliente";
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            buffer.put(message.getBytes()); // irá pegar o texto e convereter para byte
            buffer.flip();
            socketChannel.write(buffer);
            socketChannel.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
