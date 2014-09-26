package com.example.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.Toast;

public class PlayerSelect extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_player_select);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		
		final RadioButton radio1=(RadioButton) findViewById(R.id.radio1); //single player
		final RadioButton radio2=(RadioButton) findViewById(R.id.radio2); // multiplayer - single device
		final RadioButton radio3=(RadioButton) findViewById(R.id.radio3); // multiplayer - seperate devices
		
		ImageButton btnPlaynow =(ImageButton) findViewById(R.id.btnPlaynow);
		
		btnPlaynow.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				Intent intent=new Intent(PlayerSelect.this,MainActivity.class);
				
				if(radio1.isChecked()){
					intent.putExtra("option", 1);
					startActivity(intent);
				}
				else if(radio2.isChecked()){
					intent.putExtra("option",2);
					startActivity(intent);
				}
				else if(radio3.isChecked()){
					intent.putExtra("option",3);
					startActivity(intent);
				}				
				else{
					Toast.makeText(getBaseContext(), "Please select an option", Toast.LENGTH_LONG).show();
				}
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.player_select, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_player_select,
					container, false);
			return rootView;
		}
	}

}
