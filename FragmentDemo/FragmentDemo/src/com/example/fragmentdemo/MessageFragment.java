package com.example.fragmentdemo;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class MessageFragment extends Fragment implements OnClickListener {
	private TextView tv_hot,tv_his;
	private ViewPager pager;
	private ArrayList<Fragment> fragments = new ArrayList<Fragment>();
	private int currentIndex = 0;
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View messageLayout = inflater.inflate(R.layout.message_layout,
				container, false);
		initView(messageLayout);
		return messageLayout;
	}

	private void initView(View messageLayout) {
		// TODO Auto-generated method stub
		tv_hot = (TextView) messageLayout.findViewById(R.id.tv_hot);
		tv_his = (TextView) messageLayout.findViewById(R.id.tv_his);
		pager = (ViewPager) messageLayout.findViewById(R.id.cust_pager);
		fragments.add(new HotFragment());
		fragments.add(new HistoryFragment());
		pager.setAdapter(new MyFragmentPagerAdapter(getChildFragmentManager(), fragments));
		pager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int pos) {
				// TODO Auto-generated method stub
				setSelectPager(pos);
				currentIndex = pos;
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		tv_hot.setOnClickListener(this);
		tv_his.setOnClickListener(this);
		pager.setCurrentItem(0);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.tv_hot:
			pager.setCurrentItem(0);
			break;
		case R.id.tv_his:
			pager.setCurrentItem(1);
			break;

		default:
			break;
		}
	}
	private void setSelectPager(int index){
		switch (index) {
		case 0:
			tv_hot.setBackgroundResource(R.drawable.rectangle_backgroud);
			tv_his.setBackgroundResource(android.R.color.white);
			break;
		case 1:
			tv_his.setBackgroundResource(R.drawable.rectangle_backgroud);
			tv_hot.setBackgroundResource(android.R.color.white);
			break;

		default:
			break;
		}
	}
}
