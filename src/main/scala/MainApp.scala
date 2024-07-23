import scalafx.Includes._
import scalafx.animation.FadeTransition
import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.scene.effect.DropShadow
import scalafx.scene.image.{Image, ImageView}
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle
import scalafx.scene.text.{Font, Text}
import scalafx.scene.{Group, Scene}
import scalafx.util.Duration //convert javafx to scalafx

object MainApp extends JFXApp {
  stage = new PrimaryStage {
    title = "AddressApp"
    scene = new Scene(500.0, 500.0) {
      val myfont = new Font("Impact",30)
      content = Seq(
        new Group(
          new Text(x = 20, y = 40, t = "Sunway") {
            font = myfont
            effect = new DropShadow(5.0,4,4,Color.Coral)
          },
          new Text(x = 20, y = 70, t = "Oh My God") {
            font = myfont
          } ,
          new ImageView(new Image(MainApp.getClass.getResourceAsStream("image_proxy.jpg"))){
            x = 150
            y = 150
            fitWidth = 200
            fitHeight = 200
          },
          new Rectangle() {
            x = 20
            y = 100
            width = 100
            height = 200
            fill = Color.DarkOrange
          }
        )
      )
      val ft = new FadeTransition(Duration(40), content.get(0)){
        fromValue = 0
        toValue = 100
        cycleCount = FadeTransition.Indefinite
        autoReverse = true
      }

      ft.play()
    }
  }
}
