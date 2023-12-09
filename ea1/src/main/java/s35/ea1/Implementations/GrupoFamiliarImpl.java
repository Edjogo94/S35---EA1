package s35.ea1.Implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import s35.ea1.Transfers.GrupoFamiliar;
import s35.ea1.database.DBConnection;

public class GrupoFamiliarImpl {

    private final DBConnection dbConnection;

    public GrupoFamiliarImpl(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public GrupoFamiliar findById(int id) {
        String sqlQuery = "SELECT * FROM Funcionarios WHERE id = " + id;
        List<Map<String, Object>> results = dbConnection.executeSelectQuery(sqlQuery);
        if (!results.isEmpty()) {
            return GrupoFamiliar.fromMap(results.get(0));
        }
        return null;
    }

    public List<GrupoFamiliar> findAll() {
        String sqlQuery = "SELECT * FROM Funcionarios";
        List<Map<String, Object>> results = dbConnection.executeSelectQuery(sqlQuery);
        List<GrupoFamiliar> entities = new ArrayList<GrupoFamiliar>();
        for (Map<String, Object> result : results) {
            entities.add(GrupoFamiliar.fromMap(result));
        }
        return entities;
    }

    public void save(GrupoFamiliar entity) {
        Map<String, Object> entityMap = entity.toMap();
        String columns = String.join(", ", entityMap.keySet());
        String values = entityMap.values().stream().map(value -> "'" + value + "'").reduce((v1, v2) -> v1 + ", " + v2).orElse("");
        String sqlQuery = "INSERT INTO Funcionarios (" + columns + ") VALUES (" + values + ")";
        dbConnection.executeUpdateQuery(sqlQuery);
    }

    public void update(GrupoFamiliar entity) {
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
