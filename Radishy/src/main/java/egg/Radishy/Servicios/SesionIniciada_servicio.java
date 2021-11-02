/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package egg.Radishy.Servicios;

import egg.Radishy.Errores.Errores_servicio;
import egg.Radishy.Repositorios.Cultivo_repositorio;
import egg.Radishy.Repositorios.SesionIniciada_repositorio;
import egg.Radishy.Repositorios.Usuario_repositorio;
import egg.Radishy.entidades.Cultivo;
import egg.Radishy.entidades.SesionIniciada;
import egg.Radishy.entidades.Usuario;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author usuario
 */
@Service
public class SesionIniciada_servicio {
    
    @Autowired
    private SesionIniciada_repositorio repositorioSesIn;
    @Autowired
    private Usuario_repositorio usuarioRepositorio;
    
    @Autowired
    private Cultivo_repositorio cultivoRepositorio;
    
// agregarCultivo(): agrega un cultivo a los que ya posee el usuario (recibe el id del usuario)
    public void agregarMiCultivo (String idUsuario, String idCultivo) throws Errores_servicio{
        
        Optional<Usuario> rtaus = usuarioRepositorio.findById(idUsuario);
        if (rtaus.isPresent()){
            Usuario usuario = rtaus.get();
            Optional<Cultivo> rtacul = cultivoRepositorio.findById(idCultivo);
            if (rtacul.isPresent()) {
                Cultivo cultivo = rtacul.get();
                //'query de repositorioSesIn que busca la sesionIniciada según el usuario'
                SesionIniciada sesion = repositorioSesIn.findByUsuario(usuario);
                List<Cultivo> cultivos = sesion.getCultivos();
                cultivos.add(cultivo);
                repositorioSesIn.save(sesion);
            } else {
                throw new Errores_servicio("El cultivo que intenta agregar a sus cultivos, no se encuentra guardado en nuestra base de datos.\nSi quiere, puede ir a agregarla a la misma para luego incorporarlo a sus cultivos");
           }
        } else {
            throw new Errores_servicio("No se encontró al usuario.");
        }   
    }
    
    // agregarAMisCultivos(): agrega un cultivo a los que ya posee el usuario (busca al usuario en sesion iniciada)
    public void agregarAMisCultivos (String idCultivo) throws Errores_servicio{
        //if('query que cuenta la cantidad de usuarios con enSesion true' == 1){
        //  'query que busca el usuario con enSesion true'  ---> findByEnSesion
        //  Usuario usuario = usuarioRepositorio.findByEnSesion();
        //  Optional<Cultivo> rta = cultivoRepositorio.findById(idCultivo);
        //  if (rta.isPresent()) {
        //      'query que busca en repositorioSesIn la sesion iniciada segun el usuario' ---> findByUsuario
        //      SesionIniciada sesion = repositorioSesIn.findByUsuario(usuario);
        //      sesion.getCultivos.add(rta.get());
        //      repositorioSesIn.save(sesion);
        //  } else {
        //      throw new Errores_servicio("No se encuentra registrado el cultivo seleccionado");
        //  }
        //} else {
        //  throw new Errores_servicio("No puede agregar a sus cultivos debido a que no ha iniciado sesión.\nInicie su sesión o regístrese para poder hacerlo");
        //}
    }
    
// misCultivos(): devuelve una lista con todos los cultivos que el usuario posee (busca con el id de la sesionIniciada)
    public List<Cultivo> misCultivos (String idSesionIniciada) {
        SesionIniciada sesion = repositorioSesIn.findById(idSesionIniciada).get();
        return sesion.getCultivos();
    }
    
