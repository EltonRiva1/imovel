/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.professordelphi.imovel.dao;

import com.professordelphi.imovel.dto.DtoContato;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author notle
 */
public class DAOContato extends DtoContato {

    public DAOContato() {

    }

    public void persistencia(String s) {

        if (s.equalsIgnoreCase("Limpar")) {
            limpar();
        }

        if (s.equalsIgnoreCase("Incluir")) {

            setSql("INSERT INTO contato (nomecon, emailcon, observacaocon)"
                    + " VALUES ('" + getNomecon()
                    + "', '" + getEmailcon()
                    + "', '" + getObservacaocon() + "')");
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

            setSql("DELETE from contato WHERE codigocon = " + Integer.toString(getCodigocon()));

            try {
                meustate.executeUpdate(getSql());
                setMensagem("Operação efetuada com sucesso!");
            } catch (SQLException ex) {
                setMensagem("Operação cancelada! " + getSql() + ex);
            }
        }

        if (s.equalsIgnoreCase("Atualizar")) {

            setSql("UPDATE contato SET " + "nomecon = '" + getNomecon() + "',"
                    + "emailcon = '" + getEmailcon() + "',"
                    + "observacaocon = '" + getObservacaocon() + "' "
                    + "WHERE codigocon = " + Integer.toString(getCodigocon()));

            try {
                meustate.executeUpdate(getSql());
                limpar();
                setMensagem("Operação efetuada com sucesso!");
            } catch (SQLException ex) {
                setMensagem("Operação cancelada! " + ex);
            }
        }

        if (s.equalsIgnoreCase("Localizar")) {

            setSql("SELECT * FROM contato WHERE codigocon = '" + getCodigocon() + "'");

            try {
                rs = meustate.executeQuery(getSql());
                rs.next();
                setCodigocon(rs.getInt("codigocon"));
                setNomecon(rs.getString("nomecon"));
                setEmailcon(rs.getString("emailcon"));
                setObservacaocon(rs.getString("observacaocon"));
                setMensagem("Operação entrada com sucesso!");
            } catch (SQLException erro) {
                setMensagem("Operação cancelada! " + erro);
            }
        }
    }

    public void limpar() {
        setCodigocon(0);
        setNomecon("");
        setEmailcon("");
        setObservacaocon("");
    }

    public List<DtoContato> listarContato() {
        DtoContato dtoContato;
        List<DtoContato> lista = new ArrayList<DtoContato>();
        try {
            rs = meustate.executeQuery("SELECT * FROM contato");
            while (rs.next()) {
                dtoContato = new DtoContato();
                dtoContato.setCodigocon(rs.getInt("codigocon"));
                dtoContato.setNomecon(rs.getString("nomecon"));
                dtoContato.setEmailcon(rs.getString("emailcon"));
                dtoContato.setObservacaocon(rs.getString("observacaocon"));
                lista.add(dtoContato);
            }
        } catch (Exception e) {
            setMensagem(e.getMessage());
        }
        return lista;
    }

    public void localizarContato(String s) {
        if (s != null) {
            setSql("SELECT * FROM contato WHERE codigocon = '" + s + "'");
            try {
                rs = meustate.executeQuery(getSql());
                rs.next();
                setCodigocon(rs.getInt("codigocon"));
                setNomecon(rs.getString("nomecon"));
                setEmailcon(rs.getString("emailcon"));
                setObservacaocon(rs.getString("observacaocon"));
                setMensagem("Operação entrada com sucesso!");
            } catch (SQLException erro) {
                setMensagem("Operação cancelada! " + erro);
            }
        }
    }

}
