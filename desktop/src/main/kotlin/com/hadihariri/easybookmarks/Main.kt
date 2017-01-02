package com.hadihariri.easybookmarks

import com.hadihariri.easybookmarks.AppSettings
import com.hadihariri.easybookmarks.about.AboutController
import com.hadihariri.easybookmarks.capture.CaptureController
import com.hadihariri.easybookmarks.main.MainView
import com.hadihariri.easybookmarks.settings.SettingsController
import javafx.application.Application
import javafx.application.Platform
import javafx.stage.Stage
import tornadofx.App
import java.awt.*
import java.io.IOException
import javax.swing.SwingUtilities


class EasyBookmarkApp : App(MainView::class) {

    override fun shouldShowPrimaryStage() = false

    override fun start(stage: Stage) {
        super.start(stage)
        Platform.setImplicitExit(false)
        SwingUtilities.invokeLater { this.addAppToTray() }

    }

    private fun addAppToTray() {
        try {
            Toolkit.getDefaultToolkit()
            if (!SystemTray.isSupported()) {
                println("Creating system tray not supported")
                Platform.exit()
            }
            val tray = SystemTray.getSystemTray()
            val trayIcon = TrayIcon(AppSettings.icon)

            setupMenu(tray, trayIcon)

            tray.add(trayIcon)
        } catch (e: AWTException) {
            println("Unable to init system tray")
            e.printStackTrace()
        } catch (e: IOException) {
            println("Unable to init system tray")
            e.printStackTrace()
        }

    }

    private fun setupMenu(tray: SystemTray, trayIcon: TrayIcon) {
        val popup = PopupMenu()
        trayIcon.popupMenu = popup

        val exitItem = MenuItem("Exit")
        exitItem.addActionListener({
            Platform.exit()
            tray.remove(trayIcon)
        })
        val aboutItem = MenuItem("About")
        aboutItem.addActionListener {
            Platform.runLater {
                AboutController().showAbout()
            }
        }
        val settingsItem = MenuItem("Settings")
        settingsItem.addActionListener {
            Platform.runLater {
                SettingsController().showSettings()
            }
        }

        val captureItem = MenuItem("Capture")
        captureItem.addActionListener {
            Platform.runLater {
                CaptureController().showCapture()
            }
        }

        popup.add(captureItem)
        popup.add(settingsItem)
        popup.add(aboutItem)
        popup.addSeparator()
        popup.add(exitItem)
    }

}

fun main(args: Array<String>) {
    Application.launch(EasyBookmarkApp::class.java, *args)
}



