package com.ugly.agri.service;

import com.google.common.collect.Lists;
import com.ugly.agri.domain.User;
import com.ugly.agri.dto.SignInDTO;
import com.ugly.agri.dto.SignUpDTO;
import com.ugly.agri.dto.UserDTO;
import com.ugly.agri.dto.UserInfoDTO;
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

        userList.forEach(user -> userDTOList.add(UserDTO.of(user)));
        return userDTOList;
    }

    public UserDTO getUser(Long id) {
        return UserDTO.of(searchUser(id));
    }

    public UserDTO createUser(SignUpDTO signUpDTO) {
        if (isExistUserByEmail(signUpDTO.getEmail())) {
            throw new CustomException(ErrorCode.EMAIL_DUPLICATION);
        }
        return UserDTO.of(userRepository.save(signUpDTO.toEntity()));
    }

    public UserDTO updateUser(Long id, UserInfoDTO userInfoDTO) {
        User user = searchUser(id);
        user.setPassword(userInfoDTO.getPassword());
        return UserDTO.of(userRepository.save(user));
    }

    public void deleteUser(Long id) {
        User user = searchUser(id);
        user.setIsDeleted(true);
        userRepository.save(user);
    }

    private boolean isExistUserByEmail(String email) {
        return userRepository.existsByEmailAndIsDeletedFalse(email);
    }

    public User searchUser(Long id) {
        return userRepository.findByIdAndIsDeletedFalse(id)
                .orElseThrow(() -> new CustomException(ErrorCode.USER_NONE));
    }

    private User searchUser(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password)
                .orElseThrow(() -> new CustomException(ErrorCode.LOGIN_INPUT_INVALID));
    }

    public UserDTO loginUser(SignInDTO signInDTO) {
        return UserDTO.of(searchUser(signInDTO.getEmail(), signInDTO.getPassword()));
    }
}
