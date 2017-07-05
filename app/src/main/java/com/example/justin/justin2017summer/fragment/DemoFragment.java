package com.example.justin.justin2017summer.fragment;


import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Objects;

import com.example.justin.justin2017summer.ActivityA;
import com.example.justin.justin2017summer.ActivityC;
import com.example.justin.justin2017summer.AdvanceListViewActivity;
import com.example.justin.justin2017summer.AdvanceViewPagerActivity;
import com.example.justin.justin2017summer.AnimationActivity;
import com.example.justin.justin2017summer.AnimatorActivity;
import com.example.justin.justin2017summer.CheckBoxActivity;
import com.example.justin.justin2017summer.DialogActivity;
import com.example.justin.justin2017summer.GestureActivity;
import com.example.justin.justin2017summer.HandlerActivity;
import com.example.justin.justin2017summer.NinePatchActivity;
import com.example.justin.justin2017summer.NotificationActivity;
import com.example.justin.justin2017summer.R;
import com.example.justin.justin2017summer.RadioGroupActivity;
import com.example.justin.justin2017summer.ResultActivity;
import com.example.justin.justin2017summer.ResultActivity1;
import com.example.justin.justin2017summer.RunnableHandlerActivity;
import com.example.justin.justin2017summer.ScaleTypeActivity;
import com.example.justin.justin2017summer.ServiceActivity;
import com.example.justin.justin2017summer.SharedPreferenceActivity;
import com.example.justin.justin2017summer.TestAudioActivity;
import com.example.justin.justin2017summer.ViewPagerActivity;
import com.example.justin.justin2017summer.adapter.ListNormalAdapter;
import com.example.justin.justin2017summer.audio.BaseBean;

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
        contentList.add("Notification");
        contentList.add("Advance List View");
        contentList.add("Advance View Pager");
        contentList.add("Launch Mode");
        contentList.add("Activity Result");
        contentList.add("Radio Group");
        contentList.add("Check Box");
        contentList.add("Dialogs");
        contentList.add("Handler");
        contentList.add("Handler Runnable");
        contentList.add("Animation");
        contentList.add("Animator");
        contentList.add("Gesture");
        contentList.add("Shared Preference");
        contentList.add("Service & Broadcast");
        contentList.add("Audio Player");




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
                    case 2:
                        Intent intent2 = new Intent(getActivity(), NinePatchActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3 = new Intent(getActivity(), NotificationActivity.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4 = new Intent(getActivity(), AdvanceListViewActivity.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        Intent intent5 = new Intent(getActivity(), AdvanceViewPagerActivity.class);
                        startActivity(intent5);
                        break;
                    case 6:
                        Intent intent6 = new Intent(getActivity(), ActivityA.class);
                        intent6.putExtra("StringInfo","fromDemoFragment");
                        intent6.putExtra("IntegerInfo", 10);
                        Bundle bundle = new Bundle();
                        BaseBean bean = new BaseBean();
                        bean.setName("bean");
                        bundle.putSerializable("Object", bean);
                        bundle.putString("StringBundle","FromBundle");
                        bundle.putInt("IntegerBundle",101);
                        intent6.putExtra("Bundle", bundle);
                        startActivity(intent6);
                        break;
                    case 7:
                        Intent intent7 = new Intent(getActivity(), ResultActivity.class);
                        startActivityForResult(intent7, 400);
                        break;
                    case 8:
                        Intent intent8 = new Intent(getActivity(), RadioGroupActivity.class);
                        startActivity(intent8);
                        break;
                    case 9:
                        Intent intent9 = new Intent(getActivity(), CheckBoxActivity.class);
                        startActivity(intent9);
                        break;
                    case 10:
                        Intent intent10 = new Intent(getActivity(), DialogActivity.class);
                        startActivity(intent10);
                        break;
                    case 11:
                        Intent intent11 = new Intent(getActivity(), HandlerActivity.class);
                        startActivity(intent11);
                        break;
                    case 12:
                        Intent intent12 = new Intent(getActivity(), RunnableHandlerActivity.class);
                        startActivity(intent12);
                        break;
                    case 13:
                        Intent intent13 = new Intent(getActivity(), AnimationActivity.class);
                        startActivity(intent13);
                        break;
                    case 14:
                        Intent intent14 = new Intent(getActivity(), AnimatorActivity.class);
                        startActivity(intent14);
                        break;
                    case 15:
                        Intent intent15 = new Intent(getActivity(),GestureActivity.class);
                        startActivity(intent15);
                        break;
                    case 16:
                        Intent intent16 = new Intent(getActivity(),SharedPreferenceActivity.class);
                        startActivity(intent16);
                        break;
                    case 17:
                        Intent intent17 = new Intent(getActivity(),ServiceActivity.class);
                        startActivity(intent17);
                        break;
                    case 18:
                        Intent intent18 = new Intent(getActivity(),TestAudioActivity.class);
                        startActivity(intent18);
                        break;

                    default:
                }
            }
        });
        return view;
    }

}
