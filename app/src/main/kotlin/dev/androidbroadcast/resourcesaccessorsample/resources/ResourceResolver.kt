@file:Suppress("unused")

package dev.androidbroadcast.resourcesaccessorsample.resources

interface ResourceResolver {

    fun <T : Any> resolve(resource: Resource<T>): T
}
