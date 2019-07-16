package jp.co.pentain.sample.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.pentain.sample.domain.entity.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
	public Users findByEmail(String email);
}
