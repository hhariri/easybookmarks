package com.hadihariri.easybookmarks.about

import com.hadihariri.easybookmarks.system.hideView
import com.hadihariri.easybookmarks.system.showView
import javafx.stage.Screen
import tornadofx.Controller
import tornadofx.FX
import java.awt.MouseInfo


class AboutController: Controller() {
    val aboutView: AboutView by inject()
    fun showAbout() {
        showView(aboutView)
    }

    fun close() {
        hideView()
    }
}