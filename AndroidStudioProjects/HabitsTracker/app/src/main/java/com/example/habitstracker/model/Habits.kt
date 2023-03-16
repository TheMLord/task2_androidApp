package com.example.habitstracker.model

import android.os.Parcel
import android.os.Parcelable


class Habits(
    var id: Int,
    var name: String?,
    var descriptor: String?,
    var priority: Int,
    var type: String?,
    var count: Int,
    var period: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Habits

        if (id != other.id) return false
        if (name != other.name) return false
        if (descriptor != other.descriptor) return false
        if (priority != other.priority) return false
        if (type != other.type) return false
        if (count != other.count) return false
        if (period != other.period) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + descriptor.hashCode()
        result = 31 * result + priority
        result = 31 * result + type.hashCode()
        result = 31 * result + count
        result = 31 * result + period.hashCode()
        return result
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(descriptor)
        parcel.writeInt(priority)
        parcel.writeString(type)
        parcel.writeInt(count)
        parcel.writeString(period)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Habits> {
        override fun createFromParcel(parcel: Parcel): Habits {
            return Habits(parcel)
        }

        override fun newArray(size: Int): Array<Habits?> {
            return arrayOfNulls(size)
        }
    }
}