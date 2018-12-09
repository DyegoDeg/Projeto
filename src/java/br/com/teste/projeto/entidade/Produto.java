/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.teste.projeto.entidade;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Dyego
 */
@Entity
@Table(name = "PRODUTO")
public class Produto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name = "CD_PRODUTO")
    private int cdProduto;
    @Column(name = "DS_PRODUTO")
    private String dsProduto;
    @Column(name = "VL_ALTURA")
    private double vlAltura;
    @Column(name = "VL_LARGURA")
    private double vlLargura;
    @Column(name = "VL_PROFUNDIDADE")
    private double vlProfundidade;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the cdProduto
     */
    public int getCdProduto() {
        return cdProduto;
    }

    /**
     * @param cdProduto the cdProduto to set
     */
    public void setCdProduto(int cdProduto) {
        this.cdProduto = cdProduto;
    }

    /**
     * @return the dsProduto
     */
    public String getDsProduto() {
        return dsProduto;
    }

    /**
     * @param dsProduto the dsProduto to set
     */
    public void setDsProduto(String dsProduto) {
        this.dsProduto = dsProduto;
    }

    /**
     * @return the vlAltura
     */
    public double getVlAltura() {
        return vlAltura;
    }

    /**
     * @param vlAltura the vlAltura to set
     */
    public void setVlAltura(double vlAltura) {
        this.vlAltura = vlAltura;
    }

    /**
     * @return the vlLargura
     */
    public double getVlLargura() {
        return vlLargura;
    }

    /**
     * @param vlLargura the vlLargura to set
     */
    public void setVlLargura(double vlLargura) {
        this.vlLargura = vlLargura;
    }

    /**
     * @return the vlProfundidade
     */
    public double getVlProfundidade() {
        return vlProfundidade;
    }

    /**
     * @param vlProfundidade the vlProfundidade to set
     */
    public void setVlProfundidade(double vlProfundidade) {
        this.vlProfundidade = vlProfundidade;
    }

}
