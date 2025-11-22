package io.iu.ghostnet.web;

import io.iu.ghostnet.entity.Person;
import io.iu.ghostnet.repo.PersonRepo;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

@Named
@RequestScoped
public class PersonController {

    @Inject
    private PersonRepo personRepo;

    private Person neu = new Person();

    /** Eine einfache Methode für das Anlegen einer bergenden Person */
    public String anlegen() {
        neu.setBergende(true);
        personRepo.create(neu);
        neu = new Person(); // Formular zurücksetzen
        return null; // gleiche Seite neu laden
    }

    /** Liste aller bergenden Personen für die Tabelle */
    public List<Person> getBergende() {
        return personRepo.findAllBergende();
    }

    public Person getNeu() { return neu; }
    public void setNeu(Person neu) { this.neu = neu; }
}
