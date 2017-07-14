package com.example.justin.finalprojectbeyou;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.justin.finalprojectbeyou.adapter.ViewFragmentStateAdapter;
import com.example.justin.finalprojectbeyou.fragment.MusicFragment;
import com.example.justin.finalprojectbeyou.fragment.PhotosFragment;
import com.example.justin.finalprojectbeyou.fragment.ThoughtsFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FeedActivity extends BaseActivity {
    private ArrayList<Pair<String, Fragment>> list = new ArrayList<Pair<String, Fragment>>();

    @BindView(R.id.activity_advance_view_pager_tablayout)
    TabLayout tabLayout;

    @BindView(R.id.activity_advance_view_pager)
    ViewPager viewPager;

    @OnClick(R.id.activity_feed_profile_btn)
    public void feed (View v){
        goToActivity(ProfileActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        ButterKnife.bind(this);
        list.add(new Pair<String, Fragment>("Music", new MusicFragment()));
        list.add(new Pair<String, Fragment>("Photos", new PhotosFragment()));
        list.add(new Pair<String, Fragment>("Thoughts", new ThoughtsFragment()));
        ViewFragmentStateAdapter adapter = new ViewFragmentStateAdapter(this.getSupportFragmentManager(),list);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }
}
