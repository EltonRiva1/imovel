/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.professordelphi.imovel.dao;

import com.professordelphi.imovel.dto.DtoCliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author notle
 */
public class DAOCliente extends DtoCliente {

    public DAOCliente() {

    }

    public void persistencia(String s) {

        if (s.equalsIgnoreCase("Limpar")) {
            limpar();
        }

        if (s.equalsIgnoreCase("Incluir")) {

            setSql("INSERT INTO cliente (nomecli, celularcli, whatsappcli, emailcli, senhacli)"
                    + " VALUES ('" + getNomecli()
                    + "', '" + getCelularcli()
                    + "', '" + getWhatsappcli()
                    + "', '" + getEmailcli()
                    + "', '" + getSenhacli() + "')");
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

            setSql("DELETE from cliente WHERE codigocli = " + Integer.toString(getCodigocli()));

            try {
                meustate.executeUpdate(getSql());
                setMensagem("Operação efetuada com sucesso!");
            } catch (SQLException ex) {
                setMensagem("Operação cancelada! " + getSql() + ex);
            }
        }

        if (s.equalsIgnoreCase("Atualizar")) {

            setSql("UPDATE cliente SET " + "nomecli = '" + getNomecli()
                    + "', " + "celularcli = '" + getCelularcli() + "', "
                    + "whatsappcli = '" + getWhatsappcli() + "', "
                    + "emailcli = '" + getEmailcli() + "', "
                    + "senhacli = '" + getSenhacli() + "' WHERE codigocli = " + Integer.toString(getCodigocli()));

            try {
                meustate.executeUpdate(getSql());
                limpar();
                setMensagem("Operação efetuada com sucesso!");
            } catch (SQLException ex) {
                setMensagem("Operação cancelada! " + ex);
            }
        }

        if (s.equalsIgnoreCase("Localizar")) {

            setSql("SELECT * FROM cliente WHERE codigocli = '" + getCodigocli() + "'");

            try {
                rs = meustate.executeQuery(getSql());
                rs.next();
                setCodigocli(rs.getInt("codigocli"));
                setNomecli(rs.getString("nomecli"));
                setCelularcli(rs.getString("celularcli"));
                setWhatsappcli(rs.getInt("whatsappcli"));
                setEmailcli(rs.getString("emailcli"));
                setSenhacli(rs.getString("senhacli"));
                setMensagem("Operação entrada com sucesso!");
            } catch (SQLException erro) {
                setMensagem("Operação cancelada! " + erro);
            }
        }
    }

    public void limpar() {
        setCodigocli(0);
        setNomecli("");
        setCelularcli("");
        setWhatsappcli(0);
        setEmailcli("");
        setSenhacli("");
    }

    public List<DtoCliente> listarCliente() {
        DtoCliente dtoCliente;
        List<DtoCliente> lista = new ArrayList<DtoCliente>();
        try {
            rs = meustate.executeQuery("SELECT * FROM cliente");
            while (rs.next()) {
                dtoCliente = new DtoCliente();
                dtoCliente.setCodigocli(rs.getInt("codigocli"));
                dtoCliente.setNomecli(rs.getString("nomecli"));
                dtoCliente.setCelularcli(rs.getString("celularcli"));
                dtoCliente.setWhatsappcli(rs.getInt("whatsappcli"));
                dtoCliente.setEmailcli(rs.getString("emailcli"));
                dtoCliente.setSenhacli(rs.getString("senhacli"));
                lista.add(dtoCliente);
            }
        } catch (Exception e) {
            setMensagem(e.getMessage());
        }
        return lista;
    }

    public void localizarCliente(String s) {
        if (s != null) {
            setSql("SELECT * FROM cliente WHERE codigocli = '" + s + "'");
            try {
                rs = meustate.executeQuery(getSql());
                rs.next();
                setCodigocli(rs.getInt("codigocli"));
                setNomecli(rs.getString("nomecli"));
                setCelularcli(rs.getString("celularcli"));
                setWhatsappcli(rs.getInt("whatsappcli"));
                setEmailcli(rs.getString("emailcli"));
                setSenhacli(rs.getString("senhacli"));
                setMensagem("Operação entrada com sucesso!");
            } catch (SQLException erro) {
                setMensagem("Operação cancelada! " + erro);
            }
        }
    }

}
