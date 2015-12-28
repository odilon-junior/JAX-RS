package br.com.loja.resource;

import br.com.loja.dao.CarrinhoDAO;
import br.com.loja.modelo.Carrinho;
import com.google.common.net.MediaType;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by odilon on 28/12/15.
 */
@Path("carrinhos")
public class CarrinhoResource {

    @GET
    @Produces("application/xml")
    public String buscar() {
        Carrinho carrinho = new CarrinhoDAO().busca(1l);
        return carrinho.toXml();

    }
}
