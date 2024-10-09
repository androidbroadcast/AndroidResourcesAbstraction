@file:Suppress("unused")

package dev.androidbroadcast.resourcesaccessorsample

import android.content.Context
import java.io.File
import java.io.IOException

// Слой бизнес логики
class FileRenamer(private val context: Context) {

    fun renameFile(files: List<File>): List<File> {
        return files.map { file ->
            file.addNamePrefix(prefix = context.getString(R.string.file_name_prefix))
        }
    }
}

private fun File.addNamePrefix(prefix: String): File {
    val newPath = absolutePath.replaceAfterLast(delimiter = "/", name, prefix + name)
    return File(newPath).also { file ->
        if (!renameTo(file)) throw IOException("Can't rename ${this@addNamePrefix}")
    }
}
