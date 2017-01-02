package com.hadihariri.easybookmarks.capture

import com.hadihariri.easybookmarks.OSXUrlCapturer
import com.hadihariri.easybookmarks.UrlInformation
import com.hadihariri.easybookmarks.showView
import tornadofx.Controller


class CaptureController: Controller() {
    val model: CaptureViewModel by inject()
    val captureView: CaptureView by inject()

    fun showCapture() {
        // TODO: Figure out OS
        val osx = OSXUrlCapturer()
        val result = osx.getUrl()
        if (result is UrlInformation.Success) {
            model.title.value = result.title
            model.url.value = result.url
            showView(captureView)
        } else {
            TODO((result as UrlInformation.Error).message)
        }
    }
}