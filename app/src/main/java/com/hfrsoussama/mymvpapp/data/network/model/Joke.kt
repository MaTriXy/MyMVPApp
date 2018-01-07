package com.hfrsoussama.mymvpapp.data.network.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Oussama on 28/12/2017.
 */

data class Joke (
        @SerializedName("id")
        val id: Long,
        @SerializedName("joke")
        val content: String
)