    public List<Cultivo> misCultivos2 () throws Errores_servicio{
        //if ('query que cuenta la cantidad de usuarios enSesion true' == 1){
            Usuario usuario; // = usuarioRepositorio.findByEnSesion();
            SesionIniciada sesion; // = repositorioSesIn.findByUsuario(usuario);
        //    return sesion.getCultivos();
        //} else {
        //    throw new Errores_servicio("No ha iniciado sesión aún");
        //}
        return null;
    }

// misCultivosDistintos    
    public List<Cultivo> misCultivosDistinto () throws Errores_servicio{
        //if ('query que cuente la cantidad de usuarios con enSesion = true' == 1) {
        //  'query que busca al usuario segun enSesion = true' ---> findByEnSesion()
        //  Usuario usuario = usuarioRepositorio.findByEnSesion();
        //  'query que busca la sesionIniciada según el usuario (entidad)' ---> findByUsuario(usuario)
        //  SesionIniciada sesion = repositorioSesIn.findByUsuario(usuario);
        //} else {
        //  throw new Errores_servicios("No hay un usuario con la sesión iniciada.\nAntes de poder ver sus cultivos, deberá iniciar sesión.");
        //}
        //return sesion.getCultivos();
        return null;
    }
    
    // eliminarMiCultivo(): recibe el id del cultivo que quiere sacar de su listado de cultivos (busca usuario por enSesion)
    public void eliminarMiCultivo (String idCultivo) throws Errores_servicio{
        //if('query que cuenta la cantidad de usuarios con enSesion true' == 1){
        //  'query que busca al usuario segun enSesion true' ---> findByEnSesion
        //  Usuario usuario = usuarioRepositorio.findByEnSesion;
        //  'query que busca la sesionIniciada en su repositorio s/el usuario' ---> findByUsuario
        //  SesionIniciada sesion = repositorioSesIn.findByUsuario(usuario);
        //  Iterator<Cultivo> itcultivos = sesion.getCultivos().iterator();
        //  while(itcultivos.hasNext()){
        //      if (uncultivo.next.getId().equals(idCultivo)){
        //          uncultivo.remove
        //          breack;
        //      }
        //  }
        //} else {
        //  throw new Errores_servicio("No hay ningún usuario ingresado, por ende no podrá eliminar ningún cultivo");
        //}
    }
    
    public void eliminarUnCultivo (String idCultivo, String idUsuario) throws Errores_servicio{
        Optional<Usuario> rta = usuarioRepositorio.findById(idUsuario);
        if (rta.isPresent()){
            Usuario usuario = rta.get();
            //'query que busca en repositorioSesIn la sesion iniciada segun el usuario' ---> findByUsuario
            SesionIniciada sesion = repositorioSesIn.findByUsuario(usuario);
            Iterator<Cultivo> cultivos = sesion.getCultivos().iterator();
            while (cultivos.hasNext()){
                if (cultivos.next().)
            }
        } else {
            throw new Errores_servicio("No se encontró al usuario solicitado");
        }
    }
    
    // vaciarMisCultivos(): recibe el id del usuario en cuestión y vacía su lista de cultivos seleccionados
    public void vaciarMisCultivos (String idUsuario) throws Errores_servicio{
        Optional<Usuario> rta = usuarioRepositorio.findById(idUsuario);
        if(rta.isPresent()){
            Usuario usuario = rta.get();
            //'query que busca la sesionIniciada según el usuario' ---> findByUsuario
            SesionIniciada sesion = repositorioSesIn.findByUsuario(usuario);
            sesion.getCultivos().clear();
            repositorioSesIn.save(sesion);
        } else {
            throw new Errores_servicio("No se encontró al usuario solicitado");
        }
    }
    
    // vaciarMisCultivos2(): al usuario con la sesión iniciada se le quitan todos sus cultivos seleccionados
    public void vaciarMisCultivos2 () throws Errores_servicio{
        //if('query que cuenta la cantidad de usuarios enSesion true' == 1){
        //  'query que busca al usuario según enSesion' ---> findByEnSesion
        //  Usuario usuario = usuarioRepositorio.findByEnSesion(usuario);
        //  'query que busca en repositorioSesIn la sesion iniciada segun el usuario' ---> findByUsuario
        //  SesionIniciada sesion = repositorioSesIn.findByUsuario(usuario);
        //  sesion.getCultivos().clear();
        //  repositorioSesIn.save(sesion);
        //} else {
        //  throw new Errores_servicio("No ha iniciado sesión todavía");
        //}
    }
    
