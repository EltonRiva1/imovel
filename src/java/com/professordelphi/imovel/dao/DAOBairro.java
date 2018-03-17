/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.professordelphi.imovel.dao;

import com.professordelphi.imovel.dto.DtoBairro;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author notle
 */
public class DAOBairro extends DtoBairro {

    public DAOBairro() {

    }

    public void persistencia(String s) {

        if (s.equalsIgnoreCase("Limpar")) {
            limpar();
        }

        if (s.equalsIgnoreCase("Incluir")) {

            setSql("INSERT INTO bairro (nomebai)" + " VALUES('" + getNomebai() + "')");
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

            setSql("DELETE from bairro WHERE codigobai = " + Integer.toString(getCodigobai()));

            try {
                meustate.executeUpdate(getSql());
                setMensagem("Operação efetuada com sucesso!");
            } catch (SQLException ex) {
                setMensagem("Operação cancelada! " + getSql() + ex);
            }
        }

        if (s.equalsIgnoreCase("Atualizar")) {

            setSql("UPDATE bairro SET " + "nomebai = '" + getNomebai()
                    + "' WHERE codigobai = " + Integer.toString(getCodigobai()));

            try {
                meustate.executeUpdate(getSql());
                limpar();
                setMensagem("Operação efetuada com sucesso!");
            } catch (SQLException ex) {
                setMensagem("Operação cancelada! " + ex);
            }
        }

        if (s.equalsIgnoreCase("Localizar")) {

            setSql("SELECT * FROM bairro WHERE codigobai = '" + getCodigobai() + "'");

            try {
                rs = meustate.executeQuery(getSql());
                rs.next();
                setNomebai(rs.getString("nomebai"));
                setMensagem("Operação entrada com sucesso!");
            } catch (SQLException erro) {
                setMensagem("Operação cancelada! " + erro);
            }
        }
    }

    public void limpar() {
        setCodigobai(0);
        setNomebai("");
    }

    public List<DtoBairro> listarBairro() {
        DtoBairro dtoBairro;
        List<DtoBairro> lista = new ArrayList<DtoBairro>();
        try {
            rs = meustate.executeQuery("SELECT * FROM bairro");
            while (rs.next()) {
                dtoBairro = new DtoBairro();
                dtoBairro.setCodigobai(rs.getInt("codigobai"));
                dtoBairro.setNomebai(rs.getString("nomebai"));
                lista.add(dtoBairro);
            }
        } catch (Exception e) {
            setMensagem(e.getMessage());
        }
        return lista;
    }

    public void localizarBairro(String s) {
        if (s != null) {
            setSql("SELECT * FROM bairro WHERE codigobai = '" + s + "'");
            try {
                rs = meustate.executeQuery(getSql());
                rs.next();
                setCodigobai(rs.getInt("codigobai"));
                setNomebai(rs.getString("nomebai"));
                setMensagem("Operação entrada com sucesso!");
            } catch (SQLException erro) {
                setMensagem("Operação cancelada! " + erro);
            }
        }
    }

}
