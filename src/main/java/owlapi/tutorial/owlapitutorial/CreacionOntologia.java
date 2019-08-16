/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package owlapi.tutorial.owlapitutorial;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.formats.FunctionalSyntaxDocumentFormat;
import org.semanticweb.owlapi.formats.OWLXMLDocumentFormat;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;

import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLDataProperty;
import org.semanticweb.owlapi.model.OWLDatatype;
import org.semanticweb.owlapi.model.OWLDeclarationAxiom;
import org.semanticweb.owlapi.model.OWLDocumentFormat;
import org.semanticweb.owlapi.model.OWLIndividual;
import org.semanticweb.owlapi.model.OWLObjectProperty;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.PrefixManager;
import org.semanticweb.owlapi.util.DefaultPrefixManager;
import org.semanticweb.owlapi.vocab.OWL2Datatype;
import org.swrlapi.core.SWRLAPIRule;
import org.swrlapi.core.SWRLRuleEngine;
import org.swrlapi.exceptions.SWRLBuiltInException;
import org.swrlapi.factory.SWRLAPIFactory;
import org.swrlapi.parser.SWRLParseException;
import org.swrlapi.sqwrl.SQWRLQueryEngine;
import org.swrlapi.sqwrl.SQWRLResult;
import org.swrlapi.sqwrl.exceptions.SQWRLException;

/**
 *
 * @author Santiago
 */
public class CreacionOntologia {

    //OWL API
    OWLOntologyManager manager; //IRI newIRI = IRI.create("http://www.semanticweb.org/ontologies/ontological-engineering-2019-1/test-blank-ontology.owl");
    IRI newIRI = IRI.create("http://www.semanticweb.org/ontologies/ontological-engineering-2019-1/test-blank-ontology.owl");
    OWLDataFactory factory;
    PrefixManager pm;
    OWLOntology testBlankOntology;
    OWLOntology pizzaOntology;

    //SWRL API
    SWRLRuleEngine swrlEngine;
    SQWRLQueryEngine queryEngine;

    File file = new File("createdOntology.owl");

