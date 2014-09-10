package com.example.saboresalentejanoscatalogo;

import android.app.Activity;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Produto extends Activity 
{
	private String nameImage;
	
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_produto);
		
		nameImage = getIntent().getStringExtra(GaleriaProdutos.NOME_PRODUTO);
		TextView imageName = (TextView) findViewById(R.id.tv_nome_produto);
		imageName.setText(nameImage);
		
		//Toast.makeText(this, nameImage, Toast.LENGTH_LONG).show();
		displayImage();
	};
	
	
	private void displayImage()
	{
		Bitmap bitmap=null;
		String bitmapDescription = null;
		
		TypedArray imgs = getResources().obtainTypedArray(R.array.image_ids);
		TypedArray imgs_names = getResources().obtainTypedArray(R.array.image_name);
		TypedArray imgs_desc = getResources().obtainTypedArray(R.array.image_description);

		for (int i=0; i<imgs_names.length(); i++)
		{
			String imageName = imgs_names.getString(i);
			if (imageName.equalsIgnoreCase(nameImage))
			{
				bitmap = BitmapFactory.decodeResource(this.getResources(), imgs.getResourceId(i, -1));
				bitmapDescription = imgs_desc.getString(i);
			}
		}
		
		ImageView image = (ImageView) findViewById(R.id.iv_imagem_produto);
		image.setImageBitmap(bitmap);
		
		TextView description = (TextView) findViewById(R.id.tv_descricao_produto);
		description.setText(bitmapDescription);
	}
}
