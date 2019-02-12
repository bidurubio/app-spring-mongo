package br.com.rubioti.appspringmongo.repository;

import java.io.Serializable;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import br.com.rubioti.appspringmongo.domain.BaseEntity;

@NoRepositoryBean
public interface BaseRepository<ID extends Serializable, Entity extends BaseEntity<ID>> extends MongoRepository<Entity, ID> {

}
