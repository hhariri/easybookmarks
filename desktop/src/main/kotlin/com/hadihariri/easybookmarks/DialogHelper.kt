package com.hadihariri.easybookmarks

import javafx.stage.Screen
import tornadofx.FX.Companion.primaryStage
import tornadofx.View


fun showView(view: View) {
    // Try to detect the correct screen
    val robot = com.sun.glass.ui.Application.GetApplication().createRobot()
    val screen = Screen.getScreensForRectangle(robot.mouseX.toDouble(), robot.mouseY.toDouble(), 1.0, 1.0).firstOrNull()
    if (screen != null) {
        primaryStage.x = screen.visualBounds.minX + 100
        primaryStage.y = screen.visualBounds.minY + 100
    }
    primaryStage.scene.root = view.root
    primaryStage.show()
    primaryStage.toFront()
}

fun hideView() {
    primaryStage.hide()
}


