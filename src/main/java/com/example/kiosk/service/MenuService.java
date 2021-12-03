package com.example.kiosk.service;


import java.util.*;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import com.example.kiosk.Repository.MenuRepository;
import com.example.kiosk.dto.MenuDto;
import com.example.kiosk.entity.MenuEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MenuService {
    private MenuRepository menuRepository;
    
    @Transactional
    public List<MenuDto> getMenulist(){
        List<MenuEntity> menuEntities = menuRepository.findAll();
        List<MenuDto> menuDtoList = new ArrayList<>();
        
        for( MenuEntity menuEntity : menuEntities) {
            MenuDto menuDTO = MenuDto.builder()
                    .id(menuEntity.getId())
                    .name(menuEntity.getName())
                    .path(menuEntity.getPath())
                    .info(menuEntity.getInfo())
                    .price(menuEntity.getPrice())
                    .total(menuEntity.getTotal())
                    .build();
            
            menuDtoList.add(menuDTO);
        }
        return menuDtoList;
    }
    @Transactional
    public Long savePost(MenuDto menuDto) {
        return menuRepository.save(menuDto.toEntity()).getId();    
    }
    @Transactional
    public MenuDto getPost(Long id) {
        Optional<MenuEntity>menuEntityWrapper = menuRepository.findById(id);
        MenuEntity menuEntity = menuEntityWrapper.get();
        
        MenuDto menuDTO = MenuDto.builder()
                .id(menuEntity.getId())
                .name(menuEntity.getName())
                .path(menuEntity.getPath())
                .info(menuEntity.getInfo())
                .price(menuEntity.getPrice())
                .total(menuEntity.getTotal())
                .build();
        
        return menuDTO;
    }
    @Transactional
    public MenuDto getPost1(Long id) {
        Optional<MenuEntity>menuEntityWrapper = menuRepository.findById(id);
        MenuEntity menuEntity = menuEntityWrapper.get();
        
        MenuDto menuDTO = MenuDto.builder()
                .id(menuEntity.getId())
                .name(menuEntity.getName())
                .path(menuEntity.getPath())
                .info(menuEntity.getInfo())
                .price(menuEntity.getPrice())
                .build();
        
        return menuDTO;
    }
    @Transactional
    public void deletePost(Long id) {
        menuRepository.deleteById(id);
    }
    
}

