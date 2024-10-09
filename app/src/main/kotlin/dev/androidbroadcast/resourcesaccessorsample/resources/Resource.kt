@file:Suppress("unused")

package dev.androidbroadcast.resourcesaccessorsample.resources

import androidx.annotation.ColorRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

/**
 * Абстракция над ресурсом
 *
 * @param T - тип, который возвращается в результате получения ресурса
 */
sealed interface Resource<out T : Any> {

    val resId: Int

    @JvmInline
    value class String(@StringRes override val resId: Int) : Resource<kotlin.String>

    @JvmInline
    value class Text(@StringRes override val resId: Int) : Resource<CharSequence>

    @JvmInline
    value class Integer(@IntegerRes override val resId: Int) : Resource<Int>

    @JvmInline
    value class Color(@ColorRes override val resId: Int) : Resource<Int>
}
