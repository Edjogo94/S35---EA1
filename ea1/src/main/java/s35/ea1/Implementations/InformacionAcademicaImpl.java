
package s35.ea1.Implementations;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import s35.ea1.Transfers.InformacionAcademica;
import s35.ea1.database.DBConnection;

public class InformacionAcademicaImpl {

    private final DBConnection dbConnection;

    public InformacionAcademicaImpl(DBConnection dbConnection) {
        this.dbConnection = dbConnection;
    }

    public InformacionAcademica findById(int id) {
        String sqlQuery = "SELECT * FROM InformacionAcademica WHERE id = " + id;
        List<Map<String, Object>> results = dbConnection.executeSelectQuery(sqlQuery);
        if (!results.isEmpty()) {
            return InformacionAcademica.fromMap(results.get(0));
        }
        return null;
    }

    public List<InformacionAcademica> findAll() {
        String sqlQuery = "SELECT * FROM InformacionAcademica";
        List<Map<String, Object>> results = dbConnection.executeSelectQuery(sqlQuery);
        List<InformacionAcademica> entities = new ArrayList<InformacionAcademica>();
        for (Map<String, Object> result : results) {
            entities.add(InformacionAcademica.fromMap(result));
        }
        return entities;
    }

    public List<Map<String, Object>> findAllMap() {
        String sqlQuery = "SELECT * FROM InformacionAcademica";
        List<Map<String, Object>> results = dbConnection.executeSelectQuery(sqlQuery);
        return results;
    }

    public boolean save(InformacionAcademica entity) {
        Map<String, Object> entityMap = entity.toMap();
        entityMap.remove("id");
        String columns = String.join(", ", entityMap.keySet());
        String values = entityMap.values().stream().map(value -> "'" + value + "'").reduce((v1, v2) -> v1 + ", " + v2).orElse("");
        String sqlQuery = "INSERT INTO InformacionAcademica (" + columns + ") VALUES (" + values + ")";
        return dbConnection.executeUpdateQuery(sqlQuery);
    }

    public boolean update(InformacionAcademica entity) {
        Map<String, Object> entityMap = entity.toMap();
        String updateClause = entityMap.entrySet().stream()
                .map(entry -> entry.getKey() + " = '" + entry.getValue() + "'")
                .reduce((e1, e2) -> e1 + ", " + e2)
                .orElse("");
        String sqlQuery = "UPDATE InformacionAcademica SET " + updateClause + " WHERE id = " + entity.getId();
        return dbConnection.executeUpdateQuery(sqlQuery);
    }

    public boolean delete(int id) {
        String sqlQuery = "DELETE FROM InformacionAcademica WHERE id = " + id;
        return dbConnection.executeUpdateQuery(sqlQuery);
    }
}
