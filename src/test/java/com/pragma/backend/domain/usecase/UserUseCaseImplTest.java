package com.pragma.backend.domain.usecase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.pragma.backend.domain.exception.UserNotFoundException;
import com.pragma.backend.domain.model.User;
import com.pragma.backend.domain.port.out.UserRepositoryPort;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * El caso de uso se prueba sin levantar Spring ni base de datos: es POJO puro
 * dependiendo solo del puerto de salida, que aquí se mockea.
 */
@ExtendWith(MockitoExtension.class)
class UserUseCaseImplTest {

    @Mock
    private UserRepositoryPort userRepositoryPort;

    private UserUseCaseImpl userUseCase;

    @BeforeEach
    void setUp() {
        userUseCase = new UserUseCaseImpl(userRepositoryPort);
    }

    @Test
    void createUserIgnoresIncomingIdAndDelegatesToRepository() {
        User input = User.builder().id(999L).name("Ada").email("ada@pragma.com").build();
        User saved = User.builder().id(1L).name("Ada").email("ada@pragma.com").build();
        when(userRepositoryPort.save(any(User.class))).thenReturn(saved);

        User result = userUseCase.createUser(input);

        assertThat(result.getId()).isEqualTo(1L);
        assertThat(input.getId()).isNull();
    }

    @Test
    void getUserByIdThrowsWhenMissing() {
        when(userRepositoryPort.findById(42L)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> userUseCase.getUserById(42L))
                .isInstanceOf(UserNotFoundException.class);
    }

    @Test
    void getUserByIdReturnsUserWhenPresent() {
        User existing = User.builder().id(1L).name("Ada").email("ada@pragma.com").build();
        when(userRepositoryPort.findById(1L)).thenReturn(Optional.of(existing));

        assertThat(userUseCase.getUserById(1L)).isEqualTo(existing);
    }

    @Test
    void getAllUsersDelegatesToRepository() {
        when(userRepositoryPort.findAll()).thenReturn(List.of(User.builder().id(1L).build()));

        assertThat(userUseCase.getAllUsers()).hasSize(1);
    }

    @Test
    void updateUserThrowsWhenMissing() {
        when(userRepositoryPort.existsById(1L)).thenReturn(false);

        assertThatThrownBy(() -> userUseCase.updateUser(1L, new User()))
                .isInstanceOf(UserNotFoundException.class);
    }

    @Test
    void updateUserSetsIdAndSaves() {
        when(userRepositoryPort.existsById(1L)).thenReturn(true);
        User toUpdate = User.builder().name("Ada Updated").email("ada@pragma.com").build();
        when(userRepositoryPort.save(any(User.class))).thenAnswer(inv -> inv.getArgument(0));

        User result = userUseCase.updateUser(1L, toUpdate);

        assertThat(result.getId()).isEqualTo(1L);
    }

    @Test
    void deleteUserThrowsWhenMissing() {
        when(userRepositoryPort.existsById(1L)).thenReturn(false);

        assertThatThrownBy(() -> userUseCase.deleteUser(1L))
                .isInstanceOf(UserNotFoundException.class);
    }

    @Test
    void deleteUserDelegatesToRepositoryWhenPresent() {
        when(userRepositoryPort.existsById(1L)).thenReturn(true);

        userUseCase.deleteUser(1L);

        verify(userRepositoryPort).deleteById(1L);
    }
}
