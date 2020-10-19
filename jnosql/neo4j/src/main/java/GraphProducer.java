

import org.apache.tinkerpop.gremlin.neo4j.structure.Neo4jGraph;
import org.apache.tinkerpop.gremlin.structure.Graph;
import org.eclipse.jnosql.artemis.graph.GraphTraversalSourceSupplier;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import java.io.File;

@ApplicationScoped
public class GraphProducer {

    private Graph graph;


    @PostConstruct
    public void init() {
        String absolutePath = new File("").getAbsolutePath() + "/target/jnosql/";
        this.graph = Neo4jGraph.open(absolutePath);
    }

    @Produces
    @ApplicationScoped
    public Graph getGraph() {
        return graph;
    }

    @Produces
    @ApplicationScoped
    public GraphTraversalSourceSupplier getSupplier() {
        return () -> graph.traversal();
    }

    public void close(@Disposes Graph graph) throws Exception {
        graph.close();
    }
}