package com.punk.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Entity
public class PunkBeer {

    @PrimaryKey(autoGenerate = true)
    var id = 0

    @SerializedName("name")
    @Expose
    var name: String = ""

    @SerializedName("tagline")
    @Expose
    var tagline: String = ""

    @SerializedName("description")
    @Expose
    var description: String = ""

    @SerializedName("image_url")
    @Expose
    var imageUrl: String = ""

}