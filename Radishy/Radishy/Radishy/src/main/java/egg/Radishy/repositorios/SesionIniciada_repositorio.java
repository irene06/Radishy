/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.Radishy.Repositorios;

import egg.Radishy.entidades.SesionIniciada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author usuario
 */
@Repository
public interface SesionIniciada_repositorio extends JpaRepository<SesionIniciada, String>{
    
}