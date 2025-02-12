package br.stream;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class SocketChannelServe {
    public static void main(String[] args)  {
        try { // mostra o erro detalhado
            ServerSocketChannel serverChannel = ServerSocketChannel.open(); // abre a conexão
            serverChannel.socket().bind(new InetSocketAddress(5000)); //endereço local, vinculado a porta 5000
            System.out.println("Servidor em execução - ouvindo na porta 5000");
            while (true){ // entrando nesse loop, ele ficará infintito nesse processo.
                SocketChannel  socketChannel = serverChannel.accept();  //(Conexão do Servidor) fica esperando que o cliente solicite a porta 5000
                System.out.println("Conexão aceita: " + socketChannel.getRemoteAddress()); // irá pegar o endereço IP que conectou com ele. Imprime o endereço
                ByteBuffer buffer = ByteBuffer.allocate(1024);

                int byteRead = socketChannel.read(buffer); //irá lê as informações
                while (byteRead != -1){
                    buffer.flip();
                    while (buffer.hasRemaining()){ //checa se acabou ou não os bytes
                        System.out.println((char) buffer.get());
                    }
                    buffer.clear(); //limpa os bytes para que o proximo processo venha
                    byteRead = socketChannel.read(buffer);
                }
                socketChannel.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
