package s35.ea1.DAO;

import s35.ea1.Transfers.InformacionAcademica;
import s35.ea1.Implementations.InformacionAcademicaImpl;
import s35.ea1.database.DBConnection;

import java.util.List;
import java.util.Map;

public class InformacionAcademicaDAO {

    private final InformacionAcademicaImpl informacionAcademicaImpl;

    public InformacionAcademicaDAO(DBConnection dbConnection) {
        this.informacionAcademicaImpl = new InformacionAcademicaImpl(dbConnection);
    }

    public InformacionAcademica findById(int id) {
        return informacionAcademicaImpl.findById(id);
    }

    public List<InformacionAcademica> findAll() {
        return informacionAcademicaImpl.findAll();
    }
    
    public List<Map<String, Object>> findAllMap() {
        return informacionAcademicaImpl.findAllMap();
    }

    public boolean save(InformacionAcademica informacionAcademica) {
        return informacionAcademicaImpl.save(informacionAcademica);
    }

    public boolean update(InformacionAcademica informacionAcademica) {
        return informacionAcademicaImpl.update(informacionAcademica);
    }

    public boolean delete(int id) {
        return informacionAcademicaImpl.delete(id);
    }
}
