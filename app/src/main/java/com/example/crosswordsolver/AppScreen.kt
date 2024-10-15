package com.example.crosswordsolver

import androidx.annotation.StringRes

enum class AppScreen(@StringRes title: Int) {
    ChooseLength(title = R.string.choose_length),
    ChooseMode(title = R.string.choose_mode),
    ModeSet(title = R.string.mode_set),
    ModeExlude(title = R.string.mode_exlude_letters),
    ModeMask(title = R.string.mode_mask),
    Result(title = R.string.result)
}