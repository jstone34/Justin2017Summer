package com.example.justin.justin2017summer.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

import com.example.justin.justin2017summer.LaunchModeActivity;
import com.example.justin.justin2017summer.R;
import com.example.justin.justin2017summer.ViewPagerActivity;
import com.example.justin.justin2017summer.adapter.ListNormalAdapter;
import com.example.justin.justin2017summer.adapter.ScalePagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DemoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DemoFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView listView;
    private final ArrayList <String> contentList;


    public DemoFragment() {

        contentList = new ArrayList <String>();
        contentList.add("View Pager");
        contentList.add("Image Scale Type");
        contentList.add("9Patch");
        contentList.add("A");
        contentList.add("B");
        contentList.add("B");
        contentList.add("Launch Mode");
        contentList.add("E");
        contentList.add("F");
        contentList.add("G");
        contentList.add("H");

    }


    // TODO: Rename and change types and number of parameters
    public static DemoFragment newInstance(String param1, String param2) {
        DemoFragment fragment = new DemoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_demo, container, false);
        listView = (ListView)view.findViewById(R.id.fragment_demo_lv);
        ListNormalAdapter adapter;
        adapter = new ListNormalAdapter(this.getContext(),contentList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(getActivity(), ViewPagerActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1 = new Intent(getActivity(), ScaleTypeActivity.class);
                        startActivity(intent1);
                        break;
                    case 6:
                        Intent intent6 = new Intent(getActivity(), LaunchModeActivity.class);
                        startActivity(intent6);
                        break;
                    default:
                }
            }
        });
        return view;
    }

}
