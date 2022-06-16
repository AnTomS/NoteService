package ru.netology

object NoteServiceImpl: CommentAndNoteService<Note> {

    private val notes = mutableListOf(Note())
    private var noteId : Int = 1

    override fun add(note: Note): Note {
        notes.add(note.copy(id = noteId))
        noteId++
        return notes.last()
    }

    override fun delete(id: Int) {
        notes.forEach { note -> if (id == note.id) note.deleted = true }
    }


    override fun edit(noteId: Int, newNote : Note): Boolean {
        for ((index, note) in notes.withIndex()) {
            if (noteId == note.id) {
                notes[index] = note.copy(
                    id = note.id, ownerId = note.ownerId, title = newNote.title,
                    text = newNote.text
                )
                return true
            }
        }
        throw NoteNotFoundException("Заметка не найдена")
    }

    override fun getById(id: Int): Note {
        notes.forEach {note ->
            if (noteId==note.id) return note
        }
        throw NoteNotFoundException("Заметка не найдена")
    }

    override fun restore(id: Int) {
        notes.forEach{ note ->
            if (noteId==note.id && note.deleted==true) note.deleted= false
        }
        throw NoteNotFoundException("Заметка не найдена")
    }
}