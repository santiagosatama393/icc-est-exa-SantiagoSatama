import java.util.List;
import java.util.Set;

import controller.ProjectController;
import data.ProjectData;
import models.SoftwareProject;

public class App {
    public static void main(String[] args) throws Exception {
       runExamen();
    }

    private static void runExamen() {
       List<SoftwareProject> projects= ProjectData.createProjects();
       ProjectController controller = new ProjectController();

       Set<SoftwareProject> ordered=
              controller.filterAndOrderProjects(projects, 500);
    List<SoftwareProject> critical=
            controller.classifyAndExtractProjects(projects, "CRITICAL");

    System.out.println("metodo a" + ordered.size());
    for(SoftwareProject softwareProject:ordered){
        System.out.println(softwareProject.getProjectCode()+ "horas trabajadas"+ softwareProject.getMetrics().getWorload());
    }
        


    }
}
