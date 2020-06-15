/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.controlador;

import ec.edu.ups.dao.TelefonoDao;
import ec.edu.ups.dao.UsuarioDao;
import ec.edu.ups.modelo.Telefono;
import ec.edu.ups.modelo.Usuario;
import ec.edu.ups.vista.VentanaPrincipal;
import ec.edu.ups.vista.VentanaRegistro;
import java.util.Map;

/**
 *
 * @author paul_
 */
public class ControladorUsuario {
    
    VentanaPrincipal ventana;
    private Usuario usuario;
    private Telefono telefono;
    
    private UsuarioDao usuarioD;
    private TelefonoDao telefonoD;
    private VentanaRegistro vTele;
    private VentanaPrincipal vPrincipal;

    public ControladorUsuario(UsuarioDao usuarioD, TelefonoDao telefonoD) {
        this.usuarioD = usuarioD;
        this.telefonoD = telefonoD;
    }
    public void registrarUsuario(Usuario u) {
        usuarioD.create(u);

    }
    public Usuario iniciarSesion(String correo, String contrasena) {
        usuario = usuarioD.iniciarSesion(correo, contrasena);

        return usuario;
    }

     public void crearTelefono(Usuario usuario1, Telefono telefono1) {
        telefonoD.create(telefono1);
        usuario1.agregarTelefono(telefono1);
        usuarioD.update(usuario1);
    }
    public void imprimirTelefonos() {
        Map<Integer, Telefono> telefonos;
        telefonos=telefonoD.findAll();

        for (Map.Entry<Integer, Telefono> tele : telefonos.entrySet()) {
            System.out.println("uuu\n" + tele.toString());
        }
    }
}
