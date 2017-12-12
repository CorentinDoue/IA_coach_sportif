package fr.emse.IA.IA_coach_sportif.web.seance;

import fr.emse.IA.IA_coach_sportif.model.Seance;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public final class SeanceDTO {
    private final Long id;
    private final int note;
    private final Date date;
    private final List<ActiviteDTO> activites;

    public SeanceDTO(Seance seance) {
        this.id = seance.getId();
        this.note = seance.getNote();
        this.date = seance.getDate();
        this.activites = seance.getActivites()== null ? null: seance.getActivites().stream().map(ActiviteDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public int getNote() {
        return note;
    }

    public Date getDate() {
        return date;
    }

    public List<ActiviteDTO> getActivites() {
        return activites;
    }
}
