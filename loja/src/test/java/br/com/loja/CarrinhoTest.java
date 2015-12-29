package br.com.loja;

import br.com.loja.modelo.Carrinho;
import com.thoughtworks.xstream.XStream;
import org.junit.Assert;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

/**
 * Created by odilon on 28/12/15.
 */
public class CarrinhoTest extends IntegradoTest {

    @Test
    public void verificaRespostaCarrinho() {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8080");
        String conteudo = target.path("carrinhos/1").request().get(String.class);

        Carrinho carrinho = (Carrinho) new XStream().fromXML(conteudo);

        Assert.assertNotNull(carrinho);
    }

    @Override
    protected String uri() {
        return "http:localhost:8080";
    }

    @Override
    protected String packages() {
        return "br.com.loja";
    }
}
