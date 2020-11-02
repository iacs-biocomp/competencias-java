package es.aragon.iacs.competencias.action;

import java.text.ParseException;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.ejb.EJB;
import java.util.ArrayList;

import es.aragon.midas.action.MidasActionSupport;
import es.aragon.iacs.competencias.dao.ICompCatCompetencialesDAO;
import es.aragon.iacs.competencias.jpa.CompCatCompetenciales;
import es.aragon.iacs.competencias.dao.ICompCompetenciasDAO;
import es.aragon.iacs.competencias.dao.ICompTrabajadoresDAO;
import es.aragon.iacs.competencias.jpa.CompTrabajadores;
import es.aragon.iacs.competencias.jpa.CompExternos;
import es.aragon.iacs.competencias.dao.ICompExternosDAO;
import es.aragon.iacs.competencias.dao.ICompEvaluacionesDAO;
import es.aragon.iacs.competencias.dao.ICompOrganigramasDAO;
import es.aragon.iacs.competencias.dao.ICompEvaluadoresDAO;
import es.aragon.iacs.competencias.jpa.CompObjetivosCompCatcomp;
import es.aragon.iacs.competencias.jpa.CompCompetencias;
import es.aragon.iacs.competencias.jpa.CompEvaluaciones;
import es.aragon.iacs.competencias.jpa.CompObjetivos;
import es.aragon.iacs.competencias.jpa.CompObjetivosCompCatcomp;
import es.aragon.iacs.competencias.jpa.CompPares;
import es.aragon.iacs.competencias.jpa.CompSuperiores;
import es.aragon.iacs.competencias.jpa.CompEvaluadorExterno;
import es.aragon.iacs.competencias.jpa.CompEvaluadorInterno;
import es.aragon.iacs.competencias.jpa.CompSuperiores;
import es.aragon.iacs.competencias.jpa.CompRelCompCompleto;
import es.aragon.iacs.competencias.jpa.CompValoraciones;

public class EvaluacionesAction extends MidasActionSupport{
	private static final long serialVersionUID = 2108264332221967943L;
	@EJB(name="CompOrganigramasDAO")
    private ICompOrganigramasDAO organigramasDao;
	
	@EJB(name="CompCatCompetencialesDAO")
    private ICompCatCompetencialesDAO catCompetencialesDao;
	private List<CompCatCompetenciales> listaCatCompetenciales;
	
	@EJB(name="CompCompetenciasDAO")
    private ICompCompetenciasDAO competenciasDao;
    private List<CompCompetencias> listaCompetencias;
    
//    private Boolean interno;
    @EJB(name="CompTrabajadoresDAO")
    private ICompTrabajadoresDAO trabajadoresDao;
//    private CompTrabajadores trabajador;
    private List<CompObjetivosCompCatcomp> compObjCompCatcomp;
    
    private List<CompTrabajadores> listaTrabajadores;
    private List<CompEvaluadorInterno> meHanElegido;
    
    @EJB(name="CompExternosDAO")
    private ICompExternosDAO externosDao;
    
    @EJB(name="CompEvaluacionesDAO")
    private ICompEvaluacionesDAO evaluacionesDao;
    private List<CompEvaluaciones> listaEvaluaciones;
    private CompEvaluaciones evaluacionActual;
    
    private List<CompObjetivosCompCatcomp> objCompCatcomp;
    
    private List<CompPares> misPares;
	private List<CompSuperiores> misSuperiores;
	
	private List<CompTrabajadores> listaTrabajadoresAll;
	
    @EJB(name="CompEvaluadoresDAO")
    private ICompEvaluadoresDAO evaluadoresDao;
    private List<CompEvaluadorExterno> evaluadoresExternos;
    private List<CompEvaluadorInterno> evaluadoresInternos;
    
    private Integer id;
	private String nombre;
	private Date iniaportacion;
	private Date finaportacion;
	private Date inivalidacion;
	private Date finvalidacion;
	private Date iniperiodo;
	private Date finperiodo;
	private Date inievaluacion;
	private Date finevaluacion;
	private String catcompetencial;
//	private String trabajador;
	private String comp0;
	private String comp1;
	private String comp2;
	private String comp3;
	private String comp4;
	private String comp5;
	private String comp6;
	private String comp7;
	private String comp8;
	private String comp9;
	
	private List<String> compet;
	private List<String> competint;
	private List<Integer> comport;
	private List<Integer> comportint;
	
