package br.com.loja;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import java.io.IOException;
import java.net.URI;

/**
 * Created by odilon on 28/12/15.
 */
public class Servidor {
    public static void main(String[] args) throws IOException {

        ResourceConfig config = new ResourceConfig().packages("br.com.loja");
        URI uri = URI.create("http://localhost:8080/");
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
        System.out.println("Servidor rodando");
        System.in.read();
        server.stop();
    }

}
