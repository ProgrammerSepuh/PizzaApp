package com.example.pizzaapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class AddMenuActivity : AppCompatActivity() {
    lateinit var image : ImageView
    companion object{
        val IMAGE_REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_menu)

        //hide title bar
        getSupportActionBar()?.hide()

        image = findViewById(R.id.imageMenu)
        val textId : EditText = findViewById(R.id.menuId)
        val textName : EditText = findViewById(R.id.menuName)
        val textPrice : EditText = findViewById(R.id.menuPrice)
        val btnAddImage : Button = findViewById(R.id.buttonAddImage)
        val btnSaveMenu : Button = findViewById(R.id.buttonSaveMenu)

        btnAddImage.setOnClickListener {
            pickImageGalery()
        }
    }
    private fun pickImageGalery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/"
        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
            image.setImageURI()
        }
    }
}