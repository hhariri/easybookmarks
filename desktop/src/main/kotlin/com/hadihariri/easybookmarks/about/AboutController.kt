package com.hadihariri.easybookmarks.about

import javafx.stage.Screen
import tornadofx.Controller
import tornadofx.FX
import java.awt.MouseInfo


class AboutController: Controller() {
    val aboutView: AboutView by inject()

    fun showAbout() {
        // Try to detect the correct screen
        val robot = com.sun.glass.ui.Application.GetApplication().createRobot()
        val screen = Screen.getScreensForRectangle(robot.mouseX.toDouble(), robot.mouseY.toDouble(), 1.0, 1.0).firstOrNull()
        if (screen != null) {
            // Move into viewport of active screen
            primaryStage.x = screen.visualBounds.minX + 100
            primaryStage.y = screen.visualBounds.minY + 100
        }

        primaryStage.show()
    }

    fun close() {
        FX.primaryStage.hide()
    }
}