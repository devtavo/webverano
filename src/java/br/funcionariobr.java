/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br;

import be.funcionariobe;
import dao.funcionariodao;
import java.util.List;

/**
 *
 * @author Jamil
 */
public class funcionariobr {

    public funcionariobr() {
    }
  
    
    public int Registrando(funcionariobe fu){
        return new funcionariodao().registrando(fu);
    }
    
    public int Modificar(funcionariobe fu){
        return new funcionariodao().modificar(fu);
    }
    
    public int Eliminar(funcionariobe fu){
        return new funcionariodao().eliminar(fu);
    }
    
    public List<funcionariobe> listarFuncionario(){
        return new funcionariodao().listarfuncionario();
    }
     
}
