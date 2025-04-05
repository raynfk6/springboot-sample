package tw.example.com.springbootexample.domain.dataclass;

public class Project {
    private ProjectType type;
    private String name;
    
    public Project(ProjectType type, String name) {
        this.type = type;
        this.name = name;
    }
    
    public ProjectType getType() {
        return type;
    }
    public void setType(ProjectType type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
