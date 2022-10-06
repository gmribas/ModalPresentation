package com.gmribas.modalpresentation.data

object Mock {

    fun contact(id: Int = 0) = ContactDTO(
        "Contact Name $id",
        "nick $id",
        "https://w7.pngwing.com/pngs/816/275/png-transparent-icon-profile-bio-avatar-person-symbol-chat-people-thumbnail.png"
    )

    fun contactList(max: Int = 4) = (0..max).map { contact(it) }
}