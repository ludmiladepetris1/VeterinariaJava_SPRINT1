import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente {
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private final ArrayList<Mascota> mascotas;

    public Cliente(String nombre, String apellido, String telefono, String direccion) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        mascotas = new ArrayList<>();
    }

    /////////////////////////////////////////////////////////////////////

    // METODO 1: agrega una mascota a la lista de mascotas del cliente
    // (el cliente pasa a ser el dueno de esa mascota).
    public void registrarNuevoDueno(Mascota mascota) {
        // Comprueba que se recibio una mascota y que todavia no esta en la lista.
        if (mascota != null && !mascotas.contains(mascota)) {
            // Agrega la mascota a la lista del cliente.
            mascotas.add(mascota);
            // Asocia la mascota con este cliente (this: este objeto Cliente).
            mascota.setCliente(this);
        }
    }

    /////////////////////////////////////////////////////////////////////

    // METODO 2: pide al sistema que cancele un turno de este cliente.
    public void cancelarTurno(SistemaTurnos sistema, Turno turno) {
        // Comprueba que el turno exista y que sea de este cliente.
        if (turno != null && turno.getCliente() == this) {
            sistema.cancelarTurno(turno);
        }
    }

    /////////////////////////////////////////////////////////////////////

    // METODO 3: pide al sistema que cambie la fecha y hora de un turno de este cliente.
    // Devuelve true si el cambio se pudo hacer.
    public boolean cambiarHorarioTurno(SistemaTurnos sistema, Turno turno,
                                       LocalDate nuevaFecha, String nuevaHora) {
        // Comprueba que el turno exista y que sea de este cliente.
        if (turno != null && turno.getCliente() == this) {
            return sistema.modificarTurno(turno, nuevaFecha, nuevaHora);
        }
        return false;
    }

    /////////////////////////////////////////////////////////////////////

    // METODO 4: devuelve la lista de turnos que pertenecen a este cliente.
    public ArrayList<Turno> consultarTurnos(ArrayList<Turno> turnos) {
        ArrayList<Turno> resultado = new ArrayList<>();
        // Recorre todos los turnos recibidos.
        for (int i = 0; i < turnos.size(); i++) {
            // Si el turno pertenece a este cliente, lo agrega al resultado.
            if (turnos.get(i).getCliente() == this) {
                resultado.add(turnos.get(i));
            }
        }
        return resultado;
    }

    /////////////////////////////////////////////////////////////////////

    public String getNombre() { return nombre; }

    public String getApellido() { return apellido; }

    public String getTelefono() { return telefono; }

    public String getDireccion() { return direccion; }

    public ArrayList<Mascota> getMascotas() { return mascotas; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setApellido(String apellido) { this.apellido = apellido; }

    public void setTelefono(String telefono) { this.telefono = telefono; }

    public void setDireccion(String direccion) { this.direccion = direccion; }
}