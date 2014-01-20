package com.cuti.polideportivo;



import com.cuti.polideportivo.dao.SociosDAO;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.content.Intent;

public class FichaSocios extends Activity {
	
	private SociosDAO datasource;
	TextView txtdocumento;
	Bundle b = new Bundle();
	private int posicion;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ficha_socios);
		
		
		datasource = SociosDAO.getInstance(this);

		final Button seleccionar = (Button) findViewById(R.id.BtnSeleccionarSocio);
		final Button agregar = (Button) findViewById(R.id.BtnAgregarSocio);
		final Button modificar = (Button) findViewById(R.id.BtnModificarSocio);		
		final Button eliminar = (Button) findViewById(R.id.BtnEliminarSocio);
		//final Button verCats = (Button) findViewById(R.id.BtnVerCats);

		txtdocumento = (TextView) findViewById(R.id.TxtDocumento);
		final TextView txtnombre = (TextView) findViewById(R.id.TxtNombre);
		final TextView txtapellido = (TextView) findViewById(R.id.TxtApellido);
		final TextView txtsexo = (TextView) findViewById(R.id.TxtSexo);
		final TextView txtestadoCivil = (TextView) findViewById(R.id.TxtEstadoCivil);
		final TextView txtnacionalidad = (TextView) findViewById(R.id.TxtNacionalidad);
		final TextView txtfechaNacimiento = (TextView) findViewById(R.id.TxtFechaNacimiento);
		final TextView txtdomicilio = (TextView) findViewById(R.id.TxtDomicilio);
		final TextView txtlocalidad = (TextView) findViewById(R.id.TxtLocalidad);
		final TextView txtcelular = (TextView) findViewById(R.id.TxtCelular);
		final TextView txttelefono = (TextView) findViewById(R.id.TxtTelefono);
		final TextView txtemail = (TextView) findViewById(R.id.TxtEmail);
		final TextView txtcategoria = (TextView) findViewById(R.id.TxtCategoria);
		final TextView txtactividadesPreferidas = (TextView) findViewById(R.id.TxtActividadesPreferidas);
		//final Spinner spnCategorias = (Spinner)findViewById(R.id.spinnerCategorias);
		
		//ArrayAdapter<CategoriaSocial> spnCategoriaAdapter = new ArrayAdapter<CategoriaSocial>(this, android.R.layout.simple_spinner_dropdown_item, Polideportivo.getInstancia().getCategorias());
		//spnCategorias.setAdapter(spnCategoriaAdapter);
		
		seleccionar.setVisibility(View.INVISIBLE);
		b = this.getIntent().getExtras();
		if (b != null) {
			posicion = b.getInt("posicion");
			Socio so = Polideportivo.getInstancia().getSocio(posicion); 
//			Toast.makeText(this,
//					String.valueOf("start activity correo para "+ so.getNombre()),
//					Toast.LENGTH_LONG).show();
			this.mostrarDatos(so);
			
		}else{
			//eliminar.setVisibility(View.INVISIBLE);
			modificar.setVisibility(View.INVISIBLE);
		}
		
		agregar.setOnClickListener(new OnClickListener(){
			 public void onClick(View v) {
					String documento = txtdocumento.getText().toString();
					String nombre = txtnombre.getText().toString();
					String apellido = txtapellido.getText().toString();
					String sexo = txtsexo.getText().toString();
					String estadoCivil = txtestadoCivil.getText().toString();
					String nacionalidad = txtnacionalidad.getText().toString();
					String fechaNacimiento = txtfechaNacimiento.getText().toString();
					String domicilio = txtdomicilio.getText().toString();
					String localidad = txtlocalidad.getText().toString();
					String celular = txtcelular.getText().toString();
					String telefono = txttelefono.getText().toString();
					String email = txtemail.getText().toString();	
					String categoria = txtcategoria.getText().toString();
					String actividadesPreferidas = txtactividadesPreferidas.getText().toString();				 
					//if(Polideportivo.getInstancia().agregarSocio(documento, nombre, apellido, sexo, estadoCivil, nacionalidad, fechaNacimiento, domicilio, localidad, celular, telefono, email, categoria, actividadesPreferidas)==true) {
					if(datasource.crearSocioNuevo(documento, nombre, apellido, sexo, estadoCivil, nacionalidad, fechaNacimiento, domicilio, localidad, celular, telefono, email, categoria, actividadesPreferidas)==true) {
						Toast.makeText(agregar.getContext(), "Socio agregado", Toast.LENGTH_LONG).show();
					}
					else {
						Toast.makeText(agregar.getContext(), "Documento repetido", Toast.LENGTH_LONG).show();
					}
			 }
			}
		);
		modificar.setOnClickListener(new OnClickListener(){
			 public void onClick(View v) {
					String documento = txtdocumento.getText().toString();
					String nombre = txtnombre.getText().toString();
					String apellido = txtapellido.getText().toString();
					String sexo = txtsexo.getText().toString();
					String estadoCivil = txtestadoCivil.getText().toString();
					String nacionalidad = txtnacionalidad.getText().toString();
					String fechaNacimiento = txtfechaNacimiento.getText().toString();
					String domicilio = txtdomicilio.getText().toString();
					String localidad = txtlocalidad.getText().toString();
					String celular = txtcelular.getText().toString();
					String telefono = txttelefono.getText().toString();
					String email = txtemail.getText().toString();	
					String categoria = txtcategoria.getText().toString();
					String actividadesPreferidas = txtactividadesPreferidas.getText().toString();	
					Socio socio = Polideportivo.getInstancia().getSocios().get(0);
					if(Polideportivo.getInstancia().modificarSocio(socio,documento, nombre, apellido, sexo, estadoCivil, nacionalidad, fechaNacimiento, domicilio, localidad, celular, telefono, email, categoria, actividadesPreferidas)==true) {
//						Toast.makeText(agregar.getContext(), "Socio modificado", Toast.LENGTH_LONG).show();
					}
					else {
						Toast.makeText(agregar.getContext(), "Documento repetido", Toast.LENGTH_LONG).show();
					}				 
					if(b != null){
//						Bundle b = new Bundle();
						Intent i = new Intent(FichaSocios.this, ListaSocios.class);
//						b.putString("hobby", txtHobby.getText().toString());
//						i.putExtras(b);
						setResult(Activity.RESULT_OK, i);
						FichaSocios.this.finish();
					}
			 }
			}
		);
		eliminar.setOnClickListener(new OnClickListener(){
			 public void onClick(View v) {
					Socio socio = Polideportivo.getInstancia().getSocios().get(posicion);
					//Polideportivo.getInstancia().eliminarSocio(socio);
					datasource.eliminarSocioPorDocumento(socio);
					if(b != null){
//						Bundle b = new Bundle();
						Intent i = new Intent(FichaSocios.this, ListaSocios.class);
//						b.putString("hobby", txtHobby.getText().toString());
//						i.putExtras(b);
						setResult(Activity.RESULT_OK, i);
						FichaSocios.this.finish();
					}
			 }
			}
		);
		seleccionar.setOnClickListener(new OnClickListener(){
			 public void onClick(View v) {
				 if(!Polideportivo.getInstancia().getSocios().isEmpty()) {
					 Socio s = Polideportivo.getInstancia().getSocios().get(0);
					 mostrarDatos(s);					 
				 }
			 }
			}
		);
	}
	
	protected void mostrarDatos(Socio socio) {
		
//		final TextView txtdocumento = (TextView) findViewById(R.id.TxtDocumento);
		final TextView txtnombre = (TextView) findViewById(R.id.TxtNombre);
		final TextView txtapellido = (TextView) findViewById(R.id.TxtApellido);
		final TextView txtsexo = (TextView) findViewById(R.id.TxtSexo);
		final TextView txtestadoCivil = (TextView) findViewById(R.id.TxtEstadoCivil);
		final TextView txtnacionalidad = (TextView) findViewById(R.id.TxtNacionalidad);
		final TextView txtfechaNacimiento = (TextView) findViewById(R.id.TxtFechaNacimiento);
		final TextView txtdomicilio = (TextView) findViewById(R.id.TxtDomicilio);
		final TextView txtlocalidad = (TextView) findViewById(R.id.TxtLocalidad);
		final TextView txtcelular = (TextView) findViewById(R.id.TxtCelular);
		final TextView txttelefono = (TextView) findViewById(R.id.TxtTelefono);
		final TextView txtemail = (TextView) findViewById(R.id.TxtEmail);
		final TextView txtcategoria = (TextView) findViewById(R.id.TxtCategoria);
		//final Spinner spnCategorias = (Spinner)findViewById(R.id.spinnerCategorias);
		final TextView txtactividadesPreferidas = (TextView) findViewById(R.id.TxtActividadesPreferidas);		
	
		txtdocumento.setText(socio.getDocumento());
		txtnombre.setText(socio.getNombre());
		txtapellido.setText(socio.getApellido());
		txtsexo.setText(socio.getSexo());
		txtestadoCivil.setText(socio.getEstadoCivil());
		txtnacionalidad.setText(socio.getNacionalidad());
		txtfechaNacimiento.setText(socio.getFechaNacimiento());
		txtdomicilio.setText(socio.getDomicilio());
		txtlocalidad.setText(socio.getLocalidad());
		txtcelular.setText(socio.getCelular());
		txttelefono.setText(socio.getTelefono());
		txtemail.setText(socio.getEmail());
		txtcategoria.setText(socio.getCategoria());
		txtactividadesPreferidas.setText(socio.getActividadesPreferidas());
	}

}
