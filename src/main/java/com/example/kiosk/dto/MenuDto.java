package com.example.kiosk.dto;

import com.example.kiosk.entity.MenuEntity;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MenuDto {
	private Long id;
	private String name;
	private String info;
	private String path;
	private Long price;
	private Long total;
	
	public MenuEntity toEntity() {
		MenuEntity menuEntity = MenuEntity.builder()
			.id(id)
			.name(name)
			.info(info)
			.path(path)
			.price(price)
			.total(total)
			.build();
		return menuEntity;
	}
	
	@Builder
	public MenuDto(Long id, String name, String info, String path, Long price, Long total) {
		this.id = id;
		this.name = name;
		this.info = info;
		this.path = path;
		this.price = price;
		this.total = total;
	}
}
