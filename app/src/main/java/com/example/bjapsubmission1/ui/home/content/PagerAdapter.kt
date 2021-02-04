package com.example.bjapsubmission1.ui.home.content

import android.content.Context
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.bjapsubmission1.R
import com.example.bjapsubmission1.ui.home.fragment.MovieFragment
import com.example.bjapsubmission1.ui.home.fragment.TvFragment

class PagerAdapter (private val mContext: Context, fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val tabTitle = intArrayOf(R.string.movie, R.string.tv_show)

    override fun getCount(): Int = tabTitle.size

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = MovieFragment()
            1 -> fragment = TvFragment()
        }

        return fragment as Fragment
    }

    @Nullable
    override fun getPageTitle(position: Int): CharSequence {
        return mContext.resources.getString(tabTitle[position])
    }

}