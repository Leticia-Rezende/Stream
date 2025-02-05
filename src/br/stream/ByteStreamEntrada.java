package br.stream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteStreamEntrada {
    public static void main(String[] args) {
        String pathFile = "C:\\Users\\Unifan\\Stream\\resources\\arquivo.bin";
        try(InputStream inputStream = new FileInputStream(pathFile)){
            int byteData;
            while ((byteData = inputStream.read()) != -1 ){ //enquanto tiver bytes para ler, ele não retorna o -1
                System.out.println(byteData + " ");
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
