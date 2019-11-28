package com.cos.crud.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cos.crud.model.Board;

public interface BoardRepository extends JpaRepository<Board, Integer> {

	//Update 할 때는 Transactional, Modifying
	//Insert 할 때는 Transactional
	//Delete 할 때는 Transactional
	
	//트랜잭션 테스트
	@Transactional
	@Modifying
	@Query(value = "UPDATE board SET count=count+1 WHERE id=?1", nativeQuery = true)
	void increaseCount(int id);

	@Transactional
	@Modifying
	@Query(value = "UPDATE board SET createDate=11now() WHERE id=1?", nativeQuery = true)
	void timeUpdate(int id);
}
