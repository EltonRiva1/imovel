/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.professordelphi.imovel.dao;

import com.professordelphi.imovel.dto.DtoFuncionario;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author notle
 */
public class DAOFuncionario extends DtoFuncionario {

    public DAOFuncionario() {

    }

    public void persistencia(String s) {

        if (s.equalsIgnoreCase("Limpar")) {
            limpar();
        }

        if (s.equalsIgnoreCase("Incluir")) {

            setSql("INSERT INTO funcionario (nomefunc, celularfunc, whatsappfunc, emailfunc, senhafunc)"
                    + " VALUES ('" + getNomefunc()
                    + "', '" + getCelularfunc()
                    + "', '" + getWhatsappfunc()
                    + "', '" + getEmailfunc()
                    + "', '" + getSenhafunc() + "')");
            System.out.println(getSql());

            try {
                meustate.executeUpdate(getSql());
                limpar();
                setMensagem("Operação efetuada com sucesso!");
            } catch (SQLException ex) {
                setMensagem("Operação cancelada! " + getSql() + ex);
            }
        }

        if (s.equalsIgnoreCase("Excluir")) {

            setSql("DELETE from funcionario WHERE codigofunc = " + Integer.toString(getCodigofunc()));

            try {
                meustate.executeUpdate(getSql());
                setMensagem("Operação efetuada com sucesso!");
            } catch (SQLException ex) {
                setMensagem("Operação cancelada! " + getSql() + ex);
            }
        }

        if (s.equalsIgnoreCase("Atualizar")) {

            setSql("UPDATE funcionario SET " + "nomefunc = '" + getNomefunc()
                    + "', " + "celularfunc = '" + getCelularfunc() + "', "
                    + "whatsappfunc = '" + getWhatsappfunc() + "', "
                    + "emailfunc = '" + getEmailfunc() + "', "
                    + "senhafunc = '" + getSenhafunc() + "' WHERE codigofunc = " + Integer.toString(getCodigofunc()));

            try {
                meustate.executeUpdate(getSql());
                limpar();
                setMensagem("Operação efetuada com sucesso!");
            } catch (SQLException ex) {
                setMensagem("Operação cancelada! " + ex);
            }
        }

        if (s.equalsIgnoreCase("Localizar")) {

            setSql("SELECT * FROM funcionario WHERE codigofunc = '" + getCodigofunc() + "'");

            try {
                rs = meustate.executeQuery(getSql());
                rs.next();
                setCodigofunc(rs.getInt("codigofunc"));
                setNomefunc(rs.getString("nomefunc"));
                setCelularfunc(rs.getString("celularfunc"));
                setWhatsappfunc(rs.getInt("whatsappfunc"));
                setEmailfunc(rs.getString("emailfunc"));
                setSenhafunc(rs.getString("senhafunc"));
                setMensagem("Operação entrada com sucesso!");
            } catch (SQLException erro) {
                setMensagem("Operação cancelada! " + erro);
            }
        }
    }

    public void limpar() {
        setCodigofunc(0);
        setNomefunc("");
        setCelularfunc("");
        setWhatsappfunc(0);
        setEmailfunc("");
        setSenhafunc("");
    }

    public List<DtoFuncionario> listarFuncionario() {
        DtoFuncionario dtoFuncionario;
        List<DtoFuncionario> lista = new ArrayList<DtoFuncionario>();
        try {
            rs = meustate.executeQuery("SELECT * FROM funcionario");
            while (rs.next()) {
                dtoFuncionario = new DtoFuncionario();
                dtoFuncionario.setCodigofunc(rs.getInt("codigofunc"));
                dtoFuncionario.setNomefunc(rs.getString("nomefunc"));
                dtoFuncionario.setCelularfunc(rs.getString("celularfunc"));
                dtoFuncionario.setWhatsappfunc(rs.getInt("whatsappfunc"));
                dtoFuncionario.setEmailfunc(rs.getString("emailfunc"));
                dtoFuncionario.setSenhafunc(rs.getString("senhafunc"));
                lista.add(dtoFuncionario);
            }
        } catch (Exception e) {
            setMensagem(e.getMessage());
        }
        return lista;
    }

    public void localizarFuncionario(String s) {
        if (s != null) {
            setSql("SELECT * FROM funcionario WHERE codigofunc = '" + s + "'");
            try {
                rs = meustate.executeQuery(getSql());
                rs.next();
                setCodigofunc(rs.getInt("codigofunc"));
                setNomefunc(rs.getString("nomefunc"));
                setCelularfunc(rs.getString("celularfunc"));
                setWhatsappfunc(rs.getInt("whatsappfunc"));
                setEmailfunc(rs.getString("emailfunc"));
                setSenhafunc(rs.getString("senhafunc"));
                setMensagem("Operação entrada com sucesso!");
            } catch (SQLException erro) {
                setMensagem("Operação cancelada! " + erro);
            }
        }
    }

}
