package lib;

import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class Project extends RestEntity{

    private String m_name;
    private EntityManager<Node> nodes;
    private EntityManager<Link> links;

    private void initializeManagers(String base_url){
        nodes = new EntityManager<>(base_url + "/" + getTrueId() + "/nodes", "Node");
        links = new EntityManager<>(base_url + "/" + getTrueId() + "/links", "Link");
    }

    Project(String base_url, String name, String entity_id){
        super(base_url);
        m_name = name;
        m_entity_id = entity_id;
        initializeManagers(base_url);
    }

    Project(String base_url, String name) {
        super(base_url);
        m_name = name;

        JSONObject req = new JSONObject().put("name",getName());
        JSONObject res = super.create(req);
        m_entity_id = res.getString("project_id");

        initializeManagers(base_url);
    }

    public String getName() {
        return m_name;
    }
    public String getId() {
        return m_name;
    }
    public String getTrueId() {
        return m_entity_id;
    }

    public List<Node> getNodes(){
        return nodes.getEntities();
    }

    public Project addNode(String name, String type){
        List<Object> params = new ArrayList();
        params.add(name);
        params.add(type);
        nodes.addEntity(params);
        return this;
    }

    public Project addNode(String name, String type, int x, int y){
        List<Object> params = new ArrayList();
        params.add(name);
        params.add(type);
        params.add(x);
        params.add(y);
        nodes.addEntity(params);
        return this;
    }

    public Node getNode(String name){
        return nodes.getEntity(name);
    }

    public Project deleteNode(String name){
        nodes.deleteEntity(name);
        return this;
    }

    public List<Link> getLinks(){
        return links.getEntities();
    }

    public Project addLink(Node n1, Node n2){
        List<Object> params = new ArrayList();
        params.add(n1);
        params.add(n2);
        links.addEntity(params);
        return this;
    }

    public Project addLink(Node n1, Node n2, int p1, int p2){
        List<Object> params = new ArrayList();
        params.add(n1);
        params.add(n2);
        params.add(p1);
        params.add(p2);
        links.addEntity(params);
        return this;
    }

    public Link getLink(String id){
        return links.getEntity(id);
    }

    public Project deleteLink(String id){
        links.deleteEntity(id);
        return this;
    }
}