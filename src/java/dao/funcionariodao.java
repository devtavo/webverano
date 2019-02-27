/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import be.funcionariobe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jamil
 */
public class funcionariodao {

    public funcionariodao() {
    }
    public List<funcionariobe> listarfuncionario(){
        List<funcionariobe> lista= new ArrayList();
         String sql= "select * from funcionario ";
         Connection c=null;
         c=new base().getMysql();
        try {
            PreparedStatement pst= c.prepareCall(sql);
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                funcionariobe e=new funcionariobe();
                       e.setIdfuncionario(rs.getInt("idfuncionario"));
                       e.setNomfuncionario(rs.getString("nomfunc"));
                       e.setArea(rs.getString("area"));
                       e.setIdcargo(rs.getInt("idcargo"));
                       
                        
                lista.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(funcionariodao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         
         return lista;
    }
    public int registrando(funcionariobe fu){
        
        int resultado=0;
        String sql="insert into funcionario(idfuncionario, nomfunc, area, idcargo) "
                + "values(?,?,?,?)";
        base data = new base();
        Connection c = data.getMysql();
        funcionariobe e=null;
        
        try {
            PreparedStatement pst = c.prepareCall(sql);
            pst.setInt(1, fu.getIdfuncionario());
            pst.setString(2, fu.getNomfuncionario());
            pst.setString(3, fu.getArea());
            pst.setInt(4, fu.getIdcargo());
            resultado=pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(funcionariodao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public int actualizar(funcionariobe e){
    int resultado=0;
    return resultado;
    }
    
    public int modificar(funcionariobe fu){
         int resultado=0;
        String sql="update funcionario set idfuncionario=?, nomfunc=?,area=?, idcargo = ? where idfuncionario="+fu.getIdfuncionario()+"";
        base data = new base();
        Connection c = data.getMysql();
        funcionariobe e=null;
        
        try {
            PreparedStatement pst = c.prepareCall(sql);
            pst.setInt(1, fu.getIdfuncionario());
            pst.setString(2, fu.getNomfuncionario());
            pst.setString(3, fu.getArea());
            pst.setInt(4, fu.getIdcargo());
            resultado=pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(funcionariodao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
     public int eliminar(funcionariobe fu){
         int resultado=0;
        String sql="delete from funcionario where idfuncionario='"+fu.getIdfuncionario()+"";
        base data = new base();
        Connection c = data.getMysql();
        funcionariobe e=null;
        
        try {
            PreparedStatement pst = c.prepareCall(sql);
            
            resultado=pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(funcionariodao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
}
