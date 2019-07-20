package pl.sdacademy.springbootgui.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sdacademy.springbootgui.entity.Alcohol;

@Repository
public interface AlcoholRepository extends JpaRepository<Alcohol, Long> {
}
