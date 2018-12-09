/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste.projeto.service;

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
public class ProdutoServiceTest {
    
    private EJBContainer container;
    private ProdutoService instance;
    private Produto produtoOne;
    private Produto produtoTwo;
    private Produto produtoThree;
    
    public ProdutoServiceTest() {
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
        instance = (ProdutoService)container.getContext().lookup("java:global/classes/ProdutoService");
        
        produtoOne = new Produto();
        produtoOne.setDsProduto("Teste 1");
        produtoOne.setCdProduto(new Random().nextInt());
        produtoOne.setVlAltura(new Random().nextDouble());
        produtoOne.setVlLargura(new Random().nextDouble());
        produtoOne.setVlProfundidade(new Random().nextDouble());
        
        produtoTwo = new Produto();
        produtoTwo.setDsProduto("Teste 2");
        produtoTwo.setCdProduto(new Random().nextInt());
        produtoTwo.setVlAltura(new Random().nextDouble());
        produtoTwo.setVlLargura(new Random().nextDouble());
        produtoTwo.setVlProfundidade(new Random().nextDouble());
        
        produtoThree = new Produto();
        produtoThree.setDsProduto("Teste 3");
        produtoThree.setCdProduto(new Random().nextInt());
        produtoThree.setVlAltura(new Random().nextDouble());
        produtoThree.setVlLargura(new Random().nextDouble());
        produtoThree.setVlProfundidade(new Random().nextDouble());
        
        // Persist
        produtoOne = instance.addProduto(produtoOne);
        produtoTwo = instance.addProduto(produtoTwo);
        produtoThree = instance.addProduto(produtoThree);
    }
    
    @After
    public void tearDown() {
        instance.removeProduto(produtoOne);
        instance.removeProduto(produtoTwo);
        instance.removeProduto(produtoThree);
        instance = null;
        container.close();
        container = null;
    }
    
    /**
     * Test of addProduto method, of class ProdutoService.
     */
    @Test
    public void testAddProduto() throws Exception {
        System.out.println("addProduto");
        Produto p = new Produto();
        p.setDsProduto("Teste");
        p.setCdProduto(new Random().nextInt());
        p.setVlAltura(new Random().nextDouble());
        p.setVlLargura(new Random().nextDouble());
        p.setVlProfundidade(new Random().nextDouble());
        Produto result = instance.addProduto(p);
        Produto expResult = instance.getProduto(result.getId());
        assertEquals(result,expResult);
        assertEquals(result.getDsProduto(),expResult.getDsProduto());
    }

    /**
     * Test of setProduto method, of class ProdutoService.
     */
    @Test
    public void testSetProduto() throws Exception {
        System.out.println("setProduto");
        String nameOfProduto = "Produto name "+new Random().nextInt();
        Produto c = produtoTwo;
        c.setDsProduto(nameOfProduto);
        Produto result = instance.setProduto(c);
        assertEquals(nameOfProduto, result.getDsProduto());
    }

    /**
     * Test of getProdutos method, of class ProdutoService.
     */
    @Test
    public void testGetProdutos() throws Exception {
        System.out.println("getProdutos");
        List<Produto> expResult = null;
        List<Produto> result = instance.getProdutos();
        assertEquals(expResult, result);
        container.close();
    }

    /**
     * Test of getProduto method, of class ProdutoService.
     */
    @Test
    public void testGetProduto() throws Exception {
        System.out.println("getProduto");
        int idOfProduto = produtoThree.getId();
        Produto expResult = produtoThree;
        Produto result = instance.getProduto(idOfProduto);
        assertEquals(expResult, result);
    }

    /**
     * Test of getProdutoCodigo method, of class ProdutoService.
     */
    @Test
    public void testGetProdutoCodigo() throws Exception {
        System.out.println("getProdutoCodigo");
        int idOfProduto = produtoThree.getCdProduto();
        Produto expResult = produtoThree;
        Produto result = instance.getProduto(idOfProduto);
        assertEquals(expResult, result);
    }

    /**
     * Test of removeProduto method, of class ProdutoService.
     */
    @Test
    public void testRemoveProduto() throws Exception {
        System.out.println("removeProduto");
        Produto p = new Produto();
        p.setDsProduto("Teste");
        p.setCdProduto(new Random().nextInt());
        p.setVlAltura(new Random().nextDouble());
        p.setVlLargura(new Random().nextDouble());
        p.setVlProfundidade(new Random().nextDouble());
        Produto toRemove = instance.addProduto(p);
        Produto gettedToRemove = instance.getProduto(toRemove.getId());
        assertNotNull(toRemove);
        assertNotNull(gettedToRemove);
        instance.removeProduto(gettedToRemove);
        Produto removed = instance.getProduto(gettedToRemove.getId());
        assertNull(removed);
        
    }
    
}
