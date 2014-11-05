package fr.esiea.com.ratemysunrise.adaptar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import fr.esiea.com.ratemysunrise.R;
import fr.esiea.com.ratemysunrise.model.Sunrise;
import fr.esiea.com.ratemysunrise.model.Sunrises;

/**
 * Created by albert on 04/11/14.
 */
public class SunriseAdapter extends BaseAdapter {

    Context context;

    private static LayoutInflater inflater;

    public SunriseAdapter(Context context) {
        this.context = context;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return Sunrises.getInstance().getlstPhotos().size();
    }

    @Override
    public Object getItem(int position) {
        return Sunrises.getInstance().getlstPhotos().get(position);
    }

    @Override
    public long getItemId(int position) {
        return new Long(Sunrises.getInstance().getlstPhotos().get(position).getId());
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // on garde une valeur de la vue
        View v = convertView;

        GridItem holder;
        // on regarde si on peut recycler une vue
        if (v == null) {
            //on récupère le désérialiseur de layout
            v = inflater.inflate(R.layout.grid_item_layout, null);
            //initialisation du holder
            holder = new GridItem();
            holder.locationView =  (TextView) v.findViewById(R.id.lbl_location);
            //on sauvegarde le holder
            v.setTag(holder);

        } else {
            holder = (GridItem)v.getTag();
        }
        Sunrise sunrise = (Sunrise) getItem(position);

        //on assigne directement les valeurs au holder
        holder.locationView.setText(sunrise.getCity() + ", " + sunrise.getCountry());

        return v;
    }

    static class GridItem {
        TextView locationView;
    }
}
