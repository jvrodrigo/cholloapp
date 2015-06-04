package org.cholloapp.fragments;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.cholloapp.models.User;
import org.json.JSONObject;
import org.cholloapp.R;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PageOneFragment extends Fragment {
	private static String fragmentTitle = PageOneFragment.class.getSimpleName();
	TextView tTitle, tUserId, tUserName, tEmail;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.pageone_fragment, container,
				false);
		
		tTitle = (TextView) rootView.findViewById(R.id.frag1_title);
		tUserId = (TextView) rootView.findViewById(R.id.frag1_user_id);
		tUserName = (TextView) rootView.findViewById(R.id.frag1_user_name);
		tEmail = (TextView) rootView.findViewById(R.id.frag1_user_email);
		tTitle.setText("Bienvenido");
		tTitle.setTextSize(25);

		new HttpRequestTask().execute("show");

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
		// FragmentManager fragmentManager = getChildFragmentManager();
		// fragmentManager.beginTransaction().remove(this).commit();
		super.onDestroyView();
		Log.i(fragmentTitle, String.valueOf(this.getId()));

	}

	private class HttpRequestTask extends AsyncTask<String, Integer, User> {
		private ProgressDialog dialog = new ProgressDialog(getActivity());
		String userId, userName, email;

		@Override
		protected void onPreExecute() {
			 
			// spinner (wheel) style dialog
			dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER); 
			// better yet - use a string resource getString(R.string.your_message)
			dialog.setMessage(getString(R.string.loading)); 
			// display dialog
			dialog.show();
		}

		@Override
		protected void onProgressUpdate(Integer... progress) {

			//progressBar.setProgress(Math.round(progress[0]));
		}

		@Override
		protected User doInBackground(String... params) {
			try {
				HttpClient httpClient = new DefaultHttpClient();

				if (params[0].equals("show")) {
					String id = "1";
					HttpGet del = new HttpGet(
							"http://192.168.1.34:8080/cholloweb/user.json?id="
									+ id);

					del.setHeader("content-type", "application/json");

					try {
						HttpResponse resp = httpClient.execute(del);
						String respStr = EntityUtils.toString(resp.getEntity());

						JSONObject respJSON = new JSONObject(respStr);

						userId = respJSON.getString("id");
						userName = respJSON.getString("userName");
						email = respJSON.getString("email");
						Log.i("AsynTask",
								(userId + " - " + userName + " - " + email));
					} catch (Exception ex) {
						Log.e("ServicioRest", "Error!", ex);
					}
				}
			} catch (Exception e) {
				Log.e("MainActivity", e.getMessage(), e);
			}

			return null;
		}

		@Override
		protected void onPostExecute(User user) {
			if(dialog != null) dialog.dismiss();
			// Log.i("AsynTask",(userId + " - " + userName + " - " + email));
			tUserId.setText(this.userId);
			tUserName.setText(this.userName);
			tEmail.setText(email);
			
		}

	}
}