	private Boolean editar;
	private Boolean editar2;
	private Integer idEditar;
	private Date fechaActual;
	
	private Integer idNueva;
	private CompEvaluaciones nuevaEvaluacion;
	private Boolean mis;
	
	private List<CompRelCompCompleto> compRelCompCompleto;
	
	private List<Integer> notatr;
	private List<Integer> notaint;
	private List<String> dnitr;
	private List<String> dniint;
	
	private List<Integer> idrel;
	private List<Integer> idrelint;
	
	private List<CompValoraciones> listaValoraciones;
	
	private String dniActual;
	
	{
        setGrantRequired("PUBLIC"); // Esto se puede cambiar, según interese la seguridad
    }
	
	public Date fechaActual() {
		
			Date fecha = new Date();
			try {
				SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
		        String fechaHoy=formateador.format(fecha);
		        fecha = formateador.parse(fechaHoy);
		        return fecha;
			}
			catch (ParseException e){
				return fecha;
			}
	        

	        
	}
	
    public String mis() {
    	//List<CompEvaluaciones> listaEvaluaciones = new List<CompEvaluaciones>();
    	
    	List<CompEvaluaciones> todasEvaluaciones=evaluacionesDao.findAll(); //DEBERIA DEVOLVER SOLO MIS EVALUACIONES
    	dniActual=user.getIdd();
    	CompTrabajadores trabajador=trabajadoresDao.trabajador(dniActual);
    	String catCompetencial=trabajador.getCatcompetencial();
//    	Integer idActual=4; //DEBERIA PONER EL ID ACTUAL
    	misPares=organigramasDao.findParesTrabajador(dniActual);
        misSuperiores=organigramasDao.findSuperioresTrabajador(dniActual);
    	evaluadoresInternos=evaluadoresDao.findByEvaluadorInt(dniActual);
//    	evaluadoresExternos=evaluadoresDao.findByEvaluadorExt(dniActual);
    	listaEvaluaciones=new ArrayList<CompEvaluaciones>();
    	for(int i=0;i<todasEvaluaciones.size();i++) {
    		
    		//SOLO COMPRUEBA SI ES AUTOEVALUACION
    		if(todasEvaluaciones.get(i).getCatcompetencial()!= null && todasEvaluaciones.get(i).getCatcompetencial().equals(catCompetencial)) {
    			listaEvaluaciones.add(todasEvaluaciones.get(i));

    		}
    		else {
    			log.debug("no es autoevaluacion");
    			for(int j=0;j<misPares.size();j++) {
    				if(misPares.get(j).getDniTrabajador().equals(dniActual) ){
        				CompTrabajadores par=trabajadoresDao.trabajador(misPares.get(j).getDniPar());
        				String catPar=par.getCatcompetencial();
        				if(todasEvaluaciones.get(i).getCatcompetencial()!= null && todasEvaluaciones.get(i).getCatcompetencial().equals(catPar)) {
        					listaEvaluaciones.add(todasEvaluaciones.get(i));
        					log.debug("Es par 1 ");
        				}

        			}
    				else {
    					if(misPares.get(j).getDniPar().equals(dniActual)) {
    						CompTrabajadores par=trabajadoresDao.trabajador(misPares.get(j).getDniTrabajador());
            				String catPar=par.getCatcompetencial();
            				if(todasEvaluaciones.get(i).getCatcompetencial()!= null && todasEvaluaciones.get(i).getCatcompetencial().equals(catPar)) {
            					listaEvaluaciones.add(todasEvaluaciones.get(i));
            					log.debug("es par 2");
            				}
    						
    					}
    				
    				}
    				
    			}
    			//HACER BUCLE CON LOS SUPERIORES E INFERIORES, SI NO SE HA AÑADIDO YA
    			if (listaEvaluaciones.size()!=0 && listaEvaluaciones.get(listaEvaluaciones.size()-1).getId() !=todasEvaluaciones.get(i).getId()) {
    				for(int k=0;k<misSuperiores.size();k++) {
    					log.debug("Dentro de bucle superiores");

        				if(misSuperiores.get(k).getDniTrabajador().equals(dniActual) ){
        					log.debug("Primer if");
            				CompTrabajadores superior=trabajadoresDao.trabajador(misSuperiores.get(k).getDniSuperior());
            				String catSuperior=superior.getCatcompetencial();
            				if(todasEvaluaciones.get(i).getCatcompetencial()!= null && todasEvaluaciones.get(i).getCatcompetencial().equals(catSuperior)) {
            					listaEvaluaciones.add(todasEvaluaciones.get(i));
            					log.debug("es superior 1");
            				}

            			}
        				else {
        					if(misSuperiores.get(k).getDniSuperior().equals(dniActual)) {
        						log.debug("Segundo if");
        						CompTrabajadores superior=trabajadoresDao.trabajador(misSuperiores.get(k).getDniTrabajador());
                				String catSuperior=superior.getCatcompetencial();
                				if(todasEvaluaciones.get(i).getCatcompetencial()!= null && todasEvaluaciones.get(i).getCatcompetencial().equals(catSuperior)) {
                					listaEvaluaciones.add(todasEvaluaciones.get(i));
                					log.debug("es superior 2");
                				}
        						
        					}
        				
        				}
        				
        			} //BUCLE CON LOS EVALUADORES INTERNOS  SI NO SE HA AÑADIDO YA
    				if (listaEvaluaciones.size()!=0 && listaEvaluaciones.get(listaEvaluaciones.size()-1).getId() !=todasEvaluaciones.get(i).getId()) {
    					log.debug("dentro if internos");
    					for(int p=0;p<evaluadoresInternos.size();p++) {
    						log.debug("dentro for internos");
    						CompTrabajadores trabajador2=trabajadoresDao.trabajador(evaluadoresInternos.get(p).getDnitrabajador());
            				String cat=trabajador2.getCatcompetencial();
            				log.debug("cat: "+cat+" todasEvaluaciones.get(i).getCatcompetencial(): "+ todasEvaluaciones.get(i).getCatcompetencial());
            				if(todasEvaluaciones.get(i).getCatcompetencial()!= null && todasEvaluaciones.get(i).getCatcompetencial().equals(cat)) {
            					listaEvaluaciones.add(todasEvaluaciones.get(i));
            					log.debug("es evaluador interno");
            				}
    					}
    					//SI FUESE EVALUADOR EXTERNO HABRIA QUE COMPROBARLO CON SU ID
//    					
    					
    				}
    				
    			}
    			
    		}
    		
    	}
    	
    	mis=true;
    	listaCatCompetenciales=catCompetencialesDao.findAll();
    	listaTrabajadores = trabajadoresDao.findAll();
        
        objCompCatcomp=competenciasDao.allObjCompCatcomp();
        listaCompetencias=competenciasDao.findAll();
        fechaActual=fechaActual();
        editar=false;
        editar2=false;
        idEditar=-1;
//        listaEvaluaciones = evaluacionesDao.findAll();
//        log.debug("Devolviendo lista de pruebas: " + listaNiveles.size());
//        editar=false;
        return "evaluaciones"; // Este es el valor de retorno que struts.xml asocia a tiles.
                        // Sirve para indicar qué visualización queremos como resultado
    }
    
