package br.com.loja.resource;

import br.com.loja.dao.CarrinhoDAO;
import br.com.loja.modelo.Carrinho;
import com.google.common.net.MediaType;
import com.sun.deploy.net.HttpResponse;
import com.thoughtworks.xstream.XStream;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.net.URI;

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
    @Consumes("application/xml")
    @Produces("application/xml")
    public Response salvar(String xml) {
        Carrinho carrinho = (Carrinho) new XStream().fromXML(xml);
        URI uri = URI.create("carrinhos/" + carrinho.getId());
        return Response.created(uri).build();
    }

    @DELETE
    @Path("{id}/produtos/{produto}")
    public Response deletar(@PathParam("id") long id, @PathParam("produto") long idProduto){
        Carrinho carrinho = new CarrinhoDAO().busca(id);
        carrinho.remove(idProduto);
        return Response.ok().build();
    }

}
