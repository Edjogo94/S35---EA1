package s35.ea1.DAO;

import s35.ea1.Transfers.GrupoFamiliar;
import s35.ea1.Implementations.GrupoFamiliarImpl;
import s35.ea1.database.DBConnection;

import java.util.List;
import java.util.Map;

public class GrupoFamiliarDAO {

    private final GrupoFamiliarImpl grupoFamiliarImpl;

    public GrupoFamiliarDAO(DBConnection dbConnection) {
        this.grupoFamiliarImpl = new GrupoFamiliarImpl(dbConnection);
    }

    public GrupoFamiliar findById(int id) {
        return grupoFamiliarImpl.findById(id);
    }
    
    public List<Map<String, Object>> findAllMap() {
        return grupoFamiliarImpl.findAllMap();
    }

    public List<GrupoFamiliar> findAll() {
        return grupoFamiliarImpl.findAll();
    }

    public boolean save(GrupoFamiliar grupoFamiliar) {
        return grupoFamiliarImpl.save(grupoFamiliar);
    }

    public boolean update(GrupoFamiliar grupoFamiliar) {
        return grupoFamiliarImpl.update(grupoFamiliar);
    }

    public boolean delete(int id) {
        return grupoFamiliarImpl.delete(id);
    }
}
