package com.project.service;

import com.project.config.JwtTokenProvider;
import com.project.exception.UserException;
import com.project.modal.User;
import com.project.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;

import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplementationTest {

    @InjectMocks
    private UserServiceImplementation userService;

    @Mock
    private UserRepository userRepository;

    @Mock
    private JwtTokenProvider jwtTokenProvider;

    @Test
    public void testFindUserById_Success() throws Exception {
        Long userId = 1L;
        User expectedUser = new User();

        expectedUser.setFirstName("Nguyen");
        expectedUser.setLastName("Hoang");
        expectedUser.setEmail("nguyenhoang@gmail.com");



        when(userRepository.findById(userId)).thenReturn(Optional.of(expectedUser));

        User actualUser = userService.findUserById(userId);



        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void testFindUserById_NotFound() throws Exception {
        Long userId = 1L;

        when(userRepository.findById(userId)).thenReturn(Optional.empty());

        assertThrows(UserException.class, () -> userService.findUserById(userId));
    }

    //                                        FindUserProfileByJwt


    @Test
    public void testFindUserProfileByJwt_Success() throws UserException {
        // Dữ liệu giả định
        String jwt = "test_jwt";
        String userEmail = "test_email";
        User expectedUser = new User();
        // Khi phương thức findByEmail được gọi với đối số là email của user từ JWT, nó sẽ trả về người dùng được giả định
        when(jwtTokenProvider.getEmailFromJwtToken(jwt)).thenReturn(userEmail);
        when(userRepository.findByEmail(userEmail)).thenReturn(expectedUser);

        // Gọi phương thức cần kiểm tra
        User foundUser = userService.findUserProfileByJwt(jwt);

        // Kiểm tra kết quả
        assertEquals(expectedUser, foundUser);
    }



//    @Test(expected = UserException.class)
    @Test
    public void testFindUserProfileByJwt_UserNotFound() throws UserException {
        // Dữ liệu giả định
        String jwt = "eyJhbGciOiJIUzM4NCJ9.eyJpYXQiOjE3MTM0OTM3NzgsImV4cCI6MTcxMzU4MDE3OCwiZW1haWwiOiJuZ3V5ZW5ob2FuZ0BnbWFp" +
                        "bC5jb20ifQ.O4RyDqrXJ-T-DISzNrbR2a-mPK98Txndlk7pjPkr8a4rhWAYLg_fmqoMOWSP9dop";
        String userEmail = "non_existing@example.com";

        // Khi phương thức findByEmail được gọi với đối số là email của user từ JWT, nó sẽ trả về null (không tìm thấy user)
        when(jwtTokenProvider.getEmailFromJwtToken(jwt)).thenReturn(userEmail);
        when(userRepository.findByEmail(userEmail)).thenReturn(null);

        // Gọi phương thức cần kiểm tra
//        userService.findUserProfileByJwt(jwt);
        assertThrows(UserException.class, () -> userService.findUserProfileByJwt(jwt));
    }

     //                           Update user

    @Test
    public void testUpdateUserProfileByJwt_Success() throws UserException{
        // Dữ liệu giả định
        String jwt = "eyJhbGciOiJIUzM4NCJ9.eyJpYXQiOjE3MTM0OTM3NzgsImV4cCI6MTcxMzU4MDE3OCwiZW1haWwiOiJuZ3V5" +
                     "ZW5ob2FuZ0BnbWFpbC5jb20ifQ.O4RyDqrXJ-T-DISzNrbR2a-mPK98Txndlk7pjPkr8a4rhWAYLg_fmqoMOWSP9dop";
        String userEmail = "nguyenhoang@example.com";
        User currentUser = new User();
        currentUser.setEmail(userEmail);
        User updatedUser = new User();
        updatedUser.setFirstName("NewFirstName");
        updatedUser.setLastName("NewLastName");
        updatedUser.setMobile("NewMobile");
        updatedUser.setEmail("new@example.com");
        updatedUser.setPoints(250);

        // Mock phương thức getEmailFromJwtToken
        when(jwtTokenProvider.getEmailFromJwtToken(jwt)).thenReturn(userEmail);

        // Mock phương thức findByEmail
        when(userRepository.findByEmail(userEmail)).thenReturn(currentUser);

        // Gọi phương thức cần kiểm tra
        User returnedUser = userService.updateUserProfileByJwt(jwt, updatedUser);

       // Kiểm tra xem phương thức có trả về user đã được cập nhật đúng không

            assertEquals(updatedUser.getFirstName(), returnedUser.getFirstName());
            assertEquals(updatedUser.getLastName(), returnedUser.getLastName());
            assertEquals(updatedUser.getMobile(), returnedUser.getMobile());
            assertEquals(updatedUser.getEmail(), returnedUser.getEmail());
            assertEquals(updatedUser.getPoints(), returnedUser.getPoints(), 0.001); // So sánh với sai số 0.001 do số thực
            // Kiểm tra xem phương thức có trả về user có rank đúng không
            // Add test cases for checking rank based on points if needed
        }


    // Add more test cases to cover different scenarios




}