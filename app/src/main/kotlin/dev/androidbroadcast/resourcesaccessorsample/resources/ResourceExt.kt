@file:Suppress("unused")

package dev.androidbroadcast.resourcesaccessorsample.resources

import android.content.Context
import android.content.res.Resources
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment

@Suppress("UNCHECKED_CAST")
fun <T : Any> Context.resolve(resource: Resource<T>): T = when (resource) {
    is Resource.Color -> getColor(resource.resId) as T
    else -> resources.resolve(resource)
}

fun <T : Any> Fragment.resolve(resource: Resource<T>): T = requireContext().resolve(resource)

@Suppress("UNCHECKED_CAST")
fun <T : Any> Resources.resolve(resource: Resource<T>): T = when (resource) {
    is Resource.String -> getString(resource.resId) as T
    is Resource.Text -> getText(resource.resId) as T
    is Resource.Integer -> getInteger(resource.resId) as T
    is Resource.Color -> ResourcesCompat.getColor(this, resource.resId, null) as T
}

@Composable
fun <T : Any> resolveResource(resource: Resource<T>): T {
    return LocalContext.current.resolve(resource)
}
