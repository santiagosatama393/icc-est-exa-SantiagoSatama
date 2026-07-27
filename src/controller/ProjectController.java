package controller;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import models.SoftwareProject;

public class ProjectController {
  public Set<SoftwareProject> filterAndOrderProjects(
          List<SoftwareProject> projects,
          double minimumWorkload
  ){
    Set<SoftwareProject> result = new TreeSet<>(new Comparator<SoftwareProject>){
      @Override
      public int compare(SoftwareProject c1, SoftwareProject c2){
        int workloadCompare = Double.compare(
          c2.getMetrics().getWorload(),
          c1.getMetrics().getWorload()
        );
        if(workloadCompare != 0){
          return workloadCompare;
        }
        return c1.getCode().compareToIngnoreCase(c2.getCode());
      }

  };

  for (SoftwareProject project:projects ){
    if(project.getMetrics().getWorload()>= minimumWorkload){
      result.add(project);

    }

  }
  return result;

  }

  
 public List<SoftwareProject> classifyAndExtractProjects(
         List<SoftwareProject> projects,
         String requestedCategory
 ){
  Map<String,set<SoftwareProject>> categorias = new TreeMap<>();
  categorias.put("CRITICAL", new TreeSet<>((c1,c2))_->{
    int compP = interger.compare(c2.getPriority(), c1.getPriority());
    if(compP !=0){
      return compP;
    }
    int compP = C1.getProjectCode(),compareToIngnoreCase(C2.getProjectCode());
    return compC;
  }));

  categorias.put("SMALL", new TreeSet<>((c1, c2)))->{
    int compP = interger.compare(c2.getPriority(), c1.getPriority());
    if(compP !=0){
      return compP;
    }
    int compP = C1.getProjectCode(),compareToIngnoreCase(C2.getProjectCode());
    return compC;

  }));
  categorias.put("STANDAR", new TreeSet<>((c1, c2)))->{
    int compP = interger.compare(c2.getPriority(), c1.getPriority());
    if(compP !=0){
      return compP;
    }
    int compP = C1.getProjectCode(),compareToIngnoreCase(C2.getProjectCode());
    return compC;


 }));
 }));
  categorias.put("STANDAR", new TreeSet<>((c1, c2)))->{
    int compP = interger.compare(c2.getPriority(), c1.getPriority());
    if(compP !=0){
      return compP;
    }
    int compP = C1.getProjectCode(),compareToIngnoreCase(C2.getProjectCode());
    return compC;


}
}

