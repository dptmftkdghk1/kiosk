package com.example.kiosk.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.kiosk.data.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu,Integer>{
	
}
