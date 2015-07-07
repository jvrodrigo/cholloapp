package org.cholloapp.fragments;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.cholloapp.R;
import org.cholloapp.adapterslist.ProductItem;
import org.cholloapp.adapterslist.ProductListAdapter;
import org.json.JSONArray;
import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class PageTwoFragment extends Fragment {
	private static String fragmentTitle = PageOneFragment.class.getSimpleName();
	private ProductListAdapter adapter;
	
	TextView tName, tDescription, tUserName, tEmail;
	ListView mProductListView;
	
	List<ProductItem> dataList;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/*dataList = new ArrayList<ProductItem>();
		for (int i = 0; i < 4 ; i++) {
			
			dataList.add(new ProductItem(i, "Hola", "description",
					android.R.drawable.ic_menu_camera, new Date(),
					new Date()));
			Log.i("Data",dataList.toString());
		}*/
		//Log.i("Contex",getActivity().toString());
		new HttpRequestTask().execute("index");
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		View rootView = inflater.inflate(R.layout.pagetwo_fragment, container,
				false);
		//mProductListView = (ListView) inflater.inflate(R.layout.product_listview, container, false);
		
		mProductListView = (ListView) rootView.findViewById(R.id.product_listview);
		
		mProductListView
		.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(
					AdapterView<?> parent, View view,
					int position, long id) {
				Log.i("Position",String.valueOf(position));
			}
		});
		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public void onStart() {
		super.onStart();
	}

	@Override
	public void onResume() {
		super.onResume();
	}

	@Override
	public void onDestroyView() {

		super.onDestroyView();
		Log.i(fragmentTitle, String.valueOf(this.getId()));

	}

	private class HttpRequestTask extends AsyncTask<String, Integer, String> {
		private ProgressDialog dialog = new ProgressDialog(getActivity());
		int id;
		String name, description;
		//CharSequence created, modified;

		@Override
		protected void onPreExecute() {

			// spinner (wheel) style dialog
			dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
			// better yet - use a string resource
			// getString(R.string.your_message)
			dialog.setMessage(getString(R.string.loading));
			// display dialog
			dialog.show();
		}

		@Override
		protected void onProgressUpdate(Integer... progress) {

			// progressBar.setProgress(Math.round(progress[0]));
		}

		@SuppressLint("SimpleDateFormat")
		@Override
		protected String doInBackground(String... params) {
			try {
				HttpClient httpClient = new DefaultHttpClient();

				if (params[0].equals("index")) {

					HttpGet del = new HttpGet(
							"http://192.168.1.34:8080/cholloweb/users.json");

					del.setHeader("content-type", "application/json");

					try {
						HttpResponse resp = httpClient.execute(del);
						String respStr = EntityUtils.toString(resp.getEntity());

						JSONArray respJSON = new JSONArray(respStr);

						dataList = new ArrayList<ProductItem>();
						for (int i = 0; i < respJSON.length(); i++) {
							
							JSONObject obj = respJSON.getJSONObject(i);

							id = Integer.valueOf(obj.getString("id"));

							name = obj.getString("userName");
							description = obj.getString("email");
							JSONObject JSONcreated = obj.getJSONObject("created");
							JSONObject JSONmodified = obj.getJSONObject("modified");
							
							dataList.add(new ProductItem(id, name, description,
									android.R.drawable.ic_menu_camera, "Creado: " + DateUtils.getRelativeTimeSpanString(getActivity(),Long.valueOf(JSONcreated.getString("time"))),
									"Modificado: " + DateUtils.getRelativeTimeSpanString(getActivity(),Long.valueOf(JSONmodified.getString("time")))));
						}
						
					} catch (Exception ex) {
						Log.e("ServicioRest", "Error!", ex);
					}
				}
			} catch (Exception e) {
				Log.e("PageTwoFragment", e.getMessage(), e);
			}
			return null;
		}

		@Override
		protected void onPostExecute(String str) {
			if (dialog != null)
				dialog.dismiss();
			adapter = new ProductListAdapter(getActivity(),
					R.layout.product_item_list, dataList);
			
			mProductListView.setAdapter(adapter);
		}

	}
}
