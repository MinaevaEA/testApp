package com.example.pizza.glide

import android.annotation.SuppressLint
import android.os.Parcel

import android.os.Parcelable.Creator

import android.os.Parcelable


@SuppressLint("ParcelCreator")
open class SpacePhoto : Parcelable {
    var url: String?
    var title: String?

    constructor(url: String?, title: String?) {
        this.url = url
        this.title = title
    }

    protected constructor(`in`: Parcel) {
        url = `in`.readString()
        title = `in`.readString()
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, i: Int) {
        parcel.writeString(url)
        parcel.writeString(title)
    }

    companion object {
        val CREATOR = object : Creator<SpacePhoto?> {
            override fun createFromParcel(`in`: Parcel): SpacePhoto {
                return SpacePhoto(`in`)
            }

            override fun newArray(size: Int): Array<SpacePhoto?> {
                return arrayOfNulls(size)
            }
        }
        val spacePhotos: Array<SpacePhoto>
            get() = arrayOf(
                SpacePhoto("http://i.imgur.com/zuG2bGQ.jpg", "Galaxy"),
                SpacePhoto("http://i.imgur.com/ovr0NAF.jpg", "Space Shuttle"),
                SpacePhoto("http://i.imgur.com/n6RfJX2.jpg", "Galaxy Orion"),
                SpacePhoto("http://i.imgur.com/qpr5LR2.jpg", "Earth"),
                SpacePhoto("http://i.imgur.com/pSHXfu5.jpg", "Astronaut"),
                SpacePhoto("http://i.imgur.com/3wQcZeY.jpg", "Satellite")
            )
    }
}