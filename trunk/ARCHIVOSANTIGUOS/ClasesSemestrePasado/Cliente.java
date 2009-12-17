package Bonati;


public class Cliente {
    private String nombre;
    private String rut;
    private int telefono;
    private String direccion;
    private String correo;
    private String comuna;
    private Boolean visible;

    public Cliente(){

    }

    public String getNombre() {
        return this.nombre;
    }

    public String getRut() {
        return this.rut;
    }

    public int getTelefono() {
        return this.telefono;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getCorreo() {
        return this.correo;
    }

    public String getComuna() {
        return this.comuna;
    }

    public boolean getVisible() {
        return this.visible;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }

    public void setRut(String r) {
        this.rut = r;
    }

    public void setTelefono(int t) {
        this.telefono = t;
    }

    public void setDireccion(String d) {
        this.direccion = d;
    }

    public void setCorreo(String c) {
        this.correo = c;
    }

    public void setComuna(String c) {
        this.comuna = c;
    }

    public void setEstado(boolean v) {
        this.visible = v;
    }
}
