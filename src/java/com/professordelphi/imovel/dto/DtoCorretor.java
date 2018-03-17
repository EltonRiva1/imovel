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
public class DtoCorretor extends Conexao {
    
    private int codigocor, whatsappcor;
    private String nomecor, celularcor, emailcor, senhacor, crecicor;

    /**
     * @return the codigocor
     */
    public int getCodigocor() {
        return codigocor;
    }

    /**
     * @param codigocor the codigocor to set
     */
    public void setCodigocor(int codigocor) {
        this.codigocor = codigocor;
    }

    /**
     * @return the whatsappcor
     */
    public int getWhatsappcor() {
        return whatsappcor;
    }

    /**
     * @param whatsappcor the whatsappcor to set
     */
    public void setWhatsappcor(int whatsappcor) {
        this.whatsappcor = whatsappcor;
    }

    /**
     * @return the nomecor
     */
    public String getNomecor() {
        return nomecor;
    }

    /**
     * @param nomecor the nomecor to set
     */
    public void setNomecor(String nomecor) {
        this.nomecor = nomecor;
    }

    /**
     * @return the celularcor
     */
    public String getCelularcor() {
        return celularcor;
    }

    /**
     * @param celularcor the celularcor to set
     */
    public void setCelularcor(String celularcor) {
        this.celularcor = celularcor;
    }

    /**
     * @return the emailcor
     */
    public String getEmailcor() {
        return emailcor;
    }

    /**
     * @param emailcor the emailcor to set
     */
    public void setEmailcor(String emailcor) {
        this.emailcor = emailcor;
    }

    /**
     * @return the senhacor
     */
    public String getSenhacor() {
        return senhacor;
    }

    /**
     * @param senhacor the senhacor to set
     */
    public void setSenhacor(String senhacor) {
        this.senhacor = senhacor;
    }

    /**
     * @return the crecicor
     */
    public String getCrecicor() {
        return crecicor;
    }

    /**
     * @param crecicor the crecicor to set
     */
    public void setCrecicor(String crecicor) {
        this.crecicor = crecicor;
    }
     
}