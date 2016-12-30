import java.awt.Image
import java.io.File
import java.util.*
import javax.imageio.ImageIO

/**
 * Created by hadihariri on 29/12/16.
 */

object AppSettings {
    val version: String by lazy {
        val propertyStream = this.javaClass.classLoader.getResourceAsStream("version.properties")
        val properties = Properties()
        properties.load(propertyStream)
        properties["version"].toString()
    }

    val icon: Image by lazy {
        ImageIO.read(this.javaClass.classLoader.getResourceAsStream("icon.png"))
    }
}