    public String list() {
    	listaCatCompetenciales=catCompetencialesDao.findAll();
    	listaTrabajadores = trabajadoresDao.findAll();
        listaEvaluaciones=evaluacionesDao.findAll();
        objCompCatcomp=competenciasDao.allObjCompCatcomp();
        listaCompetencias=competenciasDao.findAll();
        fechaActual=fechaActual();
        editar=false;
        editar2=false;
        mis=false;
        idEditar=-1;
        log.debug("Listará sin editar");
//        listaOrganigramas = organigramasDao.findAll();
////        log.debug("Devolviendo lista de pruebas: " + listaNiveles.size());
//        editar=false;
    	//NECESITO: listaCatCompetenciales, listaTrabajadores, listaExternos,listaCompetencias
        return "evaluaciones"; // Este es el valor de retorno que struts.xml asocia a tiles.
                        // Sirve para indicar qué visualización queremos como resultado
    }
    
    public String nueva() {
    	log.debug("Se va a añadir: "+nombre);
    	//COMPROBAR QUE PUEDE AÑADIRSE: CATCOMPETNECIAL NO ESTA SINEDO EVALUADA YA DURANTE ESE PERIODO
    	
    	idNueva=evaluacionesDao.insert(nombre, iniaportacion, finaportacion, inivalidacion, finvalidacion,iniperiodo, finperiodo, inievaluacion, finevaluacion, catcompetencial);
    	log.debug("Se ha añadido: "+nombre);
    	if(idNueva != -1) {
	    	nuevaEvaluacion=evaluacionesDao.findById(idNueva);
	    	//    	listaCatCompetenciales=catCompetencialesDao.findAll();
	    	listaTrabajadores = trabajadoresDao.findByCatcomp(catcompetencial);
	//        listaEvaluaciones=evaluacionesDao.findAll();
	    	
	        objCompCatcomp=competenciasDao.compPorCatComp(catcompetencial);
	    	editar2=true;
    	}
    	else { //NO SE HA PODIDO AÑADIR
    		log.debug("no se ha podido añadir idNueva: "+idNueva);
    		listaCatCompetenciales=catCompetencialesDao.findAll();
        	listaTrabajadores = trabajadoresDao.findAll();
            listaEvaluaciones=evaluacionesDao.findAll();
            objCompCatcomp=competenciasDao.allObjCompCatcomp();
           
            editar2=false;
            
    	}
    	 listaCompetencias=competenciasDao.findAll();
         fechaActual=fechaActual();
         editar=false;
         idEditar=-1;
	      mis=false;
    	return "evaluaciones"; 
    }
    
