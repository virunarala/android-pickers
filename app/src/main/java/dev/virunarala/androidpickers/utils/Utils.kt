package dev.virunarala.androidpickers.utils

import android.content.Context
import java.io.File

enum class FileExtensions(val extension: String) {
    JPG(".jpg"),
    PNG(".png"),
    PDF(".pdf")
}

fun createInternalFile(context: Context, extension: String): File {
    val fileName = "${System.currentTimeMillis()}$extension"
    val file = File(context.filesDir, fileName)
    return file
}