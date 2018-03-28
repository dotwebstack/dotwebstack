package org.dotwebstack.validator;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.apache.jena.graph.Factory;
import org.apache.jena.query.Dataset;
import org.apache.jena.query.DatasetFactory;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.RiotException;
import org.apache.jena.util.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.topbraid.shacl.util.ModelPrinter;
import org.topbraid.shacl.validation.ValidationUtil;

public class Validator {

  private static final Logger LOG = LoggerFactory.getLogger(Validator.class);

  private static void loadFiles(Model model, String filter) throws FileNotFoundException {

    File path = new File(filter);
    File dir = new File(path.getParent());
    FileFilter fileFilter = new WildcardFileFilter(path.getName());
    File[] files = dir.listFiles(fileFilter);
    for (File file : files) {
      LOG.info(String.format("Loading file: %s",file.toString()));
      String ext = FilenameUtils.getExtension(file.toString());
      if (ext.equals("trig")) {
        // Trig files contain multiple names graph.
        // We combine those graphs, and add them to the model
        Dataset ds = DatasetFactory.create();
        RDFDataMgr.read(ds, new FileInputStream(file), "urn:dummy", Lang.TRIG);
        model.add(ds.getUnionModel());
        ds.close();
      } else {
        model.read(new FileInputStream(file), "urn:dummy", ext);
      }
    }
  
  }

  public static void main(String[] args) {

    if (args.length != 3) {
      LOG.info("Usage: validator data-graph-file ontology-graph-file shapes-graph-file");
    } else {

      LOG.info("Starting the validator");
      LOG.info(String.format("File(s) containing the data graph: %s",args[0]));
      LOG.info(String.format("File(s) containing the ontology graph: %s",args[1]));
      LOG.info(String.format("File(s) containing the shapes graph: %s",args[2]));
      
      try {
        Model dataModel = ModelFactory.createModelForGraph(Factory.createDefaultGraph());

        // Load the data model
        LOG.info("Loading data files");
        loadFiles(dataModel, args[0]);

        // Load the ontology model into the data model
        LOG.info("Loading ontology files");
        loadFiles(dataModel, args[1]);

        // Load the shapes model
        Model shapesModel = ModelFactory.createModelForGraph(Factory.createDefaultGraph());
        LOG.info("Loading shape files");
        loadFiles(shapesModel, args[2]);
        
        // Perform the validation of everything, using the data model
        LOG.info("Start validation");
        Resource report = ValidationUtil.validateModel(dataModel, shapesModel, true);
        
        // Print violations
        LOG.info(ModelPrinter.get().print(report.getModel()));
      } catch (FileNotFoundException e) {
        LOG.error(e.getMessage());
      } catch (RiotException e) {
        //Already send to output via SLF4J
      }
    }
  }
}