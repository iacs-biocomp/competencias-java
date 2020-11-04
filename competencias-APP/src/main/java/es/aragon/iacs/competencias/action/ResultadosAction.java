package es.aragon.iacs.competencias.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import es.aragon.midas.action.MidasActionSupport;
import javax.ejb.EJB;
import es.aragon.iacs.competencias.jpa.CompEvaluaciones;
import es.aragon.iacs.competencias.jpa.CompValoraciones;
import es.aragon.iacs.competencias.jpa.CompTrabajadores;
import es.aragon.iacs.competencias.jpa.CompSuperiores;
import es.aragon.iacs.competencias.jpa.CompPares;
import es.aragon.iacs.competencias.jpa.CompNiveles;
import es.aragon.iacs.competencias.jpa.CompCompetencias;
import es.aragon.iacs.competencias.jpa.CompEvaluadorInterno;
import es.aragon.iacs.competencias.dao.ICompEvaluacionesDAO;
import es.aragon.iacs.competencias.dao.ICompTrabajadoresDAO;
import es.aragon.iacs.competencias.dao.ICompEvaluadoresDAO;
import es.aragon.iacs.competencias.dao.ICompOrganigramasDAO;
import es.aragon.iacs.competencias.dao.ICompNivelesDAO;
import es.aragon.iacs.competencias.dao.ICompResultadosDAO;
import es.aragon.iacs.competencias.dao.ICompCompetenciasDAO;
import es.aragon.iacs.competencias.jpa.CompResultados;

public class ResultadosAction extends MidasActionSupport{
	private static final long serialVersionUID = 2108264332221967943L;
	private String dniActual;
	private Integer id;
	
    @EJB(name="CompEvaluacionesDAO")
    private ICompEvaluacionesDAO evaluacionesDao;
    private CompEvaluaciones evaluacionActual;
    private List<CompEvaluaciones> listaEvaluaciones;
    
    @EJB(name="CompTrabajadoresDAO")
    private ICompTrabajadoresDAO trabajadoresDao;
	
    @EJB(name="CompEvaluadoresDAO")
    private ICompEvaluadoresDAO evaluadoresDao;
    
    @EJB(name="CompOrganigramasDAO")
    private ICompOrganigramasDAO organigramasDao;
    
    @EJB(name="CompNivelesDAO")
    private ICompNivelesDAO nivelesDao;
    
    @EJB(name="CompResultadosDAO")
    private ICompResultadosDAO resultadosDao;
    
    @EJB(name="CompCompetenciasDAO")
    private ICompCompetenciasDAO competenciasDao;
    List<CompCompetencias> listaCompetencias;
    
    List<CompNiveles> niveles;
    List<CompTrabajadores> evaluados;
    List<CompCompetencias> competencias;
    
    List<CompResultados> resultados;
    
    private boolean editar;
    private boolean editar2;
    private boolean mis;
    private Date fechaActual;
	{
        setGrantRequired("PUBLIC"); // Esto se puede cambiar, según interese la seguridad
    }
    
//	public Date fechaActual() {
//		
//		Date fecha = new Date();
//		try {
//			SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
//	        String fechaHoy=formateador.format(fecha);
//	        fecha = formateador.parse(fechaHoy);
//	        return fecha;
//		}
//		catch (ParseException e){
//			return fecha;
//		}     
//	}
//	

    
    public String mis() {
    	dniActual=user.getIdd();
    	CompTrabajadores trabajador=trabajadoresDao.trabajador(dniActual);
    	evaluados=new ArrayList<CompTrabajadores>();
    	evaluados.add(trabajador);
    	competencias=competenciasDao.findAll();
    	niveles=nivelesDao.findActivos();
    	evaluacionActual=evaluacionesDao.findById(id);
    	String catcomp=evaluacionActual.getCatcompetencial();
    	resultados=resultadosDao.evaluacionCalculada(id);
    	
    	
    	return "resultadosConcretos";
    }
    
