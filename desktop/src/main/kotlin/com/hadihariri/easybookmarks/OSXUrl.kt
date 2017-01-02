package com.hadihariri.easybookmarks

import javax.script.ScriptEngineManager


class OSXUrl {

    val scriptEngineManager = ScriptEngineManager()
    val scriptEngine = scriptEngineManager.getEngineByName("AppleScript")

    fun chromeUrl(): String {
        try {
            return scriptEngine.eval("tell application \"Google Chrome\" to return (URL of active tab of window 1 as text)").toString()
        } catch (e: Throwable) {
            return "Error retrieving URL from Chrome: ${e.message}"
        }
    }
}