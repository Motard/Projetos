package com.example.saboresalentejanoscatalogo;

import java.util.ArrayList;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.GridView;
import android.widget.Toast;

public class GaleriaProdutos extends Activity {
	private GridView gridView;
	private GridViewAdapter customGridAdapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_galeria_produtos);
		
		String produto = getIntent().getStringExtra("batata");
		
		//Toast.makeText(this, produto,Toast.LENGTH_SHORT).show();
		
		gridView = (GridView) findViewById(R.id.gridView);
		customGridAdapter = new GridViewAdapter(this, R.layout.row_grid,getData());
		gridView.setAdapter(customGridAdapter);
	}
	
	private ArrayList getData()
	{
		final ArrayList imageItems = new ArrayList();
		
		TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
		
		for (int i = 0; i<imgs.length(); i++)
		{
			Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), imgs.getResourceId(i, -1));
			imageItems.add(new ImageItem(bitmap, "Image#" + i));
		}
		return imageItems;
	}

}
