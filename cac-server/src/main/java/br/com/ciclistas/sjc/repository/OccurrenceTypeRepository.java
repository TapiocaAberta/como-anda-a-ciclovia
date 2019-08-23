package br.com.ciclistas.sjc.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.ciclistas.sjc.model.OccurrenceType;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class OccurrenceTypeRepository implements PanacheRepository<OccurrenceType> { }
