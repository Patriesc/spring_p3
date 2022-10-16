package madstodolist.model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

public class Equipo {
    private String nombre;
    private long id;
    // Declaramos el tipo de recuperación como LAZY.
    // No haría falta porque es el tipo por defecto en una
    // relación a muchos.
    // Al recuperar un equipo NO SE RECUPERA AUTOMÁTICAMENTE
    // la lista de usuarios. Sólo se recupera cuando se accede al
    // atributo 'usuarios'; entonces se genera una query en la
    // BD que devuelve todos los usuarios del equipo y rellena el
    // atributo.

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "equipo_usuario",
            joinColumns = {@JoinColumn(name = "fk_equipo")},
            inverseJoinColumns = {@JoinColumn(name = "fk_usuario")})
    Set<Usuario> usuarios = new HashSet<>();


    public void setId(Long id) {
        this.id = id;
    }

    public Set<Usuario> getUsuarios() {
        return usuarios;
    }


    public void addUsuario(Usuario usuario) {
        this.getUsuarios().add(usuario);
        //     usuario.getEquipos().add(this);}
    }
}
