import java.util.List;
import java.util.Map;

public class Schema {
    private String schemaName;
    private Map<String, List<String>> schemaCourses;
    private Map<String, Integer> moduleRequirement;

    public Schema() {
    }

    public Schema(String schemaName, Map<String, List<String>> schemaCourses, Map<String, Integer> moduleRequirement) {
        this.schemaName = schemaName;
        this.schemaCourses = schemaCourses;
        this.moduleRequirement = moduleRequirement;
    }

    public String getSchemaName() {
        return schemaName;
    }

    public void setSchemaName(String schemaName) {
        this.schemaName = schemaName;
    }

    public Map<String, List<String>> getSchemaCourses() {
        return schemaCourses;
    }

    public void setSchemaCourses(Map<String, List<String>> schemaCourses) {
        this.schemaCourses = schemaCourses;
    }

    public Map<String, Integer> getModuleRequirement() {
        return moduleRequirement;
    }

    public void setModuleRequirement(Map<String, Integer> moduleRequirement) {
        this.moduleRequirement = moduleRequirement;
    }
}
