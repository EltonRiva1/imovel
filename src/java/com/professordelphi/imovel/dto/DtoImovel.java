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
public class DtoImovel extends Conexao {
    
    private int codigoimo, codigobai;
    private String enderecoimo, cepimo, fotoimo;

    /**
     * @return the codigoimo
     */
    public int getCodigoimo() {
        return codigoimo;
    }

    /**
     * @param codigoimo the codigoimo to set
     */
    public void setCodigoimo(int codigoimo) {
        this.codigoimo = codigoimo;
    }

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
     * @return the enderecoimo
     */
    public String getEnderecoimo() {
        return enderecoimo;
    }

    /**
     * @param enderecoimo the enderecoimo to set
     */
    public void setEnderecoimo(String enderecoimo) {
        this.enderecoimo = enderecoimo;
    }

    /**
     * @return the cepimo
     */
    public String getCepimo() {
        return cepimo;
    }

    /**
     * @param cepimo the cepimo to set
     */
    public void setCepimo(String cepimo) {
        this.cepimo = cepimo;
    }

    /**
     * @return the fotoimo
     */
    public String getFotoimo() {
        return fotoimo;
    }

    /**
     * @param fotoimo the fotoimo to set
     */
    public void setFotoimo(String fotoimo) {
        this.fotoimo = fotoimo;
    }
    
}