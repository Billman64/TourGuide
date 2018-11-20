package com.example.bill.tourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SiteAdapter extends ArrayAdapter<Site> {
    public SiteAdapter(@NonNull Context context, int resource, @NonNull List<Site> objects) {
        super(context, resource, objects);
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.site, parent, false);
        }

        // capture views and populate them
        final Site currentSite = getItem(position);
        TextView tvName = (TextView) listItemView.findViewById(R.id.name);
        tvName.setText(currentSite.getName());
        TextView tvDescription = (TextView) listItemView.findViewById(R.id.description);
        tvDescription.setText(currentSite.getDescription());
        TextView tvLocation = (TextView) listItemView.findViewById(R.id.location);
        String location = tvLocation.getText().toString();

        // put "located in:" by the location
        if(location != null && location != "") tvLocation.setText(getContext().getResources().getString(R.string.located_in) + currentSite.getLocation());
            else tvLocation.setText("");    // creating blank first entry to make room for header

        // load image if necessary
        ImageView image = (ImageView) listItemView.findViewById(R.id.image);
        if(currentSite.hasImage()) {
            image.setImageResource(currentSite.getImageResource());
            image.setVisibility(View.VISIBLE);
        } else image.setVisibility(View.GONE);

        // stripe effect //TODO: set a subtle background color for even numbered listView items for stripe effect
//        if(position % 2 == 0)listItemView.setBackgroundColor(R.color.colorPrimary);

//        return super.getView(position, convertView, parent);
        return listItemView;
    }
}
