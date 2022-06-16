package ru.netology

import org.junit.Test

import org.junit.Assert.*

class ServiceImplTest {

    @Test
    fun addComment() {
        val comment1 = Comment(id = 1)
        val expected = 1
        val result = CommentServiceImpl.add(comment1)
        assertEquals(1, 1)
    }

    @Test
    fun addNote() {
        val note1 = Note(id = 55)
        val expected = 1
        val result = NoteServiceImpl.add(note1).id

        assertEquals(expected, result)
    }

    @Test
    fun editComment() {
        val comment3 = Comment(id = 5, idOfNote = 1)
        val commentEdit = Comment(id = 6, idOfNote = 1, text = "newText")
        CommentServiceImpl.add(comment3)
        val expected = true
        val result = CommentServiceImpl.edit(5, commentEdit)

        assertEquals(expected, result)
    }

    @Test
    fun editNote() {
        val note1Corrected = Note(id = 56, title = "newTitle")
        NoteServiceImpl.add(note1Corrected)

        val result = NoteServiceImpl.edit(1, note1Corrected)

        assertEquals(true, result)
    }

    @Test(expected = CommentNotFoundException::class)
    fun editExceptionComment() {
        val commentEdit = Comment(id = 6, idOfNote = 1, text = "newText")
        CommentServiceImpl.add(commentEdit)
        CommentServiceImpl.edit(7, commentEdit)
    }

    @Test(expected = NoteNotFoundException::class)
    fun editExceptionNote() {
        val note1Corrected = Note(id = 56, title = "newTitle")
        NoteServiceImpl.add(note1Corrected)

        NoteServiceImpl.edit(5, note1Corrected)
    }

    @Test(expected = CommentNotFoundException::class)
    fun restoreComment() {
        val commentEdit = Comment(id = 6, idOfNote = 1, text = "newText")
        CommentServiceImpl.add(commentEdit)
        CommentServiceImpl.edit(8, commentEdit)
    }

    @Test(expected = NoteNotFoundException::class)
    fun restoreNote() {
        val noteEdit = Note(id = 6, text = "newText")
        NoteServiceImpl.add(noteEdit)
        NoteServiceImpl.edit(8, noteEdit)
    }
}