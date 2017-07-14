package com.example.justin.finalprojectbeyou.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.content.Intent;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

import com.example.justin.finalprojectbeyou.JorjaInterludeActivity;
import com.example.justin.finalprojectbeyou.MainActivity;
import com.example.justin.finalprojectbeyou.R;
import com.example.justin.finalprojectbeyou.RedboneActivity;
import com.example.justin.finalprojectbeyou.SlideActivity;
import com.example.justin.finalprojectbeyou.adapter.ListNormalAdapter;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MusicFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MusicFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private ListView listView;
    private final ArrayList <String> contentList;


    public MusicFragment() {
        contentList = new ArrayList <String>();
        contentList.add("Jorja Interlude / Drake");
        contentList.add("Redbone / Childish Gambino");
        contentList.add("Slide / Calvin Harris ft. Frank Ocean, Migos");
        contentList.add("That's What I Like / Bruno Mars");
        contentList.add("Whatever You Need / Meek Mill ft. Chris Brown");
        contentList.add("Crew / GoldLink ft. Brent Faiyaz, Shy Glizzy");
        contentList.add("I Miss That Whip / Anderson .Paak");
        contentList.add("The Weekend / SZA");
        contentList.add("Slippery / Migos ft. Gucci Mane");
        contentList.add("XO TOUR Llife3 / Lil Uzi Vert");
        contentList.add("Congratulations - Remix / Post Malone ft. Quavo, Future");
        contentList.add("Butterfly Effect / Travis Scott");
        contentList.add("Mask Off / Future");
        contentList.add("Magnolia / PlayBoi Carti");
        contentList.add("HUMBLE / Kendrick Lamar");
        contentList.add("Up / NAV");
        contentList.add("Neighbors / J. Cole");
        contentList.add("Do Not Disturb / Drake");
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BlueFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MusicFragment newInstance(String param1, String param2) {
        MusicFragment fragment = new MusicFragment();
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
        View view = inflater.inflate(R.layout.fragment_music, container, false);
        listView = (ListView)view.findViewById(R.id.fragment_demo_lv);
        ListNormalAdapter adapter;
        adapter = new ListNormalAdapter(this.getContext(),contentList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent = new Intent(getActivity(), JorjaInterludeActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent2 = new Intent(getActivity(), RedboneActivity.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3 = new Intent(getActivity(), SlideActivity.class);
                        startActivity(intent3);
                        break;

                    default:
                }
            }
        });
        return view;
    }

}

