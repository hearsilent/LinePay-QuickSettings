package com.hearsilent.linepay.quicksettings

import android.content.Intent
import android.net.Uri
import android.service.quicksettings.TileService

class LinePayTileService : TileService() {

    override fun onClick() {
        super.onClick()
        val packageName = "com.linepaytw.upay"
        try {
            val intent = packageManager.getLaunchIntentForPackage(packageName)
            intent!!.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivityAndCollapse(intent)
        } catch (e: Exception) {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.data = Uri.parse("market://details?id=$packageName")
            startActivityAndCollapse(intent)
        }
    }
}