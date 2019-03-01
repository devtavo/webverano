/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import be.personabe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class consultabreclamodao {
    
    public List<personabe> listasegunFunc(personabe e){
        List<personabe> lista= new ArrayList();
    
        String sql= "select * from persona where funcionario=?;";
//        if(!fun.equals("-1")){
//             sql= "select * from persona where funcionario=?;";
//        }else if(!d1.equals("") && !d2.equals("")){
//             sql= "select * from persona p where p.fecha between ? and ?;";
//        }else if(!estado.equals("-1") ){
//             sql= "select * from persona p, cliente c, incidencias i WHERE p.idpersona=c.idpersona and c.idcliente=i.idcliente and i.idestado=?;";  
//        } 
         Connection c=null;
        try {
            c=new base().getMysql();
            PreparedStatement pst= c.prepareCall(sql);
             pst.setString(1, e.getFuncionario());
             ResultSet rs=pst.executeQuery();
            while(rs.next()){
               e.setIdpersona(rs.getInt("idpersona"));
               e.setFecha(rs.getString("fecha"));
               e.setNombre(rs.getString("nombre"));
               e.setDomicilio(rs.getString("domicilio"));
               e.setTelefono(rs.getString("telefono"));
               e.setCelular(rs.getString("celular"));
               e.setEmail(rs.getString("email"));
               e.setIddepartamento(rs.getString("iddepartamento"));
               e.setIdprovincia(rs.getString("idprovincia"));
               e.setIddistrito(rs.getString("iddistrito"));      
               e.setIdtipodocumento(Integer.toString(rs.getInt("idtipodocumento")));
               e.setDescripcion(rs.getString("descripcion"));
               e.setArchivo(rs.getString("archivo"));
               e.setDni(rs.getString("dni"));
               e.setFuncionario(rs.getString("funcionario"));
               lista.add(e);               
            }
        } catch (SQLException ex) {
            Logger.getLogger(consultabreclamodao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
        
    }
}
