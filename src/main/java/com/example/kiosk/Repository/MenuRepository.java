package com.example.kiosk.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.kiosk.entity.MenuEntity;

public interface MenuRepository extends JpaRepository<MenuEntity,Long>{
	
}
