package org.uva.cholloapp.fragments;

import org.uva.cholloapp.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PageOneFragment extends Fragment
{
	private static String fragmentTitle = PageOneFragment.class.getSimpleName();
	TextView title;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
       
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
    	View rootView = inflater.inflate(R.layout.pageone_fragment, container, false);
    	
    	title = (TextView) rootView.findViewById(R.id.oneFragmentTextView);
    	title.setText("Holllllaaa");
    	title.setTextSize(25);
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
    }

    @Override
    public void onStart()
    {
        super.onStart();
    }

    @Override
    public void onResume()
    {
        super.onResume();
    }
    @Override
    public void onDestroyView(){
    	//FragmentManager fragmentManager = getChildFragmentManager();
    	//fragmentManager.beginTransaction().remove(this).commit();
    	super.onDestroyView();
    	Log.i(fragmentTitle,String.valueOf(this.getId()));
    	
    }
}
