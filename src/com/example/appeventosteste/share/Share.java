package com.example.appeventosteste.share;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.widget.ImageView;
import android.widget.ShareActionProvider;

public class Share {
	
	public void setShareIntent(ShareActionProvider provider, Intent shareIntent) {
		if (provider != null) {
			provider.setShareIntent(shareIntent);
		}
	}
	  
	public Intent createShareString(String text) {
		Intent shareIntent = new Intent(Intent.ACTION_SEND);
		shareIntent.putExtra(Intent.EXTRA_TEXT, text);
		shareIntent.setType("text/plain");
		return shareIntent;
	}
	  
	  
	public Intent createShareImage(ImageView imageView) {
	
		// Get access to the URI for the bitmap
		Uri bmpUri = getLocalBitmapUri(imageView);
	
		   
	   // Construct a ShareIntent with link to image
		Intent shareIntent = new Intent();
		shareIntent.setAction(Intent.ACTION_SEND);
		shareIntent.putExtra(Intent.EXTRA_STREAM, bmpUri);
		shareIntent.setType("image/*");
	   // Launch sharing dialog for image
		
		return shareIntent;
	  }
	
	  
	// Returns the URI path to the Bitmap displayed in specified ImageView
	public Uri getLocalBitmapUri(ImageView imageView) {
      // Extract Bitmap from ImageView drawable
		Drawable drawable = imageView.getDrawable();
		Bitmap bmp = null;
		
		if (drawable instanceof BitmapDrawable){
			bmp = ((BitmapDrawable) imageView.getDrawable()).getBitmap();
	    } 
		else {
	         return null;
		}
	    
		// Store image to default external storage directory
		Uri bmpUri = null;
		try {
			File file =  new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "share_image_" + System.currentTimeMillis() + ".png");
	        
			file.getParentFile().mkdirs();
			FileOutputStream out = new FileOutputStream(file);
			bmp.compress(Bitmap.CompressFormat.PNG, 90, out);
			out.close();
			bmpUri = Uri.fromFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return bmpUri;
	  }
}
