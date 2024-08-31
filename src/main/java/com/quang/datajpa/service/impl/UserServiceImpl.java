package com.quang.datajpa.service.impl;

import com.quang.datajpa.dto.request.AddressDTO;
import com.quang.datajpa.dto.request.UserRequestDTO;
import com.quang.datajpa.dto.response.UserDetailResponse;
import com.quang.datajpa.model.Address;
import com.quang.datajpa.model.User;
import com.quang.datajpa.repository.UserRepository;
import com.quang.datajpa.service.UserService;
import com.quang.datajpa.utils.UserStatus;
import com.quang.datajpa.utils.UserType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public long saveUser(UserRequestDTO request) {
        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .dateOfBirth(request.getDateOfBirth())
                .phone(request.getPhone())
                .email(request.getEmail())
                .username(request.getUsername())
                .password(request.getPassword())
                .status(request.getStatus())
                .type(UserType.valueOf(request.getType()))
                .addresses(convertToAddress(request.getAddresses()))
                .build();
        userRepository.save(user);
        log.info("User saved: " + user.toString());
        return user.getId();
    }

    @Override
    public void updateUser(long userId, UserRequestDTO request) {

    }

    @Override
    public void changeStatus(long userId, UserStatus status) {

    }

    @Override
    public void deleteUser(long userId) {

    }

    @Override
    public UserDetailResponse getUser(long userId) {
        return null;
    }

    @Override
    public List<UserDetailResponse> getAllUsers(int pageNo, int pageSize) {
        return List.of();
    }
    private Set<Address> convertToAddress(Set<AddressDTO> addresses) {
        Set<Address> result = new HashSet<>();
        addresses.forEach(a ->
                result.add(Address.builder()
                        .apartmentNumber(a.getApartmentNumber())
                        .floor(a.getFloor())
                        .building(a.getBuilding())
                        .streetNumber(a.getStreetNumber())
                        .street(a.getStreet())
                        .city(a.getCity())
                        .country(a.getCountry())
                        .addressType(a.getAddressType())
                        .build())
        );
        return result;
    }
}
