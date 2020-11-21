package com.example.replicandoactivitis

import android.annotation.SuppressLint
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // constante de boton y texto
        val boton = findViewById<Button>(R.id.boton)
        val edit = findViewById<EditText>(R.id.texto)

        boton.setOnClickListener {
            // cuando tenemos que poner el R.string.comenzar, 1º hemos de importarlo en string's
            if (boton.text.equals(getString(R.string.comenzar))) {
                edit.setVisibility(View.VISIBLE)
                // lo mismo el finalizar ha de estar importado
                boton.setText(R.string.finalizar)
            } else {

                edit.onEditorAction(EditorInfo.IME_ACTION_DONE)
                edit.clearFocus()
                yodaGizmo(edit,boton)
            }
        }



    }
    @SuppressLint("ResourceAsColor", "WrongConstant")
    fun yodaGizmo(edit: EditText, boton:Button){
        // este corresponde al id de la foto del perro que tienes al lado !!! ainss
        val foto = findViewById<ImageView>(R.id.foto1)
        // este corresponder al id Principal
        val change = findViewById<ConstraintLayout>(R.id.Principal)
        if(edit.text.toString().toLowerCase().equals("yoda")){
            foto.setImageResource(R.mipmap.ic_joda_foreground)
            //cambiar el boton de color, hemos de importar el color en color obviously
            boton.setBackgroundColor(getColor(R.color.ColorJoda))
            //cambiar el background, tambien ha de estar importado
            change.setBackgroundColor(getColor(R.color.fondojoda))
            //cambiar el tipo de letra (esto funciona cuando quiere) pss
            boton.setTypeface(null, Typeface.ITALIC)
        }else if (edit.text.toString().toLowerCase().equals("gizmo")){
            foto.setImageResource(R.mipmap.ic_gizmo_foreground)
            //color boton
            boton.setBackgroundColor(getColor(R.color.ColorGizmo))
            //background
            change.setBackgroundColor(getColor(R.color.fondoGizmo))
            boton.setTextColor(getColor(R.color.black))
            boton.setTypeface(null,Typeface.NORMAL)

        }

    }

}