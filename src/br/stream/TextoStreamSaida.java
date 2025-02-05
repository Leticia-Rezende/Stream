package br.stream;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TextoStreamSaida {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Unifan\\Stream\\resources\\arquivo.txt";
        String text = "Aula de Programação Orientada a Objetos 3 -  Stream com texto";

        try(Writer writer = new FileWriter(filePath)){
            writer.write(text);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
