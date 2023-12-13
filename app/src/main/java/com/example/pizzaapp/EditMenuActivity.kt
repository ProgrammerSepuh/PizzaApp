package com.example.pizzaapp

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.pizzaapp.model.MenuModel

class EditMenuActivity : AppCompatActivity() {
    lateinit var image : ImageView
    companion object{
        val IMAGE_REQUEST_CODE = 100

        var idMakanan = 1
        var namaMakanan = "Unknown"
        var hargaMakanan = 50000
        lateinit var gambarMakanan: Bitmap
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_menu)

        //hide title bar
        getSupportActionBar()?.hide()

        image = findViewById(R.id.imageMenu)
        val textId : EditText = findViewById(R.id.menuId)
        val textName : EditText = findViewById(R.id.menuName)
        val textPrice : EditText = findViewById(R.id.menuPrice)
        val btnAddImage : Button = findViewById(R.id.buttonAddImage)
        val btnUpdate : Button = findViewById(R.id.buttonUpdateMenu)

        //set data
        textId.setText(idMakanan.toString())
        textName.setText(namaMakanan)
        textPrice.setText(hargaMakanan.toString())
        image.setImageBitmap((gambarMakanan))

        btnAddImage.setOnClickListener {
            //pickImageGalery()
        }

        btnUpdate.setOnClickListener{
            //object class
            val databaseHelper = DatabaseHelper(this)
            val bitmapDrawable : BitmapDrawable = image.drawable as BitmapDrawable
            val bitmap : Bitmap = bitmapDrawable.bitmap

            val menuModel = MenuModel(
                textId.text.toString().toInt(),
                textName.text.toString().trim(),
                textPrice.text.toString().toInt(),
                bitmap
            )
            //databaseHelper.addMenu(menuModel)
        }
    }

    private fun pickImageGalery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/"
        //startActivityForResult(intent, AddMenuActivity.IMAGE_REQUEST_CODE)
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if(requestCode == AddMenuActivity.IMAGE_REQUEST_CODE && resultCode == RESULT_OK){
//            image.setImageURI(data?.data)
//        }
//    }
}