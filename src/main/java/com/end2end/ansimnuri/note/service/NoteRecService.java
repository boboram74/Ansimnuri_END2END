package com.end2end.ansimnuri.note.service;

import com.end2end.ansimnuri.note.dto.NoteRecDTO;

public interface NoteRecService {
    void insert(NoteRecDTO dto, String loginId);
    void delete(NoteRecDTO dto, String loginId);
}
