package com.cuti.polideportivo;


import com.cuti.polideportivo.MainActivity;
import com.cuti.polideportivo.dao.SociosDAO;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	
	private SociosDAO datasource;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		datasource = SociosDAO.getInstance(this);
		
		final Button btnFicha = (Button)findViewById(R.id.FichaSocios);	
		final Button btnLista = (Button)findViewById(R.id.ListaSocios);
		final Button btnAcerca = (Button)findViewById(R.id.Acerca);
		final Button btnSalir = (Button)findViewById(R.id.Salir);
		
		btnLista.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(MainActivity.this,ListaSocios.class);
				startActivity(intent);
			}
		});
		
			btnFicha.setOnClickListener(
				new OnClickListener() {
					public void onClick(View v) {
						Intent intent = new Intent(MainActivity.this,FichaSocios.class);
						startActivity(intent);
					}
				}				
			);
			
			btnAcerca.setOnClickListener(new OnClickListener() {
				
				public void onClick(View v) {
					// TODO Auto-generated method stub
					AlertDialog.Builder acercade= new AlertDialog.Builder(MainActivity.this);
					acercade.setMessage("Entrega polideportivo Cuti 2013");
					acercade.setCancelable(false);
					acercade.setPositiveButton("Listo", new DialogInterface.OnClickListener() {
						
						@SuppressWarnings("deprecation")
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							NotificationManager nm = (NotificationManager)getSystemService(MainActivity.NOTIFICATION_SERVICE);
							Notification notificacion = new Notification(android.R.drawable.stat_notify_more, "Gracias por usar polideportivo", System.currentTimeMillis());
							Intent inte = new Intent(MainActivity.this, MainActivity.class);
							PendingIntent pinte = PendingIntent.getActivity(MainActivity.this, 0, inte, 0);
							notificacion.setLatestEventInfo(getApplicationContext(), "Cuti 2013", "Gracias", pinte);
							nm.notify(13, notificacion);
							dialog.cancel();
						}
					});
					acercade.show();
				}
				
			});
			
			btnSalir.setOnClickListener(new OnClickListener() {
				
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					
					AlertDialog.Builder salir = new AlertDialog.Builder(MainActivity.this);
					salir.setMessage("Quieres salir de polideportivo?");
					salir.setCancelable(false);
					salir.setPositiveButton("Si", new DialogInterface.OnClickListener() {
						
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							finish();
						}
					});
					salir.setNegativeButton("No", new DialogInterface.OnClickListener() {
						
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							dialog.cancel();
						}
					});
					salir.show();
				}
			});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
