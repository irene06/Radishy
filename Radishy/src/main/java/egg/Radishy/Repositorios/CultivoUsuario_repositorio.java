/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.Radishy.Repositorios;

import egg.Radishy.Entidades.CultivoUsuario;
import egg.Radishy.Entidades.Usuario;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author usuario
 */
@Repository
public interface CultivoUsuario_repositorio extends JpaRepository<CultivoUsuario, String>{
        
    @Query("select cu from CultivoUsuario cu where cu.usuario = :usuario")
    public CultivoUsuario findByUsuario(@Param("usuario") Usuario usuario);  // este ya estaba de antes 

    @Query("Select cu from CultivoUsuario cu where cu.usuario.enSesion = true")
    public List<CultivoUsuario> cultivosUsuario();
    
    // no se si se hace así    
   // @Query("Select c.nombre, c.metodo, c.profundidadSiembraCM, s.fechaDeSembrado, s.fechaGerminadoProm, s.fechaTransplanteProm, s.fechaCosechaProm from Cultivo c, SesionIniciada s where s.usuario.enSesion = true")
   // public List<SesionIniciada> cultivosUsuarioVista(); // borre c.riego
    
    // como creo que se hace
    @Query("Select c.nombre from Cultivo c, SesionIniciada s where s.id = :id")
    public String nombreCultivo(@Param("id") String id); 
    
    @Query("Select c.metodo from Cultivo c, SesionIniciada s where s.id = :id")
    public String metodoCultivo (@Param("id") String id);
    
    @Query("Select c.profundidadSiembraCM from Cultivo c, SesionIniciada s where s.id = :id")
    public String profundidadSiembra (@Param("id") String id);
    
    //@Query("Select c.riego from Cultivo c, SesionIniciada s where s.id = :id")
    //public String riegoCultivo (@Param("id") String id);
    
    @Query("Select s.fechaDeSembrado from SesionIniciada s where s.id = :id")
    public Date fechaSembradoCultivo (@Param("id") String id);
    
//    @Query("Select s.fechaGerminadoProm from SesionIniciada s where s.id = :id")
//    public Date fechaGerminadoCultivo (@Param("id") String id);
//    
//    @Query("Select s.fechaTransplanteProm from SesionIniciada s where s.id = :id")
//    public Date fechaTransplanteCultivo (@Param("id") String id);
//    
//    @Query("Select s.fechaCosechaProm from SesionIniciada s where s.id = :id")
//    public Date fechaCosechaCultivo (@Param("id") String id);
}