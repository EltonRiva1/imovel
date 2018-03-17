/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.professordelphi.imovel.dao;

import com.professordelphi.imovel.dto.DtoImovel;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author notle
 */
public class DAOImovel extends DtoImovel {

    public DAOImovel() {

    }

    public void persistencia(String s) {

        if (s.equalsIgnoreCase("Limpar")) {
            limpar();
        }

        if (s.equalsIgnoreCase("Incluir")) {

            setSql("INSERT INTO imovel (codigobai, enderecoimo, cepimo, fotoimo)"
                    + " VALUES ('" + getCodigobai()
                    + "', '" + getEnderecoimo()
                    + "', '" + getCepimo()
                    + "', '" + getFotoimo() + "')");
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

            setSql("DELETE from imovel WHERE codigoimo = " + Integer.toString(getCodigoimo()));

            try {
                meustate.executeUpdate(getSql());
                setMensagem("Operação efetuada com sucesso!");
            } catch (SQLException ex) {
                setMensagem("Operação cancelada! " + getSql() + ex);
            }
        }

        if (s.equalsIgnoreCase("Atualizar")) {

            setSql("UPDATE imovel SET " + "codigobai = '" + getCodigobai()
                    + "', " + "enderecoimo = '" + getEnderecoimo() + "', "
                    + "cepimo = '" + getCepimo() + "', "
                    + "fotoimo = '" + getFotoimo() + "' WHERE codigoimo = " + Integer.toString(getCodigoimo()));

            try {
                meustate.executeUpdate(getSql());
                limpar();
                setMensagem("Operação efetuada com sucesso!");
            } catch (SQLException ex) {
                setMensagem("Operação cancelada! " + ex);
            }
        }

        if (s.equalsIgnoreCase("Localizar")) {

            setSql("SELECT * FROM imovel WHERE codigoimo = '" + getCodigoimo() + "'");

            try {
                rs = meustate.executeQuery(getSql());
                rs.next();
                setCodigoimo(rs.getInt("codigoimo"));
                setCodigobai(rs.getInt("codigobai"));
                setEnderecoimo(rs.getString("enderecoimo"));
                setCepimo(rs.getString("cepimo"));
                setFotoimo(rs.getString("fotoimo"));
                setMensagem("Operação entrada com sucesso!");
            } catch (SQLException erro) {
                setMensagem("Operação cancelada! " + erro);
            }
        }
    }

    public void limpar() {
        setCodigoimo(0);
        setCodigobai(0);
        setEnderecoimo("");
        setCepimo("");
        setFotoimo("");
    }

    public List<DtoImovel> listarImovel() {
        DtoImovel dtoImovel;
        List<DtoImovel> lista = new ArrayList<DtoImovel>();
        try {
            rs = meustate.executeQuery("SELECT * FROM imovel");
            while (rs.next()) {
                dtoImovel = new DtoImovel();
                dtoImovel.setCodigoimo(rs.getInt("codigoimo"));
                dtoImovel.setCodigobai(rs.getInt("codigobai"));
                dtoImovel.setEnderecoimo(rs.getString("enderecoimo"));
                dtoImovel.setCepimo(rs.getString("cepimo"));
                dtoImovel.setFotoimo(rs.getString("fotoimo"));
                lista.add(dtoImovel);
            }
        } catch (Exception e) {
            setMensagem(e.getMessage());
        }
        return lista;
    }

    public void localizarImovel(String s) {
        if (s != null) {
            setSql("SELECT * FROM imovel WHERE codigoimo = '" + s + "'");
            try {
                rs = meustate.executeQuery(getSql());
                rs.next();
                setCodigoimo(rs.getInt("codigoimo"));
                setCodigobai(rs.getInt("codigobai"));
                setEnderecoimo(rs.getString("enderecoimo"));
                setCepimo(rs.getString("cepimo"));
                setFotoimo(rs.getString("fotoimo"));
                setMensagem("Operação entrada com sucesso!");
            } catch (SQLException erro) {
                setMensagem("Operação cancelada! " + erro);
            }
        }
    }

}
