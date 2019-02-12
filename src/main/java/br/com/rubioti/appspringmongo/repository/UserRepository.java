package br.com.rubioti.appspringmongo.repository;

import org.springframework.stereotype.Repository;

import br.com.rubioti.appspringmongo.domain.User;

@Repository
public interface UserRepository extends BaseRepository<String, User> {

}
