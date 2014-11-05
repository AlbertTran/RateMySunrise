package fr.esiea.com.ratemysunrise;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import fr.esiea.com.ratemysunrise.model.Sunrise;
import fr.esiea.com.ratemysunrise.model.Sunrises;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SunriseFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SunriseFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class SunriseFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    public static final String ARG_SUNRISE_ID = "idSunrise";
    private Sunrise mSunrise;

    // TODO: Rename and change types of parameters
    private String idSunrise;
    TextView lblDateUpload;
    TextView lblCity;
    TextView lblCountry;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param id The id of the sunrise object.
     * @return A new instance of fragment SunriseFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SunriseFragment newInstance(String id) {
        SunriseFragment fragment = new SunriseFragment();
        Bundle args = new Bundle();
        args.putString(ARG_SUNRISE_ID, id);
        fragment.setArguments(args);
        return fragment;
    }
    public SunriseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            idSunrise = getArguments().getString(ARG_SUNRISE_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fgt_sunrise, container, false);
        lblDateUpload = (TextView) rootView.findViewById(R.id.lbl_dateUpload);
        lblCity = (TextView) rootView.findViewById(R.id.lbl_city);
        lblCountry = (TextView) rootView.findViewById(R.id.lbl_country);
        refresh(idSunrise);
        // Inflate the layout for this fragment
        return rootView;
    }



    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public void refresh(String id) {
        mSunrise = Sunrises.getInstance().getSunriseById(idSunrise);
        lblDateUpload.setText(mSunrise.getDateUpload().toString());
        lblCity.setText(mSunrise.getCity());
        lblCountry.setText(mSunrise.getCountry());

    }

        /**
         * This interface must be implemented by activities that contain this
         * fragment to allow an interaction in this fragment to be communicated
         * to the activity and potentially other fragments contained in that
         * activity.
         * <p>
         * See the Android Training lesson <a href=
         * "http://developer.android.com/training/basics/fragments/communicating.html"
         * >Communicating with Other Fragments</a> for more information.
         */
    public interface OnFragmentInteractionListener {
    }

}
