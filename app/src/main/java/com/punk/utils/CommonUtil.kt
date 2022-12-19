package com.punk.utils

import android.content.Context

class CommonUtil {

    companion object {

        fun isConnectingToInternet(context: Context): Boolean {
            val connectionDetector = ConnectionDetector(context)
            return connectionDetector.isConnectingToInternet()
        }
    }
}