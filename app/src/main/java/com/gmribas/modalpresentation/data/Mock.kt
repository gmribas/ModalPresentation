package com.gmribas.modalpresentation.data

import java.util.*

object Mock {

    fun contact(id: Int = 0) = ContactDTO(
        name = "Contact Name $id",
        nickname = "nick $id",
        picture = pictureList[getRandomNumber()],
        phoneNumber = getPhoneNumber()
    )

    fun contactList(max: Int = 4) = (0..max).map { contact(it) }

    private fun getPhoneNumber(): String {
        val sb = StringBuilder()
        sb
            .append("(").append(getRandomNumber()).append(getRandomNumber()).append(")")
            .append("9").append(getRandomNumber()).append(getRandomNumber()).append(getRandomNumber()).append(getRandomNumber())
            .append("-")
            .append(getRandomNumber()).append(getRandomNumber()).append(getRandomNumber()).append(getRandomNumber())
        return sb.toString()
    }

    private fun getRandomNumber(min: Int = 0, max: Int = pictureList.size - 1): Int {
        return Random().nextInt(max - min + 1) + min
    }

    private val pictureList = listOf(
        "https://w7.pngwing.com/pngs/816/275/png-transparent-icon-profile-bio-avatar-person-symbol-chat-people-thumbnail.png",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRXu865eHoVjY7dsxSRXduF4O5pzK-N8KO0aSiTuda1ONYct4Mv_KQRULzifjQwuZPi-LM&usqp=CAU",
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQSDPTH45IMOu72NyhIy9lJQFCeuGcn0eOad1EWKrHYlUiXvDNpfrv6jSmsOXHiQrzN854&usqp=CAU",
        "https://cdn1.iconfinder.com/data/icons/avatars-round-flat/33/an-04-512.png"
    )
}