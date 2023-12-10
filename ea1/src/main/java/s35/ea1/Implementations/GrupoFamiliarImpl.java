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
        String sqlQuery = "SELECT * FROM GrupoFamiliar WHERE id = " + id;
        List<Map<String, Object>> results = dbConnection.executeSelectQuery(sqlQuery);
        if (!results.isEmpty()) {
            return GrupoFamiliar.fromMap(results.get(0));
        }
        return null;
    }

    public List<GrupoFamiliar> findAll() {
        String sqlQuery = "SELECT * FROM GrupoFamiliar";
        List<Map<String, Object>> results = dbConnection.executeSelectQuery(sqlQuery);
        List<GrupoFamiliar> entities = new ArrayList<GrupoFamiliar>();
        for (Map<String, Object> result : results) {
            entities.add(GrupoFamiliar.fromMap(result));
        }
        return entities;
    }

    public List<Map<String, Object>> findAllMap() {
        String sqlQuery = "SELECT * FROM GrupoFamiliar";
        List<Map<String, Object>> results = dbConnection.executeSelectQuery(sqlQuery);
        return results;
    }

    public boolean save(GrupoFamiliar entity) {
        Map<String, Object> entityMap = entity.toMap();
        entityMap.remove("id");
        String columns = String.join(", ", entityMap.keySet());
        String values = entityMap.values().stream().map(value -> "'" + value + "'").reduce((v1, v2) -> v1 + ", " + v2).orElse("");
        String sqlQuery = "INSERT INTO GrupoFamiliar (" + columns + ") VALUES (" + values + ")";
        return dbConnection.executeUpdateQuery(sqlQuery);
    }

    public boolean update(GrupoFamiliar entity) {
        Map<String, Object> entityMap = entity.toMap();
        String updateClause = entityMap.entrySet().stream()
                .map(entry -> entry.getKey() + " = '" + entry.getValue() + "'")
                .reduce((e1, e2) -> e1 + ", " + e2)
                .orElse("");
        String sqlQuery = "UPDATE GrupoFamiliar SET " + updateClause + " WHERE id = " + entity.getId();
        return dbConnection.executeUpdateQuery(sqlQuery);
    }

    public boolean delete(int id) {
        String sqlQuery = "DELETE FROM GrupoFamiliar WHERE id = " + id;
        return dbConnection.executeUpdateQuery(sqlQuery);
    }
}
