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
public class DtoCliente extends Conexao {
    
    private int codigocli, whatsappcli;
    private String nomecli, celularcli, emailcli, senhacli;

    /**
     * @return the codigocli
     */
    public int getCodigocli() {
        return codigocli;
    }

    /**
     * @param codigocli the codigocli to set
     */
    public void setCodigocli(int codigocli) {
        this.codigocli = codigocli;
    }

    /**
     * @return the whatsappcli
     */
    public int getWhatsappcli() {
        return whatsappcli;
    }

    /**
     * @param whatsappcli the whatsappcli to set
     */
    public void setWhatsappcli(int whatsappcli) {
        this.whatsappcli = whatsappcli;
    }

    /**
     * @return the nomecli
     */
    public String getNomecli() {
        return nomecli;
    }

    /**
     * @param nomecli the nomecli to set
     */
    public void setNomecli(String nomecli) {
        this.nomecli = nomecli;
    }

    /**
     * @return the celularcli
     */
    public String getCelularcli() {
        return celularcli;
    }

    /**
     * @param celularcli the celularcli to set
     */
    public void setCelularcli(String celularcli) {
        this.celularcli = celularcli;
    }

    /**
     * @return the emailcli
     */
    public String getEmailcli() {
        return emailcli;
    }

    /**
     * @param emailcli the emailcli to set
     */
    public void setEmailcli(String emailcli) {
        this.emailcli = emailcli;
    }

    /**
     * @return the senhacli
     */
    public String getSenhacli() {
        return senhacli;
    }

    /**
     * @param senhacli the senhacli to set
     */
    public void setSenhacli(String senhacli) {
        this.senhacli = senhacli;
    }
    
}