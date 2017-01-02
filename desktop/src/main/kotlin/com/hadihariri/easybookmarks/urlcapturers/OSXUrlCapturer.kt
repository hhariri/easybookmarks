package com.hadihariri.easybookmarks.urlcapturers

import javax.script.ScriptEngineManager

class OSXUrlCapturer : UrlCapturer {
    override fun getUrl(): UrlInformation {
        try {
            val result = scriptEngine.eval("tell application \"System Events\" to (name of the first process whose frontmost is true)")
            println(result)
            when (result) {
                "Safari" -> return safari()
                "WebKit" -> return webkit()
                "Google Chrome Canary", "Google Chrome" -> return chrome()
                "Opera" -> return opera()
                "Camino" -> return camino()
                "OmniWeb" -> return omniweb()
                else -> {
                    return UrlInformation.Error("No valid application detected. No URL. Eventually we'll just use copy/paste!")
                }
            }
        } catch (e: Throwable) {
            return UrlInformation.Error("Cannot find active application: ${e.message}")
        }
    }

    override fun webkit(): UrlInformation {
        return executeScript("tell application \"WebKit\" to return (URL of current tab of window 1 as text)",
                "tell application \"WebKit\" to return (title of active tab of window 1 as text)")
    }

    override fun safari(): UrlInformation {
        return executeScript("tell application \"Safari\" to return (URL of current tab of window 1 as text)",
                "tell application \"Safari\" to return (name of current tab of window 1 as text)")
    }

    val scriptEngineManager = ScriptEngineManager()
    val scriptEngine = scriptEngineManager.getEngineByName("AppleScript")

    override fun opera(): UrlInformation {
        return executeScript("tell application \"Opera\" to return (URL of front window as text)",
                "tell application \"Opera\" to return (name of front window as text)")
    }

    override fun omniweb(): UrlInformation {
        return executeScript("tell application \"OmniWeb\" to return (address of active tab of front browser as text)",
                "tell application \"OmniWeb\" to return (title of active tab of front browser as text)")
    }

    override fun chrome(): UrlInformation {
        return executeScript("tell application \"Google Chrome\" to return (URL of active tab of window 1 as text)",
                "tell application \"Google Chrome\" to return (title of active tab of window 1 as text)")
    }

    override fun ie(): UrlInformation {
        return UrlInformation.Error("Not supported on OSX")
    }

    override fun edge(): UrlInformation {
        return UrlInformation.Error("Not supported on OSX")
    }

    override fun camino(): UrlInformation {
        return executeScript("tell application \"Camino\" to return (URL of current tab of front browser window as text)",
                "tell application \"Camino\" to return (name of current tab of front browser window as text)")
    }


    fun executeScript(urlCommand: String, titleCommand: String): UrlInformation {
        try {
            return UrlInformation.Success(
                    scriptEngine.eval(urlCommand).toString(),
                    scriptEngine.eval(titleCommand).toString())
        } catch (e: Throwable) {
            return UrlInformation.Error("Error retrieving URL: ${e.message}")
        }
    }

}