    public CreacionOntologia() {

        try {
            this.manager = OWLManager.createOWLOntologyManager();
            this.factory = manager.getOWLDataFactory();
            this.pm = new DefaultPrefixManager(
                    "http://www.semanticweb.org/ontologies/ontological-engineering-2019-1/test-blank-ontology.owl#");
            this.testBlankOntology = manager.createOntology(IRI.create(file));
            //this.testBlankOntology = manager.createOntology(newIRI);
            OWLClass clasePadre = factory.getOWLClass(":Padre", pm);
            OWLClass claseMadre = factory.getOWLClass(":Madre", pm);
            OWLClass claseHijo = factory.getOWLClass(":Hijo", pm);
            OWLClass claseHija = factory.getOWLClass(":Hija", pm);
            OWLClass clasePersona = factory.getOWLClass(":Persona", pm);
            OWLClass claseHombre = factory.getOWLClass(":Hombre", pm);
            OWLClass claseMujer = factory.getOWLClass(":Mujer", pm);
            OWLClass claseAdulto = factory.getOWLClass(":Adulto", pm);
            OWLDeclarationAxiom axiomClasePadre = factory
                    .getOWLDeclarationAxiom(clasePadre);
            manager.addAxiom(testBlankOntology, axiomClasePadre);
            OWLDeclarationAxiom axiomClaseMadre = factory
                    .getOWLDeclarationAxiom(claseMadre);
            manager.addAxiom(testBlankOntology, axiomClaseMadre);
            OWLDeclarationAxiom axiomClaseHijo = factory
                    .getOWLDeclarationAxiom(claseHijo);
            manager.addAxiom(testBlankOntology, axiomClaseHijo);
            OWLDeclarationAxiom axiomClaseHija = factory
                    .getOWLDeclarationAxiom(claseHija);
            manager.addAxiom(testBlankOntology, axiomClaseHija);
            OWLDeclarationAxiom axiomClasePersona = factory
                    .getOWLDeclarationAxiom(clasePersona);
            manager.addAxiom(testBlankOntology, axiomClasePersona);
            OWLDeclarationAxiom axiomClaseHombre = factory
                    .getOWLDeclarationAxiom(claseHombre);
            manager.addAxiom(testBlankOntology, axiomClaseHombre);
            OWLDeclarationAxiom axiomClaseMujer = factory
                    .getOWLDeclarationAxiom(claseMujer);
            manager.addAxiom(testBlankOntology, axiomClaseMujer);
            OWLDeclarationAxiom axiomClaseAdulto = factory
                    .getOWLDeclarationAxiom(claseAdulto);
            manager.addAxiom(testBlankOntology, axiomClaseAdulto);
            OWLDataProperty nombre = factory.getOWLDataProperty(":nombre", pm);
            OWLDataProperty edad = factory.getOWLDataProperty(":edad", pm);
            OWLDataProperty numeroHijos = factory.getOWLDataProperty(":numeroHijos", pm);
            OWLObjectProperty tienePadre = factory.getOWLObjectProperty(":tienePadre", pm);
            OWLObjectProperty tieneMadre = factory.getOWLObjectProperty(":tieneMadre", pm);
            OWLObjectProperty tieneHijo = factory.getOWLObjectProperty(":tieneHijo", pm);
            OWLObjectProperty tieneHija = factory.getOWLObjectProperty(":tieneHija", pm);
            OWLDeclarationAxiom axiomNombre = factory
                    .getOWLDeclarationAxiom(nombre);
            manager.addAxiom(testBlankOntology, axiomNombre);
            OWLDeclarationAxiom axiomEdad = factory
                    .getOWLDeclarationAxiom(edad);
            manager.addAxiom(testBlankOntology, axiomEdad);
            OWLDeclarationAxiom axiomNoHijos = factory
                    .getOWLDeclarationAxiom(numeroHijos);
            manager.addAxiom(testBlankOntology, axiomNoHijos);
            OWLDeclarationAxiom axiomTienePadre = factory
                    .getOWLDeclarationAxiom(tienePadre);
            manager.addAxiom(testBlankOntology, axiomTienePadre);
            OWLDeclarationAxiom axiomTieneMadre = factory
                    .getOWLDeclarationAxiom(tieneMadre);
            manager.addAxiom(testBlankOntology, axiomTieneMadre);
            OWLDeclarationAxiom axiomTieneHijo = factory
                    .getOWLDeclarationAxiom(tieneHijo);
            manager.addAxiom(testBlankOntology, axiomTieneHijo);
            OWLDeclarationAxiom axiomTieneHija = factory
                    .getOWLDeclarationAxiom(tieneHija);
            manager.addAxiom(testBlankOntology, axiomTieneHija);
            Set<OWLAxiom> domainsAndRanges = new HashSet<OWLAxiom>();
            domainsAndRanges.add(factory.getOWLObjectPropertyDomainAxiom(tienePadre, claseHijo));
            domainsAndRanges.add(factory.getOWLObjectPropertyDomainAxiom(tienePadre, claseHija));
            domainsAndRanges.add(factory.getOWLObjectPropertyDomainAxiom(tieneMadre, claseHijo));
            domainsAndRanges.add(factory.getOWLObjectPropertyDomainAxiom(tieneMadre, claseHija));
            domainsAndRanges.add(factory.getOWLObjectPropertyDomainAxiom(tieneHijo, clasePadre));
            domainsAndRanges.add(factory.getOWLObjectPropertyDomainAxiom(tieneHijo, claseMadre));
            domainsAndRanges.add(factory.getOWLObjectPropertyDomainAxiom(tieneHija, clasePadre));
            domainsAndRanges.add(factory.getOWLObjectPropertyDomainAxiom(tieneHija, claseMadre));
            domainsAndRanges.add(factory.getOWLObjectPropertyRangeAxiom(tienePadre, clasePadre));
            domainsAndRanges.add(factory.getOWLObjectPropertyRangeAxiom(tieneMadre, claseMadre));
            domainsAndRanges.add(factory.getOWLObjectPropertyRangeAxiom(tieneHijo, claseHijo));
            domainsAndRanges.add(factory.getOWLObjectPropertyRangeAxiom(tieneHija, claseHija));
            domainsAndRanges.add(factory.getOWLDataPropertyDomainAxiom(nombre, clasePersona));
            domainsAndRanges.add(factory.getOWLDataPropertyDomainAxiom(edad, clasePersona));
            domainsAndRanges.add(factory.getOWLDataPropertyDomainAxiom(numeroHijos, clasePersona));
            domainsAndRanges.add(factory.getOWLDataPropertyRangeAxiom(nombre, OWL2Datatype.XSD_STRING));
            domainsAndRanges.add(factory.getOWLDataPropertyRangeAxiom(edad, OWL2Datatype.XSD_INTEGER));
            domainsAndRanges.add(factory.getOWLDataPropertyRangeAxiom(numeroHijos, OWL2Datatype.XSD_INTEGER));

            OWLIndividual santiago = factory.getOWLNamedIndividual(":santiago", pm);
            OWLIndividual maria = factory.getOWLNamedIndividual(":maria", pm);
            OWLIndividual santiagojr = factory.getOWLNamedIndividual(":santiagojr", pm);
            OWLIndividual mariajr = factory.getOWLNamedIndividual(":mariajr", pm);
            manager.addAxioms(testBlankOntology, domainsAndRanges);
            manager.addAxiom(testBlankOntology,
                    factory.getOWLClassAssertionAxiom(clasePersona, santiago));
            manager.addAxiom(testBlankOntology,
                    factory.getOWLClassAssertionAxiom(claseHombre, santiago));
            manager.addAxiom(testBlankOntology,
                    factory.getOWLClassAssertionAxiom(clasePersona, maria));
            manager.addAxiom(testBlankOntology,
                    factory.getOWLClassAssertionAxiom(claseMujer, maria));
            manager.addAxiom(testBlankOntology,
                    factory.getOWLClassAssertionAxiom(clasePersona, santiagojr));
            manager.addAxiom(testBlankOntology,
                    factory.getOWLClassAssertionAxiom(claseHombre, santiagojr));
            manager.addAxiom(testBlankOntology,
                    factory.getOWLClassAssertionAxiom(clasePersona, mariajr));
            manager.addAxiom(testBlankOntology,
                    factory.getOWLClassAssertionAxiom(claseMujer, mariajr));
            manager.addAxiom(testBlankOntology, factory.getOWLObjectPropertyAssertionAxiom(
                    tieneHijo, santiago, santiagojr));
            manager.addAxiom(testBlankOntology, factory.getOWLObjectPropertyAssertionAxiom(
                    tieneHijo, maria, santiagojr));
            manager.addAxiom(testBlankOntology, factory.getOWLObjectPropertyAssertionAxiom(
                    tieneHija, santiago, mariajr));
            manager.addAxiom(testBlankOntology, factory.getOWLObjectPropertyAssertionAxiom(
                    tieneHija, maria, mariajr));
            manager.addAxiom(testBlankOntology, factory.getOWLDataPropertyAssertionAxiom(
                    nombre, santiago, "Santiago Gil"));
            manager.addAxiom(testBlankOntology, factory.getOWLDataPropertyAssertionAxiom(
                    edad, santiago, 55));
            manager.addAxiom(testBlankOntology, factory.getOWLDataPropertyAssertionAxiom(
                    nombre, maria, "Maria J. Tabares"));
            manager.addAxiom(testBlankOntology, factory.getOWLDataPropertyAssertionAxiom(
                    edad, maria, 53));
            manager.addAxiom(testBlankOntology, factory.getOWLDataPropertyAssertionAxiom(
                    nombre, santiagojr, "Santiago Jr. Gil"));
            manager.addAxiom(testBlankOntology, factory.getOWLDataPropertyAssertionAxiom(
                    edad, santiagojr, 15));
            manager.addAxiom(testBlankOntology, factory.getOWLDataPropertyAssertionAxiom(
                    nombre, mariajr, "Maria Jr. Tabares"));
            manager.addAxiom(testBlankOntology, factory.getOWLDataPropertyAssertionAxiom(
                    edad, mariajr, 8));
        } catch (OWLOntologyCreationException ex) {
            Logger.getLogger(CreacionOntologia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void saveOntology() {

        try {

            try {
                manager.saveOntology(testBlankOntology, new OWLXMLDocumentFormat(), new FileOutputStream(file));

                //manager.saveOntology(testBlankOntology, newIRI);
            } catch (OWLOntologyStorageException ex) {
                Logger.getLogger(CreacionOntologia.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CreacionOntologia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadPizzaOntologyFromDocument() {
        try {
            File filePizza = new File("pizza.owl");
            pizzaOntology = manager.loadOntologyFromOntologyDocument(filePizza);

        } catch (OWLOntologyCreationException ex) {
            Logger.getLogger(CreacionOntologia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadPizzaOntologyFromURI() {
        try {
            IRI pizzaIRI = IRI.create("http://protege.stanford.edu/ontologies/pizza/pizza.owl");
            pizzaOntology = manager.loadOntology(pizzaIRI);
            File fileout = new File("pizza.owl");
            manager.saveOntology(pizzaOntology, new OWLXMLDocumentFormat(), new FileOutputStream(fileout));
        } catch (OWLOntologyCreationException ex) {
            Logger.getLogger(CreacionOntologia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CreacionOntologia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (OWLOntologyStorageException ex) {
            Logger.getLogger(CreacionOntologia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void describePizzaOntology() {
        int axiomCount = pizzaOntology.getAxiomCount();
        System.out.println("La ontología de pizzas tiene " + axiomCount + " axiomas");
        System.out.println("La ontología de pizzas tiene ID \n" + String.valueOf(pizzaOntology.getOntologyID()));
    }

    public void initializeSWRLEngines() {
        
        swrlEngine = SWRLAPIFactory.createSWRLRuleEngine(testBlankOntology);
        queryEngine = SWRLAPIFactory.createSQWRLQueryEngine(testBlankOntology);
        
    }

    public void createSWRLRules() {
        try {
            SWRLAPIRule reglaAdulto = swrlEngine.createSWRLRule("ReglaAdulto", "Persona(?p) ^ edad(?p,?ed) ^ swrlb:greaterThan(?ed,17) -> Adulto(?p)");
            SWRLAPIRule reglaPadre1 = swrlEngine.createSWRLRule("ReglaPadre1", "Hombre(?h) ^ tieneHijo(?h,?hj) -> Padre(?h)");
            SWRLAPIRule reglaPadre2 = swrlEngine.createSWRLRule("ReglaPadre2", "Hombre(?h) ^ tieneHija(?h,?hj) -> Padre(?h)");
            SWRLAPIRule reglaHija1 = swrlEngine.createSWRLRule("ReglaPadre1", "Mujer(?m) ^ tienePadre(?m,?p) -> Hija(?m)");
            SWRLAPIRule reglaHija2 = swrlEngine.createSWRLRule("ReglaPadre2", "Mujer(?m) ^ tieneMadre(?m,?md) -> Hija(?m)");

            System.out.println("Reglas creadas");

        } catch (SWRLParseException ex) {
            Logger.getLogger(CreacionOntologia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SWRLBuiltInException ex) {
            Logger.getLogger(CreacionOntologia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void createSQWRLQueries()
    {
        try {
            queryEngine.createSQWRLQuery("ConsultaPadre", "Padre(?p) -> sqwrl:select(?p)");
            queryEngine.createSQWRLQuery("ConsultaHija", "Hija(?h) -> sqwrl:select(?h)");
            
            
        } catch (SWRLParseException ex) {
            Logger.getLogger(CreacionOntologia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQWRLException ex) {
            Logger.getLogger(CreacionOntologia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void callSQWRLQueries() {
        
        
        try {
            SQWRLResult resultPadre = queryEngine.runSQWRLQuery("ConsultaPadre");
            
            String messageResult = "Resultado de inferencia 'ConsultaPadre':\n";
            while (resultPadre.next()) {
                //System.out.println("Active State: " + q0Result.getValue("s"));
                messageResult += "Padre: " + resultPadre.getValue("p") + "\n";
            }
            
            System.out.println(messageResult);
            
            SQWRLResult resultHija = queryEngine.runSQWRLQuery("ConsultaHija");
            
            messageResult = "Resultado de inferencia 'ConsultaHija':\n";
            while (resultHija.next()) {
                //System.out.println("Active State: " + q0Result.getValue("s"));
                messageResult += "Hija: " + resultHija.getValue("h") + "\n";
            }
            
            System.out.println(messageResult);
            
        } catch (SQWRLException ex) {
            Logger.getLogger(CreacionOntologia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
