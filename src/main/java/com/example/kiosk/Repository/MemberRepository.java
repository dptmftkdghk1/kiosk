package com.example.kiosk.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kiosk.data.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member,Integer>{
	
}
