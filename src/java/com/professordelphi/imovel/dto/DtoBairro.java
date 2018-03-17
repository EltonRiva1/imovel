/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.professordelphi.imovel.dto;

import com.professordelphi.imovel.utilitarios.Conexao;

/**
 *
 * @author notle
 */
public class DtoBairro extends Conexao {
    
    private int codigobai;
    private String nomebai;

    /**
     * @return the codigobai
     */
    public int getCodigobai() {
        return codigobai;
    }

    /**
     * @param codigobai the codigobai to set
     */
    public void setCodigobai(int codigobai) {
        this.codigobai = codigobai;
    }

    /**
     * @return the nomebai
     */
    public String getNomebai() {
        return nomebai;
    }

    /**
     * @param nomebai the nomebai to set
     */
    public void setNomebai(String nomebai) {
        this.nomebai = nomebai;
    }
    
}