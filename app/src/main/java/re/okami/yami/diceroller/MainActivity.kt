package re.okami.yami.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView
    lateinit var diceImage2: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)

        val rollButton: Button = findViewById(R.id.roll_button)
        val resultText: TextView = findViewById(R.id.result_Text)
        rollButton.setOnClickListener {
            var wins = 0
            val games = 1000
            repeat(games) {
                var result1 = rollDice(diceImage)
                var result2 = rollDice2(diceImage2)
                if (result1 == result2) {
                    wins++

                }
            }
            resultText.text = "number of wins: $wins"

        }

    }

    fun getImage(diceRoll: Int): Int {
        return when (diceRoll) {

            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    fun rollDice(diceImage: ImageView): Int {

        val randomInt = Random().nextInt(6) + 1
        val randomInt2 = Random().nextInt(6) + 1

        val drawableResource = getImage(randomInt)
        val drawableResource2 = getImage(randomInt2)


        diceImage.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableResource2)
        return randomInt

    }

    fun rollDice2(diceImage2: ImageView): Int {

        val randomInt = Random().nextInt(6) + 1
        val randomInt2 = Random().nextInt(6) + 1

        val drawableResource = getImage(randomInt)
        val drawableResource2 = getImage(randomInt2)


        diceImage.setImageResource(drawableResource)
        diceImage2.setImageResource(drawableResource2)
        return randomInt

    }

}
