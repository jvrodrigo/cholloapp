package org.cholloapp.adapterslist;

import java.util.List;

import org.cholloapp.R;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CustomDrawerAdapter extends ArrayAdapter<DrawerItem> {

	Context context;
	List<DrawerItem> drawerItemList;
	int layoutResID;

	public CustomDrawerAdapter(Context context, int layoutResourceID,
			List<DrawerItem> listItems) {
		super(context, layoutResourceID, listItems);
		this.context = context;
		this.drawerItemList = listItems;
		this.layoutResID = layoutResourceID;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		DrawerItemHolder drawerHolder;
		View view = convertView;

		if (view == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();
			drawerHolder = new DrawerItemHolder();

			view = inflater.inflate(layoutResID, parent, false);

			drawerHolder.itemName = (TextView) view
					.findViewById(R.id.drawer_itemName);
			drawerHolder.icon = (ImageView) view.findViewById(R.id.drawer_icon);
			drawerHolder.title = (TextView) view
					.findViewById(R.id.drawer_title);

			drawerHolder.headerLayout = (LinearLayout) view
					.findViewById(R.id.header_layout);
			drawerHolder.itemLayout = (LinearLayout) view
					.findViewById(R.id.item_layout);

			view.setTag(drawerHolder);

		} else {
			drawerHolder = (DrawerItemHolder) view.getTag();

		}

		DrawerItem dItem = (DrawerItem) this.drawerItemList.get(position);

		if (dItem.getTitle() != null) {
			drawerHolder.headerLayout.setVisibility(LinearLayout.VISIBLE);
			drawerHolder.itemLayout.setVisibility(LinearLayout.INVISIBLE);
			drawerHolder.title.setText(dItem.getTitle());

		} else {

			drawerHolder.headerLayout.setVisibility(LinearLayout.INVISIBLE);
			drawerHolder.itemLayout.setVisibility(LinearLayout.VISIBLE);
			drawerHolder.icon.setImageDrawable(view.getResources().getDrawable(
					dItem.getIcon()));
			drawerHolder.itemName.setText(dItem.getItemName());

		}

		return view;
	}

	private static class DrawerItemHolder {
		TextView itemName, title;
		ImageView icon;
		LinearLayout headerLayout, itemLayout;
	}
}