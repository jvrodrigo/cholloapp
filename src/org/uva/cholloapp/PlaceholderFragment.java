package org.uva.cholloapp;

import org.uva.cholloapp.fragments.*;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
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
	private TabHost mTabHost;
	private ViewPager mViewPager;
	private TabsAdapter mTabsAdapter;
	static int secNumber;

	/**
	 * Returns a new instance of this fragment for the given section number.
	 */
	public static PlaceholderFragment newInstance(int sectionNumber) {
		PlaceholderFragment fragment = new PlaceholderFragment();

		Bundle args = new Bundle();
		secNumber = sectionNumber;
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
		
		switch (secNumber) {
		case 0:
			break;
		case 2:
			mTabHost = (TabHost) rootView.findViewById(android.R.id.tabhost);
			mTabHost.setup();

			mViewPager = (ViewPager) rootView.findViewById(R.id.pager);
			mTabsAdapter = new TabsAdapter(getActivity(), mTabHost, mViewPager);
			// Here we load the content for each tab.
			mTabsAdapter.addTab(mTabHost.newTabSpec("one").setIndicator("One"),
					PageOneFragment.class, null);
			mTabsAdapter.addTab(mTabHost.newTabSpec("two").setIndicator("Two"),
					PageTwoFragment.class, null);
			
			break;
		case 3:
			mTabHost = (TabHost) rootView.findViewById(android.R.id.tabhost);
			mTabHost.setup();

			mViewPager = (ViewPager) rootView.findViewById(R.id.pager);
			
			mTabsAdapter = new TabsAdapter(getActivity(), mTabHost, mViewPager);
			// Here we load the content for each tab.
			mTabsAdapter.addTab(mTabHost.newTabSpec("three").setIndicator("One"),
					PageThreeFragment.class, null);
			mTabsAdapter.addTab(mTabHost.newTabSpec("four").setIndicator("Four"),
					PageFourFragment.class, null);
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