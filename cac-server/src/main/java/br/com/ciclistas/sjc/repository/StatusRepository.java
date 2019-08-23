package br.com.ciclistas.sjc.repository;

import javax.enterprise.context.ApplicationScoped;

import br.com.ciclistas.sjc.model.Status;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class StatusRepository implements PanacheRepository<Status> { }
