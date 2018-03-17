/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.professordelphi.imovel.dto;

/**
 *
 * @author notle
 */
public class DtoFuncionario extends DtoCorretor {

    private int codigofunc, whatsappfunc;
    private String nomefunc, celularfunc, emailfunc, senhafunc;

    /**
     * @return the codigofunc
     */
    public int getCodigofunc() {
        return codigofunc;
    }

    /**
     * @param codigofunc the codigofunc to set
     */
    public void setCodigofunc(int codigofunc) {
        this.codigofunc = codigofunc;
    }

    /**
     * @return the whatsappfunc
     */
    public int getWhatsappfunc() {
        return whatsappfunc;
    }

    /**
     * @param whatsappfunc the whatsappfunc to set
     */
    public void setWhatsappfunc(int whatsappfunc) {
        this.whatsappfunc = whatsappfunc;
    }

    /**
     * @return the nomefunc
     */
    public String getNomefunc() {
        return nomefunc;
    }

    /**
     * @param nomefunc the nomefunc to set
     */
    public void setNomefunc(String nomefunc) {
        this.nomefunc = nomefunc;
    }

    /**
     * @return the celularfunc
     */
    public String getCelularfunc() {
        return celularfunc;
    }

    /**
     * @param celularfunc the celularfunc to set
     */
    public void setCelularfunc(String celularfunc) {
        this.celularfunc = celularfunc;
    }

    /**
     * @return the emailfunc
     */
    public String getEmailfunc() {
        return emailfunc;
    }

    /**
     * @param emailfunc the emailfunc to set
     */
    public void setEmailfunc(String emailfunc) {
        this.emailfunc = emailfunc;
    }

    /**
     * @return the senhafunc
     */
    public String getSenhafunc() {
        return senhafunc;
    }

    /**
     * @param senhafunc the senhafunc to set
     */
    public void setSenhafunc(String senhafunc) {
        this.senhafunc = senhafunc;
    }

}