    public String nuevaInfo() {
    	log.debug("Se va a añadir: "+id+comp0+comp1+comp2+comp3+comp4);
//    	log.debug("PROBANDO COMPET: "+compet);
    	evaluacionesDao.insertInfo(id, comp0,comp1,comp2,comp3,comp4,comp5,comp6,comp7,comp8,comp9);
    	log.debug("Se ha añadido: "+id+comp0+comp1+comp2+comp3+comp4);
    	catcompetencial=evaluacionesDao.getCatcompetencial(id);
    	listaCatCompetenciales=catCompetencialesDao.findAll();
    	listaTrabajadores = trabajadoresDao.findByCatcomp(catcompetencial);
        listaEvaluaciones=evaluacionesDao.findAll();
        objCompCatcomp=competenciasDao.compPorCatComp(catcompetencial);
        listaCompetencias=competenciasDao.findAll();
        fechaActual=fechaActual();
    	editar=false;
    	editar2=false;
    	mis=false;
        idEditar=-1;
    	return "evaluaciones"; 
    }
    public String editar() {
    	listaCatCompetenciales=catCompetencialesDao.findAll();
    	listaTrabajadores = trabajadoresDao.findAll();
        listaEvaluaciones=evaluacionesDao.findAll();
        catcompetencial=evaluacionesDao.getCatcompetencial(id);
        objCompCatcomp=competenciasDao.compPorCatComp(catcompetencial);
        listaCompetencias=competenciasDao.findAll();
        fechaActual=fechaActual();
    	editar=true;
    	 editar2=false;
    	 mis=false;
    	idEditar=id;
    	return "evaluaciones"; 
    }
    public String guardar() {
    	log.debug("se va a guardar elemento con id: "+id);
    	evaluacionesDao.guardar(id, nombre, iniaportacion, finaportacion, inivalidacion, finvalidacion,iniperiodo, finperiodo, inievaluacion, finevaluacion, 
    			catcompetencial, comp0,comp1, comp2, comp3, comp4, comp5, comp6, comp7, comp8, comp9);
    	listaCatCompetenciales=catCompetencialesDao.findAll();
    	listaTrabajadores = trabajadoresDao.findAll();
        listaEvaluaciones=evaluacionesDao.findAll();
        catcompetencial=evaluacionesDao.getCatcompetencial(id);
        objCompCatcomp=competenciasDao.compPorCatComp(catcompetencial);
        listaCompetencias=competenciasDao.findAll();
        fechaActual=fechaActual();
    	editar=false;
    	 editar2=false;
    	 mis=false;
        idEditar=-1;
    	return "evaluaciones"; 
    }
    
