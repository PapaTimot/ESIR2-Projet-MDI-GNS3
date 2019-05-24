import lib.Controller;
import lib.Link;
import lib.Node;
import lib.Project;
import org.junit.Test;

import java.util.List;
import static org.junit.Assert.assertEquals;

public class TestMethodesNode {

    @Test
    public void testDuplicateNodes() throws InterruptedException {

        Controller controller = new Controller("148.60.11.161");


        controller.deleteProject("TestDuplicateNode");
        Node node = controller
                .addProject("TestDuplicateNode")
                .getProject("TestDuplicateNode")
                .addNode("V", "vpcs", 0, 0)
                .getNode("V")
                .duplicateNode(200,200);

        Project project = controller
                .getProject("TestDuplicateNode");
        project.getNode("V1").duplicateNode(400,400);


        assertEquals("V1", project.getNode("V1").getName());
        assertEquals("V2", project.getNode("V2").getName());

        //project.delete();
    }

    @Test
    public void testReloadNode() throws InterruptedException {

        Controller controller = new Controller("148.60.11.161");


        controller.deleteProject("TestReloadNode");
        Node node = controller
                .addProject("TestReloadNode")
                .getProject("TestReloadNode")
                .addNode("V", "vpcs", 0, 0)
                .getNode("V")
                .reloadNode();

        Project project = controller
                .getProject("TestReloadNode");

        assertEquals("V", project.getNode("V").getName());
        //project.delete();
    }


    @Test
    public void testStartStop() throws InterruptedException {

        Controller controller = new Controller("148.60.11.161");


        controller.deleteProject("TestStartStop");
        Node node = controller
                .addProject("TestStartStop")
                .getProject("TestStartStop")
                .addNode("V", "vpcs", 100, 0)
                .getNode("V")
                .startNode();

        controller.getProject("TestStartStop").getNode("V").stopNode();

        Project project = controller
                .getProject("TestGetLink");

        //assertEquals("V", project.getNode("V").getName());
        //project.delete();
    }
}