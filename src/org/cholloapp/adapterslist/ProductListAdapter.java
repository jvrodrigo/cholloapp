package org.cholloapp.adapterslist;

import org.cholloapp.R;
import java.util.List;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ProductListAdapter extends ArrayAdapter<ProductItem> {

	Context context;
	List<ProductItem> productItemList;
	int layoutResID;

	public ProductListAdapter(Context context, int layoutResourceID,
			List<ProductItem> listItems) {
		super(context, layoutResourceID, listItems);
		this.context = context;
		this.productItemList = listItems;
		this.layoutResID = layoutResourceID;
		Log.i("ProductAdapter", "Creado");
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub

		ProductItemHolder productHolder = new ProductItemHolder();
		View view = convertView;

		if (view == null) {
			LayoutInflater inflater = ((Activity) context).getLayoutInflater();

			view = inflater.inflate(layoutResID, parent, false);

			productHolder.itemLayout = (LinearLayout) view
					.findViewById(R.id.product_item_layout);
			productHolder.icon = (ImageView) view
					.findViewById(R.id.product_item_image);
			productHolder.name = (TextView) view
					.findViewById(R.id.product_item_name);
			productHolder.description = (TextView) view
					.findViewById(R.id.product_item_description);
			productHolder.created = (TextView) view
					.findViewById(R.id.product_item_created);
			productHolder.modified = (TextView) view
					.findViewById(R.id.product_item_modified);

			view.setTag(productHolder);

		} else {
			productHolder = (ProductItemHolder) view.getTag();

		}

		ProductItem dItem = (ProductItem) this.productItemList.get(position);

		productHolder.itemLayout.setVisibility(LinearLayout.VISIBLE);
		productHolder.icon.setImageDrawable(view.getResources().getDrawable(
				dItem.getImage()));
		productHolder.name.setText(dItem.getName());
		productHolder.description.setText(dItem.getDescription());
		productHolder.created.setText(dItem.getCreated());
		productHolder.modified.setText(dItem.getModified());

		return view;
	}

	private static class ProductItemHolder {
		ImageView icon;
		TextView name, description, created, modified;
		LinearLayout itemLayout;
	}
}