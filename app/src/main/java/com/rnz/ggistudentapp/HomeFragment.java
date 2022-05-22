package com.rnz.ggistudentapp;



import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rnz.ggistudentapp.Adapters.AnnouncementAdapter;
import com.rnz.ggistudentapp.Adapters.SpaceAdapter;
import com.rnz.ggistudentapp.Models.AnnouncementModel;
import com.rnz.ggistudentapp.Models.SpaceModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.

 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
   private RecyclerView recyclerView,recyclerView1;
/*

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor

    }
    ..

    *//**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *

     * @return A new instance of fragment HomeFragment.
     *//*
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/

/*    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
  *//*      if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*//*



        //error

    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        // Inflate the layout for this fragment

         recyclerView = view.findViewById(R.id.homerecycler);
     recyclerView1 = view.findViewById(R.id.homerecycler1);
    ArrayList<SpaceModel> horizontallist = new ArrayList<>();

//        horizontallist.add(new SpaceModel(R.drawable.fb));
//        horizontallist.add(new SpaceModel(R.drawable.gp));
//        horizontallist.add(new SpaceModel(R.drawable.logpng));
/*        horizontallist.add(new SpaceModel(12, "test 1"));
        horizontallist.add(new SpaceModel(12, "test 2"));
        horizontallist.add(new SpaceModel(12, "test 3"));
        horizontallist.add(new SpaceModel(12, "test 4"));*/
        horizontallist.add(new SpaceModel(R.drawable.notes,"Notes"));
        horizontallist.add(new SpaceModel(R.drawable.exam,"Previous Paper"));
        horizontallist.add(new SpaceModel(R.drawable.doubt,"Ask doubt"));
        horizontallist.add(new SpaceModel(R.drawable.ic_add,"Add"));


        ArrayList<AnnouncementModel> list = new ArrayList<>();

         list.add(new AnnouncementModel("22/22/2222","C6","Leave Notice","This is the announcement for c6 batch that our college is going to be shutting down soon"));
        list.add(new AnnouncementModel("22/22/2222","C6","Leave Notice","This is the announcement for c6 batch that our college is going to be shutting down soon"));
        list.add(new AnnouncementModel("22/22/2222","C6","Leave Notice","This is the announcement for c6 batch that our college is going to be shutting down soon"));
        list.add(new AnnouncementModel("22/22/2222","C6","Leave Notice","This is the announcement for c6 batch that our college is going to be shutting down soon"));
        list.add(new AnnouncementModel("22/22/2222","C6","Leave Notice","This is the announcement for c6 batch that our college is going to be shutting down soon"));
        list.add(new AnnouncementModel("22/22/2222","C6","Leave Notice","This is the announcement for c6 batch that our college is going to be shutting down soon"));
        list.add(new AnnouncementModel("22/22/2222","C6","Leave Notice","This is the announcement for c6 batch that our college is going to be shutting down soon"));
        list.add(new AnnouncementModel("22/22/2222","C6","Leave Notice","This is the announcement for c6 batch that our college is going to be shutting down soon"));
        list.add(new AnnouncementModel("22/22/2222","C6","Leave Notice","This is the announcement for c6 batch that our college is going to be shutting down soon"));

        recyclerView.setHasFixedSize(true);
 recyclerView1.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
   recyclerView1.setLayoutManager(new LinearLayoutManager(view.getContext()));
        recyclerView1.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,
                false));
 recyclerView.setAdapter(new AnnouncementAdapter(list,getContext()));
        recyclerView1.setAdapter(new SpaceAdapter(horizontallist,getContext()));
        return view;
    }
}

