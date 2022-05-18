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
    
    constructor(context: Context) : super(context) {
        
    }
    
    // xml에 설정된 attribute가 있으면 호출된다.
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        getAttrs(attrs)
    }

    // defStyle는 모든 커스텀 뷰의 style을 같게 하고 싶을 때 사용한다고 하는데, 
    // application style을 새로 만든 후, 커스텀뷰의 attr을 일부러 설정 안해봤다. 생성자에 로그를 해놨는데 이래도 호출이 안된다. 좀 더 자세히 알아봐야겠다.
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

    private fun setTypedArray(a: TypedArray) {
        try {
            // xml에서 지정한 attribute 값 가져오기
            checkBoxSize = a.getFloat(R.styleable.CheckBoxView_checkBoxScale, 10f)
            checkBoxColor = a.getResourceId(R.styleable.CheckBoxView_checkBoxColor, R.color.teal_200)
            textSize = a.getDimension(R.styleable.CheckBoxView_textSize, 10f)
            textColor = a.getResourceId(R.styleable.CheckBoxView_textColor, com.google.android.material.R.color.secondary_text_default_material_light)
            text = a.getString(R.styleable.CheckBoxView_text).toString()

            
            // TextView 값 설정
            textView.textSize = textSize
            textView.setTextColor(AppCompatResources.getColorStateList(context, textColor))
            textView.text = text

            // CheckBox 값 설정
            checkBox.scaleX = checkBoxSize
            checkBox.scaleY = checkBoxSize
            checkBox.buttonTintList = AppCompatResources.getColorStateList(context, checkBoxColor)

            // LinearLayout 설정
            layout.orientation = HORIZONTAL

            // Child view의 Layout Param 설정 값
            val param = LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT)

            textView.layoutParams = param
            checkBox.layoutParams = param

            layout.addView(checkBox)
            layout.addView(textView)

            // 마지막으로 CheckBoxView에 layout을 child로 추가
            addView(layout)
        } finally {
            // Caching
            a.recycle()
        }
    }

    fun getText(): String {
        return text
    }

    fun isChecked(): Boolean {
        return checkBox.isChecked
    }
}
