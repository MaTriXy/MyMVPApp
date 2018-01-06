package com.hfrsoussama.mymvpapp.repository.network.model

import com.google.gson.annotations.SerializedName

/**
 * Created by Oussama on 28/12/2017.
 */

data class ChuckNorrisJsonResponse(
        @SerializedName("type")
        val type: String,
        @SerializedName("value")
        val jokeList: List<Joke>
)
