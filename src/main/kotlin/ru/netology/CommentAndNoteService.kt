package ru.netology

interface CommentAndNoteService<E> {

    fun add(Any: E): E

    fun delete(id: Int)

    fun edit(id: Int, entity: E): Boolean

    fun getById(id: Int): E

    fun restore(id: Int)
}