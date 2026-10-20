import java.time.LocalDate;

public class Turno 
{
    private EstadoTurno estado;
    private LocalDate fecha;
    private String hora;
    private Mascota mascota;
    private Veterinario veterinario;
    private Cliente cliente;
    private AtencionVeterinaria atencion;

    public Turno(LocalDate fecha, String hora, Mascota mascota, Veterinario veterinario, Cliente cliente) {
        this.fecha = fecha;
        this.hora = hora;
        this.mascota = mascota;
        this.veterinario = veterinario;
        this.cliente = cliente;

        // Establece que todo turno nuevo comienza con el estado "pendiente".
        estado = EstadoTurno.PENDIENTE;
    }

    // Cambia el estado si coincide con una de las opciones permitidas.
    public void cambiarEstado(EstadoTurno nuevoEstado) 
    {
        estado = nuevoEstado;
    }

    // Cambia directamente el estado del turno a cancelado.
    public void cancelar() 
    {
        estado = EstadoTurno.CANCELADO;
    }

    // Recibe y guarda una nueva fecha y una nueva hora para el turno.
    public void modificarFechaHora(LocalDate nuevaFecha, String nuevaHora) {
        fecha = nuevaFecha; // Actualiza la fecha.
        hora = nuevaHora;   // Actualiza la hora.
    }

    public LocalDate getFecha() 
    {
        return fecha; 
    }
    
    public String getHora() 
    {
         return hora; 
    }
   
    public EstadoTurno getEstado() 
    { 
        return estado; 
    }
    
    public Mascota getMascota() 
    { 
        return mascota; 
    }
    
    public Veterinario getVeterinario() 
    { 
        return veterinario; 
    }
    
    public Cliente getCliente() 
    { 
        return cliente; 
    }
    
    public AtencionVeterinaria getAtencion() 
    { 
        return atencion; 
    }

    public void setFecha(LocalDate fecha) 
    { 
        this.fecha = fecha; 
    }
    
    public void setHora(String hora) 
    { 
        this.hora = hora; 
    }
   
    public void setMascota(Mascota mascota) 
    { 
        this.mascota = mascota; 
    }
    
    public void setVeterinario(Veterinario veterinario) 
    { 
        this.veterinario = veterinario; 
    }
    
    public void setCliente(Cliente cliente) 
    { 
        this.cliente = cliente; 
    }
    
    public void setAtencion(AtencionVeterinaria atencion) 
    { 
        this.atencion = atencion; 
    }

}
