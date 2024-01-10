package com.example.navigationsincompose.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.example.navigationsincompose.R

sealed class NavItem (
    @StringRes title: Int,
    @DrawableRes icon: Int,
    navRoute: String
) {
    object Home: NavItem(R.string.home, androidx.core.R.drawable.ic_call_answer_video_low, "NAV_HOME")
    object Fav: NavItem(R.string.home, androidx.core.R.drawable.ic_call_answer_video_low, "NAV_HOME")
    object Feed: NavItem(R.string.home, androidx.core.R.drawable.ic_call_answer_video_low, "NAV_HOME")
    object Profile: NavItem(R.string.home, androidx.core.R.drawable.ic_call_answer_video_low, "NAV_HOME")
}