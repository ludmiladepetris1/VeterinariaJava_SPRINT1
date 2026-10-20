import java.time.LocalDate;
import java.util.ArrayList;

public class SistemaTurnos
{
    // Clase que administra los datos y los turnos de la veterinaria.
    private ArrayList<Turno> turnos;
    private ArrayList<Cliente> clientes;
    private ArrayList<Mascota> mascotas;
    private ArrayList<Veterinario> veterinarios;

    public SistemaTurnos()
    {
        // Constructor: se ejecuta al crear un SistemaTurnos.
        turnos = new ArrayList<>();
        clientes = new ArrayList<>();
        mascotas = new ArrayList<>();
        veterinarios = new ArrayList<>();
    }

    ////////////////////////////////////////////////////////////////////

    // METODO 1: registra un cliente.
    public void registrarCliente(Cliente cliente)
    {
        // Agrega el cliente a la lista de clientes.
        clientes.add(cliente);
    }

    ////////////////////////////////////////////////////////////////////

    // METODO 2: registra una mascota.
    public void registrarMascota(Mascota mascota)
    {
        // Agrega la mascota a la lista de mascotas.
        mascotas.add(mascota);
    }

    ////////////////////////////////////////////////////////////////////

    // METODO 3: registra un veterinario.
    public void registrarVeterinario(Veterinario veterinario)
    {
        // Agrega el veterinario a la lista de veterinarios.
        veterinarios.add(veterinario);
    }

    ////////////////////////////////////////////////////////////////////

    // METODO 4: intenta registrar un turno. Devuelve true si se pudo registrar.
    public boolean registrarTurno(LocalDate fecha, String hora, Mascota mascota,
                                  Veterinario veterinario, Cliente cliente)
    {
        // Comprueba si falta alguno de los tres datos obligatorios.
        if (mascota == null || veterinario == null || cliente == null)
        {
            return false; // Informa que no se pudo registrar el turno.
        }

        // Comprueba que la mascota pertenezca al cliente
        // y que el cliente, la mascota y el veterinario esten registrados.
        if (mascota.getCliente() != cliente
                || !clientes.contains(cliente)
                || !mascotas.contains(mascota)
                || !veterinarios.contains(veterinario))
        {
            return false; // Informa que no se pudo registrar el turno.
        }

        // Pregunta si el veterinario esta libre en esa fecha y hora;
        // null indica que todavia no hay un turno que excluir.
        if (!hayDisponibilidad(veterinario, fecha, hora, null))
        {
            return false; // Informa que no se pudo registrar el turno.
        }

        // Crea el turno con esos datos y lo agrega a la lista.
        turnos.add(new Turno(fecha, hora, mascota, veterinario, cliente));
        return true; // Informa que el turno si se registro.
    }

    ////////////////////////////////////////////////////////////////////

    // METODO 5: busca si el veterinario esta libre en esa fecha y hora.
    public boolean hayDisponibilidad(Veterinario veterinario, LocalDate fecha,
                                     String hora, Turno turnoAExcluir)
    {
        // Recorre la lista de turnos desde la posicion 0 hasta el ultimo.
        for (int i = 0; i < turnos.size(); i++)
        {
            // Guarda temporalmente el turno ubicado en la posicion i.
            Turno turno = turnos.get(i);

            // Ignora el turno que se quiere excluir y comprueba que el veterinario sea el mismo,
            // que coincidan fecha y hora y que ese turno no este cancelado.
            if (turno != turnoAExcluir
                    && turno.getVeterinario() == veterinario
                    && turno.getFecha().isEqual(fecha)
                    && turno.getHora().equals(hora)
                    && turno.getEstado() != EstadoTurno.CANCELADO)
            {
                return false; // Ya existe un turno que ocupa ese horario.
            }
        }
        // Si termino el recorrido sin encontrar un choque, el horario esta disponible.
        return true;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////

    // METODO 6: cancela un turno registrado que todavia no fue atendido.
    public void cancelarTurno(Turno turno)
    {
        // Comprueba que el turno este en la lista del sistema y que no haya sido atendido.
        if (turnos.contains(turno) && turno.getEstado() != EstadoTurno.ATENDIDO)
        {
            turno.cancelar(); // Cambia el estado del turno a cancelado.
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    // METODO 7: cambia la fecha y hora de un turno, validando que el veterinario este libre.
    public boolean modificarTurno(Turno turno, LocalDate nuevaFecha, String nuevaHora)
    {
        // Comprueba que el turno este registrado y que siga pendiente.
        if (!turnos.contains(turno) || turno.getEstado() != EstadoTurno.PENDIENTE)
        {
            return false; // Informa que no se modifico el turno.
        }

        // Comprueba que el nuevo horario este libre, excluyendo el turno que se esta cambiando.
        if (!hayDisponibilidad(turno.getVeterinario(), nuevaFecha, nuevaHora, turno))
        {
            return false; // Informa que no se modifico el turno.
        }

        // Guarda la nueva fecha y hora en el turno.
        turno.modificarFechaHora(nuevaFecha, nuevaHora);
        return true; // Informa que el turno se modifico correctamente.
    }

    //////////////////////////////////////////////////////////////////////////////////////////////

    // Devuelve la lista de turnos.
    public ArrayList<Turno> consultarTurnos()
    {
        return turnos;
    }

    // Devuelve la lista de clientes.
    public ArrayList<Cliente> getClientes()
    {
        return clientes;
    }

    // Devuelve la lista de mascotas.
    public ArrayList<Mascota> getMascotas()
    {
        return mascotas;
    }

    // Devuelve la lista de veterinarios.
    public ArrayList<Veterinario> getVeterinarios()
    {
        return veterinarios;
    }
}