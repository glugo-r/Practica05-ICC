package modulos;

public abstract class Usuario {
    protected String nombre;
    protected String correo;
    protected String tipoUsuario;

    public Usuario() {}

    public Usuario(String nombre, String correo, String tipoUsuario) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (nombre.length() < 3) {
            throw new IllegalArgumentException("El nombre debe tener al menos 3 caracteres.");
        }

        if (correo == null || !correo.contains("@") || !correo.endsWith(".com")) {
            throw new IllegalArgumentException("El formato del correo es inválido.");
        }

        this.nombre = nombre;
        this.correo = correo;
        this.tipoUsuario = tipoUsuario;
    }

    public abstract void mostrarMenu();

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Correo: " + correo + ", Rol: " + tipoUsuario;
    }
}

