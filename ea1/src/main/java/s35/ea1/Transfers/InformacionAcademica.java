package s35.ea1.Transfers;

import java.util.HashMap;
import java.util.Map;

public class InformacionAcademica {

    private int id;
    private int funcionarioId;
    private String universidad;
    private String nivelEstudio;
    private String tituloEstudio;

    public InformacionAcademica(int id, int funcionarioId, String universidad, String nivelEstudio, String tituloEstudio) {
        this.id = id;
        this.funcionarioId = funcionarioId;
        this.universidad = universidad;
        this.nivelEstudio = nivelEstudio;
        this.tituloEstudio = tituloEstudio;
    }

    public InformacionAcademica() {
    }

    public static InformacionAcademica fromMap(Map<String, Object> data) {
        InformacionAcademica informacionAcademica = new InformacionAcademica();
        informacionAcademica.setId((int) data.get("id"));
        informacionAcademica.setFuncionarioId((int) data.get("funcionario_id"));
        informacionAcademica.setUniversidad((String) data.get("universidad"));
        informacionAcademica.setNivelEstudio((String) data.get("nivel_estudio"));
        informacionAcademica.setTituloEstudio((String) data.get("titulo_estudio"));
        return informacionAcademica;
    }

    public Map<String, Object> toMap() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", this.id);
        map.put("funcionario_id", this.funcionarioId);
        map.put("universidad", this.universidad);
        map.put("nivel_estudio", this.nivelEstudio);
        map.put("titulo_estudio", this.tituloEstudio);
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

    public String getUniversidad() {
        return universidad;
    }

    public void setUniversidad(String universidad) {
        this.universidad = universidad;
    }

    public String getNivelEstudio() {
        return nivelEstudio;
    }

    public void setNivelEstudio(String nivelEstudio) {
        this.nivelEstudio = nivelEstudio;
    }

    public String getTituloEstudio() {
        return tituloEstudio;
    }

    public void setTituloEstudio(String tituloEstudio) {
        this.tituloEstudio = tituloEstudio;
    }

}