    public String concreta() {
    	log.debug("se va a evaluar evaluacion con id: "+id);
    	// Sacar la catcompetencial que se evalua en la evaluacion con id id
    	// buscar de tus pares, superiores, inferiores, etc quienes tienen catcompetnecial y añadirlos a la lista de trabjaadores a evaluar
    	evaluacionActual=evaluacionesDao.findById(id);
    	String cat=evaluacionActual.getCatcompetencial();
    	dniActual=user.getIdd();
    	CompTrabajadores yo=trabajadoresDao.trabajador(dniActual);
    	String catCompYo=yo.getCatcompetencial();
//    	Integer idActual=4; //DEBERIA PONER EL ID ACTUAL
    	misPares=organigramasDao.findParesTrabajador(dniActual);
        misSuperiores=organigramasDao.findSuperioresTrabajador(dniActual);
    	evaluadoresInternos=evaluadoresDao.findByEvaluadorInt(dniActual);
    	listaTrabajadoresAll = trabajadoresDao.findAll();
    	listaTrabajadores=new ArrayList<CompTrabajadores>();
//    	meHanElegido=new ArrayList<CompEvaluadorInterno>();
    	
    	//COMPRUEBA SI ES AUTOEVALUACION
    	log.debug("catcompyo: "+catCompYo+" cat: "+cat);
    	if(catCompYo.equals(cat)) {
    		
    		listaTrabajadores.add(yo);
    		
    	}
    	
    	//COMPRUEBA SI HAY PARES QUE EVALUAR
    	for(int i=0;i<misPares.size();i++) {
    		if(misPares.get(i).getDniTrabajador().equals(dniActual)) {
    			log.debug("DENTRO PAR 1");
    			String dniP=misPares.get(i).getDniPar();
    			CompTrabajadores par=trabajadoresDao.trabajador(dniP);
    			if(par.getCatcompetencial().equals(cat)) {
    				listaTrabajadores.add(par);
    			}
    		}
    		else {
    			if(misPares.get(i).getDniPar().equals(dniActual)) {
    				log.debug("DENTRO PAR 2");
    				String dniP=misPares.get(i).getDniTrabajador();
        			CompTrabajadores par=trabajadoresDao.trabajador(dniP);
        			if(par.getCatcompetencial().equals(cat)) {
        				listaTrabajadores.add(par);
        			}
    			}
    			
    		}
    			
    	}
    	
    	//COMPRUEBA SI HAY SUPERIORES/INFERIORES QUE EVALUAR
    	for(int i=0;i<misSuperiores.size();i++) {
    		if(misSuperiores.get(i).getDniTrabajador().equals(dniActual)) {
    			log.debug("DENTRO sup 1");
    			String dniS=misSuperiores.get(i).getDniSuperior();
    			CompTrabajadores sup=trabajadoresDao.trabajador(dniS);
    			if(sup.getCatcompetencial().equals(cat)) {
    				listaTrabajadores.add(sup);
    			}
    		}
    		else {
    			if(misSuperiores.get(i).getDniSuperior().equals(dniActual)) {
    				log.debug("DENTRO sup 2");
    				String dniS=misSuperiores.get(i).getDniTrabajador();
        			CompTrabajadores sup=trabajadoresDao.trabajador(dniS);
        			if(sup.getCatcompetencial().equals(cat)) {
        				listaTrabajadores.add(sup);
        			}
    			}
    			
    		}
    			
    	}
    	
    	//COMPRPBAR EN LISTA DE EVALUADORES INTERNOS, Y AÑADIR AQUELLOS DE LOS CUALES TU SEAS EVALUADOR
//    	for(int i=0;i<evaluadoresInternos.size();i++) {
//    	
//    			log.debug("DENTRO sup 1");
//    			String dniT=evaluadoresInternos.get(i).getDnitrabajador();
//    			CompTrabajadores tr=trabajadoresDao.trabajador(dniT);
//    			if(tr.getCatcompetencial().equals(cat)) {
//    				listaTrabajadores.add(tr);
//    			}
//	
//    	}
    	
    	listaCompetencias=new ArrayList<CompCompetencias>();
    	String nueva=evaluacionActual.getComp1();
    	List<CompCompetencias> nuevaComp=competenciasDao.findByCodigo(nueva);
    	if (nuevaComp.size() !=0) {
    		listaCompetencias.add(nuevaComp.get(0));
    	}
    	
    	nueva=evaluacionActual.getComp2();
    	nuevaComp=competenciasDao.findByCodigo(nueva);
    	if (nuevaComp.size() !=0) {
    		listaCompetencias.add(nuevaComp.get(0));
    	}
    	nueva=evaluacionActual.getComp3();
    	nuevaComp=competenciasDao.findByCodigo(nueva);
    	if (nuevaComp.size() !=0) {
    		listaCompetencias.add(nuevaComp.get(0));
    	}
    	nueva=evaluacionActual.getComp4();
    	nuevaComp=competenciasDao.findByCodigo(nueva);
    	if (nuevaComp.size() !=0) {
    		listaCompetencias.add(nuevaComp.get(0));
    	}
    	nueva=evaluacionActual.getComp5();
    	nuevaComp=competenciasDao.findByCodigo(nueva);
    	if (nuevaComp.size() !=0) {
    		listaCompetencias.add(nuevaComp.get(0));
    	}
    	nueva=evaluacionActual.getComp6();
    	nuevaComp=competenciasDao.findByCodigo(nueva);
    	if (nuevaComp.size() !=0) {
    		listaCompetencias.add(nuevaComp.get(0));
    	}
    	nueva=evaluacionActual.getComp7();
    	nuevaComp=competenciasDao.findByCodigo(nueva);
    	if (nuevaComp.size() !=0) {
    		listaCompetencias.add(nuevaComp.get(0));
    	}
    	nueva=evaluacionActual.getComp8();
    	nuevaComp=competenciasDao.findByCodigo(nueva);
    	if (nuevaComp.size() !=0) {
    		listaCompetencias.add(nuevaComp.get(0));
    	}
    	nueva=evaluacionActual.getComp9();
    	nuevaComp=competenciasDao.findByCodigo(nueva);
    	if (nuevaComp.size() !=0) {
    		listaCompetencias.add(nuevaComp.get(0));
    	}
    	nueva=evaluacionActual.getComp10();
    	nuevaComp=competenciasDao.findByCodigo(nueva);
    	if (nuevaComp.size() !=0) {
    		listaCompetencias.add(nuevaComp.get(0));
    	}
    	log.debug("listaCompetencias "+listaCompetencias.size());
    	log.debug("cat "+cat);
    	compRelCompCompleto=competenciasDao.relacionesPorCatComp(cat);
    	log.debug("compRelCompCompleto: "+compRelCompCompleto.size()+compRelCompCompleto);
    	
    	listaValoraciones=evaluacionesDao.valoracionesPorIdEvaluacion(id);
    	log.debug("listaValoraciones: "+listaValoraciones.size()+listaValoraciones);
    	
    	return "evaluacionConcreta";
    }

