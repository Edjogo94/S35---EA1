package s35.ea1.Transfers;

import java.util.HashMap;
import java.util.Map;

public class GrupoFamiliar{

    private int id;
    private int funcionarioId;
    private String miembroNombre;
    private String miembroApellido;
    private String miembroRol;

    public static GrupoFamiliar fromMap(Map<String, Object> data) {
        GrupoFamiliar grupoFamiliar = new GrupoFamiliar();
        grupoFamiliar.setId((int) data.get("id"));
        grupoFamiliar.setFuncionarioId((int) data.get("funcionario_id"));
        grupoFamiliar.setMiembroNombre((String) data.get("miembro_nombre"));
        grupoFamiliar.setMiembroApellido((String) data.get("miembro_apellido"));
        grupoFamiliar.setMiembroRol((String) data.get("miembro_rol"));
        return grupoFamiliar;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", this.id);
        map.put("funcionario_id", this.funcionarioId);
        map.put("miembro_nombre", this.miembroNombre);
        map.put("miembro_apellido", this.miembroApellido);
        map.put("miembro_rol", this.miembroRol);
        return map;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public String getMiembroNombre() {
        return miembroNombre;
    }

    public void setMiembroNombre(String miembroNombre) {
        this.miembroNombre = miembroNombre;
    }

    public String getMiembroApellido() {
        return miembroApellido;
    }

    public void setMiembroApellido(String miembroApellido) {
        this.miembroApellido = miembroApellido;
    }

    public String getMiembroRol() {
        return miembroRol;
    }

    public void setMiembroRol(String miembroRol) {
        this.miembroRol = miembroRol;
    }

}
