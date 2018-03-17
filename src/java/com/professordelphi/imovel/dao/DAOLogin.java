/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.professordelphi.imovel.dao;

import com.professordelphi.imovel.dto.DtoFuncionario;
import java.sql.SQLException;

/**
 *
 * @author notle
 */
public class DAOLogin extends DtoFuncionario {

    public DAOLogin() {
        super();
    }

    public int acessar(String email, String senha) {
        int i = 0;
        setSql("select * from funcionario where emailfunc = '" + email + "' and senhafunc = '" + senha + "'");
        try {
            rs = meustate.executeQuery(getSql());
            if (rs.next()) {
                i = 1;
            }
        } catch (SQLException erro) {
            setMensagem("E-mail ou senha inválido(s)! " + erro + " " + getSql());
        }
        setSql("select * from corretor where emailcor = '" + email + "' and senhacor = '" + senha + "'");
        try {
            rs = meustate.executeQuery(getSql());
            if (rs.next()) {
                setCodigocor(rs.getInt("codigocor"));
                i = 2;
                setMensagem(getCodigocor() + "");
            }
        } catch (SQLException erro) {
            setMensagem("E-mail ou senha do corretor incorreto! " + erro + " " + getSql());
        }
        return i;
    }
}
