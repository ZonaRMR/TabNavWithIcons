package com.suedinym.tabnavwithicons.adapters;

/**
 * Created by sue on 11/29/15.
 */

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;

import com.suedinym.tabnavwithicons.R;
import com.suedinym.tabnavwithicons.fragments.FourFragment;
import com.suedinym.tabnavwithicons.fragments.OneFragment;
import com.suedinym.tabnavwithicons.fragments.ThreeFragment;
import com.suedinym.tabnavwithicons.fragments.TwoFragment;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    protected Context mContext;



    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new OneFragment();
            case 1:
                return new TwoFragment();
            case 2:
                return new ThreeFragment();
            case 3:
                return new FourFragment();
        }
        return null;

    }

    @Override
    public int getCount() {

        return 4;
    }







/*  @Override
        public CharSequence getPageTitle(int position) {



         switch (position) {
                case 0:
                    return mContext.getString(R.string.section_one);
                case 1:
                    return mContext.getString(R.string.section_two);
                case 2:
                    return mContext.getString(R.string.section_three);
                case 3:
                    return mContext.getString(R.string.section_four);
            }
            return null;
        }*/

    private int[] imageResId = {
            R.drawable.ic_about,
            R.drawable.ic_mission,
            R.drawable.ic_exp,
            R.drawable.ic_edu
    };
    @Override
    public CharSequence getPageTitle(int position) {
        //  Drawable image = getResources().getDrawable(imageResId[position]);
        Drawable image = ContextCompat.getDrawable(mContext, imageResId[position]);
        //  Drawable image = mContext.getResources().getDrawable(imageResId[position]);
        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
        SpannableString sb = new SpannableString(" ");
        ImageSpan imageSpan = new ImageSpan(image, ImageSpan.ALIGN_BOTTOM);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return sb;
    }
}
