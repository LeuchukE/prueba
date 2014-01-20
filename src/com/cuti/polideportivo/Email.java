package com.cuti.polideportivo;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Email extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_email);

		Button btnEnviar = (Button) findViewById(R.id.BtnEnviar);
	
		btnEnviar.setOnClickListener(new OnClickListener(){
			 public void onClick(View v) {
				 EditText etEmail = (EditText) findViewById(R.id.txtDestinatario);		
				 EditText etAsunto = (EditText) findViewById(R.id.txtAsunto);	
				 EditText etMensaje = (EditText) findViewById(R.id.txtMensaje);	
				 Intent itSend =  new Intent(android.content.Intent.ACTION_SEND); 
				 itSend.setData(Uri.parse("mailto:")); 
				 //para usar con el emulador
				 itSend.setType("text/plain");
				 //para usar con el dispositivo real	
				 //itSend.setType("message/rfc822");
				 itSend.putExtra(android.content.Intent.EXTRA_EMAIL, new String[] { etEmail.getText().toString()});
				 itSend.putExtra(android.content.Intent.EXTRA_SUBJECT, etAsunto.getText().toString());
				 itSend.putExtra(android.content.Intent.EXTRA_TEXT, etMensaje.getText());
				 startActivity(Intent.createChooser(itSend, "Email "));
			 }	
			}

		);
		Bundle b = this.getIntent().getExtras();
		if(b != null) {
			int posicion = b.getInt("posicion");
			Socio so = Polideportivo.getInstancia().getSocio(posicion); 			
			EditText etEmail = (EditText) findViewById(R.id.txtDestinatario);
			etEmail.setText(so.getEmail());
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.email, menu);
		return true;
	}

}
