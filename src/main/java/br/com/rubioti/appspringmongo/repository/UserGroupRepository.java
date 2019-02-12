package br.com.rubioti.appspringmongo.repository;

import org.springframework.stereotype.Repository;

import br.com.rubioti.appspringmongo.domain.UserGroup;

@Repository
public interface UserGroupRepository extends BaseRepository<String, UserGroup> {

}
