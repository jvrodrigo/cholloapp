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
	
	private ViewPager mViewPager;
	
	static int secNumber;

	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static PlaceholderFragment newInstance(int sectionNumber) {
		PlaceholderFragment fragment = new PlaceholderFragment();

		Bundle args = new Bundle();
		secNumber = sectionNumber;
		Log.i("SectionNumber", String.valueOf(sectionNumber));
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	public PlaceholderFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_main, container,
				false);
		TabsAdapter mTabsAdapter_2;
		TabsAdapter mTabsAdapter_3;
		TabHost mTabHost;
		switch (secNumber) {
		case 0:
			break;
		case 2:
			
			mTabHost = (TabHost) rootView.findViewById(android.R.id.tabhost);
			mTabHost.setup();

			mViewPager = (ViewPager) rootView.findViewById(R.id.pager);
			mTabsAdapter_2 = new TabsAdapter(getActivity(), mTabHost, mViewPager);
			// Here we load the content for each tab.
			mTabsAdapter_2.addTab(mTabHost.newTabSpec("one").setIndicator("One"),
					PageOneFragment.class, null);
			mTabsAdapter_2.addTab(mTabHost.newTabSpec("two").setIndicator("Two"),
					PageTwoFragment.class, null);
			
			break;
		case 3:
			
			/*mTabHost = (TabHost) rootView.findViewById(android.R.id.tabhost);
			mTabHost.setup();

			mViewPager = (ViewPager) rootView.findViewById(R.id.pager);
			
			mTabsAdapter_3 = new TabsAdapter(getActivity(), mTabHost, mViewPager);
			// Here we load the content for each tab.
			
			mTabsAdapter_3.addTab(mTabHost.newTabSpec("three").setIndicator("Three"),
					PageThreeFragment.class, null);
			mTabsAdapter_3.addTab(mTabHost.newTabSpec("four").setIndicator("Four"),
					PageFourFragment.class, null);*/
			break;
		default:
			break;
		}
		
		return rootView;
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		((MainActivity) activity).onSectionAttached(getArguments().getInt(
				ARG_SECTION_NUMBER));
	}
}