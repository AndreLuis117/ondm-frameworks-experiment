package base.model;




import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;

@Node
public class Status {

    public Status(){

    }

    public Status(String statusDescription){
        this.name = statusDescription;
    }

    @Id
    private Long id;

    @Property
    private String name;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
