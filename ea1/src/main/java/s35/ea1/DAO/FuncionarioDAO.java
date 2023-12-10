package s35.ea1.DAO;

import s35.ea1.Transfers.Funcionario;
import s35.ea1.Implementations.FuncionarioImpl;
import s35.ea1.database.DBConnection;

import java.util.List;
import java.util.Map;

public class FuncionarioDAO {

    private final FuncionarioImpl funcionarioImpl;

    public FuncionarioDAO(DBConnection dbConnection) {
        this.funcionarioImpl = new FuncionarioImpl(dbConnection);
    }

    public Funcionario findById(int id) {
        return funcionarioImpl.findById(id);
    }

    public List<Funcionario> findAll() {
        return funcionarioImpl.findAll();
    }
    
    public List<Map<String, Object>> findAllMap() {
        return funcionarioImpl.findAllMap();
    }

    public boolean save(Funcionario funcionario) {
        return funcionarioImpl.save(funcionario);
    }

    public boolean update(Funcionario funcionario) {
        return funcionarioImpl.update(funcionario);
    }

    public boolean delete(int id) {
        return funcionarioImpl.delete(id);
    }
}
