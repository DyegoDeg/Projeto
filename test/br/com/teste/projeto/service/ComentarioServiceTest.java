/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste.projeto.service;

import br.com.teste.projeto.entidade.Comentario;
import br.com.teste.projeto.entidade.Produto;
import java.util.List;
import java.util.Random;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Dyego
 */
public class ComentarioServiceTest {
    
    private EJBContainer container;
    private ComentarioService instance;
    private ProdutoService instanceProduto;
    private Comentario comentarioOne;
    private Comentario comentarioTwo;
    private Comentario comentarioThree;
    private Produto produto;
    
    public ComentarioServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws NamingException {
        container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        instance = (ComentarioService)container.getContext().lookup("java:global/classes/ComentarioService");
        
        produto = new Produto();
        produto.setDsProduto("Teste");
        produto.setCdProduto(new Random().nextInt());
        produto.setVlAltura(new Random().nextDouble());
        produto.setVlLargura(new Random().nextDouble());
        produto.setVlProfundidade(new Random().nextDouble());
        
        comentarioOne = new Comentario();
        comentarioOne.setDsComentario("Teste 1");
        comentarioOne.setProduto(produto);
        
        comentarioTwo = new Comentario();
        comentarioTwo.setDsComentario("Teste 2");
        comentarioTwo.setProduto(produto);
        
        comentarioThree = new Comentario();
        comentarioThree.setDsComentario("Teste 3");
        comentarioThree.setProduto(produto);
        
        // Persist
        produto = instanceProduto.addProduto(produto);
        comentarioOne   = instance.addComentario(comentarioOne);
        comentarioTwo   = instance.addComentario(comentarioTwo);
        comentarioThree   = instance.addComentario(comentarioThree);
    }
    
    @After
    public void tearDown() {
        instance.removeComentario(comentarioOne.getCdComentario());
        instance.removeComentario(comentarioTwo.getCdComentario());
        instance.removeComentario(comentarioThree.getCdComentario());
        instanceProduto.removeProduto(produto);
        instanceProduto = null;
        instance = null;
        container.close();
        container = null;
    }
    
    /**
     * Test of addComentario method, of class ComentarioService.
     */
    @Test
    public void testAddComentario() throws Exception {
        System.out.println("addComentario");
        Comentario c = new Comentario();
        c.setDsComentario("Teste 4");
        c.setProduto(produto);
        Comentario result = instance.addComentario(c);
        Comentario expResult = instance.getComentario(result.getCdComentario());
        assertEquals(result,expResult);
        assertEquals(result.getDsComentario(),expResult.getDsComentario());
    }
    
    /**
     * Test of setComentario method, of class ComentarioService.
     */
    @Test
    public void testSetComentario() throws Exception {
        System.out.println("setComentario");
        String descricao = "Comentario desc "+new Random().nextInt();
        Comentario c = comentarioTwo;
        c.setDsComentario(descricao);
        Comentario result = instance.setComentario(c);
        assertEquals(descricao, result.getDsComentario());
    }

    /**
     * Test of getComentarios method, of class ComentarioService.
     */
    @Test
    public void testGetComentarios() throws Exception {
        System.out.println("getComentarios");
        List<Comentario> expResult = null;
        List<Comentario> result = instance.getComentarios(produto.getCdProduto());
        assertEquals(expResult, result);
        container.close();
    }

    /**
     * Test of getComentario method, of class ComentarioService.
     */
    @Test
    public void testGetComentario() throws Exception {
        System.out.println("getComentario");
        int idOfComentario = comentarioThree.getCdComentario();
        Comentario expResult = comentarioThree;
        Comentario result = instance.getComentario(idOfComentario);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeComentario method, of class ComentarioService.
     */
    @Test
    public void testRemoveComentario() throws Exception {
        System.out.println("removeComentario");
        Comentario c = new Comentario();
        c.setDsComentario("Teste 4");
        c.setProduto(produto);
        Comentario toRemove = instance.addComentario(c);
        Comentario gettedToRemove = instance.getComentario(toRemove.getCdComentario());
        assertNotNull(toRemove);
        assertNotNull(gettedToRemove);
        instance.removeComentario(gettedToRemove.getCdComentario());
        Comentario removed = instance.getComentario(gettedToRemove.getCdComentario());
        assertNull(removed);
    }
    
}
