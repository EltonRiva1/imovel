/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.professordelphi.imovel.dao;

import com.professordelphi.imovel.dto.DtoCorretor;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author notle
 */
public class DAOCorretor extends DtoCorretor {
    
    public DAOCorretor() {
        
    }
    
    public void persistencia(String s) {
        
        if (s.equalsIgnoreCase("Limpar")) {
            limpar();
        }
        
        if (s.equalsIgnoreCase("Incluir")) {
            
            setSql("INSERT INTO corretor (nomecor, celularcor, whatsappcor, emailcor, senhacor, crecicor)"
                    + " VALUES ('" + getNomecor()
                    + "', '" + getCelularcor()
                    + "', '" + getWhatsappcor()
                    + "', '" + getEmailcor()
                    + "', '" + getSenhacor()
                    + "', '" + getCrecicor() + "')");
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
            
            setSql("DELETE from corretor WHERE codigocor = " + Integer.toString(getCodigocor()));
            
            try {
                meustate.executeUpdate(getSql());
                setMensagem("Operação efetuada com sucesso!");
            } catch (SQLException ex) {
                setMensagem("Operação cancelada! " + getSql() + ex);
            }
        }
        
        if (s.equalsIgnoreCase("Atualizar")) {
            
            setSql("UPDATE corretor SET " + "nomecor = '" + getNomecor()
                    + "', " + "celularcor = '" + getCelularcor() + "', "
                    + "whatsappcor = '" + getWhatsappcor() + "', "
                    + "emailcor = '" + getEmailcor() + "', "
                    + "senhacor = '" + getSenhacor() + "', "
                    + "crecicor = '" + getCrecicor() + "' WHERE codigocor = " + Integer.toString(getCodigocor()));
            
            try {
                meustate.executeUpdate(getSql());
                limpar();
                setMensagem("Operação efetuada com sucesso!");
            } catch (SQLException ex) {
                setMensagem("Operação cancelada! " + ex);
            }
        }
        
        if (s.equalsIgnoreCase("Localizar")) {
            
            setSql("SELECT * FROM corretor WHERE codigocor = '" + getCodigocor() + "'");
            
            try {
                rs = meustate.executeQuery(getSql());
                rs.next();
                setCodigocor(rs.getInt("codigocor"));
                setNomecor(rs.getString("nomecor"));
                setCelularcor(rs.getString("celularcor"));
                setWhatsappcor(rs.getInt("whatsappcor"));
                setEmailcor(rs.getString("emailcor"));
                setSenhacor(rs.getString("senhacor"));
                setCrecicor(rs.getString("crecicor"));
                setMensagem("Operação entrada com sucesso!");
            } catch (SQLException erro) {
                setMensagem("Operação cancelada! " + erro);
            }
        }
    }
    
    public void limpar() {
        setCodigocor(0);
        setNomecor("");
        setCelularcor("");
        setWhatsappcor(0);
        setEmailcor("");
        setSenhacor("");
        setCrecicor("");
    }
    
    public List<DtoCorretor> listarCorretor() {
        DtoCorretor dtoCorretor;
        List<DtoCorretor> lista = new ArrayList<DtoCorretor>();
        try {
            rs = meustate.executeQuery("SELECT * FROM corretor");
            while (rs.next()) {
                dtoCorretor = new DtoCorretor();
                dtoCorretor.setCodigocor(rs.getInt("codigocor"));
                dtoCorretor.setNomecor(rs.getString("nomecor"));
                dtoCorretor.setCelularcor(rs.getString("celularcor"));
                dtoCorretor.setWhatsappcor(rs.getInt("whatsappcor"));
                dtoCorretor.setEmailcor(rs.getString("emailcor"));
                dtoCorretor.setSenhacor(rs.getString("senhacor"));
                dtoCorretor.setCrecicor(rs.getString("crecicor"));
                lista.add(dtoCorretor);
            }
        } catch (Exception e) {
            setMensagem(e.getMessage());
        }
        return lista;
    }
    
    public void localizarCorretor(String s) {
        if (s != null) {
            setSql("SELECT * FROM corretor WHERE codigocor = '" + s + "'");
            try {
                rs = meustate.executeQuery(getSql());
                rs.next();
                setCodigocor(rs.getInt("codigocor"));
                setNomecor(rs.getString("nomecor"));
                setCelularcor(rs.getString("celularcor"));
                setWhatsappcor(rs.getInt("whatsappcor"));
                setEmailcor(rs.getString("emailcor"));
                setSenhacor(rs.getString("senhacor"));
                setCrecicor(rs.getString("crecicor"));
                setMensagem("Operação entrada com sucesso!");
            } catch (SQLException erro) {
                setMensagem("Operação cancelada! " + erro);
            }
        }
    }
    
}
