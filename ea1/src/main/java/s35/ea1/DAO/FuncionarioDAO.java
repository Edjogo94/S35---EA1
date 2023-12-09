package s35.ea1.DAO;

import s35.ea1.Transfers.Funcionario;
import s35.ea1.Implementations.FuncionarioImpl;
import s35.ea1.database.DBConnection;

import java.util.List;

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

    public void save(Funcionario funcionario) {
        funcionarioImpl.save(funcionario);
    }

    public void update(Funcionario funcionario) {
        funcionarioImpl.update(funcionario);
    }

    public void delete(int id) {
        funcionarioImpl.delete(id);
    }
}
