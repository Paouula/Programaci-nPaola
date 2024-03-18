package paola.rivera.programacinpaola

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //1.Mandar a llamar a todos los elementos
        val txtNum1 = findViewById<EditText>(R.id.txtNum1)
        val txtNum2 = findViewById<EditText>(R.id.txtNum2)
        val btnSumar = findViewById<Button>(R.id.btnSumar)

        //Creo un objeto de la clase calculadora para que con ese objeto llamar al metodo de sumar
        val objCalculadora = Calculadora()

        //2.Programar los elementos
        btnSumar.setOnClickListener {
            objCalculadora.sumar(txtNum1.text.toString().toInt(), txtNum2.text.toString().toInt())
        }
    }
}