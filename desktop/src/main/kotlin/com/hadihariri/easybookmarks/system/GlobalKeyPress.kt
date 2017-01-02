package com.hadihariri.easybookmarks.system

import com.hadihariri.easybookmarks.capture.CaptureController
import javafx.application.Platform
import org.jnativehook.keyboard.NativeKeyEvent
import org.jnativehook.keyboard.NativeKeyListener
import sun.jvm.hotspot.HelloWorld.e




class GlobalKeyPress: NativeKeyListener {
    override fun nativeKeyTyped(p0: NativeKeyEvent) {
    }

    override fun nativeKeyPressed(p0: NativeKeyEvent) {
        val isAltPressed = (p0.modifiers and NativeKeyEvent.ALT_MASK !== 0)
        val isShiftPressed = (p0.modifiers and NativeKeyEvent.CTRL_L_MASK !== 0)
        if (p0.keyCode == 29 && isAltPressed && isShiftPressed) {
            Platform.runLater {
                CaptureController().showCapture()
            }
        }
    }

    override fun nativeKeyReleased(p0: NativeKeyEvent) {
    }
}