package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Visit;
import guru.springframework.sfgpetclinic.repositories.VisitRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class VisitSDJpaServiceTest {

    @Mock
    private VisitRepository repository;

    @InjectMocks
    private VisitSDJpaService service;

    @Test
    void findAll() {
        when(repository.findAll()).thenReturn(Set.of(new Visit(), new Visit()));

        Set<Visit> visits = service.findAll();

        verify(repository).findAll();
        assertEquals(2, visits.size());
    }

    @Test
    void findById() {
        service.findById(1L);
        verify(repository).findById(1L);
    }

    @Test
    void save() {
        service.save(new Visit());
        verify(repository).save(any(Visit.class));
    }

    @Test
    void delete() {
        service.delete(new Visit());
        verify(repository).delete(any(Visit.class));
    }

    @Test
    void deleteById() {
        service.deleteById(1L);
        verify(repository).deleteById(1L);
    }
}