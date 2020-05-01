package com.example.helloandroidmenus4;

import android.os.Bundle;
import android.app.Activity;

import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnLongClickListener;
import android.view.ActionMode;
import android.view.ActionMode.Callback;

public class MainActivity extends Activity {

	private TextView tv;

	private ActionMode mActionMode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv = (TextView) findViewById(R.id.textview1);
		registerForContextMenu(tv);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
		String s;
		s = "Opcion Menu pulsada: " + item.getTitle().toString() + ". Orden: " + item.getOrder();
		tv.setText(s);
		return true;
    }

	@Override
    public void onCreateContextMenu(ContextMenu menu, View v, 
    		                        ContextMenuInfo menuInfo) 
    {
		super.onCreateContextMenu(menu, v, menuInfo);		
		MenuInflater inflater = getMenuInflater();		
	    inflater.inflate(R.menu.menu_ctx_etiqueta, menu);
		
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

		switch (item.getItemId()) {
			case R.id.menu_cont_op1:
				Toast.makeText(this, "Etiqueta: Opcion Contextual " + item.getOrder() + " pulsada!", Toast.LENGTH_SHORT).show();
				return true;
			case R.id.menu_cont_op2:
				Toast.makeText(this, "Etiqueta: Opcion Contextual " + item.getOrder() + "  pulsada!", Toast.LENGTH_SHORT).show();
				return true;
			default:
				return super.onContextItemSelected(item);
		}
    }
}
