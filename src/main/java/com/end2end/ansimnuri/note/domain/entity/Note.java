package com.end2end.ansimnuri.note.domain.entity;

import com.end2end.ansimnuri.note.dto.NoteDTO;
import com.end2end.ansimnuri.member.domain.entity.Member;
import com.end2end.ansimnuri.util.entity.Timestamp;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder
@SequenceGenerator(
        name = "noteSequenceGenerator",
        sequenceName = "NOTE_ID_SEQ",
        allocationSize = 1
)
@Table
@Entity
public class Note extends Timestamp {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "noteSequenceGenerator")
    private Long id;
    @Column(name="CONTENT", nullable = false)
    private String content;
    @Column(name="LATITUDE", nullable = false)
    private Double latitude;
    @Column(name="LONGITUDE", nullable = false)
    private Double longitude;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID", nullable = false)
    private Member member;

    @OneToMany(mappedBy = "note", orphanRemoval = true)
    private List<NoteRec> noteRecList;
    @OneToMany(mappedBy = "note", orphanRemoval = true)
    private List<NoteReply> noteReplyList;

    public static Note of (NoteDTO noteDTO, Member member) {
        return Note.builder()
                .member(member)
                .content(noteDTO.getContent())
                .latitude(noteDTO.getLatitude())
                .longitude(noteDTO.getLongitude())
                .build();
    }

    public void update(NoteDTO noteDTO) {
        this.content = noteDTO.getContent();
        this.latitude = noteDTO.getLatitude();
        this.longitude = noteDTO.getLongitude();
    }
}