    public String guardarValoracion() {
    	log.debug("idEvaluacion (id): "+id);
    	dniActual=user.getIdd();
    	log.debug("dniEvaluador (dniActual): "+dniActual);
    	if(notaint!=null && notaint.size()!=0) {
    		//HACER LO QUE SEA CON LOS DATOS
    		log.debug("notaint "+notaint.size()+notaint);
    	}
    	if(notatr!=null && notatr.size()!=0) {
    		//HACER LO QUE SEA CON LOS DATOS
    		log.debug("notatr "+notatr.size()+notatr);
   
    	}
    	
    	if(dniint!=null && dniint.size()!=0) {
    		//HACER LO QUE SEA CON LOS DATOS
    		log.debug("dniint "+dniint.size()+dniint);
   
    	}
    	if(dnitr!=null && dnitr.size()!=0) {
    		//HACER LO QUE SEA CON LOS DATOS
    		log.debug("dnitr "+dnitr.size()+dnitr);
    	
    	}
    	if(idrel!=null && idrel.size()!=0) {
    		//HACER LO QUE SEA CON LOS DATOS
    		log.debug("idrel "+idrel.size()+idrel);
    	
    	}
    	if(idrelint!=null && idrelint.size()!=0) {
    		//HACER LO QUE SEA CON LOS DATOS
    		log.debug("idrelint "+idrelint.size()+idrelint);
    	
    	}
    	if (notatr !=null) {
	    	for (int i=0; i<notatr.size();i++) {
	    		Integer idRelacion=idrel.get(i);
	    		Integer nota=notatr.get(i);
	    		String dniEvaluado=dnitr.get(i);
	    		//dniEvaluador es dniActual
	    		//idEvaluacion es id
	    		evaluacionesDao.insertValoracion(id, dniActual, dniEvaluado, idRelacion, nota);
	    		
	    	}
    	}
    	
    	if (notaint !=null) {
	    	for (int i=0; i<notaint.size();i++) {
	    		Integer idRelacion=idrelint.get(i);
	    		Integer nota=notaint.get(i);
	    		String dniEvaluado=dniint.get(i);
	    		//dniEvaluador es dniActual
	    		//idEvaluacion es id
	    		evaluacionesDao.insertValoracion(id, dniActual, dniEvaluado, idRelacion, nota);
	    		
	    	}
    	}
    	
    	
    	return concreta();
    }

	public List<CompCompetencias> getListaCompetencias() {
		return listaCompetencias;
	}

	public void setListaCompetencias(List<CompCompetencias> listaCompetencias) {
		this.listaCompetencias = listaCompetencias;
	}

	public List<CompObjetivosCompCatcomp> getCompObjCompCatcomp() {
		return compObjCompCatcomp;
	}

