import java.util.ArrayList;

public class Veterinario {
    private String nombre;
    private String apellido;
    private String matricula;
    private String especialidad;

    public Veterinario(String nombre, String apellido, String matricula, String especialidad)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.especialidad = especialidad;
    }

    ///////////////////////////////////////////////////////////////////

    // METODO 1: devuelve una lista con los turnos de este veterinario.
    public ArrayList<Turno> consultarTurnos(ArrayList<Turno> turnos) {
        // Crea una lista vacia donde guardara los turnos encontrados.
        ArrayList<Turno> resultado = new ArrayList<>();

        // Recorre todos los turnos de la lista recibida.
        for (int i = 0; i < turnos.size(); i++) {
            // Comprueba si el veterinario asignado al turno es este veterinario.
            if (turnos.get(i).getVeterinario() == this) {
                // Si coincide, agrega el turno a la lista de resultados.
                resultado.add(turnos.get(i));
            }
        }

        // Devuelve la lista de turnos que pertenecen a este veterinario.
        return resultado;
    }

    ///////////////////////////////////////////////////////////////////

    // METODO 2: registra la atencion de un turno y devuelve la atencion creada.
    // Devuelve null si no se puede registrar.
    public AtencionVeterinaria realizarAtencion(
            Turno turno, String motivo, String diagnostico, String tratamiento) {

        // Comprueba que el turno exista, que pertenezca a este veterinario,
        // que su estado sea ATENDIDO y que todavia no tenga una atencion registrada.
        if (turno == null
                || turno.getVeterinario() != this
                || turno.getEstado() != EstadoTurno.ATENDIDO
                || turno.getAtencion() != null) {
            return null; // Si alguna condicion falla, no registra la atencion.
        }

        // Crea una atencion con la fecha del turno, los datos recibidos,
        // la mascota del turno y este veterinario.
        AtencionVeterinaria atencion = new AtencionVeterinaria(
            turno.getFecha(),
            motivo,
            diagnostico,
            tratamiento,
            turno.getMascota(),
            this
        );

        turno.setAtencion(atencion); // Asocia la atencion con el turno.
        turno.getMascota().agregarAtencion(atencion); // La agrega al historial de la mascota.

        return atencion;
    }

    ///////////////////////////////////////////////////////////////////

    public String getNombre() { return nombre; }

    public String getApellido() { return apellido; }

    public String getMatricula() { return matricula; }

    public String getEspecialidad() { return especialidad; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setApellido(String apellido) { this.apellido = apellido; }

    public void setMatricula(String matricula) { this.matricula = matricula; }

    public void setEspecialidad(String especialidad) { this.especialidad = especialidad; }
}