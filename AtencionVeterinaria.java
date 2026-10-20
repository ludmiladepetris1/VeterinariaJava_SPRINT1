import java.time.LocalDate;

public class AtencionVeterinaria {
    private LocalDate fecha;
    private String motivoConsulta;
    private String diagnostico;
    private String tratamiento;
    private Mascota mascota;
    private Veterinario veterinario;

    public AtencionVeterinaria(LocalDate fecha, String motivoConsulta, String diagnostico,
                               String tratamiento, Mascota mascota, Veterinario veterinario) {
        this.fecha = fecha;
        this.motivoConsulta = motivoConsulta;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
        this.mascota = mascota;
        this.veterinario = veterinario;
    }

    public LocalDate getFecha() 
    { 
        return fecha; 

    }
    
    public String getMotivoConsulta() 
    { 
        return motivoConsulta; 
    }
    
    public String getDiagnostico() 
    { 
        return diagnostico; 
    }
    
    
    public String getTratamiento() 
    { 
        return tratamiento; 
    }
    
    public Mascota getMascota() 
    { 
        return mascota; 
    }
    
    public Veterinario getVeterinario() 
    { 
        return veterinario; 
    }

    public void setFecha(LocalDate fecha) 
    { 
        this.fecha = fecha; 
    }
    
    public void setMotivoConsulta(String motivoConsulta) 
    { 
        this.motivoConsulta = motivoConsulta; 
    }
    
    public void setDiagnostico(String diagnostico) 
    { 
        this.diagnostico = diagnostico; 
    }
    
    public void setTratamiento(String tratamiento) 
    { 
        this.tratamiento = tratamiento; 
    }
}