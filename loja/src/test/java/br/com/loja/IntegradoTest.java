package br.com.loja;

import br.com.loja.resource.Servidor;
import org.junit.After;
import org.junit.Before;

/**
 * Created by odilon on 28/12/15.
 */
public abstract class IntegradoTest {

    private Servidor servidor;

    protected abstract String uri();

    protected abstract String packages();

    @Before
    public void before() {
        servidor = new Servidor(this.uri(), this.packages());
        servidor.inicializar();
    }

    @After
    public void after() {
        servidor.stop();
    }
}
