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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Dyego
 */
@Entity
@Table(name = "COMENTARIO")
public class Comentario implements Serializable {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CD_COMENTARIO")
    private int cdComentario;
    @Column(name = "DS_COMENTARIO")
    private String dsComentario;
    
    @OneToOne
    //@JoinColumn(name="CD_PRODUTO_FK", referencedColumnName = "CD_PRODUTO")
    private Produto produto;

    /**
     * @return the cdComentario
     */
    public int getCdComentario() {
        return cdComentario;
    }

    /**
     * @param cdComentario the cdComentario to set
     */
    public void setCdComentario(int cdComentario) {
        this.cdComentario = cdComentario;
    }

    /**
     * @return the dsComentario
     */
    public String getDsComentario() {
        return dsComentario;
    }

    /**
     * @param dsComentario the dsComentario to set
     */
    public void setDsComentario(String dsComentario) {
        this.dsComentario = dsComentario;
    }

    /**
     * @return the produto
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * @param produto the produto to set
     */
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    
    
}
