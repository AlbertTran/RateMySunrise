package fr.esiea.com.ratemysunrise;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import java.util.ArrayList;

import fr.esiea.com.ratemysunrise.model.Sunrise;


public class MainActivity extends Activity implements SunriseFragment.OnFragmentInteractionListener, SunriseListFragment.OnFragmentInteractionListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // on regarde la configuration
        // si mode smartphone
        if (findViewById(R.id.fgt_container) != null){
            // si on a des info d'etat ne rien faire
            if (savedInstanceState != null){
                return;
            }

            // on peut creer le fragment
            SunriseListFragment firstFrag = new SunriseListFragment();
            // on lui passe les arguments de l'intent qui a déclencher le oncreate
            firstFrag.setArguments(getIntent().getExtras());

            //Ajout du fragment au layout
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.fgt_container, firstFrag)
                    .commit();
        }


    }


    @Override
    public void onSunriseSelected(String id) {
        // On récupère le fragment BookFragment
        // si mode smartphone

        if (findViewById(R.id.fgt_container) != null){

            // on peut creer le fragment
            SunriseFragment nextFrag = new SunriseFragment();
            // on lui passe les arguments de l'intent
            Bundle args = new Bundle();
            args.putString(SunriseFragment.ARG_SUNRISE_ID,id);
            nextFrag.setArguments(args);

            //Ajout du fragment au layout
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fgt_container,nextFrag)
                    .addToBackStack(null)
                    .commit();
        }
        else {
            // sinon on est en mode deux panneaux
            SunriseFragment sunriseFragment = (SunriseFragment) getFragmentManager().findFragmentById(R.id.fgt_sunrise);
            sunriseFragment.refresh(id);
        }

    }




/*

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

*/

}
