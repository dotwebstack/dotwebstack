package org.dotwebstack.validator;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.jena.graph.Factory;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.util.FileUtils;
import org.topbraid.shacl.util.ModelPrinter;
import org.topbraid.shacl.validation.ValidationUtil;

public class Validator {

  private static void loadFiles(Model model, String filter) throws FileNotFoundException {

    File path = new File(filter);
    File dir = new File(path.getParent());
    FileFilter fileFilter = new WildcardFileFilter(path.getName());
    File[] files = dir.listFiles(fileFilter);
    for (int i = 0; i < files.length; i++) {
      System.out.println(String.format("Loading file: %s",files[i].toString()));
      model.read(new FileInputStream(files[i]), "urn:dummy", FileUtils.langTurtle);
    }
  
  }

  public static void main(String[] args) {

    if (args.length != 3) {
      System.out.println("Usage: validator data-graph-file ontology-graph-file shapes-graph-file");
    } else {

      System.out.println("Starting the validator");
      System.out.println(String.format("File(s) containing the data graph: %s",args[0]));
      System.out.println(String.format("File(s) containing the ontology graph: %s",args[1]));
      System.out.println(String.format("File(s) containing the shapes graph: %s",args[2]));
      
      try {
        Model dataModel = ModelFactory.createModelForGraph(Factory.createDefaultGraph());

        // Load the data model
        System.out.println("Loading data files");
        loadFiles(dataModel, args[0]);

        // Load the ontology model into the data model
        System.out.println("Loading ontology files");
        loadFiles(dataModel, args[1]);

        // Load the shapes model
        Model shapesModel = ModelFactory.createModelForGraph(Factory.createDefaultGraph());
        System.out.println("Loading shape files");
        loadFiles(shapesModel, args[2]);
        
        // Perform the validation of everything, using the data model
        System.out.println("Start validation");
        Resource report = ValidationUtil.validateModel(dataModel, shapesModel, true);
        
        // Print violations
        System.out.println(ModelPrinter.get().print(report.getModel()));
      }
      catch (FileNotFoundException e) {
        System.out.println(e.getMessage());
      }
    }
  }
}