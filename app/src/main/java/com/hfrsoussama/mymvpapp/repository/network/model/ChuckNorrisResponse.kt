package com.hfrsoussama.mymvpapp.repository.network.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Oussama on 28/12/2017.
 */

data class ChuckNorrisResponse(
        @SerializedName("type")
        val type: String,
        @SerializedName("values")
        val value: List<Joke>
)
