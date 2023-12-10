package s35.ea1.Transfers;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class Funcionario {

    private int id;
    private String tipoIdentificacion;
    private String numeroIdentificacion;
    private String nombres;
    private String apellidos;
    private String estadoCivil;
    private String sexo;
    private String direccion;
    private String telefono;
    private Date fechaNacimiento;

    public Funcionario(int id, String tipoIdentificacion, String numeroIdentificacion, String nombres, String apellidos, String estadoCivil, String sexo, String direccion, String telefono, Date fechaNacimiento) {
        this.id = id;
        this.tipoIdentificacion = tipoIdentificacion;
        this.numeroIdentificacion = numeroIdentificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.estadoCivil = estadoCivil;
        this.sexo = sexo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Funcionario() {
    }

    public static Funcionario fromMap(Map<String, Object> data) {
        Funcionario funcionario = new Funcionario();
        funcionario.setId((int) data.get("id"));
        funcionario.setTipoIdentificacion((String) data.get("tipo_identificacion"));
        funcionario.setNumeroIdentificacion((String) data.get("numero_identificacion"));
        funcionario.setNombres((String) data.get("nombres"));
        funcionario.setApellidos((String) data.get("apellidos"));
        funcionario.setEstadoCivil((String) data.get("estado_civil"));
        funcionario.setSexo((String) data.get("sexo"));
        funcionario.setDireccion((String) data.get("direccion"));
        funcionario.setTelefono((String) data.get("telefono"));
        funcionario.setFechaNacimiento((Date) data.get("fecha_nacimiento"));
        return funcionario;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", this.id);
        map.put("tipo_identificacion", this.tipoIdentificacion);
        map.put("numero_identificacion", this.numeroIdentificacion);
        map.put("nombres", this.nombres);
        map.put("apellidos", this.apellidos);
        map.put("estado_civil", this.estadoCivil);
        map.put("sexo", this.sexo);
        map.put("direccion", this.direccion);
        map.put("telefono", this.telefono);
        map.put("fecha_nacimiento", this.fechaNacimiento);
        return map;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public String getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(String numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

}
