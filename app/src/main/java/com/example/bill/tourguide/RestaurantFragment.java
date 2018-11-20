package com.example.bill.tourguide;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.bill.tourguide.dummy.DummyContent;
import com.example.bill.tourguide.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class RestaurantFragment extends Fragment {

    // establish OnListFragmentInteractionListener
    OnListFragmentInteractionListener onListFragmentInteractionListener = new OnListFragmentInteractionListener() {
        @Override
        public void onListFragmentInteraction(DummyItem item) {
            //TODO: react to swipes, get new pager position
//            item.
        }
    };

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public RestaurantFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static RestaurantFragment newInstance(int columnCount) {
        RestaurantFragment fragment = new RestaurantFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // load content
        final ArrayList<Site> sites = new ArrayList<>();
        sites.add(new Site("","",""));  // blank space for header
        sites.add(new Site("Raising Cane's Chicken Fingers","Fried chicken fast-food chain famous for its zesty dipping sauce.","Located throughout Ohio."));
        sites.add(new Site("Bob Evans","An all-day southern breakfast place.","Located througout Ohio."));
        sites.add(new Site("Buckeye Donuts","24-hour donut shop with breakfast options.","Columbus in the OSU campus area."));

        // link ListView with Adapter
        SiteAdapter siteAdapter = new SiteAdapter(getActivity(), 0 , sites);
        View rootView = inflater.inflate(R.layout.fragment_restaurant, container, false);
        ListView lv = (ListView) rootView.findViewById(R.id.listView);
        Log.d("TourGuide app", "about to set adapter");
        lv.setAdapter(siteAdapter);

        // Inflate the layout for this fragment
        return rootView;


// causes an error, even with a RecyclerView
//        if (view instanceof RecyclerView) {
//            Context context = view.getContext();
//            RecyclerView recyclerView = (RecyclerView) view;
//            if (mColumnCount <= 1) {
//                recyclerView.setLayoutManager(new LinearLayoutManager(context));
//            } else {
//                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
//            }
//            recyclerView.setAdapter(new MyRestaurantRecyclerViewAdapter(DummyContent.ITEMS, mListener));
//        }
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

//        if (context instanceof OnListFragmentInteractionListener) {
//            mListener = (OnListFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnListFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(DummyItem item);
    }
}
