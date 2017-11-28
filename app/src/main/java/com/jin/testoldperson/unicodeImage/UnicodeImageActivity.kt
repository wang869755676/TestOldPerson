package com.jin.testoldperson.unicodeImage

import android.app.Activity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.EditText

import com.jin.testoldperson.R
import kotlinx.android.synthetic.main.activity_unicode_image. *

class UnicodeImageActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_unicode_image)
        edittext.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) = Unit

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) =
                    Unit

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.e("==", s.toString() + "");
            }
        })
    }
}
