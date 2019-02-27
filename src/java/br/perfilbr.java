/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br;

import be.usuariobe;
import dao.perfildao;

/**
 *
 * @author Jamil
 */
public class perfilbr {
    
     public int loginAdministrativo(usuariobe usu){
         return new perfildao().validarAdministrativo(usu);
     }
     public int logiFuncionario(usuariobe usu){
         return new perfildao().validarFuncionario(usu)
                 ;
     }
    
}
