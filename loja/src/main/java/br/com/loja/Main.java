package br.com.loja;

import br.com.loja.resource.Servidor;

import java.io.IOException;

/**
 * Created by odilon on 28/12/15.
 */
public class Main {

    public static void main(String[] args) throws IOException {

        Servidor servidor = new Servidor("http://localhost:8080", "br.com.loja");
        servidor.inicializar();
        System.in.read();
        servidor.stop();
    }
}
