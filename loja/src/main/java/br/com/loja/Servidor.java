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

    private String packages;
    private String uri;
    private HttpServer server;

    public Servidor(String uri, String packages) {
        this.packages = packages;
        this.uri = uri;
    }

    public void inicializar() {
        ResourceConfig config = new ResourceConfig().packages("br.com.loja");
        URI uri = URI.create("http://localhost:8080/");
        server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
    }

    public void stop() {
        server.stop();
    }
}
