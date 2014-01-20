package com.cuti.polideportivo;

public class Socio {

	private String documento;
	private String nombre;
	private String apellido;
	private String sexo;
	private String estadoCivil;
	private String nacionalidad;
	private String fechaNacimiento;
	private String domicilio;
	private String localidad;
	private String celular;
	private String telefono;
	private String email;	
	private String categoria;
	private String actividadesPreferidas;
	
	public void modificar(String documento, String  nombre, String apellido, String sexo, String estadoCivil, String nacionalidad, String fechaNacimiento, String domicilio, String localidad, String celular, String telefono, String email, String categoria, String actividadesPreferidas) {
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
		this.domicilio = domicilio;
		this.localidad = localidad;
		this.celular = celular;
		this.telefono = telefono;
		this.email = email;
		this.categoria = categoria;
		this.actividadesPreferidas = actividadesPreferidas;
	}

	public Socio(String documento, String nombre, String apellido, String sexo,
			String estadoCivil, String nacionalidad, String fechaNacimiento,
			String domicilio, String localidad, String celular,
			String telefono, String email, String categoria,
			String actividadesPreferidas) {
		super();
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.sexo = sexo;
		this.estadoCivil = estadoCivil;
		this.nacionalidad = nacionalidad;
		this.fechaNacimiento = fechaNacimiento;
		this.domicilio = domicilio;
		this.localidad = localidad;
		this.celular = celular;
		this.telefono = telefono;
		this.email = email;
		this.categoria = categoria;
		this.actividadesPreferidas = actividadesPreferidas;
	}
	
	public String getDocumento() {
		return this.documento;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getSexo() {
		return sexo;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public String getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public String getLocalidad() {
		return localidad;
	}

	public String getCelular() {
		return celular;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}

	public String getCategoria() {
		return categoria;
	}

	public String getActividadesPreferidas() {
		return actividadesPreferidas;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public void setActividadesPreferidas(String actividadesPreferidas) {
		this.actividadesPreferidas = actividadesPreferidas;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Socio other = (Socio) obj;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equalsIgnoreCase(other.documento))
			return false;
		return true;
	}
	
	
}
