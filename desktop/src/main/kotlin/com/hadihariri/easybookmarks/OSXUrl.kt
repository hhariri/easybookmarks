package com.hadihariri.easybookmarks

import com.hadihariri.easybookmarks.data.UrlInformation
import javax.script.ScriptEngineManager


class OSXUrl {

    val scriptEngineManager = ScriptEngineManager()
    val scriptEngine = scriptEngineManager.getEngineByName("AppleScript")

    fun chrome(): UrlInformation {
        try {
            return UrlInformation(
                scriptEngine.eval("tell application \"Google Chrome\" to return (URL of active tab of window 1 as text)").toString(),
                scriptEngine.eval("tell application \"Google Chrome\" to return (title of active tab of window 1 as text)").toString())
        } catch (e: Throwable) {
            return UrlInformation("Error retrieving URL from Chrome: ${e.message}","")
        }
    }

}