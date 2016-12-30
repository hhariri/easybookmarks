package com.hadihariri.easybookmarks

import AppSettings
import com.hadihariri.easybookmarks.about.AboutController
import com.hadihariri.easybookmarks.main.MainView
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

        popup.add(aboutItem)
        popup.addSeparator()
        popup.add(exitItem)
    }

}

fun main(args: Array<String>) {
    Application.launch(EasyBookmarkApp::class.java, *args)
}

/* aboutItem.addActionListener {
     val scriptEngineManager = ScriptEngineManager()
     val scriptEngine = scriptEngineManager.getEngineByName("AppleScript")
     try {
         val result = scriptEngine.eval("tell application \"Google Chrome\" to return (URL of active tab of window 1 as text)")
         JOptionPane.showMessageDialog(null, result, "Title", JOptionPane.INFORMATION_MESSAGE)
     } catch (e: Throwable) {
         JOptionPane.showMessageDialog(null, e.message, "Title", JOptionPane.INFORMATION_MESSAGE)

     }
 }*/

