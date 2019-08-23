package br.com.ciclistas.sjc.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.ciclistas.sjc.model.Occurrence;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class OccurrenceRepository implements PanacheRepository<Occurrence> {}
