package pw.react.backend.reactbackend.Service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import pw.react.backend.reactbackend.Entity.User;
import pw.react.backend.reactbackend.Repository.UserRepository;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest {

    private UserServiceImpl service;
    @Mock
    private UserRepository repository;

    @Before
    public void setUp() throws Exception {
        service = spy(new UserServiceImpl());
    }

    @Test
    public void givenNotExistingUser_whenUpdateUser_thenThrowResourceNotFoundException() {
        User user = new User();
        user.setLogin("1234");
        when(repository.findById(anyString())).thenReturn(Optional.empty());

        try {
            service.CheckUser(user.getLogin());
            fail("Should throw ResourceNotFoundException");
        } catch (ResourceNotFoundException ex) {
            assertThat(ex.getMessage(), is(equalTo("User with login [1234] is already created.")));
        }
        verify(repository, times(0)).save(any(User.class));
    }

    @Test
    public void givenExistingUser_whenUpdateUser_thenExecuteSaveMethod() {
        User user = new User();
        user.setLogin("1234");
        when(repository.findById(anyString())).thenReturn(Optional.of(user));
        service.CheckUser(user.getLogin());
        verify(repository, times(1)).save(eq(user));
    }
}
