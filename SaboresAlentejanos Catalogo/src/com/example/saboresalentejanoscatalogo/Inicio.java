package com.example.saboresalentejanoscatalogo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Inicio extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        
        
        //Aceder ao botão e associar uma acção ao mesmo
        Button launchActivityListaProdutos = (Button) findViewById(R.id.bt_entrar);
        launchActivityListaProdutos.setOnClickListener(new OnClickListener() 
        {
			
			@Override
			public void onClick(View v) 
			{
				
				Intent intent = new Intent(Inicio.this, ListaProdutos.class);
				startActivity(intent);
				
			}
		});
    }
}