    // incorporarle un boolean al usuario de 'en sesion' para que sea false siempre, salvo cuando ese usuario está en sesión
    
// iniciarSesion(): recibe el nombre de usuario y la contraseña por parte del 'usuario' y controla que se pueda iniciar la sesión y los datos ingresados sean correctos
    public void iniciarSesion (String usuario, String password) throws Errores_servicio{
        // if ('query que cuente la cantidad de usarios con enSesion true' < 1) {
        //  validarHayaDatosInicioSesio(usuario, password);
        //  'query que busque al usuario en el repositorio con el nombre de usuario' ---> findByNombreUsuario(nombreUsuario)
        //  Usuario datosUsuario = usuarioRepositorio.findByNombreUsuario(usuario);
        //  if (datosUsuario.getPassword() == password) {
        //      datosUsuario.setEnSesio(true);
        //      usuarioRepositorio.save(datosUsuario);
        //  } else {
        //      throw new Errores_servicio("La contraseña ingresada no corresponde al nombre de usuario ingresado");
        // } else {
        //  throw new Errores_servicio("No se puede tener dos sesiones ingresadas a la vez, por favor cierre la sesión en curso antes de iniciar una nueva");
    }
    
    // cerrarSesion(): recibe el id del Usuario activo y le cierra la sesión
    public void cerrarSesion (String idUsuario) {
        Usuario usuario = usuarioRepositorio.findById(idUsuario).get();
        usuario.setEnSesion(false);
    }
    
    // cerrarSesion2(): a la sesion iniciada, la cierra, sin requerimiento de ningún parámetro
    public void cerrarSesion2 () throws Errores_servicio{
        //if('query que busca la cant de usuarios con enSesion true' == 1){
        //  'query que busca al usuario segun enSesion true' ---> findByEnSesion
        //  Usuario usuario = usuarioRepositorio.findByEnSesion();
        //  usuario.setEnSesion(false);
        //  usuarioRepositorio.save(usuario);
        //} else {
        //  throw new Errores_servicio("No había ninguna sesión iniciada que cerrar");
        //}
    }
    
    // validarHayaDatosInicioSesion(): 
    public void validarHayaDatosInicioSesion(String usuario, String password) throws Errores_servicio {
        if (usuario == null) {
            throw new Errores_servicio("No ha ingresado un nombre de usuario");
        }
        if (password == null) {
            throw new Errores_servicio("No ha ingresado una contraseña");
        }
    }
    
    // editarCuenta(): recibe el id de un usuario (se puede modificar haciendo que se busque al usuario 'enSesion' y sea al que se modifica) y los campos que se le permiten editar al usuario, para modificar los datos de aquellos que ingrese algo
    public void editarCuenta (String idUsuario, String usuario, String passwordActual, String passwordNueva, String apodo) throws Errores_servicio{
        Optional<Usuario> rta = usuarioRepositorio.findById(idUsuario);
        if (rta.isPresent()) {
            Usuario datosUsuario = rta.get();
            if (passwordActual == null) {
                throw new Errores_servicio("No puede guardar ningún cambio si no introduce su contraseña actual");
            }
            if (usuario != null) {
             datosUsuario.setNombre(usuario);
            }
            if (passwordNueva != null) {
                datosUsuario.setPassword(passwordNueva);
            }
            if(apodo != null) {
             datosUsuario.setApodo(apodo);
            }
            usuarioRepositorio.save(datosUsuario);
        } 
    }
    
    // query en repositorio del usuario que cuente la cantidad de usuarios con 'enSesion' = true, y devuelva dicha cantidad 
    // query en repositorio del usuario que busque y devuelva al usuario con 'enSesion' = true  ---> findByEnSesion()
    // query en repositorio del usuario que busca al usuario según el nombre del usuario  ---> findByNombreUsuario()
}
