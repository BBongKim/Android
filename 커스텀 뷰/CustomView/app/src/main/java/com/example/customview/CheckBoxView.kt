package com.example.customview

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.CheckBox
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.content.res.AppCompatResources

class CheckBoxView : LinearLayout {

    private val layout: LinearLayout = LinearLayout(context)
    private val textView: TextView = TextView(context)
    private val checkBox: CheckBox = CheckBox(context)

    private var checkBoxSize: Float = 0f
    private var checkBoxColor: Int = 0

    private var textSize: Float = 0f
    private var textColor: Int = 0
    private var text: String = ""

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        getAttrs(attrs)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        getAttrs(attrs, defStyle)
    }

    private fun getAttrs(attrs: AttributeSet) {
        val types = context.obtainStyledAttributes(attrs, R.styleable.CheckBoxView)
        setTypedArray(types)
    }

    private fun getAttrs(attrs: AttributeSet, defStyle: Int) {
        val types = context.obtainStyledAttributes(attrs, R.styleable.CheckBoxView, defStyle, 0)
        setTypedArray(types)
    }

    private fun setTypedArray(types: TypedArray) {
        try {
            checkBoxSize = types.getFloat(R.styleable.CheckBoxView_checkBoxScale, 10f)
            checkBoxColor = types.getResourceId(R.styleable.CheckBoxView_checkBoxColor, R.color.teal_200)
            textSize = types.getDimension(R.styleable.CheckBoxView_textSize, 10f)
            textColor = types.getResourceId(R.styleable.CheckBoxView_textColor, com.google.android.material.R.color.secondary_text_default_material_light)
            text = types.getString(R.styleable.CheckBoxView_text).toString()

            textView.textSize = textSize
            textView.setTextColor(AppCompatResources.getColorStateList(context, textColor))
            textView.text = text

            checkBox.scaleX = checkBoxSize
            checkBox.scaleY = checkBoxSize
            checkBox.buttonTintList = AppCompatResources.getColorStateList(context, checkBoxColor)

            layout.orientation = HORIZONTAL

            val param = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT)

            textView.layoutParams = param
            checkBox.layoutParams = param

            layout.addView(checkBox)
            layout.addView(textView)

            addView(layout)
        } finally {
            types.recycle()
        }
    }

    fun getText(): String {
        return text
    }

    fun isChecked(): Boolean {
        return checkBox.isChecked
    }
}