package org.moshe.arad.repositories.dao.data;

import org.moshe.arad.repositories.entities.GameUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameUserRepository extends JpaRepository<GameUser, Long> {

}
