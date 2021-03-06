package com.david.test.driver.adapter;

import com.david.test.driver.fragment.GamesFragment;
import com.david.test.driver.fragment.MoviesFragment;
import com.david.test.driver.fragment.TopRatedFragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {
	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {
		switch(index){
		case 0:
			return new TopRatedFragment();
		case 1:
			return new GamesFragment();
		case 2:
			return new MoviesFragment();
		}
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}

}
