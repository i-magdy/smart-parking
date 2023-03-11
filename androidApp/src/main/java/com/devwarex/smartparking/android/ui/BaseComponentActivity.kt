package com.devwarex.smartparking.android.ui

import androidx.activity.ComponentActivity
import androidx.annotation.LayoutRes

open class BaseComponentActivity : ComponentActivity {


    constructor(): super()
    constructor(contentLayoutId: Int): super(contentLayoutId)

}