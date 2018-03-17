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
public class DtoContato extends Conexao {
    
    private int codigocon;
    private String nomecon, emailcon, observacaocon;

    /**
     * @return the codigocon
     */
    public int getCodigocon() {
        return codigocon;
    }

    /**
     * @param codigocon the codigocon to set
     */
    public void setCodigocon(int codigocon) {
        this.codigocon = codigocon;
    }

    /**
     * @return the nomecon
     */
    public String getNomecon() {
        return nomecon;
    }

    /**
     * @param nomecon the nomecon to set
     */
    public void setNomecon(String nomecon) {
        this.nomecon = nomecon;
    }

    /**
     * @return the emailcon
     */
    public String getEmailcon() {
        return emailcon;
    }

    /**
     * @param emailcon the emailcon to set
     */
    public void setEmailcon(String emailcon) {
        this.emailcon = emailcon;
    }

    /**
     * @return the observacaocon
     */
    public String getObservacaocon() {
        return observacaocon;
    }

    /**
     * @param observacaocon the observacaocon to set
     */
    public void setObservacaocon(String observacaocon) {
        this.observacaocon = observacaocon;
    }
      
}