    public String calcular() {
    	competencias=competenciasDao.findAll();
    	//cojo la lista con todos los niveles activos
    	niveles=nivelesDao.findActivos();
    	log.debug("Se van a calcular los resultados de la evaluacion con id: "+id);
    	//Busco la evaluacion con id id
    	evaluacionActual=evaluacionesDao.findById(id);
    	//Busco la catcomp de la evaluacion
    	String catcomp=evaluacionActual.getCatcompetencial();
    	//Busco los trabajadores que tieen catcomp catcomp
    	evaluados=trabajadoresDao.findByCatcomp(catcomp);
    	//Que busque si ya ha sido calculada, en cuyo caso mostrara los resultados sin volver a calcularla
    	resultados=resultadosDao.evaluacionCalculada(id);
    	
    	if(resultados==null) {
    		
	    	
	    	//Busco todas las valoraciones de la evaluacion con id id
	    	List<CompValoraciones> listaValoraciones=evaluacionesDao.valoracionesPorIdEvaluacion(id);
	    	
	    	//Bucle para cada trabajador encontrado para calcular sus resultados
	    	for(int i=0;i<evaluados.size();i++) {
	    		log.debug("Evaluado: "+evaluados.get(i));
	    		//Para cada trabajador necesito saber (para calcular un resultado por cada grupo):
	    		//SU DNI
	    		String dniEvaluado=evaluados.get(i).getDni();
	    		log.debug("dniEvaluado: "+dniEvaluado);
	    		for(int j=0;j<listaValoraciones.size();j++) {
	    			//miro si es su dni
	    			if(listaValoraciones.get(j).getDnievaluado().equals(dniEvaluado) && listaValoraciones.get(j).getDnievaluador().equals(dniEvaluado)) {
	    				//Habrá que añadir a la variable suma de esa competencia y nivel, la valoracion y sumo uno al nº de valoraciones de esa competencia y nivel
	    				log.debug("1");
	    				
	    				resultadosDao.sumarValoracion(id,dniEvaluado, 1, listaValoraciones.get(j).getCodcomp(),listaValoraciones.get(j).getIdnivel(), listaValoraciones.get(j).getValoracion());
	    			}
	    		}
	    		//SUS JEFES
	    		List<CompSuperiores> superiores=organigramasDao.findSuperioresByTrabajador(dniEvaluado);
	    		log.debug("superiores: "+superiores.size()+superiores);
	    		for (int k=0;k<superiores.size();k++) {
	    			String dniSuperior=superiores.get(k).getDniSuperior();
	    			for(int j=0;j<listaValoraciones.size();j++) {
	        			//miro si es su dni
	        			if(listaValoraciones.get(j).getDnievaluado().equals(dniEvaluado) && listaValoraciones.get(j).getDnievaluador().equals(dniSuperior)) {
	        				//Habrá que añadir a la variable suma de esa competencia y nivel, la valoracion y sumo uno al nº de valoraciones de esa competencia y nivel
	        				log.debug("2");
	        				
	        				resultadosDao.sumarValoracion(id,dniEvaluado, 2, listaValoraciones.get(j).getCodcomp(),listaValoraciones.get(j).getIdnivel(), listaValoraciones.get(j).getValoracion());
	        			}
	        		}
	    			
	    		}
	    		//SUS INFERIORES
	    		List<CompSuperiores> inferiores=organigramasDao.findSuperioresBySuperior(dniEvaluado);
	    		log.debug("inferiores: "+inferiores.size()+inferiores);
	    		for (int k=0;k<inferiores.size();k++) {
	    			String dniInferior=inferiores.get(k).getDniTrabajador();
	    			for(int j=0;j<listaValoraciones.size();j++) {
	        			//miro si es su dni
	        			if(listaValoraciones.get(j).getDnievaluado().equals(dniEvaluado) && listaValoraciones.get(j).getDnievaluador().equals(dniInferior)) {
	        				//Habrá que añadir a la variable suma de esa competencia y nivel, la valoracion y sumo uno al nº de valoraciones de esa competencia y nivel
	        				log.debug("3");
	        				
	        				resultadosDao.sumarValoracion(id,dniEvaluado, 3, listaValoraciones.get(j).getCodcomp(),listaValoraciones.get(j).getIdnivel(), listaValoraciones.get(j).getValoracion());
	        			}
	        		}
	    			
	    		}
	    		
	    		
	    		//SUS PARES
	    		List<CompPares> pares=organigramasDao.findParesTrabajador(dniEvaluado);
	    		log.debug("pares: "+pares.size()+pares);
	    		for (int k=0;k<pares.size();k++) {
	    			if(pares.get(k).getDniPar().equals(dniEvaluado)) {
	    				//EL par es dnitrabajador
	    				String dniPar=pares.get(k).getDniTrabajador();
	    				for(int j=0;j<listaValoraciones.size();j++) {
	            			//miro si es su dni
	            			if(listaValoraciones.get(j).getDnievaluado().equals(dniEvaluado) && listaValoraciones.get(j).getDnievaluador().equals(dniPar)) {
	            				//Habrá que añadir a la variable suma de esa competencia y nivel, la valoracion y sumo uno al nº de valoraciones de esa competencia y nivel
	            				log.debug("4_1");
	            				
	            				resultadosDao.sumarValoracion(id,dniEvaluado, 4, listaValoraciones.get(j).getCodcomp(),listaValoraciones.get(j).getIdnivel(), listaValoraciones.get(j).getValoracion());
	            			}
	            		}
	    				
	    				
	    				
	    			}else {//EL par es dniPar
	    				String dniPar=pares.get(k).getDniPar();
	    				for(int j=0;j<listaValoraciones.size();j++) {
	            			//miro si es su dni
	            			if(listaValoraciones.get(j).getDnievaluado().equals(dniEvaluado) && listaValoraciones.get(j).getDnievaluador().equals(dniPar)) {
	            				//Habrá que añadir a la variable suma de esa competencia y nivel, la valoracion y sumo uno al nº de valoraciones de esa competencia y nivel
	            				log.debug("4_2");
	            				
	            				resultadosDao.sumarValoracion(id,dniEvaluado, 4, listaValoraciones.get(j).getCodcomp(),listaValoraciones.get(j).getIdnivel(), listaValoraciones.get(j).getValoracion());
	            			}
	            		}
	    			}
	    			
	    			
	    			
	    		}
	    		//SUS ELEGIDOS (SEPARAR GRUPO 1 Y GRUPO 2)
	    		
	    		List<CompEvaluadorInterno> evaluadores1= evaluadoresDao.findInternos(dniEvaluado, id,1);
	    		log.debug("evaluadores1: "+evaluadores1.size()+evaluadores1);
	    		for (int k=0;k<evaluadores1.size();k++) {
	    			String dniEvaluador=evaluadores1.get(k).getDnievaluador();
	    			for(int j=0;j<listaValoraciones.size();j++) {
	        			//miro si es su dni
	        			if(listaValoraciones.get(j).getDnievaluado().equals(dniEvaluado) && listaValoraciones.get(j).getDnievaluador().equals(dniEvaluador)) {
	        				//Habrá que añadir a la variable suma de esa competencia y nivel, la valoracion y sumo uno al nº de valoraciones de esa competencia y nivel
	        				log.debug("4_3");
	        				
	        				resultadosDao.sumarValoracion(id,dniEvaluado, 4, listaValoraciones.get(j).getCodcomp(),listaValoraciones.get(j).getIdnivel(), listaValoraciones.get(j).getValoracion());
	        			}
	        		}
	    			
	    		}
	    		
	    		
	    		List<CompEvaluadorInterno> evaluadores2= evaluadoresDao.findInternos(dniEvaluado, id,2);
	    		log.debug("evaluadores2: "+evaluadores2.size()+evaluadores2);
	    		
	    		for (int k=0;k<evaluadores2.size();k++) {
	    			String dniEvaluador=evaluadores2.get(k).getDnievaluador();
	    			for(int j=0;j<listaValoraciones.size();j++) {
	        			//miro si es su dni
	        			if(listaValoraciones.get(j).getDnievaluado().equals(dniEvaluado) && listaValoraciones.get(j).getDnievaluador().equals(dniEvaluador)) {
	        				//Habrá que añadir a la variable suma de esa competencia y nivel, la valoracion y sumo uno al nº de valoraciones de esa competencia y nivel
	        				log.debug("5");
	        				
	        				resultadosDao.sumarValoracion(id,dniEvaluado, 5, listaValoraciones.get(j).getCodcomp(),listaValoraciones.get(j).getIdnivel(), listaValoraciones.get(j).getValoracion());
	        			}
	        		}
	    			
	    		}
	    		
	    		
	    		//BUCLE PARA CALCULAR EL PROMEDIO EN CADA CASO
	    		//Bucle para cada trabajador encontrado para calcular sus resultados
		    	for(int a=0;a<evaluados.size();a++) {
		    		log.debug("bucle evaluados");
		    		dniEvaluado=evaluados.get(a).getDni();
		    		resultados=resultadosDao.evaluacionCalculada(id);
		    		for(int j=0;j<competencias.size();j++){
		    			for(int k=0;k<niveles.size();k++) {
		    				float promedio=0.0f;
		    				boolean evaluado=false;
		    				//Para cada grupo busca las correspondientes, y añade una que sea el promedio
		    				for(int t=0;t<resultados.size();t++) {
//		    					log.debug("dentro bucle resultados");
		    					if(resultados.get(t).getGrupoev()==1 && resultados.get(t).getDnievaluado().equals(dniEvaluado) && resultados.get(t).getIdnivel()==niveles.get(k).getId() && resultados.get(t).getCodcomp().equals(competencias.get(j).getCodigo())) {
		    						log.debug("pongo evaluado a true");
		    						//sumas el valor suma aplicando el valorporcentual del nivel (preguntar vega)
		    						evaluado=true;
		    					}
		    					if(resultados.get(t).getGrupoev()==2 && resultados.get(t).getDnievaluado().equals(dniEvaluado) && resultados.get(t).getIdnivel()==niveles.get(k).getId() && resultados.get(t).getCodcomp().equals(competencias.get(j).getCodigo())) {
		    						//sumas el valor suma aplicando el valorporcentual del nivel (preguntar vega)
		    						log.debug("pongo evaluado a true");
		    						evaluado=true;
		    					}
		    					if(resultados.get(t).getGrupoev()==3 && resultados.get(t).getDnievaluado().equals(dniEvaluado) && resultados.get(t).getIdnivel()==niveles.get(k).getId() && resultados.get(t).getCodcomp().equals(competencias.get(j).getCodigo())) {
		    						//sumas el valor suma aplicando el valorporcentual del nivel (preguntar vega)
		    						log.debug("pongo evaluado a true");
		    						evaluado=true;
		    					}
		    					if(resultados.get(t).getGrupoev()==4 && resultados.get(t).getDnievaluado().equals(dniEvaluado) && resultados.get(t).getIdnivel()==niveles.get(k).getId() && resultados.get(t).getCodcomp().equals(competencias.get(j).getCodigo())) {
		    						//sumas el valor suma aplicando el valorporcentual del nivel (preguntar vega)
		    						log.debug("pongo evaluado a true");
		    						evaluado=true;
		    					}
		    					if(resultados.get(t).getGrupoev()==5 && resultados.get(t).getDnievaluado().equals(dniEvaluado) && resultados.get(t).getIdnivel()==niveles.get(k).getId() && resultados.get(t).getCodcomp().equals(competencias.get(j).getCodigo())) {
		    						//sumas el valor suma aplicando el valorporcentual del nivel (preguntar vega)
		    						log.debug("pongo evaluado a true");
		    						evaluado=true;
		    					}
		    					
		    				}
		    				if(evaluado) {
		    					log.debug("voy a añadir el promedio");
		    					resultadosDao.sumarValoracion(id,dniEvaluado,niveles.get(k).getId(),competencias.get(j).getCodigo(),-1, promedio);
		    				}
		    				
		    				
		    				
		    			}
		    			
		    		}
		    	}	
	    		
	    		
	    	}
	    	resultados=resultadosDao.evaluacionCalculada(id);
    	}
    	return "resultadosConcretos";
    }

