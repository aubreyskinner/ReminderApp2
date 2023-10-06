package com.example.reminderapp2.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Reminder(
    @StringRes val stringResourceId: Int,
    @DrawableRes val imageResourceId: Int,
    val dayReminder: Int
)

