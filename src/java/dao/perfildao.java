/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import be.perfilbe;
import be.usuariobe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jamil
 */
public class perfildao {
    public int validarAdministrativo(usuariobe usu){
        int r=0;
         String sql="select p.idperfil, p.nomperfil, u.nomusuario,u.claveusuario from perfil as p inner join usuario as u on u.idusuario=p.idperfil where nomperfil='ADMINISTRATIVO' and u.nomusuario='"+usu.getNomusuario()+"' and u.claveusuario='"+usu.getClaveusuario()+"'";
        Connection c = new base().getMysql();
      
        try {
            
           PreparedStatement pst = c.prepareCall(sql);
           
            ResultSet rs = pst.executeQuery();
            if (rs!=null && rs.next()){
                
                r = 1;
            }
                
            Logger.getLogger(usuariodao.class.getName()).log(Level.SEVERE, r+"");
               
            
            rs.close();
            pst.close();
            c.close();
            rs=null;
            pst=null;
            c=null;
        } catch (SQLException ex) {
            Logger.getLogger(usuariodao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
     public int validarFuncionario(usuariobe usu){
        int r=0;
        String sql="select p.idperfil, p.nomperfil, u.nomusuario,u.claveusuario from perfil as p inner join usuario as u on u.idusuario=p.idperfil where nomperfil='FUNCIONARIO' and u.nomusuario='"+usu.getNomusuario()+"' and u.claveusuario='"+usu.getClaveusuario()+"'";
        Connection c = new base().getMysql();
      
        try {
            
           PreparedStatement pst = c.prepareCall(sql);
            ResultSet rs = pst.executeQuery();
            if (rs!=null && rs.next()){
                
                r = -1;
            }
                
            Logger.getLogger(usuariodao.class.getName()).log(Level.SEVERE, r+"");
               
            
            rs.close();
            pst.close();
            c.close();
            rs=null;
            pst=null;
            c=null;
        } catch (SQLException ex) {
            Logger.getLogger(usuariodao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
}
