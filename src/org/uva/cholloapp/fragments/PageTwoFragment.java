package org.uva.cholloapp.fragments;

import org.uva.cholloapp.R;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PageTwoFragment extends Fragment
{
	private static String fragmentTitle = PageTwoFragment.class.getSimpleName();
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.pagetwo_fragment, container, false);
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
    public void onDestroy(){
    	super.onDestroy();
    }
    @Override
    public void onDestroyView(){
    	//FragmentManager fragmentManager = getChildFragmentManager();
    	//fragmentManager.beginTransaction().remove(this).commit();
    	super.onDestroyView();
    	Log.i(fragmentTitle,String.valueOf(this.getId()));
    }
}
