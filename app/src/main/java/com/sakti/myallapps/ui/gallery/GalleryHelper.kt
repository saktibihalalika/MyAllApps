package com.sakti.myallapps.ui.gallery

import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore

object GalleryHelper {
    fun getAllPhotos(context: Context): List<String> {
        val uri: Uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        val projection = arrayOf(MediaStore.Images.Media.DATA)
        val cursor: Cursor? = context.contentResolver.query(
            uri,
            projection,
            null,
            null,
            MediaStore.Images.ImageColumns.DATE_TAKEN + " DESC"
        )
        val columnIndex = cursor?.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        val photoPaths = mutableListOf<String>()
        while (cursor?.moveToNext() == true) {
            columnIndex?.let {
                val photoPath = cursor.getString(it)
                photoPaths.add(photoPath)
            }
        }
        cursor?.close()
        return photoPaths
    }
}
