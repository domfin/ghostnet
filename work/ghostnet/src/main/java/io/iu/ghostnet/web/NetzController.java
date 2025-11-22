package io.iu.ghostnet.web;

import io.iu.ghostnet.entity.Geisternetz;
import io.iu.ghostnet.entity.Status;
import io.iu.ghostnet.repo.GeisternetzRepo;
import io.iu.ghostnet.repo.PersonRepo;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class NetzController implements Serializable {

    @Inject
    private GeisternetzRepo geisternetzRepo;

    @Inject
    private PersonRepo personRepo;

    /* ---------- Startseite (Melden) ---------- */
    private Geisternetz neu;
    private List<Geisternetz> offeneNetze;

    /* ---------- Bearbeiten-Seite ---------- */
    private Long editId;
    private Geisternetz aktuell;
    /** Auswahl der bergenden Person (Dropdown) */
    private Long selectedPersonId;

    @PostConstruct
    public void init() {
        neu = new Geisternetz();
        neu.setStatus(Status.GEMELDET);
        reloadOffene();
    }

    /* ====== Startseite ====== */

    public List<Geisternetz> getOffeneNetze() {
        if (offeneNetze == null) reloadOffene();
        return offeneNetze;
    }

    private void reloadOffene() {
        // Dashboard: nur GEMELDET + BEVORSTEHEND
        offeneNetze = geisternetzRepo.findForDashboard();
    }

    /** index.xhtml benutzt (Action) #{netzController.erfassen} */
    public String erfassen() { return melden(); }

    public String melden() {
        // Meldende Person bleibt anonym; bergende Person wird später in der Bearbeitung gesetzt
        neu.setBergendePerson(null);
        neu.setStatus(Status.GEMELDET);
        geisternetzRepo.create(neu);

        neu = new Geisternetz();
        neu.setStatus(Status.GEMELDET);
        reloadOffene();
        return "index?faces-redirect=true";
    }

    public String alsBevorstehend(Long id) {
        Geisternetz g = geisternetzRepo.findById(id);
        if (g != null) {
            g.setStatus(Status.BEVORSTEHEND);
            geisternetzRepo.update(g);
        }
        reloadOffene();
        return "index?faces-redirect=true";
    }

    public String alsGeborgen(Long id) {
        Geisternetz g = geisternetzRepo.findById(id);
        if (g != null) {
            g.setStatus(Status.GEBORGEN);
            geisternetzRepo.update(g);
        }
        reloadOffene();
        return "index?faces-redirect=true";
    }

    public String alsVerschollen(Long id) {
        Geisternetz g = geisternetzRepo.findById(id);
        if (g != null) {
            g.setStatus(Status.VERSCHOLLEN);
            geisternetzRepo.update(g);
        }
        reloadOffene();
        return "index?faces-redirect=true";
    }

    /* ====== Bearbeiten-Seite ====== */

    /** z.B. via <f:event type="preRenderView" listener="#{netzController.load}"/> */
    public void load() {
        if (editId != null && aktuell == null) {
            aktuell = geisternetzRepo.findById(editId);
            if (aktuell != null && aktuell.getBergendePerson() != null) {
                selectedPersonId = aktuell.getBergendePerson().getId();
            } else {
                selectedPersonId = null;
            }
        }
    }

    public String speichern() {
        if (aktuell != null) {
            if (selectedPersonId != null) {
                aktuell.setBergendePerson(personRepo.findById(selectedPersonId));
            } else {
                aktuell.setBergendePerson(null);
            }
            geisternetzRepo.update(aktuell);
        }
        return "index?faces-redirect=true";
    }

    /* ====== Hilfsdaten für Dropdowns ====== */
    public List<io.iu.ghostnet.entity.Person> getAllePersonen() {
        return personRepo.findAll();
    }

    /* ====== Getter/Setter ====== */
    public Geisternetz getNeu() { return neu; }
    public void setNeu(Geisternetz neu) { this.neu = neu; }

    public Long getEditId() { return editId; }
    public void setEditId(Long editId) { this.editId = editId; }

    public Geisternetz getAktuell() { return aktuell; }
    public void setAktuell(Geisternetz aktuell) { this.aktuell = aktuell; }

    public Long getSelectedPersonId() { return selectedPersonId; }
    public void setSelectedPersonId(Long selectedPersonId) { this.selectedPersonId = selectedPersonId; }
}
