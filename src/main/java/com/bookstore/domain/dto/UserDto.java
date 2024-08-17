package com.bookstore.domain.dto;

import com.bookstore.domain.entity.RoleEntity;
import com.bookstore.domain.entity.ShoppingCartEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.management.relation.Role;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String username;
    private String email;
    private Boolean enabled;
    private String address;
    private RoleEntity role;
    private ShoppingCartEntity shoppingCart;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDto userDto = (UserDto) o;
        return Objects.equals(id, userDto.id) && Objects.equals(username, userDto.username) && Objects.equals(email, userDto.email) && Objects.equals(enabled, userDto.enabled) && Objects.equals(address, userDto.address) && Objects.equals(role, userDto.role) && Objects.equals(shoppingCart, userDto.shoppingCart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, enabled, address, role, shoppingCart);
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", address='" + address + '\'' +
                ", role=" + role +
                ", shoppingCart=" + shoppingCart +
                '}';
    }
}