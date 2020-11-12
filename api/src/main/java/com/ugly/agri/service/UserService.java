package com.ugly.agri.service;

import com.google.common.collect.Lists;
import com.ugly.agri.domain.User;
import com.ugly.agri.dto.SignUpDTO;
import com.ugly.agri.dto.UserDTO;
import com.ugly.agri.exception.CustomException;
import com.ugly.agri.repository.UserRepository;
import com.ugly.agri.type.ErrorCode;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public List<UserDTO> getUsers() {
        List<User> userList = userRepository.findByIsDeletedFalse();
        List<UserDTO> userDTOList = Lists.newArrayList();

        userList.forEach(user -> userDTOList.add(User.toDTO(user)));
        return userDTOList;
    }

    public UserDTO getUser(Long id) {
        return User.toDTO(searchUser(id));
    }

    public void createUser(SignUpDTO signUpDTO) {
        userRepository.save(signUpDTO.toEntity());
    }

    public void updateUser(Long id, Boolean isSeller) {
        User user = searchUser(id);
        user.setIsSeller(isSeller);
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        User user = searchUser(id);
        user.setIsDeleted(true);
        userRepository.save(user);
    }

    private User searchUser(Long id) {
        return userRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NONE));
    }
}
