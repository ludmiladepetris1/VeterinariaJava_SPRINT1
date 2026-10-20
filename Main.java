import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Creamos el sistema de turnos.
        SistemaTurnos sistema = new SistemaTurnos();

        // Creamos un cliente, un veterinario y una mascota.
        Cliente cliente = new Cliente(
            "Ana", "Gomez", "123456", "Calle 123"
        );

        Veterinario veterinario = new Veterinario(
            "Luis", "Perez", "MAT-123", "Clinica general"
        );

        Mascota mascota = new Mascota(
            1, "Luna", "Perro", "Caniche",
            LocalDate.of(2020, 5, 10), cliente
        );

        // Registramos los datos en el sistema.
        sistema.registrarCliente(cliente);
        sistema.registrarMascota(mascota);
        sistema.registrarVeterinario(veterinario);

        // Intentamos registrar un turno para Luna.
        boolean turnoRegistrado = sistema.registrarTurno(
            LocalDate.of(2026, 10, 20),
            "10:30",
            mascota,
            veterinario,
            cliente
        );

        // Mostramos si se pudo registrar el primer turno.
        System.out.println(
            "¿Se registró el primer turno? " + respuesta(turnoRegistrado)
        );

        // Solo continuamos con las pruebas si el turno se registró.
        if (turnoRegistrado) {
            Turno turno = sistema.consultarTurnos().get(0);

            // Intentamos registrar otro turno para el mismo veterinario
            // en la misma fecha y hora.
            boolean turnoRepetido = sistema.registrarTurno(
                LocalDate.of(2026, 10, 20),
                "10:30",
                mascota,
                veterinario,
                cliente
            );

            System.out.println(
                "¿Se registró otro turno en el mismo horario? "
                + respuesta(turnoRepetido)
            );

            // Intentamos cambiar el horario del turno pendiente.
            boolean cambioHorario = cliente.cambiarHorarioTurno(
                sistema,
                turno,
                LocalDate.of(2026, 10, 20),
                "11:00"
            );

            System.out.println(
                "¿Se cambió el horario del turno pendiente? "
                + respuesta(cambioHorario)
            );

            // Marcamos el turno como atendido y registramos la atención.
            turno.cambiarEstado(EstadoTurno.ATENDIDO);

            veterinario.realizarAtencion(
                turno,
                "Control general",
                "Buen estado de salud",
                "Continuar controles anuales"
            );

            // Intentamos cambiar el horario de un turno ya atendido.
            boolean cambioTurnoAtendido = cliente.cambiarHorarioTurno(
                sistema,
                turno,
                LocalDate.of(2026, 10, 21),
                "09:00"
            );

            System.out.println(
                "¿Se cambió el horario del turno atendido? "
                + respuesta(cambioTurnoAtendido)
            );

            // Mostramos los datos finales.
            System.out.println("Mascota: " + mascota.getNombre());
            System.out.println(
                "Cliente: " + cliente.getNombre() + " " + cliente.getApellido()
            );
            System.out.println(
                "Veterinario: " + veterinario.getNombre() + " "
                + veterinario.getApellido()
            );
            System.out.println("Estado del turno: " + turno.getEstado());
            System.out.println("Hora del turno: " + turno.getHora());
            System.out.println(
                "Atenciones en el historial: "
                + mascota.consultarHistorial().size()
            );
            System.out.println(
                "Mascotas del cliente: " + cliente.getMascotas().size()
            );
        }
    }

    // Convierte true en "Sí" y false en "No" para mostrarlo en pantalla.
    public static String respuesta(boolean resultado) {
        if (resultado) {
            return "Sí";
        } else {
            return "No";
        }
    }
}