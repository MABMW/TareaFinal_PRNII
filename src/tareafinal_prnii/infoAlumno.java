package tareafinal_prnii;

public class infoAlumno {

    private String codigo;
    private String nombre;
    private String sexo;
    private String fechaNacimiento;
    private String[][] notas;

    public infoAlumno() {
    }

    public infoAlumno(String codigo, String nombre, String sexo, String fechaNacimiento, String[][] notas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.notas = notas;
    }

    public String[][] getNotas() {
        return notas;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setNotas(String[][] notas) {
        this.notas = notas;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
