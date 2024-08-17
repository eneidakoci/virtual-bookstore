package com.bookstore.service.impl;

import com.bookstore.domain.dto.ShoppingCartDto;
import com.bookstore.domain.dto.ShoppingCartRequest;
import com.bookstore.domain.entity.ShoppingCartEntity;
import com.bookstore.domain.entity.UserEntity;
import com.bookstore.domain.mapper.ShoppingCartMapper;
import com.bookstore.repository.ShoppingCartRepository;
import com.bookstore.service.ShoppingCartService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ShoppingCartMapper shoppingCartMapper;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository, ShoppingCartMapper shoppingCartMapper) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.shoppingCartMapper = shoppingCartMapper;
    }

    @Override
    public ShoppingCartDto createShoppingCart(ShoppingCartRequest request, UserEntity userEntity) {
        ShoppingCartEntity shoppingCartEntity = ShoppingCartMapper.shoppingCartRequestToEntity(request, userEntity);
        shoppingCartEntity = shoppingCartRepository.save(shoppingCartEntity);
        return ShoppingCartMapper.toDto(shoppingCartEntity);
    }

    @Override
    public ShoppingCartDto updateShoppingCart(Long id, ShoppingCartRequest request) {
        ShoppingCartEntity existingCart = shoppingCartRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ShoppingCart not found with id: " + id));

        ShoppingCartEntity updatedCart = shoppingCartRepository.save(existingCart);
        return ShoppingCartMapper.toDto(updatedCart);
    }

    @Override
    public void deleteShoppingCart(Long id) {
        if (shoppingCartRepository.existsById(id)) {
            shoppingCartRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("ShoppingCart not found with id: " + id);
        }
    }

    @Override
    public ShoppingCartDto getShoppingCartById(Long id) {
        ShoppingCartEntity shoppingCartEntity = shoppingCartRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("ShoppingCart not found with id: " + id));
        return ShoppingCartMapper.toDto(shoppingCartEntity);
    }

    @Override
    public List<ShoppingCartDto> getAllShoppingCarts() {
        List<ShoppingCartEntity> shoppingCartEntities = shoppingCartRepository.findAll();
        return shoppingCartEntities.stream()
                .map(ShoppingCartMapper::toDto)
                .toList();
    }
}
