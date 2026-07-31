package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import models.SoftwareProject;

public class ProjectController {
  public Set<SoftwareProject> filterAndOrderProjects(List<SoftwareProject> projects,double minimumWorkload){
    Set<SoftwareProject> resultado = new TreeSet<>(
      (c1,c2)->{
        int compW = Double.compare(c2.getMetrics().getWorload(),c1.getMetrics().getWorload());
        if(compW !=0){
          return compW;
        }
        int compCo = c1.getProjectCode().compareToIgnoreCase(c2.getProjectCode());
        return compCo;
      }
    );
    for (SoftwareProject project:projects ){
      if(project.getMetrics().getWorload()>= minimumWorkload){
        resultado.add(project);

      }

    }
    return resultado;
}

  
public List<SoftwareProject> classifyAndExtractProjects(List<SoftwareProject> projects, String requestedCategory){
   Map<String,Set<SoftwareProject>> categorias = new TreeMap<>();
  categorias.put("CRITICAL", new TreeSet<>(
    (c1,c2)->{
      int compP = Integer.compare(c2.getPriority(),c1.getPriority());
      if(compP !=0){
        return compP;
      }
      int comPc = c1.getProjectCode().compareToIgnoreCase(c2.getProjectCode());
      return comPc;
    }
  ));

  categorias.put("SMALL", new TreeSet<>(
    (c1,c2)->{
      int compP = Integer.compare(c2.getPriority(),c1.getPriority());
      if(compP !=0){
        return compP;
      }
      int comPc = c1.getProjectCode().compareToIgnoreCase(c2.getProjectCode());
      return comPc;
    }
  ));
  categorias.put("STANDARD", new TreeSet<>(
    (c1,c2)->{
      int compP = Integer.compare(c2.getPriority(),c1.getPriority());
      if(compP !=0){
        return compP;
      }
      int comPc = c1.getProjectCode().compareToIgnoreCase(c2.getProjectCode());
      return comPc;
    }
  ));
  for(SoftwareProject sp : projects){
    String rango;
    if(sp.getMetrics().getWorload()>=900 || sp.getMetrics().getPendingTasks()>=18){
      rango = "CRITICAL";
    }else if (sp.getMetrics().getWorload()>=350){
      rango = "STANDARD";
    }else{
      rango = "SMALL";
    }
    Set<SoftwareProject> rs = categorias.get(rango);
    rs.add(sp);

  }
  String rCategory = requestedCategory == null? "" : requestedCategory.trim().toUpperCase();
  if(!categorias.containsKey(rCategory)){
    return new ArrayList<>();
  }
  return new ArrayList<>(categorias.get(rCategory));
}
}