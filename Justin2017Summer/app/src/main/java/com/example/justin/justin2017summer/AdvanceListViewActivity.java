package com.example.justin.justin2017summer;

import android.app.AlertDialog;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.justin.justin2017summer.adapter.AdvanceListViewAdapter;
import com.example.justin.justin2017summer.adapter.BaseViewPagerAdapter;
import com.example.justin.justin2017summer.fragment.BlueFragment;
import com.example.justin.justin2017summer.fragment.GreenFragment;
import com.example.justin.justin2017summer.fragment.RedFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdvanceListViewActivity extends BaseActivity {
    private ViewPager viewPager;
    private ArrayList<Fragment> list = new ArrayList<Fragment>();

    @BindView(R.id.activity_advance_list_view) ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_advance);
        ButterKnife.bind(this);
        viewPager = (ViewPager)findViewById(R.id.activity_view_pager);
        list.add(new RedFragment());
        list.add(new GreenFragment());
        list.add(new BlueFragment());
        BaseViewPagerAdapter pagerAdapter = new BaseViewPagerAdapter(getSupportFragmentManager(),list);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(0);


        ArrayList<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("Hello, How are you?");
        list.add("I'm fine, thank you!");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");
        list.add("Hello");



        AdvanceListViewAdapter adapter = new AdvanceListViewAdapter(this, list);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showToast(String.valueOf(position));
            }
        });

    }
}
