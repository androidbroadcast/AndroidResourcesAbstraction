@file:Suppress("unused")

package dev.androidbroadcast.resourcesaccessorsample.resources

import android.content.Context
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.StringRes

interface ResourceManager {

    fun getString(@StringRes id: Int): String

    fun getText(@StringRes id: Int): CharSequence

    @ColorInt
    fun getColor(@ColorRes id: Int): Int
}

class AndroidResourcesManager(private val context: Context) : ResourceManager {

    override fun getString(@StringRes id: Int): String = context.getString(id)

    override fun getText(@StringRes id: Int): CharSequence = context.getText(id)

    @ColorInt
    override fun getColor(id: Int): Int = context.getColor(id)
}
