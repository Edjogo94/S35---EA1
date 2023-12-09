package s35.ea1.DAO;

import s35.ea1.Transfers.GrupoFamiliar;
import s35.ea1.Implementations.GrupoFamiliarImpl;
import s35.ea1.database.DBConnection;

import java.util.List;

public class GrupoFamiliarDAO {

    private final GrupoFamiliarImpl grupoFamiliarImpl;

    public GrupoFamiliarDAO(DBConnection dbConnection) {
        this.grupoFamiliarImpl = new GrupoFamiliarImpl(dbConnection);
    }

    public GrupoFamiliar findById(int id) {
        return grupoFamiliarImpl.findById(id);
    }

    public List<GrupoFamiliar> findAll() {
        return grupoFamiliarImpl.findAll();
    }

    public void save(GrupoFamiliar grupoFamiliar) {
        grupoFamiliarImpl.save(grupoFamiliar);
    }

    public void update(GrupoFamiliar grupoFamiliar) {
        grupoFamiliarImpl.update(grupoFamiliar);
    }

    public void delete(int id) {
        grupoFamiliarImpl.delete(id);
    }
}
