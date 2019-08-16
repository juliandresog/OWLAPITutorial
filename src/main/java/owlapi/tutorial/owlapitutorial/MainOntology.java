/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package owlapi.tutorial.owlapitutorial;

import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.OWLOntologyManager;

/**
 *
 * @author Santiago
 */
public class MainOntology {

    public static void main(String[] args) {

//        OWLOntologyManager man = OWLManager.createOWLOntologyManager();
//        System.out.println(man.getOntologies().size());
//    }
        
        //Creacion de la ontologia
        CreacionOntologia nuevaOntologia = new CreacionOntologia();
        System.out.println("Ontología creada");
        
        
        
        
        
        //Cargar ontologia creada anteriormente
        System.out.println("Leyendo pizza ontology de Protégé online");
        nuevaOntologia.loadPizzaOntologyFromURI();
        System.out.println("Describiendo pizza ontology:");
        nuevaOntologia.describePizzaOntology();
        
        
        //Manejo de SWRL y SQWRL
        /*System.out.println("Inicializando motores de inferencia");
        nuevaOntologia.initializeSWRLEngines();
        System.out.println("Creando reglas SWRL");
        nuevaOntologia.createSWRLRules();
        System.out.println("Creando consultas SQWRL");
        nuevaOntologia.createSQWRLQueries();
        System.out.println("Generando inferencias de las consultas");
        nuevaOntologia.callSQWRLQueries();*/
        
        
        
        
        //Guardar ontologia
        System.out.println("Almacenando archivo");
        nuevaOntologia.saveOntology();
        
        System.out.println("Finalizando ejecución");

    }
}
