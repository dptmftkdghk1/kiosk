package com.example.kiosk.entity;

import lombok.*;
import javax.persistence.*;


@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name="menu")
public class MenuEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private Long id;
	
	@Column(nullable=false, length=10)
	private String name;
	
	@Column(nullable=false, length=30)
	private String info;
	
	@Column(nullable=false, length=100)
	private String path;
	
	@Column
	private Long price;
	private Long total;
	
	@Builder
	public MenuEntity(Long id, String name, String info, String path, Long price, Long total) {
		this.id = id;
		this.name = name;
		this.info = info;
		this.path = path;
		this.price = price;
		this.total = total;
	}
	
}
