package br.com.loja.resource;

import br.com.loja.dao.CarrinhoDAO;
import br.com.loja.modelo.Carrinho;
import com.thoughtworks.xstream.XStream;

import javax.ws.rs.*;

/**
 * Created by odilon on 28/12/15.
 */
@Path("carrinhos")
public class CarrinhoResource {

    @Path("{id}")
    @GET
    @Produces("application/xml")
    public String buscar(@PathParam("id") Long id) {
        Carrinho carrinho = new CarrinhoDAO().busca(id);
        return carrinho.toXml();
    }

    @POST
    @Produces("application/xml")
    public String salvar(String xml) {
        Carrinho carrinho = (Carrinho) new XStream().fromXML(xml);
        new CarrinhoDAO().adiciona(carrinho);
        return "<>ok<>";

    }
}
