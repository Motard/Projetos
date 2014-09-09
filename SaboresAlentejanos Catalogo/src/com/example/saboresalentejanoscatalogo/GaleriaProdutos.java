package com.example.saboresalentejanoscatalogo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class GaleriaProdutos extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_galeria_produtos);
		
		String produto = getIntent().getStringExtra("batata");
		
		Toast.makeText(this, produto,Toast.LENGTH_SHORT).show();
	}

}
