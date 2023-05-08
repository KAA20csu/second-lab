package com.example.second_lab

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf

sealed class AbstractCard(
    open val img: String? = null,
    open val title: String? = null,
    open val subtitle: String? = null,
    open val hasBag: String? = null,
    open val isCircle: Boolean? = null
) {
    val id: Int = genId++

    abstract val viewType: Int

    companion object {
        var genId = 1
    }

    fun toBundle(): Bundle = bundleOf(
        "img" to img,
        "title" to title,
        "subtitle" to subtitle,
        "hasBag" to hasBag,
        "isCircle" to isCircle,
    )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as AbstractCard

        if (img != other.img) return false
        if (title != other.title) return false
        if (subtitle != other.subtitle) return false
        if (hasBag != other.hasBag) return false
        if (isCircle != other.isCircle) return false

        return true
    }

    override fun hashCode(): Int {
        var result = img.hashCode()
        result = 31 * result + title.hashCode()
        result = 31 * result + subtitle.hashCode()
        result = 31 * result + hasBag.hashCode()
        result = 31 * result + isCircle.hashCode()
        return result
    }
}

class FirstCard(
    override val img: String? = null,
    override val title: String? = null,
    override val subtitle: String? = null,
    override val hasBag: String? = null
) : AbstractCard() {
    override val viewType: Int = 1
}

class SecondCard(
    override val img: String? = null,
    override val title: String? = null,
    override val subtitle: String? = null
) : AbstractCard() {
    override val viewType: Int = 2
}
class ThirdCard(
    override val title: String? = null,
    override val subtitle: String? = null
) : AbstractCard() {
    override val viewType: Int = 3
}
class FourthCard(
    override val img: String? = null,
    override val title: String? = null,
    override val subtitle: String? = null,
    override val isCircle: Boolean? = null
) : AbstractCard() {
    override val viewType: Int = 4
}