package com.cuti.polideportivo;
import java.util.ArrayList;
import java.util.Vector;


public class Polideportivo {

	private ArrayList<Socio> socios;
	private Vector<ActividadDeportiva> actividades;
	private Vector<CategoriaSocial> categorias;
	private static Polideportivo instancia = null;
	
    private Polideportivo() {

    }

    public static Polideportivo getInstancia(){
        if (instancia == null) {
        	
            instancia = new Polideportivo();
            
            Vector<ActividadDeportiva> actividades = new Vector<ActividadDeportiva>();
            
            ActividadDeportiva actividad1 = new ActividadDeportiva(1, "Futbol");
            actividades.add(actividad1);
            ActividadDeportiva actividad2 = new ActividadDeportiva(2, "Basketball");
            actividades.add(actividad2);
            ActividadDeportiva actividad3 = new ActividadDeportiva(3, "Tenis");            
            actividades.add(actividad3);           
            ActividadDeportiva actividad4 = new ActividadDeportiva(4, "Natacion");
            actividades.add(actividad4);        
            
            instancia.setActividades(actividades);
            
            Vector<CategoriaSocial> categorias = new Vector<CategoriaSocial>();
            CategoriaSocial categoria1 = new CategoriaSocial(1, "Categoria social 1");
            categorias.add(categoria1);
            CategoriaSocial categoria2 = new CategoriaSocial(2, "Categoria social 2");
            categorias.add(categoria2);
            CategoriaSocial categoria3 = new CategoriaSocial(3, "Categoria social 3");
            categorias.add(categoria3);  
            CategoriaSocial categoria4 = new CategoriaSocial(4, "Categoria social 4");
            categorias.add(categoria4);      
            
            instancia.setCategorias(categorias);
            instancia.setSocios(new ArrayList<Socio>());
        }
        return instancia;
    }

	public ArrayList<Socio> getSocios() {
		return socios;
	}

	public Vector<ActividadDeportiva> getActividades() {
		return actividades;
	}

	public Vector<CategoriaSocial> getCategorias() {
		return categorias;
	}

	public void setSocios(ArrayList<Socio> socios) {
		this.socios = socios;
	}

	public void setActividades(Vector<ActividadDeportiva> actividades) {
		this.actividades = actividades;
	}

	public void setCategorias(Vector<CategoriaSocial> categorias) {
		this.categorias = categorias;
	}	
    
    public boolean agregarSocio(String documento, String nombre, String apellido, String sexo,
			String estadoCivil, String nacionalidad, String fechaNacimiento,
			String domicilio, String localidad, String celular,
			String telefono, String email, String categoria,
			String actividadesPreferidas) {
    	Socio s = new Socio(documento, nombre, apellido, sexo,
    			estadoCivil, nacionalidad, fechaNacimiento,
    			domicilio, localidad, celular,
    			telefono, email, categoria,
    			actividadesPreferidas);
    	if(existeSocio(documento)){
    		return false;
    	}
    	else {
    		getSocios().add(s);
    	}
    	return true;
    }
    
    public boolean modificarSocio(Socio socio, String documento, String  nombre, String apellido, String sexo, String estadoCivil, String nacionalidad, String fechaNacimiento, String domicilio, String localidad, String celular, String telefono, String email, String categoria, String actividadesPreferidas) {
//    	if(socio.getDocumento()!=documento) {
//    		if(existeSocio(documento)) {
//    			return false;
//    		}			
//    	}
    	socio.modificar(documento, nombre, apellido, sexo, estadoCivil, nacionalidad, fechaNacimiento, domicilio, localidad, celular, telefono, email, categoria, actividadesPreferidas);
    	return true;
    }
    
    public void eliminarSocio(Socio socio) {
    	socios.remove(socio);
    }
    
    public Socio getSocio(int pos){
		
    	return (Socio)this.socios.get(pos);
    	
    }

    public boolean existeSocio(Socio socio) {
    	
    	for(int i=0;i<socios.size();i++) {
        	Socio s = socios.get(i);
        	if(s.equals(socio)) {
        		return true;
        	}
        }
        
    	return false;
    }

    public boolean existeSocio(String documento) {
    	
    	for(int i=0;i<socios.size();i++) {
    		Socio s = socios.get(i);
    		if(s.getDocumento().equalsIgnoreCase(documento)) {
    			return true;
    		}
    	}
    	
    	return false;
    }

}
