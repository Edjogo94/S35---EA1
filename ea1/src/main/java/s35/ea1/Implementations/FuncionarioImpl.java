package s35.ea1.Implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import s35.ea1.Transfers.Funcionario;
import s35.ea1.database.DBConnection;

public class FuncionarioImpl {

    private final DBConnection dbConnection;

    public FuncionarioImpl(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public Funcionario findById(int id) {
        String sqlQuery = "SELECT * FROM Funcionarios WHERE id = " + id;
        List<Map<String, Object>> results = dbConnection.executeSelectQuery(sqlQuery);
        if (!results.isEmpty()) {
            return Funcionario.fromMap(results.get(0));
        }
        return null;
    }

    public List<Funcionario> findAll() {
        String sqlQuery = "SELECT * FROM Funcionarios";
        List<Map<String, Object>> results = dbConnection.executeSelectQuery(sqlQuery);
        List<Funcionario> entities = new ArrayList<Funcionario>();
        for (Map<String, Object> result : results) {
            entities.add(Funcionario.fromMap(result));
        }
        return entities;
    }

    public void save(Funcionario entity) {
        Map<String, Object> entityMap = entity.toMap();
        String columns = String.join(", ", entityMap.keySet());
        String values = entityMap.values().stream().map(value -> "'" + value + "'").reduce((v1, v2) -> v1 + ", " + v2).orElse("");
        String sqlQuery = "INSERT INTO Funcionarios (" + columns + ") VALUES (" + values + ")";
        dbConnection.executeUpdateQuery(sqlQuery);
    }

    public void update(Funcionario entity) {
        Map<String, Object> entityMap = entity.toMap();
        String updateClause = entityMap.entrySet().stream()
                .map(entry -> entry.getKey() + " = '" + entry.getValue() + "'")
                .reduce((e1, e2) -> e1 + ", " + e2)
                .orElse("");
        String sqlQuery = "UPDATE Funcionarios SET " + updateClause + " WHERE id = " + entity.getId();
        dbConnection.executeUpdateQuery(sqlQuery);
    }

    public void delete(int id) {
        String sqlQuery = "DELETE FROM Funcionarios WHERE id = " + id;
        dbConnection.executeUpdateQuery(sqlQuery);
    }
}
