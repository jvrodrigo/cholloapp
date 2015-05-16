package org.uva.cholloapp;

import org.uva.cholloapp.fragments.*;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {
	/**
	 * The fragment argument representing the section number for this fragment.
	 */
	private static final String ARG_SECTION_NUMBER = "section_number";

	static int secNumber;

	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static PlaceholderFragment newInstance(int sectionNumber) {
		secNumber = sectionNumber;
		PlaceholderFragment fragment = new PlaceholderFragment();

		Bundle args = new Bundle();
		secNumber = sectionNumber;
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	public PlaceholderFragment() {
	}

	public PlaceholderFragment(int sectionNumber) {
		// super.onCreate(getArguments());
		PlaceholderFragment.secNumber = sectionNumber;
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		setArguments(args);

	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		Log.i("SectionNumber", String.valueOf(secNumber));
		switch (secNumber) {
		// Here we load the content for each tab.
		case 1:
			View rootView_1 = inflater.inflate(R.layout.fragment_main_1, container,
					false);
			TabHost mTabHost_1 = (TabHost) rootView_1.findViewById(R.id.tabhost_1);
			mTabHost_1.setup();

			ViewPager mViewPager_1 = (ViewPager) rootView_1.findViewById(R.id.pager_1);
			TabsAdapter mTabsAdapter_1 = new TabsAdapter(getActivity(), mTabHost_1,
					mViewPager_1);
			mTabsAdapter_1.addTab(
					mTabHost_1.newTabSpec("1-a").setIndicator("Seccion 1-A"),
					PageOneFragment.class, savedInstanceState);
			mTabsAdapter_1.addTab(
					mTabHost_1.newTabSpec("1-b").setIndicator("Seccion 1-B"),
					PageTwoFragment.class, savedInstanceState);
			return rootView_1;
		case 2:
			View rootView_2 = inflater.inflate(R.layout.fragment_main_2, container,
					false);
			TabHost mTabHost_2 = (TabHost) rootView_2.findViewById(R.id.tabhost_2);
			mTabHost_2.setup();

			ViewPager mViewPager = (ViewPager) rootView_2.findViewById(R.id.pager_2);

			TabsAdapter mTabsAdapter_2 = new TabsAdapter(getActivity(), mTabHost_2,
					mViewPager);
			mTabsAdapter_2.addTab(
					mTabHost_2.newTabSpec("2-a").setIndicator("Seccion 2-A"),
					PageThreeFragment.class, savedInstanceState);
			mTabsAdapter_2.addTab(
					mTabHost_2.newTabSpec("2-b").setIndicator("Seccion 2-B"),
					PageFourFragment.class, savedInstanceState);
			
			return rootView_2;
		default: return null;
		}
		

	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((MainActivity) activity).onSectionAttached(getArguments().getInt(
				ARG_SECTION_NUMBER));
	}

	@Override
	public void onDestroyView() {
		super.onDestroyView();

		Log.i("PlaceHolderDestroyView", String.valueOf(getId()));
	}

	@Override
	public void onDestroy() {

		super.onDestroy();
	}

}