	public String getDniActual() {
		return dniActual;
	}

	public void setDniActual(String dniActual) {
		this.dniActual = dniActual;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public CompEvaluaciones getEvaluacionActual() {
		return evaluacionActual;
	}

	public void setEvaluacionActual(CompEvaluaciones evaluacionActual) {
		this.evaluacionActual = evaluacionActual;
	}

	public List<CompResultados> getResultados() {
		return resultados;
	}

	public void setResultados(List<CompResultados> resultados) {
		this.resultados = resultados;
	}

	public List<CompNiveles> getNiveles() {
		return niveles;
	}

	public void setNiveles(List<CompNiveles> niveles) {
		this.niveles = niveles;
	}

	public List<CompTrabajadores> getEvaluados() {
		return evaluados;
	}

	public void setEvaluados(List<CompTrabajadores> evaluados) {
		this.evaluados = evaluados;
	}

	public List<CompCompetencias> getCompetencias() {
		return competencias;
	}

	public void setCompetencias(List<CompCompetencias> competencias) {
		this.competencias = competencias;
	}

	public List<CompEvaluaciones> getListaEvaluaciones() {
		return listaEvaluaciones;
	}

	public void setListaEvaluaciones(List<CompEvaluaciones> listaEvaluaciones) {
		this.listaEvaluaciones = listaEvaluaciones;
	}

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

	public boolean isEditar2() {
		return editar2;
	}

	public void setEditar2(boolean editar2) {
		this.editar2 = editar2;
	}

	public boolean isMis() {
		return mis;
	}

	public void setMis(boolean mis) {
		this.mis = mis;
	}

	public List<CompCompetencias> getListaCompetencias() {
		return listaCompetencias;
	}

	public void setListaCompetencias(List<CompCompetencias> listaCompetencias) {
		this.listaCompetencias = listaCompetencias;
	}

	public Date getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}
	
}
