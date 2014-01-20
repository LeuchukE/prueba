package com.cuti.polideportivo;


import java.util.List;


import com.cuti.polideportivo.dao.SociosDAO;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemLongClickListener;

public class ListaSocios extends Activity {
	
	private SociosDAO datasource;
	private List<Socio> listaSocio;

	EditText editable;
	Button agregar;
	ListView lista;
	
	private Socio socioSeleccionado;
	private static final int USUARIO_OK = 0;
	private int itemSocioSeleccionado;
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_socios);
		
		
		lista = (ListView) findViewById(R.id.lvlista);
		
		this.rellenarlista();
		
		registerForContextMenu(lista);
		
		lista.setOnItemLongClickListener(new OnItemLongClickListener() {
			
			public boolean onItemLongClick(AdapterView<?> parent, View view,
				int position, long id) {
				
				itemSocioSeleccionado = position;
				socioSeleccionado = (Socio) lista.getItemAtPosition(position);
			
				openContextMenu(lista);
			
				return true;
			}
		});
				
	}
	
	private void rellenarlista(){
		
		//ArrayList<Socio> listaSocio = new ArrayList();
		
		//listaSocio = Polideportivo.getInstancia().getSocios();
		listaSocio = datasource.obtenerTodosLosSocios();
		
//		final ArrayAdapter<Socio> aA = new ArrayAdapter<Socio>(this, android.R.layout., listaSocio);
		ListAdapter la = new AdaptadorSocios(this, listaSocio);
		lista.setAdapter(la);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
		ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu_contextual_socio, menu);
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data){
		if(requestCode == USUARIO_OK){
			if(resultCode == RESULT_OK){
				Toast.makeText(this, "Socio modificado", Toast.LENGTH_LONG).show();
				this.rellenarlista();
			}
		}
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.ficha_socio:
			Intent intent = new Intent(ListaSocios.this, FichaSocios.class);
			Bundle b = new Bundle();
			b.putInt("posicion", itemSocioSeleccionado);
			intent.putExtras(b);
			startActivityForResult(intent, USUARIO_OK);
//			Toast.makeText(this,
//					String.valueOf("start activity ficha para "+ itemSocioSeleccionado),
//					Toast.LENGTH_LONG).show();
			break;
		case R.id.enviar_correo:
			Intent intentCorreo = new Intent(ListaSocios.this, Email.class);
			Bundle b2 = new Bundle();
			b2.putInt("posicion", itemSocioSeleccionado);
			intentCorreo.putExtras(b2);
			startActivityForResult(intentCorreo, USUARIO_OK);
			break;
		default:
			return super.onOptionsItemSelected(item);
		}
	return true;
	}


}