	public void setCompObjCompCatcomp(List<CompObjetivosCompCatcomp> compObjCompCatcomp) {
		this.compObjCompCatcomp = compObjCompCatcomp;
	}

	public List<CompTrabajadores> getListaTrabajadores() {
		return listaTrabajadores;
	}

	public void setListaTrabajadores(List<CompTrabajadores> listaTrabajadores) {
		this.listaTrabajadores = listaTrabajadores;
	}

	public List<CompCatCompetenciales> getListaCatCompetenciales() {
		return listaCatCompetenciales;
	}

	public void setListaCatCompetenciales(List<CompCatCompetenciales> listaCatCompetenciales) {
		this.listaCatCompetenciales = listaCatCompetenciales;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getCatcompetencial() {
		return catcompetencial;
	}

	public void setCatcompetencial(String catcompetencial) {
		this.catcompetencial = catcompetencial;
	}

	public String getComp1() {
		return comp1;
	}

	public void setComp1(String comp1) {
		this.comp1 = comp1;
	}

	public String getComp2() {
		return comp2;
	}

	public void setComp2(String comp2) {
		this.comp2 = comp2;
	}

	public String getComp3() {
		return comp3;
	}

	public void setComp3(String comp3) {
		this.comp3 = comp3;
	}

	public String getComp4() {
		return comp4;
	}

	public void setComp4(String comp4) {
		this.comp4 = comp4;
	}

	public String getComp5() {
		return comp5;
	}

	public void setComp5(String comp5) {
		this.comp5 = comp5;
	}

	public String getComp6() {
		return comp6;
	}

	public void setComp6(String comp6) {
		this.comp6 = comp6;
	}

	public String getComp7() {
		return comp7;
	}

	public void setComp7(String comp7) {
		this.comp7 = comp7;
	}

	public String getComp8() {
		return comp8;
	}

	public void setComp8(String comp8) {
		this.comp8 = comp8;
	}

	public String getComp9() {
		return comp9;
	}

	public void setComp9(String comp9) {
		this.comp9 = comp9;
	}


	public List<CompEvaluaciones> getListaEvaluaciones() {
		return listaEvaluaciones;
	}

	public void setListaEvaluaciones(List<CompEvaluaciones> listaEvaluaciones) {
		this.listaEvaluaciones = listaEvaluaciones;
	}

	public Boolean getEditar() {
		return editar;
	}

	public void setEditar(Boolean editar) {
		this.editar = editar;
	}

	public Integer getIdEditar() {
		return idEditar;
	}

	public void setIdEditar(Integer idEditar) {
		this.idEditar = idEditar;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<CompObjetivosCompCatcomp> getObjCompCatcomp() {
		return objCompCatcomp;
	}

	public void setObjCompCatcomp(List<CompObjetivosCompCatcomp> objCompCatcomp) {
		this.objCompCatcomp = objCompCatcomp;
	}

	public Boolean getEditar2() {
		return editar2;
	}

	public void setEditar2(Boolean editar2) {
		this.editar2 = editar2;
	}

	public Integer getIdNueva() {
		return idNueva;
	}

	public void setIdNueva(Integer idNueva) {
		this.idNueva = idNueva;
	}

	public CompEvaluaciones getNuevaEvaluacion() {
		return nuevaEvaluacion;
	}

	public void setNuevaEvaluacion(CompEvaluaciones nuevaEvaluacion) {
		this.nuevaEvaluacion = nuevaEvaluacion;
	}

	public String getComp0() {
		return comp0;
	}

	public void setComp0(String comp0) {
		this.comp0 = comp0;
	}

	public CompEvaluaciones getEvaluacionActual() {
		return evaluacionActual;
	}

	public void setEvaluacionActual(CompEvaluaciones evaluacionActual) {
		this.evaluacionActual = evaluacionActual;
	}

	public Boolean getMis() {
		return mis;
	}

	public void setMis(Boolean mis) {
		this.mis = mis;
	}

	public List<CompPares> getMisPares() {
		return misPares;
	}

	public void setMisPares(List<CompPares> misPares) {
		this.misPares = misPares;
	}

	public List<CompSuperiores> getMisSuperiores() {
		return misSuperiores;
	}

	public void setMisSuperiores(List<CompSuperiores> misSuperiores) {
		this.misSuperiores = misSuperiores;
	}

	public List<CompEvaluadorExterno> getEvaluadoresExternos() {
		return evaluadoresExternos;
	}

	public void setEvaluadoresExternos(List<CompEvaluadorExterno> evaluadoresExternos) {
		this.evaluadoresExternos = evaluadoresExternos;
	}

	public List<CompEvaluadorInterno> getEvaluadoresInternos() {
		return evaluadoresInternos;
	}

	public void setEvaluadoresInternos(List<CompEvaluadorInterno> evaluadoresInternos) {
		this.evaluadoresInternos = evaluadoresInternos;
	}

	public List<String> getCompet() {
		return compet;
	}

	public void setCompet(List<String> compet) {
		this.compet = compet;
	}


	public List<CompRelCompCompleto> getCompRelCompCompleto() {
		return compRelCompCompleto;
	}

	public void setCompRelCompCompleto(List<CompRelCompCompleto> compRelCompCompleto) {
		this.compRelCompCompleto = compRelCompCompleto;
	}

	public List<CompEvaluadorInterno> getMeHanElegido() {
		return meHanElegido;
	}

	public void setMeHanElegido(List<CompEvaluadorInterno> meHanElegido) {
		this.meHanElegido = meHanElegido;
	}

	public List<CompTrabajadores> getListaTrabajadoresAll() {
		return listaTrabajadoresAll;
	}

	public void setListaTrabajadoresAll(List<CompTrabajadores> listaTrabajadoresAll) {
		this.listaTrabajadoresAll = listaTrabajadoresAll;
	}

	public List<String> getDnitr() {
		return dnitr;
	}

	public void setDnitr(List<String> dnitr) {
		this.dnitr = dnitr;
	}

	public List<String> getDniint() {
		return dniint;
	}

	public void setDniint(List<String> dniint) {
		this.dniint = dniint;
	}

	public List<String> getCompetint() {
		return competint;
	}

	public void setCompetint(List<String> competint) {
		this.competint = competint;
	}

	public List<Integer> getComport() {
		return comport;
	}

	public void setComport(List<Integer> comport) {
		this.comport = comport;
	}

	public List<Integer> getComportint() {
		return comportint;
	}

	public void setComportint(List<Integer> comportint) {
		this.comportint = comportint;
	}

	public List<Integer> getNotatr() {
		return notatr;
	}

	public void setNotatr(List<Integer> notatr) {
		this.notatr = notatr;
	}

	public List<Integer> getNotaint() {
		return notaint;
	}

	public void setNotaint(List<Integer> notaint) {
		this.notaint = notaint;
	}

	public List<Integer> getIdrel() {
		return idrel;
	}

	public void setIdrel(List<Integer> idrel) {
		this.idrel = idrel;
	}

	public List<Integer> getIdrelint() {
		return idrelint;
	}

	public void setIdrelint(List<Integer> idrelint) {
		this.idrelint = idrelint;
	}

	public List<CompValoraciones> getListaValoraciones() {
		return listaValoraciones;
	}

	public void setListaValoraciones(List<CompValoraciones> listaValoraciones) {
		this.listaValoraciones = listaValoraciones;
	}

	public String getDniActual() {
		return dniActual;
	}

	public void setDniActual(String dniActual) {
		this.dniActual = dniActual;
	}

	public Date getIniaportacion() {
		return iniaportacion;
	}

	public void setIniaportacion(Date iniaportacion) {
		this.iniaportacion = iniaportacion;
	}

	public Date getFinaportacion() {
		return finaportacion;
	}

	public void setFinaportacion(Date finaportacion) {
		this.finaportacion = finaportacion;
	}

	public Date getInivalidacion() {
		return inivalidacion;
	}

	public void setInivalidacion(Date inivalidacion) {
		this.inivalidacion = inivalidacion;
	}

	public Date getFinvalidacion() {
		return finvalidacion;
	}

	public void setFinvalidacion(Date finvalidacion) {
		this.finvalidacion = finvalidacion;
	}

	public Date getIniperiodo() {
		return iniperiodo;
	}

	public void setIniperiodo(Date iniperiodo) {
		this.iniperiodo = iniperiodo;
	}

	public Date getFinperiodo() {
		return finperiodo;
	}

	public void setFinperiodo(Date finperiodo) {
		this.finperiodo = finperiodo;
	}

	public Date getInievaluacion() {
		return inievaluacion;
	}

	public void setInievaluacion(Date inievaluacion) {
		this.inievaluacion = inievaluacion;
	}

	public Date getFinevaluacion() {
		return finevaluacion;
	}

	public void setFinevaluacion(Date finevaluacion) {
		this.finevaluacion = finevaluacion;
	}

	public Date getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}





	
	
}
