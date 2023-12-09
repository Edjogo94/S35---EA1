package s35.ea1.DAO;

import s35.ea1.Transfers.InformacionAcademica;
import s35.ea1.Implementations.InformacionAcademicaImpl;
import s35.ea1.database.DBConnection;

import java.util.List;

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

    public void save(InformacionAcademica informacionAcademica) {
        informacionAcademicaImpl.save(informacionAcademica);
    }

    public void update(InformacionAcademica informacionAcademica) {
        informacionAcademicaImpl.update(informacionAcademica);
    }

    public void delete(int id) {
        informacionAcademicaImpl.delete(id);
    }
}
