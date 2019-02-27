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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Docente
 */
public class usuariodao {

    public usuariodao() {
    }
    
    public int registrando(usuariobe usu){
        
        int resultado=0;
        String sql="insert into usuario(idusuario, nomusuario, claveusuario) "
                + "values(?,?,md5(?))";
        base data = new base();
        Connection c = data.getMysql();
        usuariobe e=null;
        
        try {
            PreparedStatement pst = c.prepareCall(sql);
            pst.setInt(1, usu.getIdusuario());
            pst.setString(2, usu.getNomusuario());
            pst.setString(3, usu.getClaveusuario());
            resultado=pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(usuariodao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public int actualizar(usuariobe e){
    int resultado=0;
    return resultado;
    }
    
    public List<usuariobe> mostrarusuarios(){
    List<usuariobe> lista = new ArrayList();
    return lista;
    }
    
    
    public int validar(usuariobe usu){
        
        int resultado=0;
        String sql="select nomusuario, claveusuario from usuario where nomusuario='"+usu.getNomusuario()+"' and claveusuario='"+usu.getClaveusuario()+"'";
        Connection c = new base().getMysql();
      
        try {
            
           PreparedStatement pst = c.prepareCall(sql);
           ResultSet rs = pst.executeQuery();
            
            if (rs!=null && rs.next()){
                
                resultado = 1;
                
            }
                
            Logger.getLogger(usuariodao.class.getName()).log(Level.SEVERE, resultado+"");
               
            
            rs.close();
            pst.close();
            c.close();
            rs=null;
            pst=null;
            c=null;
        } catch (SQLException ex) {
            Logger.getLogger(usuariodao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
     public List<perfilbe> listarperfiles(Integer usuario){
        
        String sql="select p.idperfil as codigoperfil, p.nomperfil as nombreperfil, u.idusuario as codigousuario, m.idmodulo as codigomodulo from usuario u, perfil p, modulo m where p.idperfil=u.idusuario and idperfil=m.idmodulo and  u.idusuario = '"+usuario+"'";
        boolean encontro=false;
        
        System.out.println(sql);
        Logger.getLogger(sql);
        
        List<perfilbe> lista = new ArrayList();
        perfilbe e;
        
        try {
            Connection c = new base().getMysql();
            Statement st = c.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                e=new perfilbe();
                
                e.setIdperfil(rs.getInt("codigoperfil"));
                e.setNomperfil(rs.getString("nombreperfil"));
                e.setIdusuario(rs.getInt("codigousuario"));
                e.setIdmodulo(rs.getInt("codigomodulo"));
                
                lista.add(e);
            }
            rs.close();
            st.close();
            c.close();
            rs=null;
            st=null;
            c=null;
        } catch (SQLException ex) {
            Logger.getLogger(usuariodao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public boolean validarAcceso(HttpSession session,String opcion){
        
        boolean retorno = false;
        List<perfilbe> listaperfiles = (List<perfilbe>)session.getAttribute("perfiles");
        
        if (listaperfiles!=null && listaperfiles.size()>0){
            
            for(int i=0;i<listaperfiles.size();i++){ 
                perfilbe a = (perfilbe)listaperfiles.get(i);
                
                if (a.getIdmodulo()!=0){
                    
                    return true;
                    
                }
                
                
            }
            
        }
        
        return retorno;
        
    }
    
    
}
