/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import be.detalle_incidenciasbe;
import be.distritobe;
import be.funcionariobe;
import be.personabe;
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
 * @author gustavo-pc
 */
public class personadao {

    public int registrar(personabe e){
        int r=0;
            String sql= "insert into persona(idpersona, nombre, domicilio, telefono, celular, email, iddepartamento, idprovincia, iddistrito, idtipodocumento,descripcion,archivo,dni,fecha,funcionario) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            Connection c=null;
       try {
                 
            c=new base().getMysql();
            int id=nuevoId(c);
            PreparedStatement pst=c.prepareCall(sql);
            pst.setInt(1, id);
            pst.setString(2, e.getNombre());
            pst.setString(3, e.getDomicilio());
            pst.setString(4, e.getTelefono());
            pst.setString(5, e.getCelular());
            pst.setString(6, e.getEmail());
            pst.setString(7, e.getIddepartamento());
            pst.setString(8, e.getIdprovincia());
            pst.setString(9, e.getIddistrito());
            pst.setInt(10, Integer.parseInt(e.getIdtipodocumento()));
            pst.setString(11, e.getDescripcion());
            pst.setString(12, e.getArchivo());
            pst.setString(13, e.getDni());
            pst.setString(14, e.getFecha());
            pst.setString(15,e.getFuncionario());
            
            r=pst.executeUpdate();
            pst.close();
            pst=null;
            c.close();
            c=null;
        } catch (SQLException ex) {
            Logger.getLogger(personadao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    public int registrarcliente(){
        int r=0;
            String sql= "insert into cliente(idcliente,idpersona) values(?,?)";
            Connection c=null;
       try {
                 
            c=new base().getMysql();
            int id=nuevoIdcliente(c);
            int idpersona=nuevoId(c)-1;
            PreparedStatement pst=c.prepareCall(sql);
            pst.setInt(1, id);
            pst.setInt(2, idpersona);
            
            
            r=pst.executeUpdate();
            pst.close();
            pst=null;
            c.close();
            c=null;
        } catch (SQLException ex) {
            Logger.getLogger(personadao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return r;
    }
    
    public int registrarincidencia(personabe p){
        int d=0;
            String sql= "INSERT INTO incidencias(idincidencias,idfuncionario, idcliente, idcategoria,idestado,area_idarea) VALUES(?,?,?,?,?,?);";
            Connection c=null;
           
                        
       try {
                 
            c=new base().getMysql();
            int idinci=nuevoIdincidencias(c);
            
            int idcliente=nuevoIdcliente(c)-1;
            int idcate=1;
            int idesta=1;
            int idarea=0;
            PreparedStatement pst=c.prepareCall(sql);
            pst.setInt(1, idinci);
            pst.setInt(2, Integer.parseInt(p.getFuncionario()));
            pst.setInt(3, idcliente);
            pst.setInt(4, idcate);
            pst.setInt(5, idesta);
            pst.setInt(6, idarea);
                        
            d=pst.executeUpdate();
            pst.close();
            pst=null;
            c.close();
            c=null;
        } catch (SQLException ex) {
            Logger.getLogger(personadao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
    public int registrardetincidencia( int funcionario){
        int di=0;
            String sql= "insert into detalle_incidencia(iddetalle_incidencia, incidencias_idincidencias, areaorigen, areadestino,fecha, detalle,idfuncionario) values(?,?,?,?, timestamp(now()),? ,?);";
            Connection c=null;
     try {
                 
            c=new base().getMysql();
            int iddet_inci=nuevoIddet_incidencias(c);
            int idinci=nuevoIdincidencias(c)-1;
            
            int idcliente=nuevoIdcliente(c)-1;
            String areain="0";
            String areafi=null;
            String deta=" ";
            
            PreparedStatement pst=c.prepareCall(sql);
            pst.setInt(1, iddet_inci);
            pst.setInt(2, idinci);
            pst.setString(3, areain);
            pst.setString(4, areafi );
            pst.setString(5,deta);
            pst.setInt(6, funcionario );
                        
            di=pst.executeUpdate();
            pst.close();
            pst=null;
            c.close();
            c=null;
        } catch (SQLException ex) {
            Logger.getLogger(personadao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return di;
    }
    
    public List<personabe> getpersona(personabe e){
        List<personabe> lista= new ArrayList();
         String sql= "select * from persona p, funcionario f where p.idpersona=? and f.idfuncionario=p.funcionario";
         Connection c=null;
         c=new base().getMysql();
         
        try {
            PreparedStatement pst= c.prepareCall(sql);
             pst.setInt(1, e.getIdpersona());
           
             
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
               e.setFuncionario(rs.getString("idfuncionario"));
               lista.add(e);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(personadao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return lista;
        
    }
    public List<personabe> getpersonasegunf(String fun){
        List<personabe> l= new ArrayList();
         String sql= "select * from persona where funcionario=? ";
    
         Connection c=null;
         c=new base().getMysql();
         
        try {
            PreparedStatement pst= c.prepareCall(sql);
             pst.setString(1, fun);
           
             
            ResultSet rs=pst.executeQuery();
            while(rs.next()){
                personabe e=new personabe();
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
               l.add(e);
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(personadao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return l;
        
    }
    
    
    private int nuevoIdincidencias(Connection c){
        int r=0;
        String sql="select IFNULL(max(idincidencias),0)+1 codigoi from incidencias";
        
        try {
            PreparedStatement pst= c.prepareCall(sql);
            
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                r=rs.getInt("codigoi");
            }
            rs.close();
            rs=null;
            
            pst.close();
            pst=null;
            
            //c.close();
            //c=null;
        } catch (SQLException ex) {
            Logger.getLogger(personadao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return r;
    }
    private int nuevoIddet_incidencias(Connection c){
        int x=0;
        String sql="select IFNULL(max(iddetalle_incidencia),0)+1 codigodi from detalle_incidencia";
        
        try {
            PreparedStatement pst= c.prepareCall(sql);
            
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                x=rs.getInt("codigodi");
            }
            rs.close();
            rs=null;
            
            pst.close();
            pst=null;
            
            //c.close();
            //c=null;
        } catch (SQLException ex) {
            Logger.getLogger(personadao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return x;
    }
    private int nuevoId(Connection c){
        int r=0;
        String sql="select IFNULL(max(idpersona),0)+1 codigo from persona";
        
        try {
            PreparedStatement pst= c.prepareCall(sql);
            
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                r=rs.getInt("codigo");
            }
            rs.close();
            rs=null;
            
            pst.close();
            pst=null;
            
            //c.close();
            //c=null;
        } catch (SQLException ex) {
            Logger.getLogger(personadao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return r;
    }
    private int nuevoIdcliente(Connection c){
        int r=0;
        String sql="select IFNULL(max(idcliente),0)+1 codigoc from cliente";
        
        try {
            PreparedStatement pst= c.prepareCall(sql);
            
            ResultSet rs=pst.executeQuery();
            if(rs.next()){
                r=rs.getInt("codigoc");
            }
            rs.close();
            rs=null;
            
            pst.close();
            pst=null;
            
            //c.close();
            //c=null;
        } catch (SQLException ex) {
            Logger.getLogger(personadao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return r;
    }
}
