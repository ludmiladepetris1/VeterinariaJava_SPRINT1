import java.time.LocalDate;
import java.util.ArrayList;

public class Mascota {
    private int identificador;
    private String nombre;
    private String especie;
    private String raza;
    private LocalDate fechaNacimiento;
    private Cliente cliente;
    private final ArrayList<AtencionVeterinaria> atenciones;

    public Mascota(int identificador, String nombre, String especie, String raza,
                   LocalDate fechaNacimiento, Cliente cliente) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.especie = especie;
        this.raza = raza;
        this.fechaNacimiento = fechaNacimiento;
        this.cliente = cliente;

        atenciones = new ArrayList<>();

        // Pregunta si recibio un cliente.
        if (cliente != null) {
            // Si recibio un cliente, le pide que registre esta mascota.
            cliente.registrarNuevoDueno(this);
        }
    }

    /////////////////////////////////////////////////////////////////

    // METODO 1: agrega una atencion veterinaria al historial de la mascota.
    public void agregarAtencion(AtencionVeterinaria atencion) {
        // Comprueba que la atencion exista (que se haya realizado).
        if (atencion != null) {
            // Si existe, la agrega a la lista de atenciones.
            atenciones.add(atencion);
        }
    }

    /////////////////////////////////////////////////////////////////

    // METODO 2: devuelve el historial de atenciones de la mascota.
    // Si todavia no tuvo ninguna, devuelve una lista vacia.
    public ArrayList<AtencionVeterinaria> consultarHistorial() {
        return atenciones;
    }

    /////////////////////////////////////////////////////////////////

    // METODO 3: recibe la lista general de turnos y devuelve
    // otra lista con los turnos de esta mascota.
    public ArrayList<Turno> consultarTurnos(ArrayList<Turno> turnos) {
        // Crea una lista vacia para guardar los turnos que coincidan.
        ArrayList<Turno> resultado = new ArrayList<>();

        for (int i = 0; i < turnos.size(); i++) {
            // Si el turno corresponde a esta mascota (this), lo agrega a resultado.
            if (turnos.get(i).getMascota() == this) {
                resultado.add(turnos.get(i));
            }
        }
        // Devuelve la lista con los turnos encontrados.
        return resultado;
    }

    //////////////////////////////////////////////////////////////////

    public int getIdentificador() { return identificador; }

    public String getNombre() { return nombre; }

    public String getEspecie() { return especie; }

    public String getRaza() { return raza; }

    public LocalDate getFechaNacimiento() { return fechaNacimiento; }

    public Cliente getCliente() { return cliente; }

    public void setIdentificador(int identificador) { this.identificador = identificador; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setEspecie(String especie) { this.especie = especie; }

    public void setRaza(String raza) { this.raza = raza; }

    public void setFechaNacimiento(LocalDate fechaNacimiento) { this.fechaNacimiento = fechaNacimiento; }

    public void setCliente(Cliente cliente) { this.cliente = cliente; }
}